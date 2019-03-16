import java.sql.*;

public class FetchMultipleRows 
{

	public static void main(String[] args)  throws Exception
	{
	
		String url="jdbc:mysql://localhost:3306/learning";
		String uid="root";
		String pwd="myrootpwd";
		String query="Select * from Student";
		String userData;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,uid,pwd);
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next())
		{
			userData = rs.getString("userId") + " : " + rs.getString("userName");
			System.out.println(userData);
		}
		
		st.close();
		con.close();
	}

}