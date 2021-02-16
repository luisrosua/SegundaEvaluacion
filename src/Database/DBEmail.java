package Database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Otro.Message;
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
	
	public boolean newUser(String name, String pass) throws Exception{
		String sql = "INSERT INTO usuarios(usuario, pass) VALUES ('"+name+"','"+pass+"')";
		try {
			this.stm.executeUpdate(sql);
			return true;
		}
		catch(Exception ex){
			return false;
		} 
	}
	
	public ArrayList<Message> getMessages(User u) throws Exception{
		ArrayList<Message> m = new ArrayList<Message>();
		Message me = null;
		String sql = "SELECT * FROM mensajes WHERE id_destino = '"+u.getId()+"'";
		
		ResultSet result = this.stm.executeQuery(sql);
		while(result.next()) {
			me = new Message(result.getString("texto"), result.getInt("id_remite"), result.getInt("id_destino"), result.getBoolean("nuevo"));
			m.add(me);
		}
		
		return m;
	}
	
	public void sendMessage(Message m) throws Exception{
		String sql = "INSERT INTO mensajes(texto, id_remite, id_destino, nuevo) VALUES ('"+m.getText()+"', '"+m.getIdRemite()+"', '"+m.getIdDestino()+"',1)";
		this.stm.executeUpdate(sql);
	}
}
