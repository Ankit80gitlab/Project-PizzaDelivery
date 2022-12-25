import java.sql.*;

public class connection {

    static Connection con;
    static Statement stmt;
    static PreparedStatement ps;

    public static void establishConnection() {
        try {
            //register the driver and load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // establish a connection
            String user = "root";
            String pass = "Root";
            String url = "jdbc:mysql://localhost:3306/";

            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            System.out.println("CLASS NOT FOUND EXCEPTION - PLEASE CHECK CONNECTION");
        } catch (SQLException e) {
            System.out.println("CONNECTION ERROR - PLEASE CHECK CONNECTION");
        }
    }

    public static void createDatabase() {
        try {
            stmt = con.createStatement();

            String query = "create database pizzaDeliverySystem;";
            int count = stmt.executeUpdate(query);

            String query2 = "use pizzaDeliverySystem;";
            int count2 = stmt.executeUpdate(query2);
        } catch (SQLException e) {
            System.out.println("ERROR CREATING DATABASE - DATABASE IS ALREADY CREATED");
        }
    }

    public static void createTableAndKey() {
        try {
            String query1 = "create table item(itemId int primary key, category varchar(30));";
            stmt.executeUpdate(query1);

            String query2 = "create table pizza(pId int primary key, pName varchar(30), sizeS int, sizeM int, sizeL int, itemId int);";
            stmt.executeUpdate(query2);

            String query3 = "create table crust(cId int primary key, cName varchar(30), cPrice int, itemId int);";
            stmt.executeUpdate(query3);

            String query4 = "create table topping(tId int primary key, tName varchar(30), tPrice int, itemId int);";
            stmt.executeUpdate(query4);

            String query5 = "create table garlic(gId int primary key, gName varchar(30), gPrice int, itemId int);";
            stmt.executeUpdate(query5);

            String query6 = "create table beverage(bId int primary key, bName varchar(30), bPrice int, itemId int);";
            stmt.executeUpdate(query6);

            String query61 = "create table customer(name varchar(30) , phoneNo int, total int, itemId int);";
            stmt.executeUpdate(query61);

            String query7 = "alter table pizza add foreign key (itemId) references item(itemId) on delete cascade on update cascade;";
            stmt.executeUpdate(query7);

            String query8 = "alter table crust add foreign key (itemId) references item(itemId) on delete cascade on update cascade;";
            stmt.executeUpdate(query8);

            String query9 = "alter table topping add foreign key (itemId) references item(itemId) on delete cascade on update cascade;";
            stmt.executeUpdate(query9);

            String query10 = "alter table garlic add foreign key (itemId) references item(itemId) on delete cascade on update cascade;";
            stmt.executeUpdate(query10);

            String query11 = "alter table beverage add foreign key (itemId) references item(itemId) on delete cascade on update cascade;";
            stmt.executeUpdate(query11);

        } catch (SQLException e) {
            System.out.println("SQLException, database error");
        }
    }

    public static void dataInsertion() {
        try {
            stmt.executeUpdate("insert into item values(1,'pizza');");
            stmt.executeUpdate("insert into item values(2,'garlic bread');");
            stmt.executeUpdate("insert into item values(3,'beverages');");

            stmt.executeUpdate("insert into pizza values(1,'african peri peri pizza',0,350,450,1);");
            stmt.executeUpdate("insert into pizza values(2,'barbecue veg',0,300,400,1);");
            stmt.executeUpdate("insert into pizza values(3,'jamaican jerk veg',250,350,450,1);");
            stmt.executeUpdate(" insert into pizza values(4,'what a pizza exotic',200,300,400,1);");
            stmt.executeUpdate(" insert into pizza values(5,'english cheddar',175,375,500,1);");

            stmt.executeUpdate("insert into crust values(1,'wheat thin crust',60,1);");
            stmt.executeUpdate("insert into crust values(2,'fresh pan base',80,1);");
            stmt.executeUpdate("insert into crust values(3,'hand tossed',70,1);");

            stmt.executeUpdate("insert into topping values(1,'extra cheese',80,1);");
            stmt.executeUpdate("insert into topping values(2,'veg toppings',120,1);");

            stmt.executeUpdate("insert into garlic values(1,'stuffed garlic bread',90,2);");
            stmt.executeUpdate("insert into garlic values(2,'plain garlic bread sticks',80,2);");

            stmt.executeUpdate("insert into beverage values(1,'pepsi',60,2);");
            stmt.executeUpdate("insert into beverage values(2,'coke',60,2);");
        } catch (SQLException e) {
            System.out.println("SQLException, database error");
        }
    }

    public static void customerData(int input, String name, long phoneNo, int total) {
        try {
            stmt.executeUpdate("use pizzaDeliverySystem;");

            if (input == 1) {
                ps=con.prepareStatement("insert into customer values(?,?,?,1)");
                ps.setString(1,name);
                ps.setInt(2, (int) phoneNo);
                ps.setInt(3,total);
                ps.executeUpdate();
            }
            else if (input == 2) {
                ps=con.prepareStatement("insert into customer values(?,?,?,2)");
                ps.setString(1,name);
                ps.setInt(2, (int) phoneNo);
                ps.setInt(3,total);
                ps.executeUpdate();
            }
            else if (input == 3) {
                ps=con.prepareStatement("insert into customer values(?,?,?,3)");
                ps.setString(1,name);
                ps.setInt(2, (int) phoneNo);
                ps.setInt(3,total);
                ps.executeUpdate();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("SQLException, database error");
        }
    }
}
