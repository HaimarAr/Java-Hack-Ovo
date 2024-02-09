package Producto;

public class Producto {
	//Ezaugarriak
	private String izena;
	private String deskripzioa;
	private int kodigo;
	private double prezioa;
	private double descuento;
	
	
	//Ekintzak metodo bidez
	public Producto() {
		//Produktu bat sortzen du baina hutsa egongo da
		this.izena = "ezezaguna";
		this.deskripzioa = "ezezaguna";
		this.kodigo = 0;
		this.prezioa = 0;
		this.descuento = 0;
	}
	
	
	public Producto(String izena, String deskripzioa, int kodigo, double prezioa, double descuento) {
		//Emandako balioekin produktu bat sortzen du.
		this.izena = izena;
		this.deskripzioa = deskripzioa;
		this.kodigo = kodigo;
		this.prezioa = prezioa;
		this.descuento = descuento;
	}
	
	
	public static String ganga(Producto p1) {
		//String bat bidaltzen du bueltan
		String era;
		
		if(p1.prezioa < 1.0) {
			era = "GANGA";
		}else if(p1.prezioa >= 1.0 && p1.prezioa < 10){
			era = "NORMAL";
		}else {
			era = "LUJO";
		}
		
		return era;
	}
	
	public static void deskontu(Producto p1) {
		//Deskontua egiten du
		double deskontua = p1.prezioa * p1.descuento;
		System.out.println("Deskontua " + deskontua +"$-koa da.");
	}


	/**
	 * @return the izena
	 */
	public String getIzena() {
		return izena;
	}


	/**
	 * @param izena the izena to set
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}


	/**
	 * @return the deskripzioa
	 */
	public String getDeskripzioa() {
		return deskripzioa;
	}


	/**
	 * @param deskripzioa the deskripzioa to set
	 */
	public void setDeskripzioa(String deskripzioa) {
		this.deskripzioa = deskripzioa;
	}


	/**
	 * @return the kodigo
	 */
	public int getKodigo() {
		return kodigo;
	}


	/**
	 * @param kodigo the kodigo to set
	 */
	public void setKodigo(int kodigo) {
		this.kodigo = kodigo;
	}


	/**
	 * @return the prezioa
	 */
	public double getPrezioa() {
		return prezioa;
	}


	/**
	 * @param prezioa the prezioa to set
	 */
	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}


	/**
	 * @return the descuento
	 */
	public double getDescuento() {
		return descuento;
	}


	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}


}