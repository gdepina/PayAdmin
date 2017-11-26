package uade.ioo.vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uade.ioo.modelo.AdministradorDePagos;
import uade.ioo.vista.comportamiento.IVistaRecibirCheque;

public class CalcularChequesController implements ActionListener {

	private AdministradorDePagos modelo;
	private IVistaRecibirCheque source;

	public CalcularChequesController(AdministradorDePagos modelo, IVistaRecibirCheque source) {
		super();
		this.modelo = modelo;
		this.source = source;
	}

	public void actionPerformed(ActionEvent e) {
		this.modelo.calcularChequesAUsar(source.getMonto());	
	}
}
