package order_java.classes;

//import jdk.javadoc.internal.doclets.toolkit.resources.doclets;

public class ReportData{
        
    static double[] Sales_S_Shirt=new double[2]; // quantity & revenue
    static double[] Sales_M_Shirt=new double[2];
    static double[] Sales_L_Shirt=new double[2];
    static double[] Sales_S_Hoodie=new double[2];
    static double[] Sales_M_Hoodie=new double[2];
    static double[] Sales_L_Hoodie=new double[2];



    public ReportData()
    {
        // this.apparelType=apparelType;
        // this.apparelSize=apparelSize;    
        
    }

    

    public static double getQuantity_S_Shirt()
    {
            Sales_S_Shirt[0]=Apparel.totalSold[0][0];
            return Sales_S_Shirt[0];
    }

    public static double getRevenue_S_Shirt()
    {   
            Sales_S_Shirt[1]=Apparel.totalSold[0][0]*Apparel.prices[0][0];
            return Sales_S_Shirt[1];
    }

    public static double getQuantity_M_Shirt()
    {
            Sales_M_Shirt[0]=Apparel.totalSold[0][1];
            return Sales_M_Shirt[0];
    }

    public static double getRevenue_M_Shirt()
    {   
            Sales_M_Shirt[1]=Apparel.totalSold[0][1]*Apparel.prices[0][1];
            return Sales_M_Shirt[1];
    }

    public static double getQuantity_L_Shirt()
    {
            Sales_L_Shirt[0]=Apparel.totalSold[0][2];
            return Sales_L_Shirt[0];
    }

    public static double getRevenue_L_Shirt()
    {   
            Sales_L_Shirt[1]=Apparel.totalSold[0][2]*Apparel.prices[0][2];
            return Sales_L_Shirt[1];
    }

    public static double getQuantity_S_Hoodie()
    {
            Sales_S_Hoodie[0]=Apparel.totalSold[1][0];
            return Sales_S_Hoodie[0];
    }
    
    public static double getRevenue_S_Hoodie()
    {
            Sales_S_Hoodie[1]=Apparel.totalSold[1][0]*Apparel.prices[1][0];
            return Sales_S_Hoodie[1];
    }

    public static double getQuantity_M_Hoodie()
    {
            Sales_M_Hoodie[0]=Apparel.totalSold[1][1];
            return Sales_M_Hoodie[0];
    }

    public static double getRevenue_M_Hoodie()
    {
            Sales_M_Hoodie[1]=Apparel.totalSold[1][1]*Apparel.prices[1][1];
            return Sales_M_Hoodie[1];
    }

    public static double getQuantity_L_Hoodie()
    {
            Sales_L_Hoodie[0]=Apparel.totalSold[1][2];
            return Sales_L_Hoodie[0];
    }

    public static double getRevenue_L_Hoodie()
    {
            Sales_L_Hoodie[1]=Apparel.totalSold[1][2]*Apparel.prices[1][2];
            return Sales_L_Hoodie[1];
    }

    





    
}