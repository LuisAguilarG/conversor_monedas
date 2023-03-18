package conversores;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JComboBox;

public class ConversorDivisas {
	private String[] idDivisas = {"Pesos mexicanos", "Dólares estadounidenses", "Euros", "Libras esterlinas", "Yenes japoneses", "Wones surcoreanos"};
	private double[][] tablaCruzadaDivisas = new double[idDivisas.length][idDivisas.length];
	
	/* Representa los valores con los que se inicializará la tabla cruzada de divisas */
	private double[] tasasCambio = { // [0][0], [0][1] ... [1][0], [1][1]... etc
			1.0, 0.0534, 0.0501, 0.0439, 7.1112, 69.6292, // Pesos mexicanos
			18.7176, 1.0, 0.9393, 0.8226, 133.0652, 1304.9847, // Dólares estadounidenses
			19.9349, 1.0647, 1.0, 0.8759, 141.6494, 1389.6625, // Euros
			22.7603, 1.2155, 1.1416, 1.0, 161.6799, 1586.0101, // Libras esterlinas
			0.1407, 0.0075, 0.0070, 0.0061, 1.0, 9.8178, // Yenes japoneses
			0.0143, 0.0007, 0.0007, 0.0006, 0.1018, 1.0}; // Wones surcoreanos
	
	public ConversorDivisas() {
		inicializarPermutacionesDivisas();
	}
	
	private void inicializarPermutacionesDivisas() {
		int i = 0;
		for (int j = 0; j < idDivisas.length; j++) {
			for (int k = 0; k < idDivisas.length; k++) {
				tablaCruzadaDivisas[j][k] = tasasCambio[i];
				// System.out.println("Array"+"["+j+"]"+"["+k+"]"+ "="+tasasCambio[i]);
				i++;
			}
		}
	}
	
	public double convertirImporte(int divisaOrigen, int divisaDestino, double importe) {
		double tasaCambio = tablaCruzadaDivisas[divisaOrigen][divisaDestino];
		DecimalFormat formatoDecimal = new DecimalFormat("0.000");
		
		return Double.parseDouble(formatoDecimal.format(importe * tasaCambio)); 
	}
	
	public void inicializarJComboBox(JComboBox<String> jComboBox) {
		for (String divisa : idDivisas) {
			jComboBox.addItem(divisa);
		}
	}
	
	public void intercambiarOrdenDivisas(JComboBox<String> jComboBox1, JComboBox<String> jComboBox2) {
		int temporal = jComboBox1.getSelectedIndex();
		jComboBox1.setSelectedIndex(jComboBox2.getSelectedIndex());
		jComboBox2.setSelectedIndex(temporal);
	}
}
