/**
 * 
 */
package Producto;

/**
 * 
 */
public class Hasiera {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Produktua sortu
		Producto p1 = new Producto();		
		p1.setIzena("Mandarina");
		p1.setDeskripzioa("Fruta");
		p1.setKodigo(1);
		p1.setPrezioa(15);
		p1.setDescuento(0.7);
		//Produktua Ganga,Normal,Lujo
		System.out.println(Producto.ganga(p1));
		Producto.deskontu(p1);
	}

}
