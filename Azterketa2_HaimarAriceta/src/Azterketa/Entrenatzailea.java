package Azterketa;

public class Entrenatzailea extends Pertsona {

	//Entrenatzailea sortzailea
	protected int esperientziaUrteak;
	protected boolean euskaldunaDa; 
	
	public Entrenatzailea(String izena, String abizena, int adina, int esperientziaUrteak, boolean euskaldunaDa) {
        super(izena, abizena, adina);
        this.esperientziaUrteak = esperientziaUrteak;
        this.euskaldunaDa = euskaldunaDa;
    }
	
	//Entrenatzailea bistaratzeko
	@Override
	public String toString() {
		return "Entrenatzailea [izena=" + super.getIzena() + ", abizena=" + super.getAbizena() + ", adina=" + super.getAdina() + ", esperientziaUrteak=" + esperientziaUrteak + ", euskaldunaDa=" + euskaldunaDa + "]";
	}
	
	
}
