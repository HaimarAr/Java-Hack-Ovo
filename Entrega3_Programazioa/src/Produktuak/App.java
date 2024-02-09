package Produktuak;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Beharrezko objetuak sortu
		mobilak m1 = new mobilak("Samsung S7", 500, 3, 16, 25);
		mobilak m2 = new mobilak("Iphone", 1000, 5, 32, 64 );
		accesorio a1 = new accesorio("Usb-C", 30, "Kargadorea");
		accesorio a2 = new accesorio("Karkasa handia", 10, "Karkasa");
		
		//Informazioa erakutsi
		m1.informazioaErakutsi();
		m2.informazioaErakutsi();
		a1.Karkabateragarria(a1.mobilesKarka);
		a2.Kargabateragarria(a2.mobilesKarga);
	}

}
