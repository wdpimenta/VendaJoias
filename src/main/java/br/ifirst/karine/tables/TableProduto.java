/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.tables;

import br.ifirst.karine.entities.Produto;
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
public class TableProduto extends AbstractTable<Produto> {

    public TableProduto() {
        this(null);
    }

    public TableProduto(TableModelListener listener) {
        this(new ArrayList<Produto>(), listener);
    }

    public TableProduto(List<Produto> lista, TableModelListener listener) {
        super(lista, listener, new String[]{"ID", "Nome", "Referência", "Lagura", "Comprimento"},
                new Class[]{Integer.class, String.class,String.class, BigDecimal.class, BigDecimal.class});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Produto d = dados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return d.getId();
            case 1:
                return d.getNome();
            case 2:
                return d.getReferencia();
            case 3:
                return Util.nf1.format(d.getLargura().setScale(1, RoundingMode.HALF_EVEN));
            case 4:
                return Util.nf1.format(d.getComprimento().setScale(1, RoundingMode.HALF_EVEN));
                
                
            default:
                return "";

        }
    }
    
}
