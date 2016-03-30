/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.tables;

import br.ifirst.karine.entities.ProdutoBanho;
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
public class TableProdutoBanho extends AbstractTable<ProdutoBanho> {

    public TableProdutoBanho() {
        this(null);
    }

    public TableProdutoBanho(TableModelListener listener) {
        this(new ArrayList<ProdutoBanho>(), listener);
    }

    public TableProdutoBanho(List<ProdutoBanho> lista, TableModelListener listener) {
        super(lista, listener, new String[]{"Grama", "Banho", "Valor"}, new Class[]{Integer.class, String.class, BigDecimal.class});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        ProdutoBanho d = dados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return Util.nf4.format(d.getGramas().setScale(4, RoundingMode.HALF_EVEN));
            case 1:
                return d.getBanho().getNome();
            case 2:
                return Util.nf.format(d.getValorTotal().setScale(2, RoundingMode.HALF_EVEN));
            default:
                return "";

        }
    }

}
