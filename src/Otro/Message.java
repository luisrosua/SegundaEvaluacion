package Otro;

public class Message {
	private String text;
	private int idRemite;
	private int idDestino;
	private boolean nuevo;
	
	public Message(String text, int rem, int des, boolean nuevo){
		this.text = text;
		this.idRemite = rem;
		this.idDestino = des;
		this.nuevo = nuevo;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getIdRemite() {
		return idRemite;
	}

	public void setIdRemite(int idRemite) {
		this.idRemite = idRemite;
	}

	public int getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

	public boolean isNuevo() {
		return nuevo;
	}

	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}
	
	public String toString() {
		return this.text+" "+this.nuevo;
	}
}
