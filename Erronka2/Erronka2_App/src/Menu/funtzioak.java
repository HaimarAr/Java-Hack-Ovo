package Menu;

import java.sql.Connection;
import Almazena.Almazena;
import Eskariak.Eskariak;
import Faktura.Faktura;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import Gehitu.GehituAlmazena;
import Gehitu.GehituLangileak;
import Gehitu.GehituUsuarios;
import Hornitzaileak.Hornitzaileak;
import Langileak.Langileak;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class funtzioak {
	
	public static void aukeratu(String value) {
    	try 
    	{
     	    switch(value) {
     	    
     	    case ("almazena"):
     	    	Almazena.main(value);
     	    	break;
     	    		
     	    case ("hornitzaileformulario"):
     	    	Hornitzaileak.main(value);
     	    	break;
	     	case("langileak"):
	     		Langileak.main(value);
	     	break;
	     	case("eskariak"):
	     		Eskariak.main(value);
	     	break;
	     	case("faktura"):
	     		Faktura.main(value);
	     	break;
	     		
     	    }
    	   
    	}
    	catch(Exception ex)
    	{       
    	    System.out.println(ex);
    	}
   
    	    
    }
}
