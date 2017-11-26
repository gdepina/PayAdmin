package uade.ioo.vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import uade.ioo.modelo.AdministradorDePagos;
import uade.ioo.modelo.ChequeDeTercero;
import uade.ioo.vista.comportamiento.IVistaRecibirCheque;

public class AgregarChequeController implements ActionListener {
	
	private AdministradorDePagos modelo;
	private IVistaRecibirCheque source;

	public AgregarChequeController(AdministradorDePagos modelo, IVistaRecibirCheque source) {
		super();
		this.modelo = modelo;
		this.source = source;
	}

	public void actionPerformed(ActionEvent e) {
		ChequeDeTercero c = new ChequeDeTercero(source.getNumero(), source.getMonto(), source.getFechaEmision(), source.getEstado());
		if(this.modelo.getChequePorNumero(source.getNumero()) == null) {
			this.modelo.registrarChequeTercero(c);
		}
		else {
			JOptionPane.showMessageDialog(null,"Error. Numero de cheque existente");
		}	
	}
	

}
