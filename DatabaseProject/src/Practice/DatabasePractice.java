package Practice;

import java.sql.Connection;
import java.sql.*;

public class DatabasePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}
		catch(ClassNotFoundException ex) {
			System.out.println("Problem in loading the driver");
			ex.printStackTrace();
		}
		
		try {
			String dbName = "Employee.accdb";
			String dbURL = "jdbc:ucanaccess://" + dbName;
			conn = DriverManager.getConnection(dbURL);
			stat = conn.createStatement();
			String query;
			
			/*String query = "INSERT INTO EMP (EName,Salary) "
					+ "values ('ABC', 95000)";
			stat.executeUpdate(query);*/
			
			query = "UPDATE EMP SET SALARY = 120000 where EName = 'ABC' ";
			stat.executeUpdate(query);
			
			query = "delete from Empl where EName = 'Kim' ";
			stat.executeUpdate(query);
			
			rs = stat.executeQuery("SELECT * FROM EMPLOYEE");
			int id;
			String name;
			double sal;
			while(rs.next()) {
				id = rs.getInt(1);
				name = rs.getString(2);
				sal = rs.getDouble(3);
				System.out.println(" ID " + id + " name " + name + " sal " + sal);
			}
			
			
		}
		catch(SQLException ex)
		{
			System.out.println("Problem with database");
		}
		finally {
			try {
				if(conn!=null)
				{
					rs.close();
					stat.close();
					conn.close();
				}
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
	}

}
