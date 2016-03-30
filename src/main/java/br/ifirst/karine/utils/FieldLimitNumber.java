/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Wanderson
 */
public class FieldLimitNumber extends PlainDocument {

    private final int limit;

    public FieldLimitNumber(int i) {
        super();
        this.limit = i;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException {
        str = str.replaceAll("\\D", "");
        try {
            Long.parseLong(str);
        } catch (NumberFormatException ex) {
            str = "";
        }

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}
