package Utils;

import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class CommonUtils {
	
	public static int appendRandomNumber() {

		Random random = new Random();
		return random.nextInt(2000);

	}
	
	public static String getValueAsPerType(Cell cell) {

		String value = null;

		if (cell.getCellType() == CellType.STRING) {
			value = cell.getStringCellValue();

		} else {

			value = String.valueOf((int) cell.getNumericCellValue());
		}
		return value;
	}

}
