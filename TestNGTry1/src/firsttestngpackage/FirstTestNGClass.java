package firsttestngpackage;

import firsttestngpackage.ExcelUtils;



public class FirstTestNGClass {
   public static void main() {
	   
	   System.out.println("Total Number of Rows in the excel is : "+ExcelUtils.rowCount());
	   System.out.println("Total Number of Columns in the excel is : "+ExcelUtils.columnCount());
	   
   }
}