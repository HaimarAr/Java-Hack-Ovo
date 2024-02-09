package Azterketa;

public class Atezaina extends Jokalaria{
	
	protected int jasotakogolak;
	//Atezaina sortzailea
	public Atezaina(String izena, String abizena, int adina, boolean titularraDa, int jasotakogolak) {
        super(izena, abizena, adina, titularraDa);
        this.jasotakogolak = jasotakogolak;
    }

	
	//Atezaina bistaratzeko
	@Override
	public String toString() {
		return "Atezaina [jasotakogolak=" + jasotakogolak + ", izena=" + super.getIzena() +", abizena=" + super.getAbizena() +", adina=" + super.getAdina() + ", titularraDa=" + super.isTitularraDa() + "]";
	}

}
