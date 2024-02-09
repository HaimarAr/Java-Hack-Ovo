package denda;

public class produktua {
	private String izena;
	private double prezioa;
	
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public double getPrezioa() {
		return prezioa;
	}
	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	public produktua(String izena, double prezioa) {
		this.izena = izena;
		this.prezioa = prezioa;
	}

	public produktua() {
		this.izena = "Sagarra";
		this.prezioa = 2.30;
	}


}
