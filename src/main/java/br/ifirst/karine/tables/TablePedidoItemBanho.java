/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.tables;

import br.ifirst.karine.entities.PedidoItemBanho;
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
public class TablePedidoItemBanho extends AbstractTable<PedidoItemBanho> {

    public TablePedidoItemBanho() {
        this(null);
    }

    public TablePedidoItemBanho(TableModelListener listener) {
        this(new ArrayList<PedidoItemBanho>(), listener);
    }

    public TablePedidoItemBanho(List<PedidoItemBanho> lista, TableModelListener listener) {
        super(lista, listener, new String[]{"Ref.", "Banho", "Grama banho", "Vlr grama", "Vlr banho", "Qtde ", "Valor Total"},
                new Class[]{String.class, String.class, Integer.class, BigDecimal.class, BigDecimal.class, Integer.class, BigDecimal.class});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        PedidoItemBanho d = dados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return d.getProdutoBanho().getProduto().getReferencia();
            case 1:
                return d.getProdutoBanho().getBanho().toString();
            case 2:
                return d.getProdutoBanho().getGramas();
            case 3:
                return Util.nf4.format(d.getProdutoBanho().getBanho().getValorGrama().setScale(4, RoundingMode.HALF_EVEN));
            case 4:
                return Util.nf.format(d.getProdutoBanho().getValorTotal().setScale(2, RoundingMode.HALF_EVEN));
            case 5:
                return d.getQuantidade().intValue();
            case 6:
                return Util.nf.format(d.getValorTotal().setScale(2, RoundingMode.HALF_EVEN));
            default:
                return "";

        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 5;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {

        if (columnIndex == 5) {
            try {
                int valueAux = Integer.parseInt(String.valueOf(value));

                PedidoItemBanho d = dados.get(rowIndex);
                d.setQuantidade(new BigDecimal(valueAux));
                d.setValorTotal(d.getValorUnitario().multiply(d.getQuantidade()));
                fireTableRowsUpdated(rowIndex, rowIndex);

            } catch (NumberFormatException ignorado) {
                //caso tenha colocado valor errado sistema não altera valor
            }

        }
    }

}
