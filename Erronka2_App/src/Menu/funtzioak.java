package Menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import Gehitu.GehituAlmazena;
import Gehitu.GehituLangileak;
import Gehitu.GehituUsuarios;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class funtzioak {
	
	public static void aukeratu(String value, int value2) {
        // Hemen exekutatu SELECT kontsulta datu basean
        // Erabiltzaile zerrenda datu baseatik lortu eta erakutsi
    	try 
    	{
     	    switch(value) {
     	    
     	    case ("almazena"):
     	    		switch(value2) {
     	    		
     	    		case 1:
     	    			break;
     	    		case 2:
     	    			GehituAlmazena.main();
     	    			break;
     	    		case 3:
     	    			break;
     	    		}
     	    		break;
     	    case ("usuarios"):
	     	    	switch(value2) {
	 	    		
	 	    		case 1:
	 	    			break;
	 	    			
	 	    		case 2:
	 	    			GehituUsuarios.main();	
	 	    			break;
	 	    		case 3:
	 	    			break;
	 	    		}
     	   break;
	     	case("langileak"):
		     		switch(value2) {
	 	    		
	 	    		case 1:
	 	    			break;
	 	    			
	 	    		case 2:
	 	    			GehituLangileak.main();
	 	    			break;
	 	    		case 3:
	 	    			break;
	 	    			
	 	    		}
	     	break;
	     		
     	    }
    	    /*if(value.equals("almazena")) {
    	    	
    	    }
    	    else if(value.equals("bezeroak")) {
    	    	
    	    }
    	    else if(value.equals("eskariak")) {
    	    }
    	    else if(value.equals("faktura")) {	
    	    	
    	    }
    	    else if(value.equals("hornitzaileformulario")) {
    	    	
    	    }
    	    else if(value.equals("langileak")) {
    	    	
    	    }*/
    	}
    	catch(Exception ex)
    	{       
    	    System.out.println(ex);
    	}
   
    	    
    }
}
