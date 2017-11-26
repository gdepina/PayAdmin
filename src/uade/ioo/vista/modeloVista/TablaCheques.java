package uade.ioo.vista.modeloVista;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import uade.ioo.modelo.Cheque;


public class TablaCheques extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Cheque> cheques;
	
	

	public TablaCheques(List<Cheque> cheques) {
		super();
		this.cheques = cheques;
	}

	@Override
	public int getRowCount() {
		return cheques.size() + 1;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		if (rowIndex == 0) {
			if(columnIndex==0) {
				return "Numero";
			}
			if(columnIndex==1) {
				return "Monto";
			}
			if(columnIndex==2) {
				return "Fecha de emision";
			}
			if(columnIndex==3) {
				return "Estado";
			}
		}
		
		if(columnIndex == 0) {
			return this.cheques.get(rowIndex -1).getNumero();
		}
		if(columnIndex == 1) {
			return this.cheques.get(rowIndex -1).getMonto();
		}
		if(columnIndex == 2) {
			return this.cheques.get(rowIndex -1).getFechaEmision().toString();
		}
		if(columnIndex == 3) {
			return this.cheques.get(rowIndex -1).getEstado().toString();
		}
		
		return null;
	}

}
