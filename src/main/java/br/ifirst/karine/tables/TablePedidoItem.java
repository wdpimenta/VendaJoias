/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.tables;

import br.ifirst.karine.entities.PedidoItem;
import br.ifirst.karine.utils.Util;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;

/**
 *
 * @author Wanderson
 */
public class TablePedidoItem extends AbstractTable<PedidoItem> {

    public TablePedidoItem() {
        this(null);
    }

    public TablePedidoItem(TableModelListener listener) {
        this(new ArrayList<PedidoItem>(), listener);
    }

    public TablePedidoItem(List<PedidoItem> lista, TableModelListener listener) {
        super(lista, listener, new String[]{"Produto", "Qtde ", "Valor Total"},
                new Class[]{String.class, Integer.class, String.class, BigDecimal.class, BigDecimal.class, BigDecimal.class});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        PedidoItem d = dados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return d.getProduto().toString();
            case 1:
                return d.getQuantidade().intValue();
            case 2:
                return Util.nf.format(d.getValorTotal().setScale(2, RoundingMode.HALF_EVEN));
            default:
                return "";

        }
    }

}
