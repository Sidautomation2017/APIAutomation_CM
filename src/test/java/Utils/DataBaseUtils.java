package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

//import com.cm.base.Constant;
import Runner.TestSuite;

public class DataBaseUtils {

	private static String CMDBusername;
	private static String CMDBpassword;
	private static String CMDBURL;
	private static String connectionString;
	private static Connection connection;
	private static Connection con;
	private static boolean res;

	public static Connection databaseconnection(String env, String dbName) {
		try {
			CMDBusername = "etluser";
			CMDBpassword = "XEiC5z28u95Vetl";
			CMDBURL = "jdbc:sqlserver://cm-kcsr-ecs-qa-sql.database.windows.net";
			if (env.equalsIgnoreCase("CMQA")) {
				connectionString = CMDBURL + ";databaseName=" + dbName
						+ ";autoReConnect=true&amp;allowMultiQueries=true";
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(connectionString, CMDBusername, CMDBpassword);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

	// Sample method to run select from DBname passed in method parameter
	public static int getInhouseFleetIdentifier(String env, String dbName) {
		int resultdata = 0;
		try {
			connection = databaseconnection(env, dbName);
			Statement st;
			st = connection.createStatement();
			String sqlQuery = "Select top 1 Identifier from Inhousefleet where name= "+"'"+Configuration.inhouseFleetName+ "'";
			System.out.println(sqlQuery);
			ResultSet resSet = st.executeQuery(sqlQuery);
			while (resSet.next()) {
				resultdata = resSet.getInt("Identifier");
				// System.out.println(resultdata);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultdata;
	}

	// Sample method to run select from DBname passed in method parameter
	public static String getInhouseEffecteveDate(String env, String dbName) {
		String resultdata = null;
		try {
			connection = databaseconnection(env, dbName);
			Statement st;
			st = connection.createStatement();
			String sqlQuery = "	SELECT CONVERT(VARCHAR(50), GETDATE(), 127) as EffectiveDate";
			System.out.println(sqlQuery);
			ResultSet resSet = st.executeQuery(sqlQuery);
			while (resSet.next()) {
				resultdata = resSet.getString("EffectiveDate");
				System.out.println(resultdata);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultdata;

	}

	/*
	 * public static void main(String args[]) {
	 * DataBaseUtils.getInhouseFleetIdentifier(Configuration.testEnv,
	 * Configuration.kcsmdb); }
	 */

	public static void clearBriefingData(String env, String dbName, String tableName) {

		try {
			connection = databaseconnection(env, dbName);
			Statement st;
			st = connection.createStatement();
			String sqlQuery = "update" + " " + tableName + " " + "set isactive = 0";
			st.executeUpdate(sqlQuery);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void getBriefingPlanIDToBackdate(String env, String dbName) {
		try {
			Calendar now = Calendar.getInstance();
			connection = databaseconnection(env, dbName);
			Statement st;
			PreparedStatement pstmt;
			int briefingPlanId = 0;
			int effectiveWeek = now.get(Calendar.WEEK_OF_YEAR) - 1;
			st = connection.createStatement();
			String selectsqlQuery = "select Identifier from Briefingplan where isactive=1;";
			ResultSet resSet = st.executeQuery(selectsqlQuery);
			while (resSet.next()) {
				briefingPlanId = resSet.getInt("Identifier");

			}
			String updateQuery = "update Briefingplan set effectivenumber= ? where identifier =?";
			pstmt = connection.prepareStatement(updateQuery);
			pstmt.setInt(1, effectiveWeek);
			pstmt.setInt(2, briefingPlanId);
			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Sample method to call Store procedure from DBname passed in method parameter
	public static void getUserInformationFromSP(String env, String dbName) {

		try {
			connection = databaseconnection(env, dbName);
			java.sql.CallableStatement cs = connection.prepareCall("{call [QA_GetIdentifier]}");
			res = cs.execute();
			if (res)
				System.out.println("SP executed sucessfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}