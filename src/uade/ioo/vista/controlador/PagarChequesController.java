package uade.ioo.vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uade.ioo.modelo.AdministradorDePagos;

public class PagarChequesController implements ActionListener {

	private AdministradorDePagos modelo;

	public PagarChequesController(AdministradorDePagos modelo) {
		super();
		this.modelo = modelo;		
	}

	public void actionPerformed(ActionEvent e) {
		this.modelo.pagar();		
	}
}
