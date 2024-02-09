package Azterketa;

public class Erdilaria extends Jokalaria{
	
	//Erdilaria sortzailea
	protected int asistentziaKopurua;
	
	public Erdilaria(String izena, String abizena, int adina, boolean titularraDa, int asistentziaKopurua) {
        super(izena, abizena, adina, titularraDa);
        this.asistentziaKopurua = asistentziaKopurua;
    }

	//Erdilaria bistaratzeko
	@Override
	public String toString() {
		return "Erdilaria [asistentziaKopurua=" + asistentziaKopurua + ", izena=" + super.getIzena() +", abizena=" + super.getAbizena() +", adina=" + super.getAdina() + ", titularraDa=" + super.isTitularraDa() + "]";
	}
}
