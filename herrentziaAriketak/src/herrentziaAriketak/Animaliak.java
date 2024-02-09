package herrentziaAriketak;

public class Animaliak {

	private String arraza;
	private double pisua;
	private double altuera;
	
	
	public Animaliak(){}
	
	public Animaliak(String arraza, double pisua, double altuera) {
		this.arraza = arraza;
		this.pisua = pisua;
		this.altuera = altuera;
	}
	
	public void jaten() {
		System.out.println("Jaten ari naiz");
	}
	/**
	 * @return the arraza
	 */
	public String getArraza() {
		return arraza;
	}

	/**
	 * @param arraza the arraza to set
	 */
	public void setArraza(String arraza) {
		this.arraza = arraza;
	}

	/**
	 * @return the pisua
	 */
	public double getPisua() {
		return pisua;
	}

	/**
	 * @param pisua the pisua to set
	 */
	public void setPisua(double pisua) {
		this.pisua = pisua;
	}

	/**
	 * @return the altuera
	 */
	public double getAltuera() {
		return altuera;
	}

	/**
	 * @param altuera the altuera to set
	 */
	public void setAltuera(double altuera) {
		this.altuera = altuera;
	}

	@Override
	public String toString() {
		return "Animaliak [arraza=" + arraza + ", pisua=" + pisua + ", altuera=" + altuera + "]";
	}

	
}
