import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class operations {


    static String user = "root";
    static String pass = "Root";
    static String url = "jdbc:mysql://localhost:3306/pizzaDeliverySystem";
    static Connection con;
    static PreparedStatement ps;

    public static void displayingItem()
    {
        try {

            con = DriverManager.getConnection(url, user, pass);
            ps = con.prepareStatement("use pizzaDeliverySystem;");
            ps.executeUpdate();

            String query = "select itemId, category from item;";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println("------------------------------------------------------------------");
            System.out.format("%-10s %-20s","S.NO","CATEGORY");
            System.out.println();
            while (rs.next())
            {
                int itemId = rs.getInt(1);
                String category = rs.getString(2);

                System.out.format("%-10s %-20s",itemId,category.toUpperCase());
                System.out.println();
            }
            System.out.println("------------------------------------------------------------------");

        }
        catch (SQLException e)
        {
            System.out.println("SQLException, database error");
        }
    }

    public static void displayingPizza()
    {
        try {

            con = DriverManager.getConnection(url, user, pass);
            ps = con.prepareStatement("use pizzaDeliverySystem;");
            ps.executeUpdate();

            String query = "select pId, pName, sizeS, sizeM, sizeL from pizza;";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println("------------------------------------------------------------------");
            System.out.format("%-6s %-25s %-12s %-12s %-12s","S.NO","PIZZA NAME","SMALL","MEDIUM","LARGE");
            System.out.println();
            while (rs.next())
            {
                int pId = rs.getInt(1);
                String pName = rs.getString(2);
                int sizeS = rs.getInt(3);
                int sizeM = rs.getInt(4);
                int sizeL = rs.getInt(5);

                System.out.format("%-6s %-25s %-12s %-12s %-12s",pId,pName.toUpperCase(),sizeS,sizeM,sizeL);
                System.out.println();
            }
            System.out.println("------------------------------------------------------------------");

        }
        catch (SQLException e)
        {
            System.out.println("SQLException, database error");
        }
    }

    public static void displayingCrust()
    {
        try {

            con = DriverManager.getConnection(url, user, pass);
            ps = con.prepareStatement("use pizzaDeliverySystem;");
            ps.executeUpdate();

            String query = "select cId, cName, cPrice from crust;";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println("------------------------------------------------------------------");
            System.out.format("%-10s %-10s %-10s","S.NO","CRUST NAME","PRICE");
            System.out.println();
            while (rs.next())
            {
                int cId = rs.getInt(1);
                String cName = rs.getString(2);
                int cPrice = rs.getInt(3);
                
                System.out.format("%-10s %-10s %-10s",cId,cName.toUpperCase(),cPrice);
                System.out.println();
            }
            System.out.println("------------------------------------------------------------------");

        }
        catch (SQLException e)
        {
            System.out.println("SQLException, database error");
        }
    }

    public static void displayingTopping()
    {
        try {

            con = DriverManager.getConnection(url, user, pass);
            ps = con.prepareStatement("use pizzaDeliverySystem;");
            ps.executeUpdate();

            String query = "select tId, tName, tPrice from topping;";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println("------------------------------------------------------------------");
            System.out.format("%-10s %-10s %-10s","S.NO","TOPPING NAME","PRICE");
            System.out.println();
            while (rs.next())
            {
                int tId = rs.getInt(1);
                String tName = rs.getString(2);
                int tPrice = rs.getInt(3);

                System.out.format("%-10s %-10s %-10s",tId,tName.toUpperCase(),tPrice);
                System.out.println();
            }
            System.out.println("------------------------------------------------------------------");

        }
        catch (SQLException e)
        {
            System.out.println("SQLException, database error");
        }
    }

    public static void displayingGarlic()
    {
        try {

            con = DriverManager.getConnection(url, user, pass);
            ps = con.prepareStatement("use pizzaDeliverySystem;");
            ps.executeUpdate();

            String query = "select gId, gName, gPrice from garlic;";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println("------------------------------------------------------------------");
            System.out.format("%-10s %-10s %-10s","S.NO","BREAD NAME","PRICE");
            System.out.println();
            while (rs.next())
            {
                int gId = rs.getInt(1);
                String gName = rs.getString(2);
                int gPrice = rs.getInt(3);

                System.out.format("%-10s %-10s %-10s",gId,gName.toUpperCase(),gPrice);
                System.out.println();
            }
            System.out.println("------------------------------------------------------------------");

        }
        catch (SQLException e)
        {
            System.out.println("SQLException, database error");
        }
    }

    public static void displayingBeverage()
    {
        try {

            con = DriverManager.getConnection(url, user, pass);
            ps = con.prepareStatement("use pizzaDeliverySystem;");
            ps.executeUpdate();

            String query = "select bId, bName, bPrice from beverage;";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println("------------------------------------------------------------------");
            System.out.format("%-10s %-10s %-10s","S.NO","BEVERAGE NAME","PRICE");
            System.out.println();
            while (rs.next())
            {
                int bId = rs.getInt(1);
                String bName = rs.getString(2);
                int bPrice = rs.getInt(3);

                System.out.format("%-10s %-10s %-10s",bId,bName.toUpperCase(),bPrice);
                System.out.println();
            }
            System.out.println("------------------------------------------------------------------");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("SQLException, database error");
        }
    }
}
