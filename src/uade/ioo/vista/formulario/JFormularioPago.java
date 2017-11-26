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
import uade.ioo.vista.controlador.CalcularChequesController;
import uade.ioo.vista.controlador.PagarChequesController;
import uade.ioo.vista.modeloVista.TablaCheques;

public class JFormularioPago extends JFormularioBase implements IVistaRecibirCheque {

	private static final long serialVersionUID = 1L;

	JTextField txtMontoPagar = new JTextField();
	JButton btnCalcularCheques = new JButton("Determinar Cheques a Usar");
	JButton btnConfirmarPago = new JButton("Confirmar Pago");
	JTable tabla;

	public JFormularioPago(AdministradorDePagos modelo) {
		super(modelo);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		this.getContentPane().add(new JLabel("Monto a Pagar"));
		this.getContentPane().add(txtMontoPagar);
		this.getContentPane().add(btnCalcularCheques);
		this.getContentPane().add(btnConfirmarPago);
	
		btnCalcularCheques.setMaximumSize(getMaximumSize());
		btnConfirmarPago.setMaximumSize(getMaximumSize());
		
		btnCalcularCheques.addActionListener(new CalcularChequesController(this.getModelo(), this));
		btnConfirmarPago.addActionListener(new PagarChequesController(this.getModelo()));
		
		
		this.tabla = new JTable(new TablaCheques(modelo.getChequesPorEstado(Estado.RECEIVED)));

		this.getContentPane().add(tabla);
	}
	
	@Override
	public void actualizar() {
		super.actualizar();
		this.tabla.setModel(new TablaCheques(this.getModelo().getChequesDisponibles()));
	}

	@Override
	public int getNumero() {
		// TODO Auto-generated method stub
	//return	this.getModelo().ultimoNumeroCheque();
		return 0;
	}

	@Override
	public double getMonto() {
		// TODO Auto-generated method stub
		return Double.parseDouble(this.txtMontoPagar.getText());
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
