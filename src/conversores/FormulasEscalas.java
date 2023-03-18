package conversores;

public abstract class FormulasEscalas {
	private static String[] idEscala = {"Celsius", "Fahrenheit", "Kelvin"};
	
	public static double seleccionarFormula(int escalaOrigen, int escalaDestino, double grados) {

		if (escalaOrigen == 0 && escalaDestino == 1) {
			return (grados * 9 / 5) + 32;
		} else if (escalaOrigen == 0 && escalaDestino == 2) {
			return grados + 273.15;
		} else if (escalaOrigen == 1 && escalaDestino == 0) {
			return (grados - 32) * 5 / 9;
		} else if (escalaOrigen == 1 && escalaDestino == 2) {
			return (grados - 32) * 5 / 9 + 273.15;
		} else if (escalaOrigen == 2 && escalaDestino == 0) {
			return grados - 273.15;
		} else if (escalaOrigen == 2 && escalaDestino == 1) {
			return (grados - 273.15) * 9 / 5 + 32;
		}
		return grados; // Si escalaOrigen == escalaDestino
	}
	
	public static String[] obtenerListaEscalas() {
		return idEscala;
	}
}
