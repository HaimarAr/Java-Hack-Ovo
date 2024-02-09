package denda;

public class Hasiera{

	public static void main(String[] args) {
		produktua produktu = new produktua();
		produktua produktu1 = new produktua("Esnea",4.30);
		saskia sas = new saskia(produktu1);
		sas.karritoraGehitu(produktu);
		System.out.println(sas.produktuKop(sas) +" produktu daude. ");
		System.out.println("Prezioa:" + sas.prezioTotala(sas) + "$ dira.");
		sas.karritoraKendu(produktu);
		System.out.println(sas.produktuKop(sas) +" produktu daude. ");
		System.out.println("Prezioa:" + sas.prezioTotala(sas) + "$ dira.");
		//berriro posizio berdina jartzen bada, automatikoki txikitxen da lista, esaterako 0. posiziokoa borratzen badugu 1. posizioan dagoen produktua 0.posizioan jarriko da.
		sas.karritoraKendu(produktu);
		System.out.println(sas.produktuKop(sas) +" produktu daude. ");
		System.out.println("Prezioa:" + sas.prezioTotala(sas) + "$ dira.");
	}
}
