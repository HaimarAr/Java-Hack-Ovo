package Produktuak;

public  class mobilak extends Produktuak{
	
	private int pantallaTamaina;
	private int ram;
	private double memoria;
		
		public mobilak(String izena, double balioa, int pantallaTamaina, int ram, double memoria) {
			super(izena, balioa);
			this.pantallaTamaina=pantallaTamaina;
			this.memoria = memoria;
			this.ram = ram;
		}
		
		@Override
		public void informazioaErakutsi() {
			super.informazioaErakutsi();
			System.out.println("Pantallaren tamaina: " + pantallaTamaina + " pulgada dira");
			System.out.println("Telefonoaren memoria: " + memoria+ "G");
			System.out.println("Telefonoaren ram: " + ram + "G");
		}

		
		
}
