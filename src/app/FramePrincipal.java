package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;

public class FramePrincipal extends JFrame {
	private JPanel contenedorPrincipalPanel = new JPanel();
	private JPanel contenidoVariablePanel = new JPanel();
	private BienvenidaPanel bienvenidaPanel = new BienvenidaPanel();
	private DivisasPanel divisasPanel = new DivisasPanel();
	private TemperaturaPanel temperaturaPanel = new TemperaturaPanel();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal frame = new FramePrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FramePrincipal() {
		inicializarFrame();
		inicializarNavegacionPanel();	
		establecerContexto(bienvenidaPanel);
	}
	
	private void inicializarFrame() {
		// Frame
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setIconImage(Toolkit.getDefaultToolkit().getImage(FramePrincipal.class.getResource("/img/calculadora-azul-icono.png")));
		setTitle("Conversor DivTemp");
		setBackground(new Color(0, 29, 48));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 500);
		setLocationRelativeTo(null);
		
		// JPanel principal
		contenedorPrincipalPanel.setBackground(new Color(0, 29, 48));
		contenedorPrincipalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedorPrincipalPanel);
		contenedorPrincipalPanel.setLayout(null);
		contenedorPrincipalPanel.add(contenidoVariablePanel);
		
		// JPanel dinámico
		contenidoVariablePanel.setBackground(new Color(0, 29, 48));
		contenidoVariablePanel.setBounds(0, 162, 784, 299);
		contenidoVariablePanel.setLayout(new BorderLayout(0, 0));
	}
	
	/* Componentes de navegación: inicio, divisas y temperatura. */
	private void inicializarNavegacionPanel() {
		inicializarBotonInicio();
		inicializarBotonDivisas();
		inicializarBotonTemperatura();
	}
	
	private void inicializarBotonInicio() {
		JButton botonInicio = new JButton("Inicio");
		botonInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				establecerContexto(bienvenidaPanel);
			}
		});
		botonInicio.setFocusable(false);
		botonInicio.setBackground(new Color(0, 29, 48));
		botonInicio.setContentAreaFilled(false);
		botonInicio.setBorderPainted(false);
		botonInicio.setOpaque(false);
		botonInicio.setBorder(null);
		botonInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonInicio.setIcon(new ImageIcon(FramePrincipal.class.getResource("/img/calculadora-azul-icono.png")));
		botonInicio.setBounds(49, 0, 97, 129);
		contenedorPrincipalPanel.add(botonInicio);
		
		JLabel etiquetaBotonInicio = new JLabel("INICIO");
		etiquetaBotonInicio.setFont(new Font("Arial Black", Font.BOLD, 15));
		etiquetaBotonInicio.setForeground(new Color(255, 255, 255));
		etiquetaBotonInicio.setBounds(61, 115, 67, 19);
		contenedorPrincipalPanel.add(etiquetaBotonInicio);
	}
	
	private void inicializarBotonDivisas() {
		JButton botonDivisas = new JButton("Divisas");
		botonDivisas.setForeground(new Color(255, 255, 255));
		botonDivisas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				establecerContexto(divisasPanel);
			}
		});
		botonDivisas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonDivisas.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		botonDivisas.setFocusable(false);
		botonDivisas.setBorder(new EmptyBorder(0, 0, 0, 0));
		botonDivisas.setBackground(new Color(77, 185, 255));
		botonDivisas.setBounds(172, 50, 245, 50);
		contenedorPrincipalPanel.add(botonDivisas);
	}
	
	public void inicializarBotonTemperatura() {
		JButton botonTemperatura = new JButton("Temperatura");
		botonTemperatura.setForeground(new Color(255, 255, 255));
		botonTemperatura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				establecerContexto(temperaturaPanel);
			}
		});
		botonTemperatura.setFocusable(false);
		botonTemperatura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonTemperatura.setBorder(new EmptyBorder(0, 0, 0, 0));
		botonTemperatura.setBackground(new Color(77, 185, 255));
		botonTemperatura.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		botonTemperatura.setBounds(427, 50, 245, 50);
		contenedorPrincipalPanel.add(botonTemperatura);
	}

	public void establecerContexto(JPanel jpanel) {
		contenidoVariablePanel.removeAll();
		contenidoVariablePanel.add(jpanel, BorderLayout.CENTER);
		contenidoVariablePanel.revalidate();
		contenidoVariablePanel.repaint();
	}
}
