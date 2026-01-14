package DBUser;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBconnectionuser {
	public static Connection getConnection() {
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/users";
		String username="root";
		String password="MySql987";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
