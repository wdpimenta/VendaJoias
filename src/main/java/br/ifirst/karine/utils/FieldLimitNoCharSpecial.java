/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Wanderson
 */
public class FieldLimitNoCharSpecial extends FieldLimit {

    public FieldLimitNoCharSpecial(int i, boolean upper) {
        super(i, upper);
    }

    public FieldLimitNoCharSpecial(int i) {
        super(i);
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        super.insertString(offset, str = str.replaceAll("[^A-Za-z0-9 ]", ""), attr);
    }
}
