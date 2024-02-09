package obp;

public class pertsona {
	String izena;
	String abizenak;
	int adina;
	float altuera;
	float pisua;
	
	
	//Ekintzak metodo bidez
	public pertsona() {
		this.izena = "ezezaguna";
		this.abizenak = "ezezaguna";
		this.adina = 0;
	}
	public pertsona(String izena, String abizenak) {
		this.izena = izena;
		this.abizenak = abizenak;
		
	}
	
	
	public pertsona(String izena, String abizenak, int adina) {
 		this.izena = izena;
		this.abizenak = abizenak;
		this.adina = adina;
	}
	public void jaio() {
		System.out.println("Jaio naiz");
	}
	public void HitzEgin() {
		System.out.println("Hitz egin dezaket");
	}
	@Override
	public String toString() {
		return "pertsona [izena=" + izena + ", abizenak=" + abizenak + ", adina=" + adina + ", altuera=" + altuera
				+ ", pisua=" + pisua + "]";
	}
	
	
}
