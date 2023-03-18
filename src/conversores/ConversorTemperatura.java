package conversores;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JComboBox;

public class ConversorTemperatura {
	
	public ConversorTemperatura() {
		
	}
	
	public double convertirEscalas(int escalaOrigen, int escalaDestino, double grados) {
		double resultado = FormulasEscalas.seleccionarFormula(escalaOrigen, escalaDestino, grados);
		DecimalFormat formatoDecimal = new DecimalFormat("0.000");
		
		return Double.parseDouble(formatoDecimal.format(resultado)); 
	}
	
	
	public void inicializarJComboBox(JComboBox<String> jComboBox) {
		for (String escala : FormulasEscalas.obtenerListaEscalas()) {
			jComboBox.addItem(escala);
		}
	}
	
	public void intercambiarOrdenEscalas(JComboBox<String> jComboBox1, JComboBox<String> jComboBox2) {
		int temporal = jComboBox1.getSelectedIndex();
		jComboBox1.setSelectedIndex(jComboBox2.getSelectedIndex());
		jComboBox2.setSelectedIndex(temporal);
	}
}
