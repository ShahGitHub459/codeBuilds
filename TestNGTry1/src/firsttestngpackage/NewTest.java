package firsttestngpackage;

import org.testng.annotations.Test;
import firsttestngpackage.ExcelUtils;
public class NewTest {
  @Test
  public void f() {
	   System.out.println("Total Number of Rows in the excel is : "+ExcelUtils.rowCount());
	   System.out.println("Total Number of Columns in the excel is : "+ExcelUtils.columnCount());
	
  }
}
