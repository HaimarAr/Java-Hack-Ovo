package Azterketa;

public class Main {
	
	//Lehenengo hau exekutatuko da.
	public static void main(String[] args) {
		
		//Taldeaegiteko beharrezkoak diren Objetuak sortu
		Entrenatzailea entrenatzailea = new Entrenatzailea("Javier", "Clemente", 73, 48 ,true );
		
		 Atezaina atezaina = new Atezaina("Alex", "Remiro", 28, true, 18);	
		
		 //Atzelariak gorde arrayan
		 Atzelaria[] atzelariak = new Atzelaria[4];
		 
		 atzelariak[0] = new Atzelaria("Igor", "Zubeldia", 26, true);
		 atzelariak[1]  = new Atzelaria("David", "Garcia", 29, true);
		 atzelariak[2]  = new Atzelaria("Yuri", "Berchiche", 33, true);
		 atzelariak[3]  = new Atzelaria("Iñigo", "Lekue", 30, true);
		 
		//Erdilariak gorde arrayan
		 Erdilaria[] erdilariak = new Erdilaria[4];
		 
	 	 erdilariak[0] = new Erdilaria("Martin", "Zubimendi", 25, true, 2);
	 	 erdilariak[1]= new Erdilaria("Oihan", "Sancet", 23, true, 4);
	 	 erdilariak[2] = new Erdilaria("Ander", "Barrenetxea", 22, true, 2);
	 	 erdilariak[3] = new Erdilaria("Niko", "Williams", 21, true, 6);
		 
	 	 //Aurrelariak gorde arrayan
	 	 Aurrelaria[] aurrelariak = new Aurrelaria[2];
		 
		 aurrelariak[0] = new Aurrelaria("Gorka", "Guruzeta", 27, true, 8);
		 aurrelariak[1] = new Aurrelaria("Mikel", "Oyarzabal", 27, true, 8);
		 
		 //Taldea sortu
		
		Taldea taldea = new Taldea("Euskal Selekzioa", "Euskadi", entrenatzailea, atezaina, atzelariak, erdilariak, aurrelariak);
		
		//Taldea imprimatu
		
		taldea.Bistaratu(entrenatzailea , atezaina, atzelariak, erdilariak, aurrelariak);
		
    }
}
