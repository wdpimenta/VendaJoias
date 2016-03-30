/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.relatorios;

import br.ifirst.karine.utils.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Wanderson
 */
public class RelPedidoItemCliente {

    private static boolean fileImported = false;
    private static final String PATH = System.getProperty("user.home") + File.separatorChar + "KaOnze" + File.separatorChar + "relatario";

    public static void setFileImported(boolean fileImported) {
        RelPedidoItemCliente.fileImported = fileImported;
    }

    private static void exportFiles() {
        OutputStream out = null;
        InputStream in = null;

        String files[] = new String[]{"PedidoSemImagem.jasper", "PedidoItemSemImagem.jasper"};

        File directoryFile = new File(PATH);
        if (!directoryFile.exists()) {
            directoryFile.mkdirs();
        }

        for (String string : files) {
            try {
                in = RelPedido.class.getResourceAsStream("/resources/" + string);
                // always write to different location
                String libraryPath = PATH + File.separatorChar + string;
                File fileOut = new File(libraryPath);
                out = new FileOutputStream(fileOut);
                Util.copy(in, out);
                in.close();
                out.close();
            } catch (Exception ex) {
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }

                } catch (Exception ex) {
                }

                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (Exception ex) {
                }

            }
        }
    }

    public static JasperPrint imprimirPedidoItem(JRDataSource JPRPedidoItemDataSource) {

        try {

            if (!fileImported) {
                exportFiles();
                fileImported = true;
            }

            Map<String, Object> map = new HashMap<>();
            map.put("URL_SUB_REPORT", PATH + File.separatorChar);

            JasperPrint fillReport = JasperFillManager.fillReport(PATH + File.separatorChar + "PedidoSemImagem.jasper", map, JPRPedidoItemDataSource);
            fillReport.setName(fillReport.getName());

            return fillReport;

        } catch (JRException ex) {
            Logger.getLogger(RelPedido.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
