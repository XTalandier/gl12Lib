/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.*; 
import javax.swing.event.TableModelListener; 
import javax.swing.event.TableModelEvent; 

/**
 *
 * @author Duss
 */
public class DAOTable extends AbstractTableModel  implements TableModelListener  {
	protected ArrayList<DAO> data = new ArrayList<DAO>();
	protected ArrayList<String> lesChamps = new ArrayList<String>();
	protected ArrayList<String> lesChampsCustoms = new ArrayList<String>();
	
	
	public void setChampsCustom(String lesChampsCusts[]){
		int n = lesChampsCusts.length;
		for(int i = 0 ; i < n ; i++){
			lesChampsCustoms.add(lesChampsCusts[i]);
		}
	}
	
	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return lesChamps.size();
	}
	@Override
	public String getColumnName(int columnIndex) {
		String retVal;
		if(lesChampsCustoms.size() > 0){
			retVal = lesChampsCustoms.get(columnIndex);
		}else{
			retVal = lesChamps.get(columnIndex);
		}
		return retVal;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data.get(rowIndex).getValueOf(columnIndex);
	}
	@Override
    public boolean isCellEditable(int row, int column) {
		return !(column == 0);
    }

	@Override
	public void tableChanged(TableModelEvent e) {
		System.out.println("aaaxxxxx");
	}
	
	public void addRow(DAO obj){
		data.add(obj);
	}
	
	public void removeRow(int i){
		data.remove(i);
	}
	
	protected TableModel model; 

    public TableModel getModel() {
		System.out.println("getModel()");
        return model;
    }

    public void  setModel(TableModel model) {
		System.out.println("setModel()");
        this.model = model; 
        model.addTableModelListener(this);
	}
	
	public static void hideColumn(JTable jTable , String laCol){
		jTable.getColumn(laCol).setWidth(0);
		jTable.getColumn(laCol).setMinWidth(0);
		jTable.getColumn(laCol).setMaxWidth(0);
	}
	
}