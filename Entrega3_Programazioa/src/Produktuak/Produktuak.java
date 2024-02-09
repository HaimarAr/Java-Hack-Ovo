package Produktuak;

public abstract class Produktuak {
	
	private String izena;
	private double balioa;
	
	public Produktuak(String izena, double balioa) {
		this.izena = izena;
		this.balioa = balioa;
	}

	public void informazioaErakutsi() {
		System.out.println("Izena: " + izena +".");
		System.out.println("Balioa: " + balioa + "$");
	}
	
}
