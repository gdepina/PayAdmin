package uade.ioo.principal;

import javax.swing.JFrame;

import uade.ioo.modelo.AdministradorDePagos;
import uade.ioo.vista.formulario.JFormularioPrincipal;

public class Programa {

	public static void main(String[] args) {
		AdministradorDePagos modelo = new AdministradorDePagos();
		JFrame f = new JFormularioPrincipal(modelo);
		f.setVisible(true);

	}

}
