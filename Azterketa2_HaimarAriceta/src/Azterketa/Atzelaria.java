package Azterketa;

public class Atzelaria extends Jokalaria {
	
	//Atzelaria sortzailea
	public Atzelaria(String izena, String abizena, int adina, boolean titularraDa) {
        super(izena, abizena, adina, titularraDa);
    }
	
	
	//Atzelaria bistaratzeko
	@Override
	public String toString() {
		return "Atzelaria [izena=" + super.getIzena() +", abizena=" + super.getAbizena() +", adina=" + super.getAdina() + ", titularraDa=" + super.isTitularraDa() + "]";
	}
}
