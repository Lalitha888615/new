import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Source {
	private static String url="jdbc:postgresql://localhost:5432/capgaws101b10";
    private static String user="postgres";
    private static String password="P@dma123";
    private static Connection con=null;
    private static Statement stmt=null;
    
	public static void createConnection() throws ClassNotFoundException,SQLException {
	try {
		Class.forName("org.postgresql.Driver");
	    con=DriverManager.getConnection(url,user,password);
		System.out.println("Connection successful");
	    }
	    catch(SQLException ex) {
	    	System.out.println("Check connection details");
	    }
        catch(ClassNotFoundException ex) {
        	System.out.println("Check the driver");
        }
	 }
	public static void insertRecord(int id,String name,int age, int salary, String designation) throws SQLException {
	    String q="insert into employees values(" +id + ",'" +name+  "'," + age + "," + salary + ")";
	    stmt=con.createStatement();
	stmt.execute(q);
	System.out.println("Record inserted"); 
	
	    
	}
	public static void deleteRecord(int id) throws SQLException {
	    try {
	        String q="Delete from employees where employee_id=" + id; 
	        stmt=con.createStatement();
	        stmt.execute(q);
	        System.out.println("Record deleted successfully");
	        }
	        catch(SQLException ex) {
	            System.out.println("Check query");
	        }

	    }
	public static void displayRecords() throws SQLException {
	    stmt=con.createStatement();
	    String q="select * from employees"; 
	  
	    ResultSet rs=    stmt.executeQuery(q);
	    ResultSetMetaData rsmd=rs.getMetaData();
	    for(int i=1;i<=rsmd.getColumnCount() ; i++) {
	        System.out.print(rsmd.getColumnName(i)+"\t");
	    }
	    System.out.println();
	while(rs.next()) {
	    System.out.print(rs.getInt(1) + "\t\t");
	    System.out.print(rs.getString(2) + "\t\t");
	    System.out.print(rs.getInt("employee_age") + "\t\t");
	    System.out.print(rs.getInt(4) + "\n");
	    

	} 
  }
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		int id;
		String name;
		int age;
		int salary;
	
		createConnection();
		//System.out.println("Enter your id, name, age, salary");
		//id=sc.nextInt();
		//name=sc.next();
		//age=sc.nextInt();
		//salary=sc.nextInt();
		//designation=sc.next(); 
		  

		//insertRecord(id, name, age, salary); 
		  
		displayRecords();
		    }
		  
		}

	  





