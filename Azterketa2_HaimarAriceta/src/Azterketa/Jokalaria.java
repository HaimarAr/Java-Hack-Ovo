package Azterketa;



public class Jokalaria extends Pertsona {
	//Jokalaria sortzailea
	private boolean titularraDa; 
	
	public Jokalaria(String izena, String abizena, int adina, boolean titularraDa) {
        super(izena, abizena, adina);
        this.titularraDa = titularraDa;
    }

	/**
	 * @return the titularraDa
	 */
	//Booleanoaren balorea lortzeko
	public boolean isTitularraDa() {
		return titularraDa;
	}

	/**
	 * @param titularraDa the titularraDa to set
	 */
	public void setTitularraDa(boolean titularraDa) {
		this.titularraDa = titularraDa;
	}
	 
	 
}
