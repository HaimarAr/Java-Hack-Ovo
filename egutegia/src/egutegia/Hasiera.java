/**
 * 
 */
package egutegia;

/**
 * 
 */
public class Hasiera {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int aukera = 0;
		egutegia data = new egutegia();
		do {
			System.out.println("aukerat: 1-egun bat gehitu, 2- hilabete bat gehitu, 3-urteak gehitu");
			data.menu(aukera);
		}while(aukera != 0);
	}

}

