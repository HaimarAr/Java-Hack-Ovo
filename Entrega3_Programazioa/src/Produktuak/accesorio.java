package Produktuak;


public class accesorio extends Produktuak {
	
	String mota;
	String mobilesKarka[] = new String[]{"Samsung","LG","Xiaomi","Huaweii"};
	String mobilesKarga[] = new String[]{"Iphone","Blackberry","Motorola","Oppo"};
	public accesorio(String izena, double balioa, String mota) {		
		super(izena, balioa);	
		this.mota = mota;
		
	}
	
	//Bateragarriak
	public void Karkabateragarria(String mobilesKarka[]) {			
		System.out.println("Karkasa mugikor hauetan dira bateragarriak:");
		for(int i=0; i < this.mobilesKarka.length; i++) {
			System.out.println( mobilesKarka[i]);
		}
	}
	
	//Bateragarriak
	public void Kargabateragarria(String mobilesKarga[]) {
		System.out.println("Kargadoreak mugikor hauetan dira bateragarriak: ");
		for(int i=0; i < this.mobilesKarga.length; i++) {
			System.out.println( mobilesKarga[i]);
		}
	}
}	
	
