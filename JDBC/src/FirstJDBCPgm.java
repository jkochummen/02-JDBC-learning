import java.sql.*;

public class FirstJDBCPgm 
{

	public static void main(String[] args) throws Exception
	{
		String url ="jdbc:mysql://localhost:3306/learning";
		String uid = "root";
		String pswd = "myrootpwd";
		String query = "select userName from Student where userId='101';";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,uid,pswd);
		
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		rs.next();
		
		String name = rs.getString("username");
		
		System.out.println(name);
		
		st.close();
		con.close();
		//*/
		
	}

}
