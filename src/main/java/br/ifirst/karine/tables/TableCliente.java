/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.tables;

import br.ifirst.karine.entities.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;

/**
 *
 * @author Wanderson
 */
public class TableCliente extends AbstractTable<Cliente> {

    public TableCliente() {
        this(null);
    }

    public TableCliente(TableModelListener listener) {
        this(new ArrayList<Cliente>(), listener);
    }

    public TableCliente(List<Cliente> lista, TableModelListener listener) {
        super(lista, listener, new String[]{"ID", "Nome ", "CPF/CNPJ", "Telefone"},
                new Class[]{Integer.class, String.class, String.class, String.class});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Cliente d = dados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return d.getId();
            case 1:
                return d.getNome();
            case 2:
                return d.getCnpjCpf();
            case 3:
                return d.getTelefone() != null ? d.getTelefone() : d.getCelular();
            default:
                return "";

        }
    }

}
