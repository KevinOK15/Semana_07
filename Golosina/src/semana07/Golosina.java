package semana07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

public class Golosina extends JFrame implements ActionListener {

	// Declaraci�n de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblMarca;
	private JLabel lblCantidad;
	private JComboBox<String> cboMarca;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtS;

	// Lanza la aplicaci�n
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Golosina frame = new Golosina();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Golosina() {
		setTitle("Golosina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 11, 80, 14);
		contentPane.add(lblMarca);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 36, 80, 14);
		contentPane.add(lblCantidad);

		cboMarca = new JComboBox<String>();
		cboMarca.setModel(new DefaultComboBoxModel<String>(new String[] { "Cream Cracker", "Chomp", "P\u00EDcaras", "Dona Pepa" }));
		cboMarca.setBounds(100, 8, 100, 20);
		contentPane.add(cboMarca);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(100, 33, 100, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 61, 414, 190);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}

	// Procesa la pulsaci�n del bot�n Borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtCantidad.setText("");
		txtS.setText("");
		cboMarca.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}

	// Procesa la pulsaci�n del bot�n Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		int cant, cara;
		double prec, impC, impD, impP;
		String marc;
		
		marc = cboMarca.getSelectedItem().toString();
		cant = Integer.parseInt(txtCantidad.getText());
		
		if 		( marc =="Cream Cracker" ){ prec=9.0 ;}
		else if ( marc =="Chomp" ){ prec=7.4 ;}
		else if ( marc =="P�caras" ){ prec=8.6 ;}
		else 	{ prec=10.6 ;}
		impC = prec*cant;
		
		if		( cant<5 ){ impD=impC*0.03 ;}
		else if ( cant>=5 && cant<10 ){ impD=impC*0.07 ;}
		else if ( cant>=10 && cant<15 ){ impD=impC*0.11 ;}
		else 	{ impD=impC*0.15 ;}
		impP = impC-impD;
		
		if 		( cant>=12 ) { cara=4*cant ;}
		else if ( cant>=8 && cant<12 ) { cara=2*cant ;}
		else if ( cant>=4 && cant<8 ) { cara=6 ;}
		else 	{ cara=3 ;}
		
		
		txtS.setText(" **REPORTE DEL PROGRAMA GOLOSINA**\n\n" );
		txtS.append("Importe de la compra : "+ decimalFormat(impC) + "\n");
		txtS.append("Importe descuento : "+ decimalFormat(impD) + "\n");
		txtS.append("Importe a pagar : "+ decimalFormat(impP) + "\n");
		txtS.append("Caramelos de obsequio : "+ cara + "\n");
		
		

	}
	String decimalFormat(double p){
		return String.format("%.2f",p).replace(",", ".");
	}
	
	
	
}