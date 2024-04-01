package Clases;

import javax.swing.JOptionPane;

public class ConversorTemperatura {

	private double valorIngresado;
	private Object eleccionLista;
	
	public void IngresarTemperatura() {
	
	boolean bandera = false;
	
	do {
		try {
			valorIngresado = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la temperatura que deseas convertir"));
			bandera = true;
			
			if(valorIngresado == 0) {
				JOptionPane.showMessageDialog(null, "No se permite ingresar solo el numero cero");
				bandera = false;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Solo se permiten numeros");
			bandera = false;
		}
	} while (!bandera);
}
	public String[] ListaTemperatura() {
		
		String[] lista = { "De Celsius a Fahrenheit",
						   "De Fahrenheit a Celsius",
						   "De Kelvin a Celsius",
						   "De Celsius a Kelvin",
						   "De Fahrenheit a Kelvin",
						   "De Kelvin a Fahrenheit" };            		
		
		return lista;
	}
	
	public void TipoConversion(String[] lista) {
		try {
			eleccionLista = JOptionPane.showInputDialog(null,"Elige la temperatura a la que deseas convertir", "Temperaturas",JOptionPane.QUESTION_MESSAGE, null, lista, lista[0]);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public String NombreGrados(String[] lista) {
		String nombre = "";
		
		try {
			if(eleccionLista.toString() == lista[0] || eleccionLista.toString() == lista[5]) {
				nombre = "Fahrenheit";
			} else if(eleccionLista.toString() == lista[1] || eleccionLista.toString() == lista[2]) {
				nombre = "Celsius";
			} else if(eleccionLista.toString() == lista[3] || eleccionLista.toString() == lista[4]) {
				nombre = "Kelvin";
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
		return nombre;
	}
	
	public double ConvertirTemperatura (String[] lista) {
		double resultado = 0;
		
		try {
			if(lista[0] == eleccionLista.toString()) {
				resultado = valorIngresado * 1.8 + 32;
			} else if (lista[1] == eleccionLista.toString()) {
				resultado = (valorIngresado - 32) / 1.8;
			} else if (lista[2] == eleccionLista.toString()) {
				resultado = valorIngresado - 273.15;
			} else if (lista[3] == eleccionLista.toString()) {
				resultado = valorIngresado + 273.15;
			} else if (lista[4] == eleccionLista.toString()) {
				resultado = 5/9 + (valorIngresado - 32) + 273.15;
			} else if (lista[5] == eleccionLista.toString()) {
				resultado = (valorIngresado - 273.15) * 9/5 + 32;
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return resultado;
	}
}
