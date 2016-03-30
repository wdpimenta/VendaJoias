/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Properties;
import javax.swing.JTextField;

/**
 *
 * @author Wanderson
 */
public class Util {

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static NumberFormat nf = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
    public static NumberFormat nf1 = new DecimalFormat("#,#0.0", new DecimalFormatSymbols(new Locale("pt", "BR")));
    public static NumberFormat nf4 = new DecimalFormat("#,####0.0000", new DecimalFormatSymbols(new Locale("pt", "BR")));

    public static Properties propertiesDB;

    public static Properties getPropertiesDB() {
        return propertiesDB;
    }

    public static void setPropertiesDB(Properties propertiesDB) {
        Util.propertiesDB = propertiesDB;
    }

    public static long getLong(JTextField field) {
        return getLong(field, 0);
    }

    public static int getInt(JTextField field) {
        return getInt(field, 0);
    }

    public static long getLong(JTextField field, long valueMinimo) {
        long ret;
        try {
            ret = Long.parseLong(field.getText());
        } catch (NumberFormatException e) {
            ret = 0L;
        }

        if (ret < valueMinimo) {
            return valueMinimo;
        }
        return ret;
    }

    public static int getInt(JTextField field, int valueMinimo) {
        int ret;
        try {
            ret = Integer.parseInt(field.getText());
        } catch (NumberFormatException e) {
            ret = 0;
        }

        if (ret < valueMinimo) {
            return valueMinimo;
        }
        return ret;
    }

    public static void copy(InputStream src, OutputStream dst) throws IOException {
        byte[] buf = new byte[1024];
        int len;
        while ((len = src.read(buf)) > 0) {
            dst.write(buf, 0, len);
        }
        src.close();
        dst.close();
    }

    public static String extractException(Exception ex) {

        StackTraceElement[] stackTrace = ex.getStackTrace();

        StringBuilder sb = new StringBuilder("Motivo :");
        sb.append("\n").append(ex.getMessage());

        if (stackTrace.length > 0) {

            sb.append("\n").append("Arquivo : ").append(stackTrace[0].getFileName());
            sb.append("\n").append("Classe  : ").append(stackTrace[0].getClassName());
            sb.append("\n").append("Método  : ").append(stackTrace[0].getMethodName());
            sb.append("\n").append("Linha   : ").append(stackTrace[0].getLineNumber());

        }
        return sb.toString();
    }
}
