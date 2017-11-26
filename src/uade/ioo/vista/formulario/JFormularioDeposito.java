package uade.ioo.vista.formulario;

import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import uade.ioo.modelo.AdministradorDePagos;
import uade.ioo.modelo.Cheque.Estado;
import uade.ioo.vista.comportamiento.IVistaRecibirCheque;
import uade.ioo.vista.controlador.DepositarChequeController;
import uade.ioo.vista.modeloVista.TablaCheques;

public class JFormularioDeposito extends JFormularioBase implements IVistaRecibirCheque  {

	private static final long serialVersionUID = 1L;
	
	private JTextField txtNumero = new JTextField();
	private JButton btnDepositar = new JButton("Depositar");
	JTable tabla;

	public JFormularioDeposito(AdministradorDePagos modelo) {
		super(modelo);
	
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.getContentPane().add(new JLabel("Numero de cheque :"));
		this.getContentPane().add(txtNumero);
		this.getContentPane().add(btnDepositar);
		
		btnDepositar.setMaximumSize(getMaximumSize());
		btnDepositar.addActionListener(new DepositarChequeController(this.getModelo(), this));
		
		this.tabla = new JTable(new TablaCheques(modelo.getChequesPorEstado(Estado.DEFEATED)));
		this.getContentPane().add(tabla);
	}


	@Override
	public void actualizar() {
		super.actualizar();
		this.tabla.setModel(new TablaCheques(this.getModelo().getChequesPorEstado(Estado.DEFEATED)));
	}


	@Override
	public int getNumero() {
		return Integer.parseInt(this.txtNumero.getText());
	}


	@Override
	public double getMonto() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Date getFechaEmision() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Estado getEstado() {
		// TODO Auto-generated method stub
		return null;
	}


}
