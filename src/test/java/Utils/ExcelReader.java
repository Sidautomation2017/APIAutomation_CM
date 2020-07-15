package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

import Pojo.CreateEquipmentOrder;
import Pojo.DestinationRoute;
import Pojo.OrderQuantity;

public class ExcelReader {
	public static void main(String[] args) throws IOException {

		ExcelReader reader = new ExcelReader();
		List<CreateEquipmentOrder> list = reader.getEquipmentOrderData("", "Sheet1");
		for (CreateEquipmentOrder ce : list) {
			System.out.println(ce.getCustomerName());
		}
	}

	public List<CreateEquipmentOrder> getEquipmentOrderData(String fileName, String sheetName) throws IOException {
		List<CreateEquipmentOrder> cmpData = new ArrayList<CreateEquipmentOrder>();
		List<OrderQuantity> orderData = new ArrayList<OrderQuantity>();
		List<DestinationRoute> desData = new ArrayList<DestinationRoute>();
		File file = new File(
				"C:\\Users\\Sidheshwar.Tondare\\Worspace_Demo\\APIFrameWork_Demo\\APIFrameWork_Demo\\src\\test\\resources\\"
						+ fileName);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheetcount = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetcount; i++) {
			XSSFSheet sheet = workbook.getSheetAt(i);
			String sName = workbook.getSheetName(i);
			if (sName.equalsIgnoreCase(sheetName)) {
				Iterator<Row> rowitr = sheet.iterator();
				rowitr.next();

				while (rowitr.hasNext()) {
					CreateEquipmentOrder ceo = new CreateEquipmentOrder();
					OrderQuantity oq = new OrderQuantity();
					DestinationRoute dr = new DestinationRoute();
					Row row = rowitr.next();
					Iterator<Cell> cell = row.cellIterator();
					orderData.clear();
					desData.clear();
					while (cell.hasNext()) {
						
						// sceData.clear();

						Cell value = cell.next();
						int columnIndex = value.getColumnIndex();
						switch (columnIndex) {
						case 0:
							ceo.setOrderNumber(Integer.valueOf(CommonUtils.getValueAsPerType(value)));

							break;
						case 1:
							ceo.setRequestingUserID(CommonUtils.getValueAsPerType(value));
							break;
						case 2:
							ceo.setCustomerName(CommonUtils.getValueAsPerType(value));
							break;

						case 3:
							ceo.setCustomerNumber(CommonUtils.getValueAsPerType(value));
							break;
						case 4:
							ceo.setStcc(CommonUtils.getValueAsPerType(value));
							break;
						case 5:
							ceo.setEquipmentTypeCode(CommonUtils.getValueAsPerType(value));
							break;
						case 6:
							ceo.setCustomerCity(CommonUtils.getValueAsPerType(value));
							break;
						case 7:
							ceo.setCustomerState(CommonUtils.getValueAsPerType(value));
							break;
						case 8:
							ceo.setPhoneNumber(CommonUtils.getValueAsPerType(value));
							break;
						case 9:
							ceo.setCustomerEmail(CommonUtils.getValueAsPerType(value));
							break;
						case 10:
							oq.setEquipmentDateRequiredOn(CommonUtils.getValueAsPerType(value));
							break;
						case 11:
							oq.setEquipmentQuantity(CommonUtils.getValueAsPerType(value));
							break;
						case 12:
							ceo.setOfflineStation(CommonUtils.getValueAsPerType(value));
							break;
						case 13:
							ceo.setOfflineStateCode(CommonUtils.getValueAsPerType(value));
							break;
						case 14:
							ceo.setConnectingCarrierSCAC(CommonUtils.getValueAsPerType(value));
							break;
						case 15:
							ceo.setCustomerStationNumber(CommonUtils.getValueAsPerType(value));
							break;
						case 16:
							dr.setRouteSCAC(CommonUtils.getValueAsPerType(value));
							break;
						case 17:
							dr.setSequenceNumber(CommonUtils.getValueAsPerType(value));
							break;
						case 18:
							dr.setR260JunctionId(CommonUtils.getValueAsPerType(value));
							break;
						case 19:
							dr.setDestinationStationNumber(CommonUtils.getValueAsPerType(value));
							break;
						case 20:
							ceo.setGuaranteeProgram(CommonUtils.getValueAsPerType(value));
							break;
						case 21:
							ceo.setSpecialInstructions(CommonUtils.getValueAsPerType(value));
							break;
						case 22:
							ceo.setOrganization(CommonUtils.getValueAsPerType(value));
							break;
						}
					
					}
					orderData.add(oq);
					desData.add(dr);
					ceo.setOrderQuantity(orderData);
					ceo.setDestinationRoute(desData);
					cmpData.add(ceo);
				}
			}
		}

		// System.out.println(cmpData);
		return cmpData;

	}

}
