/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.tables;

import br.ifirst.karine.entities.Banho;
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
public class TableBanho extends AbstractTable<Banho> {

    public TableBanho() {
        this(null);
    }

    public TableBanho(TableModelListener listener) {
        this(new ArrayList<Banho>(), listener);
    }

    public TableBanho(List<Banho> lista, TableModelListener listener) {
        super(lista, listener, new String[]{"ID", "Nome ", "Sigla", "Valor grama"},
                new Class[]{Integer.class, String.class, String.class, BigDecimal.class});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Banho d = dados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return d.getId();
            case 1:
                return d.getNome();
            case 2:
                return d.getSigla();
            case 3:
                return Util.nf.format(d.getValorGrama().setScale(2, RoundingMode.HALF_EVEN));
            default:
                return "";

        }
    }
}
