package br.ifirst.karine.utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class FieldLimit extends PlainDocument {

    private final int limit;
    // optional uppercase conversion
    private boolean toUppercase = false;
    private boolean toLowercase = false;

    public FieldLimit(int i) {
        super();
        this.limit = i;
    }

    public FieldLimit(int i, boolean upper) {
        super();
        this.limit = i;
        toUppercase = upper;
        toLowercase = !upper;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException {
        if (str == null) {
            return;
        }
        if ((getLength() + str.length()) <= limit) {
            if (toUppercase) {
                super.insertString(offset, str.toUpperCase(), attr);
            } else {
                if (toLowercase) {
                    super.insertString(offset, str.toLowerCase(), attr);
                } else {
                    super.insertString(offset, str, attr);
                }
            }

        }
    }
}
