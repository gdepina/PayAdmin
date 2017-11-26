package uade.ioo.vista.formulario;

import javax.swing.JFrame;

import uade.ioo.modelo.AdministradorDePagos;
import uade.ioo.observer.IObservador;

public abstract class JFormularioBase extends JFrame implements IObservador {

	private static final long serialVersionUID = 1L;
	private AdministradorDePagos modelo;
	
	public JFormularioBase(AdministradorDePagos modelo){
		this.modelo = modelo;
		this.modelo.registrarObservador(this);
		
		this.setSize(640, 480);
		this.setLocationRelativeTo(null);
		
	}

	protected AdministradorDePagos getModelo() {
		return modelo;
	}
	
	public void actualizar() {
	}


}
