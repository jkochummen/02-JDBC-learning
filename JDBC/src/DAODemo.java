import java.sql.*;

public class DAODemo 
{

	public static void main(String[] args) throws Exception
	{


//Input data for search and addition
		String rollnumber = "112";
		String name = "Peter";

		DAOClass dao = new DAOClass();
		
//      Add new student
		dao.addStudent(rollnumber, name);

//      Search for a student.
		Student s1 = dao.searchStudentByRollnum(rollnumber);
				
		System.out.println("Student name for the roll number " + s1.rollnum + " is " + s1.name);

	}

}

class Student
{
	String rollnum;
	String name;
}

class DAOClass
{
	//Connections strings
	String uid="root";
	String upwd="myrootpwd";
	String url="jdbc:mysql://localhost:3306/learning";
	
	String query;
	String AddQuery = "insert into Student values(?,?);";
	String searchQuery = "select userName from Student where userid = ?;";
	
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
			
	public void connect() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,uid,upwd);
		st = con.prepareStatement(query);
	}
	
	
	public Student searchStudentByRollnum(String srollnum) throws Exception
	{
		query = searchQuery;
		connect();	
		st.setString(1,srollnum);	
		
		rs = 	st.executeQuery();
		
		while(rs.next())
		{
			Student s = new Student();
			s.name = rs.getString(1);
			s.rollnum = srollnum;
			return s;
		}
		
		return null;

	}
	
	public void addStudent(String srollnum, String sname) throws Exception
	{
		query = AddQuery;
		connect();	
		
		st.setString(1,srollnum);	
		st.setString(2,sname);
		
		st.executeUpdate();
		
		System.out.println("Successfully added the Student: " + sname + " to the system" );
		
	}
	

}