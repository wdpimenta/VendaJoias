/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.tables;

import br.ifirst.karine.entities.Pedido;
import br.ifirst.karine.utils.Util;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.event.TableModelListener;

/**
 *
 * @author Wanderson
 */
public class TablePedido extends AbstractTable<Pedido> {

    public TablePedido() {
        this(null);
    }

    public TablePedido(TableModelListener listener) {
        this(new ArrayList<Pedido>(), listener);
    }

    public TablePedido(List<Pedido> lista, TableModelListener listener) {
        super(lista, listener, new String[]{"Pedido", "Data", "Cliente ", "Vlr Gr banho", "Status"},
                new Class[]{Integer.class, Date.class, String.class, BigDecimal.class, String.class});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Pedido d = dados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return d.getId();
            case 1:
                return d.getDataCadastro();
            case 2:
                return String.valueOf(d.getCliente());
            case 3:
                return Util.nf.format(d.getValorTotal().setScale(2, RoundingMode.HALF_EVEN));
            case 4:
                return d.getStatus();
            default:
                return "";

        }
    }
}
