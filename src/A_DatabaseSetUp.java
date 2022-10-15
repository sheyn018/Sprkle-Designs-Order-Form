import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class A_DatabaseSetUp
{
    static String strDriver = "com.mysql.cj.jdbc.Driver";
    static String strConn = "jdbc:mysql://localhost:3306/";
    static String strUser = "root";
    static String strPass = "";

    static Connection objConn;
    static String strTable, strDb, strInput;

    public static void main(String[] args)
    {
    	CreateDB();
    	CreateTables();
    }

    public static void CreateDB()
    {
        try
        {
            Class.forName(strDriver);

        	Scanner objDataEntry = new Scanner(System.in);

        	System.out.print("Enter the root password: ");
        	strPass = objDataEntry.next();

        	objConn = DriverManager.getConnection(strConn, strUser, strPass);
        	System.out.print("Login successful...\n\n");

        	Statement objCreateDB = objConn.createStatement();

        	String strCreateDB = "CREATE DATABASE OrderForm;";
        	objCreateDB.executeUpdate(strCreateDB);

        	System.out.print("Database 'OrderForm' has been created...");

        	objDataEntry.close();
        }

        catch (Exception objEx)
        {
            System.out.println("Login failed!");
            System.out.println(objEx.toString());
        }

        finally
        {
            strConn = "jdbc:mysql://localhost:3306/OrderForm";
        }
     }

     public static void CreateTables()
     {
    	 try
         {
    		 objConn = DriverManager.getConnection(strConn, strUser, strPass);

	         String strSQLCreateTable1 = "CREATE TABLE TblOrder (" +
	                                     "OrderID VARCHAR(10) NOT NULL, OrderDesc VARCHAR(15) NOT NULL, OrderPrice DECIMAL(18,2) NOT NULL, "
	                                     + "PRIMARY KEY (OrderID))";

	         String strSQLCreateTable2 = "CREATE TABLE TblClient (" +
					                     "ClientNum VARCHAR(5) NOT NULL, ClientName VARCHAR(50) NOT NULL, ClientContact VARCHAR(11) NOT NULL, ClientEmail VARCHAR(30) NOT NULL, " +
					                     "PaymentRefNumber VARCHAR(15) NOT NULL, PaymentMode VARCHAR(10) NOT NULL,"
					                     + "PRIMARY KEY (ClientNum))";

	         String strSQLCreateTable3 = "CREATE TABLE TblTransaction (" +
	            						 "TransactionNum VARCHAR(10) NOT NULL, TransactionDate DATE NOT NULL, ClientNum VARCHAR(5) NOT NULL, "
	            						 + "PRIMARY KEY (TransactionNum), Constraint FK FOREIGN KEY (ClientNum) REFERENCES TblClient(ClientNum))";

	         String strSQLCreateTable4 = "CREATE TABLE TblCharacteristics (" +
						            	 "TransactionNum VARCHAR(10) NOT NULL, OrderID VARCHAR(10) NOT NULL, OrderContent VARCHAR(500) NOT NULL, " +
					                     "OrderSize VARCHAR(10) NOT NULL, OrderQty INT(2) NOT NULL, OrderTotal DECIMAL(18,2) NOT NULL, GrandTotal DECIMAL(18,2) NOT NULL,"
					                     + "Constraint FK1 FOREIGN KEY (TransactionNum) REFERENCES TblTransaction(TransactionNum),"
					                     + "Constraint FK2 FOREIGN KEY (OrderID) REFERENCES TblOrder(OrderID))";

	         Statement objCreateTable = objConn.createStatement();

	         objCreateTable.executeUpdate(strSQLCreateTable1);
	         objCreateTable.executeUpdate(strSQLCreateTable2);
	         objCreateTable.executeUpdate(strSQLCreateTable3);
	         objCreateTable.executeUpdate(strSQLCreateTable4);

	         String strInsertTblOrder = "INSERT INTO TblOrder (OrderID, OrderDesc, OrderPrice) VALUES "
	            						+ "('GD-001', 'Logo', 500.00), "
	            						+ "('GD-002', 'Product Ads', 150.00), "
	            						+ "('GD-003', 'Shop Template', 150.00), "
	            						+ "('GD-004', 'Product Label', 150.00), "
	            						+ "('GD-005', 'Card Layout', 200.00), "
	            						+ "('GD-006', 'Cover Photo', 500.00)";

	         objCreateTable.executeUpdate(strInsertTblOrder);

	         System.out.println("\nDatabase tables complete...");
          }

          catch (Exception objEx)
	      {
        	  System.out.println("Database tables failed!");
	          System.out.println(objEx.toString());
	      }
      }
}
