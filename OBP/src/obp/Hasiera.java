/**
 * 
 */
package obp;

/**
 * 
 */
public class Hasiera {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pertsona pertsona  = new pertsona();
		pertsona pertsona2 = new pertsona("Haimar","Ariceta");
		pertsona pertsona3 = new pertsona("Xabier", "Garcia", 34);
		System.out.println(pertsona.izena);
		System.out.println(pertsona2.izena + " " + pertsona2.abizenak);
		System.out.println(pertsona3);
		pertsona.jaio();
		pertsona2.HitzEgin();

	}

}
