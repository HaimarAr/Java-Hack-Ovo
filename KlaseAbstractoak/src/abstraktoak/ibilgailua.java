package abstraktoak;

public abstract class ibilgailua {
 
	private String marka;
	private String modeloa;
	
	public ibilgailua(String marka, String modeloa) {
		this.marka = marka;
		this.modeloa = modeloa;
	}
	
	public void informazioaErakutsi() {
		System.out.println("Marka: " + marka);
		System.out.println("Modeloa: " + modeloa);
	}
	
	public abstract void mugitu();
}
