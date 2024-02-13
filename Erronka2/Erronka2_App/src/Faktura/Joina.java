package Faktura;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


public class Joina {
	
	public static void JoinaEgin(JTextField id_eskaria, Connection connection, JTable table, DefaultTableModel taula) throws SQLException {
		// TODO Auto-generated method stub
		 
		        try {
		            String query = "SELECT eskariak.id_eskaria, eskariak.NAN, almazena.izena, faktura.kantitatea, almazena.prezioaS FROM hackovo.eskariak, faktura, almazena  WHERE eskariak.id_eskaria = ? AND eskariak.id_eskaria=faktura.id_eskaria AND almazena.ErregistroID=faktura.ErregistroID";
		            
		            // Utilizar PreparedStatement para evitar la inyección de SQL
		            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		                preparedStatement.setString(1, id_eskaria.getText());
		                try (ResultSet res = preparedStatement.executeQuery()) {
		                   

		                    taula.addColumn("id_eskaria");
		                    taula.addColumn("NAN");
		                    taula.addColumn("izena");
		                    taula.addColumn("kantitatea");
		                    taula.addColumn("prezioaS");

		                    String[] array = new String[5];

		                    while (res.next()) {
		                        for (int i = 0; i < 5; i++) {
		                            array[i] = res.getString(i + 1);
		                        }
		                        taula.addRow(array);
		                    }
		                    preparedStatement.close();

		                    // Configurar el modelo de la tabla
		                    table.setModel(taula);
		                    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		                }
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		            System.err.println("Error en la consulta SQL: " + e.getMessage());
		        }
		       
				
		    }

			public static void PdfSortu(JTextField id, Connection connection, JTable table, DefaultTableModel taula) {
				// TODO Auto-generated method stub
				try {
					PDDocument faktura = new PDDocument();
					//Creamos una nueva hoja
					PDPage hoja1 = new PDPage(PDRectangle.A4);
					faktura.addPage(hoja1);
					//Le decimos que contenido tendra el PDF
					PDPageContentStream contenido = new PDPageContentStream(faktura, hoja1);
					
					contenido.beginText();
					contenido.setFont(PDType1Font.COURIER_BOLD, 20);
					contenido.newLineAtOffset(120, hoja1.getMediaBox().getHeight()-(60));
					contenido.showText("FAKTURA");
					contenido.endText();
					
					float margin = 30;
					
					//Se calcula la posición vertical inicial para comenzar a escribir en la página. Esto se hace restando siete veces el margen desde la altura total de la página.
					float y = hoja1.getMediaBox().getHeight() - (7 * margin);
					
					//Se calcula el ancho disponible para la tabla restando dos veces el margen desde el ancho total de la página.
					float tableAnchura = hoja1.getMediaBox().getWidth();
					
					//Se almacena la posición vertical actual.
					float yPosition = y;
					
					//Se define el margen entre las celdas de la tabla.
					float margenCeldas = 1f;
					
					// Se obtiene el número de filas en el modelo de tabla pasado como parámetro.
					int lineas = taula.getRowCount();
					
					//Se obtiene el número de columnas en el modelo de tabla.
					int columnas = taula.getColumnCount();
					
					//Se define la altura de las filas de la tabla en 35 puntos.
					float lineasAltura = 35f;
					
					//Se calcula la altura total de la tabla sumando una fila adicional (para los encabezados).
					float tableAltura = lineasAltura * (lineas + 1);
					
					//Se calcula el ancho de cada columna dividiendo el ancho total de la tabla entre el número de columnas.
					float colAnchura = tableAnchura / (float) columnas;
					
					//Se inicializan las posiciones de escritura en la primera celda de la tabla.
					 float siguienteX = margin;
					 float seguienteY = yPosition;
					 
					 // Comienza un bucle para iterar sobre las columnas de la tabla.
					 for(int i = 0; i < columnas; i++) {
						 //Obtiene el nombre de la columna en la posición i del modelo de tabla.
						String cabezal = taula.getColumnName(i);
						//: Inicia un nuevo bloque de texto en el flujo de contenido.
						contenido.beginText();
						contenido.setFont(PDType1Font.COURIER_BOLD, 10);
						//Establece la posición de inicio del texto en las coordenadas (siguienteX, seguienteY).
						contenido.newLineAtOffset(siguienteX, seguienteY);
						contenido.showText(cabezal);
						contenido.endText();
						//Actualiza la posición siguienteX para la siguiente columna. Se está desplazando la posición actual hacia la derecha en una cantidad igual al ancho de una columna.
						siguienteX += colAnchura;
					 }
					// Dibuja las filas
				        for (int i = 0; i < lineas; i++) {
				        	//Decrementa la posición seguienteY para comenzar en la siguiente fila.
				        	seguienteY -= lineasAltura;
				        	siguienteX = margin;
				        	//Comienza un bucle anidado para iterar sobre las columnas de cada fila.
				            for (int j = 0; j < columnas; j++) {
				            	//Obtiene el valor de la celda en la fila i y columna j del modelo de tabla y lo convierte en una cadena.
				            	String a[] = taula.getValueAt(i, j).toString().split(":",2);
				            	String cellValue = a[0];
				                
				                contenido.beginText();
				                contenido.setFont(PDType1Font.HELVETICA, 8);
				                contenido.newLineAtOffset(siguienteX, seguienteY);
				                //Muestra el texto de la celda en la posición actual.
				                contenido.showText(cellValue);
				                contenido.endText();
				                siguienteX += colAnchura;
				            }
				        } 
				        
				        contenido.close();
				        String directorioDescargas = System.getProperty("user.home") + File.separator + "Downloads";
			            String rutaArchivoPDF = directorioDescargas + File.separator + "factura.pdf";
			            faktura.save(rutaArchivoPDF);
				        faktura.close();
				}
				catch(Exception x) {
					System.out.println("Erron: " + x.getMessage().toString());
				}
				
				
			}
	}
		
