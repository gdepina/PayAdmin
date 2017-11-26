package uade.ioo.vista.formulario;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

import uade.ioo.modelo.AdministradorDePagos;
import uade.ioo.modelo.Cheque.Estado;

public class JFormularioReporte extends JFormularioBase {

	private static final long serialVersionUID = 1L;

	private JLabel lblMontoDisponible = new JLabel("0");
	private JLabel lblMontoPagado = new JLabel("0");
	private JLabel lblMontoDepositados = new JLabel("0");
	private JLabel lblMontoPropios = new JLabel("0");
	private JLabel lblMontoProxVencimiento = new JLabel("0");

	public JFormularioReporte(AdministradorDePagos modelo) {
		super(modelo);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.getContentPane().add(new JLabel("Monto disponible para realizar pagos a terceros: ")); //Cheques que estan estado recived
		this.getContentPane().add(lblMontoDisponible);
		this.getContentPane().add(new JLabel("Monto pagado: ")); //Cheques que estan en delivered
		this.getContentPane().add(lblMontoPagado);
		this.getContentPane().add(new JLabel("Monto depositado en banco: ")); //Cheques DEPOSITADOS
		this.getContentPane().add(lblMontoDepositados);
		this.getContentPane().add(new JLabel("Monto dinero emitido: ")); // Monto total de los cheques propios delivered
		this.getContentPane().add(lblMontoPropios);
		this.getContentPane().add(new JLabel("Monto cheques proximos a vencer: ")); //fecha de emisio + 30 dias total.
		this.getContentPane().add(lblMontoProxVencimiento);

		this.actualizar();

	}

	@Override
	public void actualizar() {
		super.actualizar();
		this.lblMontoDisponible.setText(Double.toString(this.getModelo().getMontoPorEstado(Estado.RECEIVED)));
		this.lblMontoPagado.setText(Double.toString(this.getModelo().getMontoPorEstado(Estado.DELIVERED)));
		this.lblMontoDepositados.setText(Double.toString(this.getModelo().getMontoPorEstado(Estado.DEPOSITED)));
		this.lblMontoPropios.setText(Double.toString(this.getModelo().getMontoChequesPropios(Estado.DELIVERED)));
		this.lblMontoProxVencimiento.setText(Double.toString(this.getModelo().getMontoProxVencimiento()));
	}

}
