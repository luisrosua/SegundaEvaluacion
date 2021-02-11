package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	private Connection con = null;
	private String url;
	private String user;
	private String pass;
	
	public Database() throws Exception{
		con = null;
		url = "jdbc:mysql://localhost:3396/email";
		user = "root";
		pass = "";
		con = DriverManager.getConnection(url, user, pass);
	}
}
