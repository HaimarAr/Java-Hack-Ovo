package abstraktoak;

public class Kotxea extends ibilgailua {

	
	private int abiaduraMaximoa;
	
	public Kotxea(String marka, String modeloa, int abiaduraMaximoa) {
		super(marka, modeloa);
		this.abiaduraMaximoa=abiaduraMaximoa;
	}
	
	@Override
	public void informazioaErakutsi() {
		super.informazioaErakutsi();
		System.out.println("Abiadura maximoa:" + abiaduraMaximoa + " da");
	}
	@Override
	public void mugitu() {
		// TODO Auto-generated method stub
	
	}

}
