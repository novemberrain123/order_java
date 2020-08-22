package order_java.classes;

public class ReportData{
    private String apparelType;
    private char apparelSize;
    private int totalSold;
    private double totalSales;

    public ReportData(String apprelType, char apparelSize,int totalSold )
    {
        this.apparelSize=apparelSize;
        this.apparelType=apparelType;
        this.totalSold=totalSold; 
          
    }

    public String getapprelType()
    {
            return apparelType;
    }

    public char getapprelSizeString()
    {
            return apparelSize;
    }

    public int getTotalSold()
    {
            return totalSold;
    }

    public void setTotalSales(String apparelType, char apparelSize)
    {
        // double total;
        //     if(apparelSize=='S')
        //     {
        //         total=
        //     }
    }

    public int getTotalSales()
    {
            return totalSold;
    }





    
}