package Azterketa;


public class Taldea {
	
	private String izena;
    private String herria;
    
    //Taldearen sortailea
    
    public Taldea(String izena, String herria, Entrenatzailea entrenatzailea, Atezaina atezaina, Atzelaria[] atzelariak, Erdilaria[] erdilariak, Aurrelaria[] aurrelariak) {
    	this.izena = izena;
        this.herria = herria;
        
        
    }
    
    //Bistaratzeko funtzioa
    public void Bistaratu(Entrenatzailea entrenatzailea, Atezaina atezaina, Atzelaria[] atzelariak, Erdilaria[] erdilariak, Aurrelaria[] aurrelariak) {
    	
    	System.out.println(this.toString());
    	System.out.println(entrenatzailea.toString());
    	System.out.println(atezaina.toString());
    	for(int i = 0; i!= 4 ; i++) {
    		System.out.println(atzelariak[i].toString());
    	}
    	for(int i = 0; i!= 4 ; i++) {
    		System.out.println(erdilariak[i].toString());
    	}
    	for(int i = 0; i!= 2 ; i++) {
    		System.out.println(aurrelariak[i].toString());
    	}  
    }

	@Override
	public String toString() {
		return "Taldea [izena=" + izena + ", herria=" + herria + "]";
	}
}
