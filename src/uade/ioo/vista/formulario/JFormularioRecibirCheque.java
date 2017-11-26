package uade.ioo.vista.formulario;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import uade.ioo.modelo.AdministradorDePagos;
import uade.ioo.modelo.Cheque.Estado;
import uade.ioo.vista.comportamiento.IVistaRecibirCheque;
import uade.ioo.vista.controlador.AgregarChequeController;

public class JFormularioRecibirCheque extends JFormularioBase implements IVistaRecibirCheque {

	private static final long serialVersionUID = 1L;
	
	private JTextField txtMonto = new JTextField();
	private JTextField txtNumero = new JTextField();
	private JTextField txtFechaEmision = new JTextField();
	private JButton btnAgregarCheque = new JButton("Recibir Cheque");
	String[] estadosCheques = new String[] {"RECEIVED", "DEFEATED", "DELIVERED", "DEPOSITED"};
	JComboBox<String> comboEstados = new JComboBox<String>(estadosCheques);

	public JFormularioRecibirCheque(AdministradorDePagos modelo) {
		super(modelo);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		this.getContentPane().add(new JLabel("Numero: "));
		this.getContentPane().add(txtNumero);
		this.getContentPane().add(new JLabel("Monto: "));
		this.getContentPane().add(txtMonto);
		this.getContentPane().add(new JLabel("Fecha de emision (dd/mm/aaaa):"));
		this.getContentPane().add(txtFechaEmision);
		comboEstados.setEditable(true);
		this.getContentPane().add(comboEstados);
		this.getContentPane().add(btnAgregarCheque);
		
		
	    btnAgregarCheque.addActionListener(new AgregarChequeController(this.getModelo(), this));
		
		btnAgregarCheque.setMaximumSize(getMaximumSize());
		
	}

	@Override
	public int getNumero() {
		return Integer.parseInt(this.txtNumero.getText());
		
	}

	@Override
	public double getMonto() {
		double monto=0;
		try {
			 monto = Double.parseDouble(this.txtMonto.getText());
		}
		catch(Exception e1){
			JOptionPane.showMessageDialog(null, "Error. Ingrese un importe valido");
			
		}
		return monto;
	}
	
	@Override
	public Date getFechaEmision() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return (Date) formatter.parse(this.txtFechaEmision.getText());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error. Formato de fecha invalido");
		}
		return null;
	}

	@Override
	public Estado getEstado() {
		Estado estadoEnum =Estado.valueOf((String) this.comboEstados.getSelectedItem());
		return estadoEnum;
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}


}
