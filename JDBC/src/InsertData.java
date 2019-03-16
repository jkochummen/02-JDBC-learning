import java.sql.*;

public class InsertData 
{

	public static void main(String[] args) throws Exception
	{
	
		String url ="jdbc:mysql://localhost:3306/learning";
		String uid = "root";
		String pwd = "myrootpwd";
		String query1 ="Insert into Student values('107','Sinju')";
	
		String usrId = "108";
		String usrName = "Sarah";
		String query2 = "Insert into Student values(?,?);";
		
		String query3 ="select * from Student";				
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,uid,pwd);
		
	// insert using embeded data values int he query
		Statement st1 = con.createStatement();
		
		st1.executeUpdate(query1);

	// insert using prepared query

		PreparedStatement st2 = con.prepareStatement(query2);
		st2.setString(1, usrId);
		st2.setString(2, usrName);
		int rowsinserted = st2.executeUpdate();
		
		System.out.println(rowsinserted + " row/s inserted\n");

	// Select all records from the database.
		Statement st3 = con.createStatement();
		ResultSet rs = st3.executeQuery(query3);

		while(rs.next())
		{
			System.out.println(rs.getString("userId") + " : " + rs.getString("userName"));
		}

	}

}
