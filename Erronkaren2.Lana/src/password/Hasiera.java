package password;


public class Hasiera {
	
	public static void main(String[] args) {
	
		password pasahitza = new password(20);
		
		System.out.println(pasahitza.getPassword());
		if(pasahitza.luzeera() > 8  && 20 > pasahitza.luzeera()) {
			if(pasahitza.isStrong() == true) {
				System.out.println("Indartsua da");
			}
			else {
				System.out.println("Ez da indartsua");
			}
		}
		else {
			System.out.println("Ez da indartsua");
		}
		
		
		System.out.println(pasahitza.luzeera());
	}
	
}
