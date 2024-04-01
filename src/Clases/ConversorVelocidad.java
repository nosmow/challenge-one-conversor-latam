package Clases;

import javax.swing.JOptionPane;

public class ConversorVelocidad {

	private double valorIngresado;
	private Object eleccionLista;
	
	public void IngresarVelocidad() {
	
	boolean bandera = false;
	
	do {
		try {
			valorIngresado = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor que deseas convertir"));
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
	public String[] ListaVelocidades() {
		
		String[] lista = { "De Milla por hora a Pie por segundo",
						   "De Pie por segundo a Milla por hora",
						   "De Metro por segundo a Kilómetro por hora",
						   "De Kilómetro por hora a Metro por segundo",
						   "De Nudo a Milla por hora",
						   "De Milla por hora a Nudo",
						   "De Pie por segundo a Metro por segundo",
				   		   "De Metro por segundo a Pie por segundo",
						   "De Kilómetro por hora a Nudo",
						   "De Nudo a Kilómetro",
						   "De Milla por hora a Metro por segundo",
						   "De Metro por segundo a Milla por hora",
						   "De Nudo a Pie por segundo",
						   "De Pie por segundo a Nudo",
						   "De Kilómetro por hora a Milla por hora",
						   "De Milla por hora a Kilómetro por hora",
						   "De Metro por segundo a Nudo",
						   "De Nudo a Metro por segundo",
						   "De Kilómetro por hora a Pie por segundo",
						   "De Pie por segundo a Kilómetro por hora" };
		
		return lista;
	}
	
	public void TipoConversion(String[] lista) {
		try {
			eleccionLista = JOptionPane.showInputDialog(null,"Elige la velocidad a la que deseas convertir", "Velocidades",JOptionPane.QUESTION_MESSAGE, null, lista, lista[0]);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public String NombreVelocidad(String[] lista) {
		String nombre = "";
		
		try {
			if(eleccionLista.toString() == lista[1] || eleccionLista.toString() == lista[4] ||
			   eleccionLista.toString() == lista[11] || eleccionLista.toString() == lista[14]) {
				nombre = "Millas por hora";
			} else if(eleccionLista.toString() == lista[0] || eleccionLista.toString() == lista[7] ||
					  eleccionLista.toString() == lista[12] || eleccionLista.toString() == lista[18]) {
				nombre = "Pies por segundo";
			} else if(eleccionLista.toString() == lista[3] || eleccionLista.toString() == lista[6] ||
					  eleccionLista.toString() == lista[10] || eleccionLista.toString() == lista[17]) {
				nombre = "Metros por segundo";
			} else if(eleccionLista.toString() == lista[2] || eleccionLista.toString() == lista[9] ||
					  eleccionLista.toString() == lista[15] || eleccionLista.toString() == lista[19]) {
				nombre = "Kilómetros por hora";
			} else if(eleccionLista.toString() == lista[5] || eleccionLista.toString() == lista[5] ||
					  eleccionLista.toString() == lista[13] || eleccionLista.toString() == lista[16]) {
				nombre = "Nudos";
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
		return nombre;
	}
	
	public double ConvertirVelocidad(String[] lista) {
		double resultado = 0;
		
		try {
			if(lista[0] == eleccionLista.toString()) {
				resultado = valorIngresado * 1.467;
			} else if (lista[1] == eleccionLista.toString()) {
				resultado = valorIngresado / 1.467;
			} else if (lista[2] == eleccionLista.toString()) {
				resultado = valorIngresado * 3.6;
			} else if (lista[3] == eleccionLista.toString()) {
				resultado = valorIngresado / 3.6;
			} else if (lista[4] == eleccionLista.toString()) {
				resultado = valorIngresado * 1.151;
			} else if (lista[5] == eleccionLista.toString()) {
				resultado = valorIngresado / 1.151;
			} else if (lista[6] == eleccionLista.toString()) {
				resultado = valorIngresado / 3.281;
			} else if (lista[7] == eleccionLista.toString()) {
				resultado = valorIngresado * 3.281;
			} else if (lista[8] == eleccionLista.toString()) {
				resultado = valorIngresado / 1.852;
			} else if (lista[9] == eleccionLista.toString()) {
				resultado = valorIngresado * 1.852;
			} else if (lista[10] == eleccionLista.toString()) {
				resultado = valorIngresado / 2.237;
			} else if (lista[11] == eleccionLista.toString()) {
				resultado = valorIngresado * 2.237;
			} else if (lista[12] == eleccionLista.toString()) {
				resultado = valorIngresado * 1.688;
			} else if (lista[13] == eleccionLista.toString()) {
				resultado = valorIngresado / 1.688;
			} else if (lista[14] == eleccionLista.toString()) {
				resultado = valorIngresado / 1.609;
			} else if (lista[15] == eleccionLista.toString()) {
				resultado = valorIngresado * 1.609;
			} else if (lista[16] == eleccionLista.toString()) {
				resultado = valorIngresado * 1.944;
			} else if (lista[17] == eleccionLista.toString()) {
				resultado = valorIngresado / 1.944;
			} else if (lista[18] == eleccionLista.toString()) {
				resultado = valorIngresado / 1.097;
			} else if (lista[19] == eleccionLista.toString()) {
				resultado = valorIngresado * 1.097;
			} 
		} catch (Exception e) {
			e.getMessage();
		}

		return resultado;
	}
}
