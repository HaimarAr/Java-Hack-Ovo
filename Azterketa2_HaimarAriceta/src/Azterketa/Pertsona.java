package Azterketa;

//Pertsona sortu 
public class Pertsona {
	 	private String izena;
	    private String abizena;
	    private int adina;

	    public Pertsona(String izena, String abizena, int adina) {
	        this.izena = izena;
	        this.abizena = abizena;
	        this.adina = adina;
	    }
	     
	    //setter eta getter-ak ezarri baloreak ezartzeko
	    public String getIzena() {
	        return izena;
	    }

	    public void setIzena(String izena) {
	        this.izena = izena;
	    }

	    public String getAbizena() {
	        return abizena;
	    }

	    public void setAbizena(String abizena) {
	        this.abizena = abizena;
	    }

	    public int getAdina() {
	        return adina;
	    }

	    public void setAdina(int adina) {
	        this.adina = adina;
	    }
}
