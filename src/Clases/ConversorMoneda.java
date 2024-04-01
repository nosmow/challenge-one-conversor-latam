package Clases;

import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.parser.JSONParser;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;


public class ConversorMoneda {
	
	private Object eleccionLista;
	private double valorIngresado;
	
	public String monedaConversion;
	private boolean convertir;
	private Character simbolo;
	public String nombreConversion;
	
	private int eliminado;
	
	public void IngresarCantidad() {
		boolean bandera = false;
		
		do {
			try {
				valorIngresado = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de dinero que deseas convertir"));
				bandera = true;
				
				if(valorIngresado <= 0) {
					JOptionPane.showMessageDialog(null, "No se permite ingresar numeros negativos ni cero");
					bandera = false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Solo se permiten numeros");
				bandera = false;
			}
		} while (!bandera);	
	}
	
	public String MiMoneda(String miPais) {
		String nombreMoneda = "";
		
		try {
			nombreMonedas nm = new nombreMonedas();
			JSONObject json = new JSONObject(nm.monedas);
			nombreMoneda = json.getString(miPais);  
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		return nombreMoneda;
	}
	public static String[] removeElement(String[] arr, String item) {
		String[] arreglo = null;
		
		try {
			arreglo = Arrays.stream(arr)
	                .filter(s -> !s.equals(item))
	                .toArray(String[]::new);
		} catch (Exception e) {
			e.getMessage();
		}
        
		return arreglo;
    }
	public String[] ListaMonedas(String miPais) {
		String[] lista = null;

		try {
			lista = new String[] { miPais + " a Dolar",
					   miPais + " a Euro",
					   miPais + " a Libras Esterlinas",
					   miPais + " a Yen Japonés",
					   miPais + " a Won sur-coreano",
					   "Dolar a " + miPais,
					   "Euro a " + miPais,
					   "Libras Esterlinas a " + miPais,
					   "Yen Japonés a " + miPais,
					   "Won sur-coreano a " + miPais } ;	
			
			String item = miPais + " a " + miPais;
			lista = removeElement(lista, item); 
			
			
		} catch (Exception e) {
			e.getMessage();
		}
		       
		return lista;
	}
	
	public void TipoMoneda(String[] lista, String miPais) {
		try {	
			eleccionLista = JOptionPane.showInputDialog(null,"Elige la moneda a la que deseas convertir tu dinero", "Monedas",JOptionPane.QUESTION_MESSAGE, null, lista, lista[0]);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	//Obtiene mi moneda en la lista de tipoMoneda
	public String NombreMonedaConversion() {
		String textoAntesDePalabra = "";
        String palabraBuscada = " a"; // La palabra que deseas buscar

        // Paso 1: Encuentra la posición de la palabra buscada en el texto
        int posicionPalabra = eleccionLista.toString().indexOf(palabraBuscada);

        if (posicionPalabra != -1) {
            // Paso 2: Extrae la parte del texto antes de la palabra buscada
            textoAntesDePalabra = eleccionLista.toString().substring(0, posicionPalabra).trim();    
        }

        return textoAntesDePalabra;
	}


	public void MonedaConversion(String miPais) {
		String firstWord = eleccionLista.toString();
        int n = miPais.length();
        //String truncated = firstNChars(firstWord, n);
          
		String lastWord = eleccionLista.toString().substring(eleccionLista.toString().lastIndexOf("a ")+1);
			
		if(lastWord.equals(" Dolar")) {
			monedaConversion = "USD";
			nombreConversion = "Dolares";
			convertir = true;
		} else if(lastWord.equals(" Euro")) {
			monedaConversion = "EUR";
			nombreConversion = "Euros";
			convertir = true;
		} else if(lastWord.equals(" Libras Esterlinas")) {
			monedaConversion = "GBP";
			nombreConversion = lastWord;
			convertir = true;
		} else if(lastWord.equals(" Yen Japonés")) {
			monedaConversion = "JPY";
			nombreConversion = "Yenes Japoneses";
			convertir = true;
		} else if(lastWord.equals(" Won sur-coreano")) {
			monedaConversion = "KRW";
			nombreConversion = "Wones sur-coreanos";
			convertir = true;
		} else if(lastWord.equals(" " + miPais)) {
			nombreConversion = miPais;			
			if(NombreMonedaConversion().equals("Dolar")) {
				monedaConversion = "USD";
				convertir = false;
			} else if(NombreMonedaConversion().equals("Euro")) {
				monedaConversion = "EUR";
				convertir = false;
			} else if(NombreMonedaConversion().equals("Libras Esterlinas")) {
				monedaConversion = "GBP";
				convertir = false;
			} else if(NombreMonedaConversion().equals("Yen Japonés")) {
				monedaConversion = "JPY";
				convertir = false;
			} else if(NombreMonedaConversion().equals("Won sur-coreano")) {
				monedaConversion = "KRW";
				convertir = false;
			}
		}
	}
	
	public Character SimboloMoneda(String miMoneda) {
		Character simbolo = null;
		
		try {
			if(monedaConversion == "EUR" && convertir == true) {
				simbolo = '€';
			} else if (miMoneda == "EUR" && convertir == false) {
				simbolo = '€';
			} else {
				simbolo = '$';
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
		return simbolo;
	}
	
	public double ConvertirDivisa(double moneda2) {
		double conversion = 0;
		
		try {
			if(convertir == true) {
				conversion = valorIngresado * moneda2;
			} else {
				conversion = valorIngresado / moneda2;

			}
		} catch (Exception e) {
			e.getMessage();
		}
	
		return conversion;
	}
}
