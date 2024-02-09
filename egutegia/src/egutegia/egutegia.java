package egutegia;

import java.util.Scanner;

public class egutegia {
	
	int urtea;
	int hilabetea;
	int eguna;
	
	public egutegia(int urtea, int hilabetea, int eguna) {
		this.urtea = urtea;
		this.hilabetea = hilabetea;
		this.eguna = eguna;
	}
	
	public egutegia() {
		this.urtea = 2000;
		this.hilabetea = 1;
		this.eguna = 1;
	}
	
	public void erakutsi() {
		System.out.println(this.eguna+"/"+this.hilabetea+"/"+this.urtea);

	}
	
	public void menu(int aukera) {
		Scanner sc = new Scanner(System.in);
		
		switch(aukera) {
		
		case 1:
			this.egunBatGehio();
			break;
		case 2:
			this.hilabeteBatGehio();
			break;
		case 3:	
			System.out.println("Zenbat urte gehitu nahi dituzu? ");
			int zenb = sc.nextInt();
			this.gehituUrtea(zenb);
			break;
		case 4:
			this.erakutsi();
			break;
		case 5:
			break;
		case 0:
			break;
		}
	}
	
	public void egunBatGehio() {
		this.eguna++;
			if( this.hilabetea == 1 || this.hilabetea ==  3 || this.hilabetea ==  5 || this.hilabetea == 7 || this.hilabetea == 8 || this.hilabetea == 10 || this.hilabetea == 12) {
				if(this.eguna > 31) {
					this.hilabetea++;
					if(this.hilabetea > 12) {
						this.urtea++;
						this.hilabetea = 1;
					}
					this.eguna = 1;
				}
			}else if (this.hilabetea == 2 || this.hilabetea ==  4 || this.hilabetea ==  6 || this.hilabetea == 9 || this.hilabetea == 11) {
				if(this.eguna > 30 && this.hilabetea != 2) {
					this.hilabetea++;
					this.eguna = 1;
				}else if(this.eguna > 28 && this.hilabetea == 2) {
					this.hilabetea++;
					this.eguna = 1;
				}
			}
		}
	
	
	public void hilabeteBatGehio() {
		this.hilabetea++;
		if( this.hilabetea == 12) {
				if(this.hilabetea > 12) {
					this.urtea++;
					this.hilabetea = 1;
				}
				this.eguna = 1;
			}
		
	}
	
	public void gehituUrtea(int Zenbat) {
		this.urtea= this.urtea + Zenbat;
	}
}
