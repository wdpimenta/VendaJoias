/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.tables;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wanderson
 * @param <T>
 */
public abstract class AbstractTable<T> extends AbstractTableModel {

    protected final List<T> dados;
    protected String[] columns = new String[]{};
    protected Class[] clazz = new Class[]{};

    public AbstractTable(List<T> lista, TableModelListener listener, String[] columns, Class[] clazz) {
        dados = lista;
        addTableModelListener(listener);
        this.clazz = clazz;
        this.columns = columns;
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return clazz[columnIndex];
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
    }

    public void add(T object) {
        dados.add(object);
        int lastIndex = getRowCount() - 1;
        fireTableRowsInserted(lastIndex, lastIndex);
    }

    public void addList(List<T> list) {
        int size = getRowCount();
        dados.addAll(list);
        if (getRowCount() > 0) {
            fireTableRowsInserted(size, getRowCount() - 1);
        }
    }

    public void update(T object) {
        if (dados.contains(object)) {
            int row = dados.indexOf(object);
            dados.set(row, object);
            fireTableRowsUpdated(row, row);
        }
    }

    public void remove(int rowIndex) {
        dados.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void remove(T object) {
        dados.remove(object);
        fireTableDataChanged();
    }

    public boolean isExists(T object) {
        return dados.contains(object);
    }

    public T get(int rowIndex) {
        return dados.get(rowIndex);
    }

    public T get(T object) {
        if (dados.contains(object)) {
            return get(dados.indexOf(object));
        }
        return null;
    }

    public List<T> getAll() {
        return dados;
    }

    public void clear() {
        dados.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return dados.isEmpty();
    }

    public int indexOf(T object) {
        return dados.indexOf(object);
    }

}
