package uade.ioo.vista.formulario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import uade.ioo.modelo.AdministradorDePagos;

public class JFormularioPrincipal extends JFormularioBase {
	
	private static final long serialVersionUID = 1L;

	public JFormularioPrincipal(AdministradorDePagos modelo) {
		super(modelo);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menu = new JMenuBar();
		
		JMenu items = new JMenu("Formularios");
		menu.add(items);
		
		JMenuItem opcAgregarCheque = new JMenuItem("Agregar Cheque");	
		JMenuItem ocpDepositar = new JMenuItem("Depositar cheque");
		JMenuItem opcReportes = new JMenuItem("Reporte");
		JMenuItem ocpPago = new JMenuItem("Pagar");
		
		opcAgregarCheque.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFormularioRecibirCheque(getModelo());
				f.setVisible(true);
				
			}
		});
		
		ocpDepositar.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFormularioDeposito(getModelo());
				f.setVisible(true);
				
			}
		});
		
		ocpPago.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFormularioPago(getModelo());
				f.setVisible(true);
				
			}
		});
		
		opcReportes.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFormularioReporte(getModelo());
				f.setVisible(true);
				
			}
		});
		
		
		items.add(opcAgregarCheque);
		items.add(ocpDepositar);
		items.add(opcReportes);
		items.add(ocpPago);
		
		
		this.setJMenuBar(menu);
	}


}
