package app;

import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import conversores.ConversorTemperatura;

import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import java.awt.Cursor;

public class TemperaturaPanel extends JPanel {
	private JComboBox<String> listaEscalasDestino;
	private JComboBox<String> listaEscalasOrigen;
	private ConversorTemperatura conversorTemperatura = new ConversorTemperatura();
	private JLabel resultado;
	private JTextField entradaGrados;
	private JPanel contenedorPrincipalPanel;

	public TemperaturaPanel() {
		setBounds(new Rectangle(0, 0, 784, 299));
		setLayout(null);
		inicializarContenedorPrincipal();
		inicializarEntradaImporte();
		inicializarListasEscalas();
		inicializarBotonesAccion();
		inicializarResultado();
	}
	
	private void inicializarContenedorPrincipal() {
		contenedorPrincipalPanel = new JPanel();
		contenedorPrincipalPanel.setBackground(new Color(0, 29, 48));
		contenedorPrincipalPanel.setBounds(0, 0, 784, 299);
		add(contenedorPrincipalPanel);
		contenedorPrincipalPanel.setLayout(null);
	}
	
	private void inicializarEntradaImporte() {
		
		JButton botonResultadoConversion = new JButton("Calcular");
		botonResultadoConversion.setFocusable(false);
		botonResultadoConversion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonResultadoConversion.setBorderPainted(false);
		botonResultadoConversion.setContentAreaFilled(false);
		botonResultadoConversion.setOpaque(false);
		botonResultadoConversion.setFont(new Font("Arial Black", Font.BOLD, 18));
		botonResultadoConversion.setForeground(new Color(255, 255, 255));
		botonResultadoConversion.setBorder(null);
		botonResultadoConversion.setBounds(309, 100, 170, 79);
		botonResultadoConversion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				int indiceOpcionTemperaturaOrigen;
				int indiceOpcionTemperaturaDestino;
				double grados;
				String opcionTemperaturaOrigen = listaEscalasOrigen.getItemAt(listaEscalasOrigen.getSelectedIndex());
				String opcionTemperaturaDestino = listaEscalasDestino.getItemAt(listaEscalasDestino.getSelectedIndex());
				
				try {
					indiceOpcionTemperaturaOrigen = listaEscalasOrigen.getSelectedIndex();
					indiceOpcionTemperaturaDestino = listaEscalasDestino.getSelectedIndex();
					grados = Double.parseDouble(entradaGrados.getText());
				} catch (Exception exception) {
					indiceOpcionTemperaturaOrigen = 0;
					indiceOpcionTemperaturaDestino = 0;
					grados = 0;
				}
				double resultadoConversion = conversorTemperatura.convertirEscalas(indiceOpcionTemperaturaOrigen, indiceOpcionTemperaturaDestino, grados);
				resultado.setText(resultadoConversion + " grados " + opcionTemperaturaDestino);
			}
		});
		contenedorPrincipalPanel.add(botonResultadoConversion);
		JLabel etiquetaImporte = new JLabel("Ingrese los grados");
		etiquetaImporte.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaImporte.setForeground(new Color(255, 255, 255));
		etiquetaImporte.setFont(new Font("Arial Black", Font.BOLD, 15));
		etiquetaImporte.setBounds(56, 18, 210, 20);
		contenedorPrincipalPanel.add(etiquetaImporte);
		
		entradaGrados = new JTextField();
		entradaGrados.setBorder(new CompoundBorder());
		entradaGrados.setForeground(new Color(77, 77, 77));
		entradaGrados.setHorizontalAlignment(SwingConstants.CENTER);
		entradaGrados.setFont(new Font("Arial", Font.PLAIN, 20));
		entradaGrados.setToolTipText("Números enteros o decimales");
		entradaGrados.setBounds(56, 41, 210, 39);
		contenedorPrincipalPanel.add(entradaGrados);
		entradaGrados.setColumns(10);
	}
	
	private void inicializarListasEscalas() {
		listaEscalasOrigen = new JComboBox<>(); 
		listaEscalasOrigen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		listaEscalasOrigen.setFont(new Font("Arial", Font.PLAIN, 15));
		listaEscalasOrigen.setFocusable(false);
		listaEscalasOrigen.setBounds(56, 119, 220, 45);
		contenedorPrincipalPanel.add(listaEscalasOrigen);
		conversorTemperatura.inicializarJComboBox(listaEscalasOrigen);
		
		listaEscalasDestino = new JComboBox<>(); 
		listaEscalasDestino.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		listaEscalasDestino.setFont(new Font("Arial", Font.PLAIN, 15));
		listaEscalasDestino.setFocusable(false);
		listaEscalasDestino.setBounds(509, 119, 220, 45);
		contenedorPrincipalPanel.add(listaEscalasDestino);	
		conversorTemperatura.inicializarJComboBox(listaEscalasDestino);
	}

	private void inicializarBotonesAccion() {
		JLabel etiquetaIntercambio = new JLabel("");
		etiquetaIntercambio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		etiquetaIntercambio.setIcon(new ImageIcon(TemperaturaPanel.class.getResource("/img/intercambiar-azul-icono.png")));
		etiquetaIntercambio.setBounds(345, 18, 75, 75);
		contenedorPrincipalPanel.add(etiquetaIntercambio);
		
		JButton botonIntercambio = new JButton("");
		botonIntercambio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				conversorTemperatura.intercambiarOrdenEscalas(listaEscalasOrigen, listaEscalasDestino);
			}
		});
		botonIntercambio.setOpaque(false);
		botonIntercambio.setFocusable(false);
		botonIntercambio.setContentAreaFilled(false);
		botonIntercambio.setBorderPainted(false);
		botonIntercambio.setBorder(null);
		botonIntercambio.setBounds(345, 18, 75, 75);
		contenedorPrincipalPanel.add(botonIntercambio);
		

		JLabel etiquetaConversion = new JLabel("");
		etiquetaConversion.setIcon(new ImageIcon(TemperaturaPanel.class.getResource("/img/flecha-azul-icono.png")));
		etiquetaConversion.setBounds(309, 97, 177, 85);
		contenedorPrincipalPanel.add(etiquetaConversion);
	}

	private void inicializarResultado() {
		resultado = new JLabel("");
		resultado.setOpaque(true);
		resultado.setFocusTraversalKeysEnabled(false);
		resultado.setFocusable(false);
		resultado.setFont(new Font("Arial", Font.PLAIN, 18));
		resultado.setHorizontalTextPosition(SwingConstants.CENTER);
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setForeground(new Color(77, 77, 77));
		resultado.setBackground(new Color(255, 255, 255));
		resultado.setBounds(56, 213, 673, 59);
		contenedorPrincipalPanel.add(resultado);
		
		JLabel etiquetaResultado = new JLabel("Resultado");
		etiquetaResultado.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaResultado.setForeground(Color.WHITE);
		etiquetaResultado.setFont(new Font("Arial Black", Font.BOLD, 15));
		etiquetaResultado.setBounds(56, 190, 177, 20);
		contenedorPrincipalPanel.add(etiquetaResultado);
	}	
}
