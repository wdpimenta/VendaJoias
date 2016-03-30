/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.utils;

/**
 *
 * @author Wanderson
 */
public class UtilValidaDocumento {

    private static final int[] pesosCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesosCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    private static int calcularDigitoVerificador(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    public static boolean isValidDocumento(String doc) {
        doc = doc.replaceAll("\\D", "");
        if (doc.isEmpty()) {
            doc = "01234567890";
        }
        
        if (doc.equals("01234567890")) {
            return true;
        } else {
            if (doc.length() == 11) {
                return isValidCPF(doc);
            } else {
                if (doc.length() == 14) {
                    return isValidCNPJ(doc);
                } else {
                    return false;
                }
            }
        }

    }

    public static boolean isValidCPF(String cpf) {
        cpf = cpf.replaceAll("\\D", "");
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }

        Integer digito1 = calcularDigitoVerificador(cpf.substring(0, 9), pesosCPF);
        Integer digito2 = calcularDigitoVerificador(cpf.substring(0, 9) + digito1, pesosCPF);
        return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
    }

    public static boolean isValidCNPJ(String cnpj) {

        cnpj = cnpj.replaceAll("\\D", "");
        if ((cnpj == null) || (cnpj.length() != 14)) {
            return false;
        }

        Integer digito1 = calcularDigitoVerificador(cnpj.substring(0, 12), pesosCNPJ);
        Integer digito2 = calcularDigitoVerificador(cnpj.substring(0, 12) + digito1, pesosCNPJ);

        return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
    }

}
