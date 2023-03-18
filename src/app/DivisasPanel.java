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

import conversores.ConversorDivisas;

import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import java.awt.Cursor;

public class DivisasPanel extends JPanel {
	private JComboBox<String> listaDivisasDestino;
	private JComboBox<String> listaDivisasOrigen;
	private ConversorDivisas conversorDivisas = new ConversorDivisas();
	private JLabel resultado;
	private JTextField entradaCantidad;
	private JPanel contenedorPrincipalPanel;

	public DivisasPanel() {
		setBounds(new Rectangle(0, 0, 784, 299));
		setLayout(null);
		inicializarContenedorPrincipal();
		inicializarEntradaImporte();
		inicializarListasDivisas();
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
				int indiceOpcionDivisaOrigen;
				int indiceOpcionDivisaDestino;
				double importe;
				String opcionDivisasOrigen = listaDivisasOrigen.getItemAt(listaDivisasOrigen.getSelectedIndex());
				String opcionDivisasDestino = listaDivisasDestino.getItemAt(listaDivisasDestino.getSelectedIndex());
				
				try {
					indiceOpcionDivisaOrigen = listaDivisasOrigen.getSelectedIndex();
					indiceOpcionDivisaDestino = listaDivisasDestino.getSelectedIndex();
					importe = Double.parseDouble(entradaCantidad.getText());
				} catch (Exception exception) {
					indiceOpcionDivisaOrigen = 0;
					indiceOpcionDivisaDestino = 0;
					importe = 0;
				}
				double resultadoConversion = conversorDivisas.convertirImporte(indiceOpcionDivisaOrigen, indiceOpcionDivisaDestino, importe);
				resultado.setText(resultadoConversion + " " + opcionDivisasDestino);
			}
		});
		contenedorPrincipalPanel.add(botonResultadoConversion);
		JLabel etiquetaImporte = new JLabel("Ingrese el importe");
		etiquetaImporte.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaImporte.setForeground(new Color(255, 255, 255));
		etiquetaImporte.setFont(new Font("Arial Black", Font.BOLD, 15));
		etiquetaImporte.setBounds(56, 18, 210, 20);
		contenedorPrincipalPanel.add(etiquetaImporte);
		
		entradaCantidad = new JTextField();
		entradaCantidad.setBorder(new CompoundBorder());
		entradaCantidad.setForeground(new Color(77, 77, 77));
		entradaCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		entradaCantidad.setFont(new Font("Arial", Font.PLAIN, 20));
		entradaCantidad.setToolTipText("Números enteros o decimales");
		entradaCantidad.setBounds(56, 41, 210, 39);
		contenedorPrincipalPanel.add(entradaCantidad);
		entradaCantidad.setColumns(10);
	}
	
	private void inicializarListasDivisas() {
		listaDivisasOrigen = new JComboBox<>(); 
		listaDivisasOrigen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		listaDivisasOrigen.setFont(new Font("Arial", Font.PLAIN, 15));
		listaDivisasOrigen.setFocusable(false);
		listaDivisasOrigen.setBounds(56, 119, 220, 45);
		contenedorPrincipalPanel.add(listaDivisasOrigen);
		conversorDivisas.inicializarJComboBox(listaDivisasOrigen);
		
		listaDivisasDestino = new JComboBox<>(); 
		listaDivisasDestino.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		listaDivisasDestino.setFont(new Font("Arial", Font.PLAIN, 15));
		listaDivisasDestino.setFocusable(false);
		listaDivisasDestino.setBounds(509, 119, 220, 45);
		contenedorPrincipalPanel.add(listaDivisasDestino);	
		conversorDivisas.inicializarJComboBox(listaDivisasDestino);
	}

	private void inicializarBotonesAccion() {
		JLabel etiquetaIntercambio = new JLabel("");
		etiquetaIntercambio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		etiquetaIntercambio.setIcon(new ImageIcon(DivisasPanel.class.getResource("/img/intercambiar-azul-icono.png")));
		etiquetaIntercambio.setBounds(345, 18, 75, 75);
		contenedorPrincipalPanel.add(etiquetaIntercambio);
		
		JButton botonIntercambio = new JButton("");
		botonIntercambio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				conversorDivisas.intercambiarOrdenDivisas(listaDivisasOrigen, listaDivisasDestino);
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
		etiquetaConversion.setIcon(new ImageIcon(DivisasPanel.class.getResource("/img/flecha-azul-icono.png")));
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
