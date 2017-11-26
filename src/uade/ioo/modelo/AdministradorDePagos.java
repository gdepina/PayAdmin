package uade.ioo.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import uade.ioo.modelo.Cheque.Estado;
import uade.ioo.observer.Observado;

public class AdministradorDePagos extends Observado {
	
	private List<Cheque> cheques = new ArrayList<Cheque>();
	List<Cheque> chequesDisponibles = new ArrayList<Cheque>();

	
	public void registrarChequeTercero(ChequeDeTercero cheque){
		this.cheques.add(cheque);
		this.notificarObservadores();
	}
	
	public void registrarChequePropio(Cheque cheque){
		this.cheques.add(cheque);
		this.chequesDisponibles.add(cheque);
		this.notificarObservadores();
	}
	
	
	public double getMontoTotalCheques() {
		double result = 0;
		for(Cheque c: this.cheques) {
			result += c.getMonto();
		}
		return result;
	}
	
	public double getMontoPorEstado(Estado estado) {
		double result = 0;
		for(Cheque c: this.cheques) {
			if (c.getEstado() == estado) {
				result += c.getMonto();
			}
		}
		return result;
	}
	
	public double getMontoChequesPropios(Estado estado) {
		double result = 0;
		for(Cheque c: this.cheques) {
			if (c.getEstado() == estado && c instanceof ChequePropio) {
				result += c.getMonto();
			}
		}
		return result;
	}
	
	public double getMontoProxVencimiento() {
		double result = 0;
	
		Date hoy = new Date();
	
		for(Cheque c: this.cheques) {	
			long diff = hoy.getTime() - c.getFechaEmision().getTime();		
			if (c.getEstado() == Estado.RECEIVED && (diff / (1000 * 60 * 60 * 24) <= 7)) {
				result += c.getMonto();
			}
		}
		return result;
	}
	
	
	public List<Cheque> getChequesPorEstado(Estado estado) {
		List<Cheque> chequesFiltrados = new ArrayList<Cheque>();
		
		for(Cheque c: this.cheques) {
			if (c.getEstado() == estado) {
				chequesFiltrados.add(c);
			}
		}
		return chequesFiltrados;		
	}
	
	public Cheque getChequePorNumero(int numeroCheque) {
		Cheque chequeSeleccionado = null;
		
		for(Cheque c: this.cheques) {
			if (c.getNumero() == numeroCheque) {
				chequeSeleccionado = c;
			}
		}
		
		return chequeSeleccionado;
	}
	
	public void depositar(int numeroCheque) {
		Cheque chequeActual = this.getChequePorNumero(numeroCheque);	
		chequeActual.setEstado(Estado.DEPOSITED);
		this.notificarObservadores();	
	}
	
	
	public static void ordernarChequesPorMonto(List<Cheque> cheques) {	
        Collections.sort(cheques, new Comparator<Cheque>() {
            public int compare(Cheque o1, Cheque o2) {
                return o1.getMonto() > o2.getMonto() ? -1 : o1.getMonto() == o2.getMonto() ? 0 : 1;
            }
        });
        
		return;		
	}
	
	public void calcularChequesAUsar(double monto) {
		List<Cheque> chequesRecibidos = this.getChequesPorEstado(Estado.RECEIVED);
		AdministradorDePagos.ordernarChequesPorMonto(chequesRecibidos);	
		double montoAux = 0;
		int nroCheque;
		
		for(Cheque c: chequesRecibidos) {			
			if ((c.getMonto() + montoAux) <= monto) {
				chequesDisponibles.add(c);
				montoAux += c.getMonto();				
			}
		}
		
		if (montoAux == monto) {
			this.notificarObservadores();
			return;
		} else {
			nroCheque=AdministradorDePagos.ultimoNumeroCheque(chequesRecibidos);
			System.out.println("proximo nro de cheque " +nroCheque);
			this.registrarChequePropio(new ChequePropio(monto - montoAux,nroCheque));			
		}
		this.notificarObservadores();
		return;		
	}

	public List<Cheque> getChequesDisponibles() {
		return chequesDisponibles;
	}

	public void pagar() {
		for(Cheque c: chequesDisponibles) {
			if (c.getEstado() != Estado.DELIVERED) {
				c.setEstado(Estado.DELIVERED);
			}
		}
		this.notificarObservadores();
	}

	public static int ultimoNumeroCheque(List<Cheque> cheques) {
		int nroMax=0;
		for(Cheque c: cheques) {
			if (c.getNumero() > nroMax) {
				nroMax = c.getNumero() +1;
			}
		}
		return nroMax;

	}
	
}
