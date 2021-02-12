package Database;

import java.sql.ResultSet;
import java.sql.Statement;
import Otro.User;

public class DBEmail extends Database{
	
	Statement stm;
	
	public DBEmail() throws Exception{
		this.stm = this.con.createStatement();
	}
	
	public User getUser(String name, String pass) throws Exception{
		User u = null;
		String sql = "SELECT * FROM usuarios WHERE usuario = '"+name+"' AND pass = '"+pass+"'";
		
		ResultSet result = this.stm.executeQuery(sql);
		
		if(result.next()) {
			u = new User(result.getInt("id_usuario"), result.getString("usuario"), result.getString("pass"));
		}
		return u;
	}
}
