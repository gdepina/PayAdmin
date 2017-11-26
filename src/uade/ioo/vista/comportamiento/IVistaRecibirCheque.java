package uade.ioo.vista.comportamiento;

import java.util.Date;

import uade.ioo.modelo.Cheque.Estado;


public interface IVistaRecibirCheque {
	int getNumero();
	double getMonto();
	Date getFechaEmision();
	Estado getEstado();
}
