package Constants;

public class ConstantsTobeUsed {
	public int rowLength;
	public String FilePath=System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
	public String FileName="MediaMarket312_EU_20191206.xlsx";
	public String SheetName="Details";
	public String[] nombre;
	public String[] marca;
	public Double[] precio;
	public String[] link;
	public String[] link_img;
	public String[] ean;
	public int[] availability;
	public ConstantsTobeUsed(String[] nombre1,String[] marca1,Double[] precio1,String[] link1,String[] link_img1,String[] ean1,int[] availability1,int length) {
		nombre=nombre1;
		marca=marca1;
		precio=precio1;
		link=link1;
		link_img=link_img1;
		ean=ean1;
		rowLength=length;
		availability=availability1;
	}
	public ConstantsTobeUsed() {
		
	}
}
