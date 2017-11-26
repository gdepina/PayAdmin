package uade.ioo.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observado {
	private List<IObservador> observadores = new ArrayList<IObservador>();
	
	
	public void registrarObservador(IObservador obs) {
		this.observadores.add(obs);	
	}
	
	public void quitarObservador(IObservador obs) {
		this.observadores.remove(obs);	
	}
	
	protected void notificarObservadores() {
		for (IObservador obs: this.observadores) {
			obs.actualizar();
		}
	}
}
