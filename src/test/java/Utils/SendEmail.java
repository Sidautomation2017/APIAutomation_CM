package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

//import org.apache.commons.io.IOUtils;

//import com.cm.base.Constant;

public class SendEmail {
	public static void main(String[] args) {
		sendEmail("C:\\Report\\report.html");
	}

	public static void sendEmail(String path) {
		try {
			Date date = new Date();
			SimpleDateFormat ft1 = new SimpleDateFormat("dd_MMMM_yyyy");
			String foldername = ft1.format(date);
			String mailBody, passTestCaseCount, failTestCaseCount, skipTestCaseCount;
			String startTime, endTime, totalTime;
			int totalTestCases;

			String host = "smtp.office365.com";
			final String fromEmail = "crtmnotifications@cloudmoyo.com";
			final String password = "h7%gDQNX$aau";

			System.out.println("TLSEmail Start");
			Properties props = new Properties();
			props.put("mail.smtp.host", host); // SMTP Host1
			props.put("mail.smtp.port", "587"); // TLS Port
			props.put("mail.smtp.auth", "true"); // enable authentication
			props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

			// create Authenticator object to pass in Session.getInstance argument
			Authenticator auth = new Authenticator() {
				// override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			};
			Session session = Session.getInstance(props, auth);
			Message message = new MimeMessage(session); // email message

			message.setFrom(new InternetAddress(fromEmail));

			InternetAddress[] recipients = InternetAddress.parse("Bhushan.Borse@cloudmoyo.com");
			// InternetAddress[] recipients =
			// InternetAddress.parse("Sidheshwar.Tondare@cloudmoyo.com,Bhushan.Borse@CloudMoyo.com,Kaustubh.Vaze@cloudmoyo.com,Pankaj.Murande@cloudmoyo.com");
			message.addRecipients(Message.RecipientType.TO, recipients);
			message.setSubject("TRRA Automation Report");

			InputStream inputStream = new FileInputStream(path);
			Reader inputStreamReader = new InputStreamReader(inputStream);
			{
				mailBody = inputStreamReader.toString();
			}

			/*
			 * passTestCaseCount = ReturnSubstring(ReturnData("passChild:",path), ':',
			 * ',').trim(); failTestCaseCount =
			 * ReturnSubstring(ReturnData("failChild:",path), ':', ',').trim();
			 * skipTestCaseCount = ReturnSubstring(ReturnData("skipChild:",path), ':',
			 * ',').trim(); startTime = ReturnSubstring1(ReturnDataOfNextLine("Start",path),
			 * '>', '/').trim(); endTime =
			 * ReturnSubstring1(ReturnDataOfNextLine("End",path), '>', '/').trim();
			 * totalTime = ReturnSubstring1(ReturnDataOfNextLine("Time Taken",path),'>',
			 * '/').trim(); totalTestCases=Integer.parseInt(passTestCaseCount)
			 * +Integer.parseInt(failTestCaseCount) + Integer.parseInt(skipTestCaseCount) ;
			 * 
			 * System.out.println("1. pass" +passTestCaseCount+
			 * " 2. Fail "+failTestCaseCount+ "  3. Skip"+skipTestCaseCount+
			 * "4. Total"+totalTestCases); System.out.println(startTime+
			 * " "+endTime+" "+totalTime); String
			 * emailBody="<table width='600'  style='color: #000000; border:1px solid #ccc; padding: 5px; font-family: Tahoma,  Geneva, sans-serif; font-size: 14px;' cellspacing='0' cellpadding='0' border='0' align='left'>"
			 * ; emailBody += "<tr>"; emailBody +=
			 * "<td style='border-bottom:5px solid #028ec3; background: #eaeff3;'>";
			 * emailBody +=
			 * "<span style='display: block; font-size: 22px; padding: 10px;'> MMCS OTS Automation </span>"
			 * ; emailBody += "</td>"; emailBody += "</tr>"; emailBody += "<tr>"; emailBody
			 * += "<td>"; emailBody += "<br>"; emailBody += "Hello Team,"; emailBody +=
			 * "<br><br>"; emailBody += "</td>"; emailBody += "</tr>"; emailBody += "<tr>";
			 * emailBody += "<td style='font-family: Tahoma,  Geneva, sans-serif;'>";
			 * emailBody +=
			 * "<strong style='border-bottom: 1px solid #ccc; padding-bottom: 2px;'>";
			 * emailBody += "Summary of Execution is as below :-"; emailBody += "</strong>";
			 * emailBody += "</td>"; emailBody += "</tr>"; emailBody += "<tr>"; emailBody +=
			 * "<td>"; emailBody += "<br>"; emailBody +=
			 * "<table style='color: #000000; font-family: Tahoma,  Geneva, sans-serif; font-size: 14px; width: 70%; border: 1px solid #ccc; border-collapse: collapse;'  cellspacing='1' cellpadding='2' border='1' align='left'>"
			 * ; emailBody += "<tr>"; emailBody += "<td width='150px'>"; emailBody +=
			 * "<strong>Environment</strong>"; emailBody += "</td>"; emailBody += "<td>";
			 * emailBody += "QA"; emailBody += "</td>"; emailBody += "</tr>"; emailBody +=
			 * "<tr>"; emailBody += "<td width='150px'>"; emailBody +=
			 * "<strong>Total Test Cases</strong>"; emailBody += "</td>"; emailBody +=
			 * "<td>"; emailBody += totalTestCases; emailBody += "</td>"; emailBody +=
			 * "</tr>"; emailBody += "<tr>"; emailBody += "<td>"; emailBody +=
			 * "<strong>Test Cases Passed</strong>"; emailBody += "</td>"; emailBody +=
			 * "<td>"; emailBody += passTestCaseCount; emailBody += "</td>"; emailBody +=
			 * "</tr>"; emailBody += "<tr>"; emailBody += "<td>"; emailBody +=
			 * "<strong>Test Cases Failed</strong>"; emailBody += "</td>"; emailBody +=
			 * "<td>"; emailBody += failTestCaseCount; emailBody += "</td>"; emailBody +=
			 * "</tr>"; emailBody += "<tr>"; emailBody += "<td>"; emailBody +=
			 * "<strong>Execution Report</strong>"; emailBody += "</td>"; emailBody +=
			 * "<td>"; // emailBody+=
			 * "<a href="+CommonUtils.getStored_value("AzureReportpath")+">";
			 * emailBody+="Click Here"; emailBody+="</a>"; emailBody += "</td>"; emailBody
			 * += "</tr>"; emailBody += "</table>"; emailBody +="<tr >"; emailBody +=
			 * "<td>"; emailBody += "<strong>Regards,</strong><br>"; emailBody +=
			 * "<span style='color: #000000; font-weight: normal; font-family: Tahoma,  Geneva, sans-serif;'> MMCS Automation Team</span><br><br><br>"
			 * ; emailBody += "</tr>"; emailBody += "</td>"; emailBody +=
			 * "<tr bgcolor='#ffffff'>"; emailBody +=
			 * "<td style='font-family:Tahoma,Helvetica,sans-serif; border-top: 1px solid #ccc; border-bottom:1px solid #ccc;  color:#000000;text-align:center; font-size:14px; padding: 15px 0; text-align:center;'>"
			 * ; emailBody += "This is an auto generated mail. Please do not reply";
			 * emailBody += "<br></td>";
			 * 
			 * 
			 */
			String emailBody = "Dear Team, \r\n" + "Please find attached TRRA Automation report.\r\n"+"Regards,\r\n"+"Automation QA";
			BodyPart messageBodyPart = new MimeBodyPart();
		
			Multipart multipart = new MimeMultipart();
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
		    messageBodyPart2.setText(emailBody);
			DataSource source = new FileDataSource(path);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(path);
			
			// multipart.addBodyPart(messageBodyPart2);
			multipart.addBodyPart(messageBodyPart);
			 multipart.addBodyPart(messageBodyPart2);
			message.setContent(emailBody, "text/html");
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("Report Mail Sucessfully");

		}

		catch (MessagingException e) {

			throw new RuntimeException(e);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String ReturnData(String searchString, String path) throws IOException {
		File file = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line = null;
		// string selectLines = line.Contains(searchString));
		while ((line = br.readLine()) != null) {
			if (line.contains(searchString)) {
				// line = br.readLine();
				break;
			}
		}
		return line;

	}

	public static String ReturnDataOfNextLine(String searchString, String path) throws IOException {
		File file = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = "";
		while ((line = br.readLine()) != null) {
			if (line.contains(searchString)) {
				line = br.readLine();
				break;
			}
		}
		return line;
	}

	public static String ReturnSubstring(String actualString, char startChar, char endChar) {
		int startIndex = actualString.indexOf(startChar);
		int endIndex = actualString.indexOf(endChar);
		int start = startIndex;
		return actualString.substring(++start, endIndex);
	}

	public static String ReturnSubstring1(String actualString, char startChar, char endChar) {
		int startIndex = actualString.indexOf(startChar);
		int endIndex = actualString.indexOf(endChar);
		int start = startIndex;
		return actualString.substring(++start, --endIndex);
	}
}
