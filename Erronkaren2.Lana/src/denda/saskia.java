package denda;
	
	
import java.util.ArrayList;
import java.util.Scanner;

	public class saskia {
		
		//Izen berdina eduki behar dute <barruan dagoena eta erreferrentzia egiten dion klasearen artean>
		ArrayList<produktua> produktuak = new ArrayList<>();
		
		
		public void karritoraGehitu(produktua produktua){
			this.produktuak.add(0, produktua);
			
		}
		
		public saskia(produktua produktua){
	
			karritoraGehitu(produktua);
		}

		public int produktuKop(saskia sas) {
			// TODO Auto-generated method stub
		
			return 	this.produktuak.size();
		}
		
		public double prezioTotala(saskia sas) {
		double prezioa = 0;
			for(int i=0; this.produktuak.size() > i;i++) {
				
				prezioa = prezioa + this.produktuak.get(i).getPrezioa();
				
			}
			
			
			return prezioa;
			
		}

		public void karritoraKendu(produktua produktu) {
			System.out.println("Ze posiziokoa kendu nahiko zenuke?");
			Scanner sc = new Scanner(System.in);
			int zenb = sc.nextInt();
			if( this.produktuak.size() > zenb) {
				this.produktuak.remove(zenb);
				System.out.println("Ondo borratu da!");
			}else {
				System.out.println("Ez daude hainbeste produktu!");
			}
			
			
			
		}

		
	}