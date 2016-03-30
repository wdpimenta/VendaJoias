/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Wanderson
 */
public class FieldLimitMoney extends PlainDocument {

    private final int limit;
    private final int decimal;

    public FieldLimitMoney(int i) {
        this(i, 2);

    }

    public FieldLimitMoney(int i, int d) {
        super();
        this.limit = i;
        this.decimal = d;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        str = str.replaceAll("\\D", "");
        try {
            str = String.valueOf(Long.parseLong(str));
            str = (super.getText(0, getLength()) + str).replaceAll("\\D", "");

            BigDecimal value = new BigDecimal(str);
            BigDecimal f = new BigDecimal(10).pow(decimal);

            value = value.divide(f, decimal, RoundingMode.HALF_EVEN);

            if ((str.length() - 2) <= limit) {
                
                Util.nf4.setMaximumFractionDigits(decimal);
                Util.nf4.setMinimumFractionDigits(decimal);
                
                super.remove(0, offset);
                super.insertString(0, Util.nf4.format(value.setScale(decimal, RoundingMode.HALF_EVEN)), attr);
            }
        } catch (NumberFormatException ex) {

        }

    }

    @Override
    public void remove(int offs, int len) throws BadLocationException {
        super.remove(offs, len);
        String text = getText(0, getLength());
        super.remove(0, getLength());
        insertString(0, text, null);
    }

}
