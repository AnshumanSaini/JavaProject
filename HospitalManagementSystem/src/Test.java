import java.sql.*;

public class Test {

	public static void main(String[] args) 
	{
		Connection connection = null;
		try 
                {
			// below two lines are used for connectivity.
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root", "root");

			// mydb is database
			// mydbuser is name of database
			// mydbuser is password of database

			Statement statement;
			statement = connection.createStatement();
			ResultSet resultSet;
			resultSet = statement.executeQuery("select * from sample");
			int rollno;
			String name;
			while (resultSet.next()) 
			{
				rollno = resultSet.getInt("rollno");
				name = resultSet.getString("name").trim();
				System.out.println("rollno : " + rollno + " name : " + name);
			}
			resultSet.close();
			statement.close();
			connection.close();
		}
		catch (Exception exception) 
                {
			System.out.println(exception);
		}
	}

}
