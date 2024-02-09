/**
 * 
 */
package password;
import java.security.*;
/**
 * 
 */
public class password {
	
	private String password;
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @param args
	 * @return 
	 */
	public password(String pasahitza) {
		// TODO Auto-generated method stub
		this.password = pasahitza;
	}
	
	
	
	public password(int luzeera) {
		//Emandako balioekin produktu bat sortzen du.
		this.password = generateRandomPassword(luzeera);
		
	}
	
	public String generateRandomPassword(int luzeera) {
		
		String karaktereak = new String ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?");
		String pasahitza = "";
		for (int i=0; luzeera > i ; i++) {
			char karakt = karaktereak.charAt((int) (Math.random()*92));
			pasahitza=pasahitza+karakt;
		}
		
		return pasahitza;
		
		
	}
	
	public boolean isStrong() {
		String karaktereak = new String("~`!@#$%^&*()-_=+[{]}\\\\|;:\\'\\\",<.>/?");
		String zenbakiak = new String("0123456789");
		String larria = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		String xehea = new String("abcdefghijklmnopqrstuvwxyz");
		int esp = 0;
		int zenb = 0;
		int larr = 0;
		int xehe = 0;
		for (int i = 0;this.password.length()>i;i++) {
			for (int j = 0;this.password.length()>j;j++) {
				
				if((this.password.charAt(i)) ==  karaktereak.charAt(j) && esp == 0) {
					esp = 1;
				}
				if ((this.password.charAt(i)) ==  zenbakiak.charAt(j) && zenb == 0) {
					zenb = 1;
				}
				if ((this.password.charAt(i)) ==  larria.charAt(j) && larr == 0) {
					larr = 1;
				}
				if ((this.password.charAt(i)) ==  xehea.charAt(j) && larr == 0) {
					xehe = 1;
				}
			}
			
			
		
		}
		if(esp == 1 && zenb == 1 && larr == 1 && xehe == 1 ) {
			
			return true;
			
		}else {
			return false;
		}
		
	}
	
	public int luzeera() {
		return this.getPassword().length();
	}
}
