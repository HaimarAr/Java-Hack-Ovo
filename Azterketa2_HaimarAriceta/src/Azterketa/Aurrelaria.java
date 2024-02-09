package Azterketa;

public class Aurrelaria extends Jokalaria {
	protected int golKopurua;
	//Aurrelaria sortzailea
	public Aurrelaria(String izena, String abizena, int adina, boolean titularraDa, int golKopurua) {
	   super(izena, abizena, adina, titularraDa);
	   this.golKopurua = golKopurua;
	}
	
	//Aurrelaria bistaratzeko
	@Override
	public String toString() {
		return "Aurrelaria [golKopurua=" + golKopurua + ", izena=" + super.getIzena() +", abizena=" + super.getAbizena() +", adina=" + super.getAdina() + ", titularraDa=" + super.isTitularraDa() + "]";
	}
}
