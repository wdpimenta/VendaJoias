/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine;

import br.ifirst.karine.utils.EMF;
import br.ifirst.karine.utils.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.OfficeSilver2007Skin;

/**
 *
 * @author Wanderson
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SubstanceLookAndFeel.setSkin(new OfficeSilver2007Skin());
                Properties loadProperties = App.loadProperties();
                if (loadProperties != null) {
                    Util.setPropertiesDB(loadProperties);
                    EMF.get();
                    if (setNoCreateBanco(loadProperties)) {

//                        UsuarioDao usuarioDao = new UsuarioDao();
                        boolean isLogado = false;
//
//                        if (usuarioDao.findAll().isEmpty()) {
//                            FrmUsuario frmUsuario = new FrmUsuario(null, true);
//                            frmUsuario.setVisible(true);
//
//                        } else {
//                            FrmLogin frmLogin = new FrmLogin(null, true);
//                            frmLogin.setVisible(true);
//                        }

                        if (!isLogado) {
                            new FrmPrincipal().setVisible(true);
                        }
                    }
                } else {
                    System.exit(1);
                }
            }
        });

    }

    private static Properties loadProperties() {

        InputStream targetStream = null;
        Properties props = new Properties();
        File initialFile = null;
        OutputStream output = null;

        String userDir = System.getProperty("user.dir");
        String fileSeparator = System.getProperty("file.separator");
        initialFile = new File(String.format("%s%sDataBaseConfig.properties", userDir, fileSeparator));

        try {
            targetStream = new FileInputStream(initialFile);
            try {
                props.load(targetStream);
                props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
                props.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
                props.put("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
                return props;
            } catch (IOException ex) {
                JOptionPane.showConfirmDialog(null, String.format("Não foi possível ler dados de configuração\n", Util.extractException(ex)));
            }

        } catch (FileNotFoundException ex) {

            JOptionPane.showMessageDialog(null, "Não existe configuração de banco de dados, vamos configurar agora");

            try {
                if (!initialFile.exists()) {
                    initialFile.getParentFile().mkdirs();
                }
                output = new FileOutputStream(initialFile);

                props.put("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/loja_joia");
                props.put("javax.persistence.jdbc.user", "");
                props.put("javax.persistence.jdbc.password", "");
                props.put("javax.persistence.schema-generation.database.action", "drop-and-create");

                props.store(output, "Confirugação de banco de dados");

                Runtime.getRuntime().exec("Notepad " + initialFile.getAbsolutePath());
            } catch (IOException ex1) {
                JOptionPane.showMessageDialog(null, String.format("Não foi possível criar arquivo para configuração de banco de dados\n", Util.extractException(ex1)));
            }

        } finally {
            try {
                if (targetStream != null) {
                    targetStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return null;
    }

    private static boolean setNoCreateBanco(Properties props) {

        File initialFile = null;
        OutputStream output = null;

        String userDir = System.getProperty("user.dir");
        String fileSeparator = System.getProperty("file.separator");
        initialFile = new File(String.format("%s%sDataBaseConfig.properties", userDir, fileSeparator));

        try {
            if (!initialFile.exists()) {
                initialFile.getParentFile().mkdirs();
            }
            output = new FileOutputStream(initialFile);

            props.remove("javax.persistence.schema-generation.database.action");
            props.remove("hibernate.dialect");
            props.remove("javax.persistence.jdbc.driver");
            props.remove("hibernate.cache.provider_class");

            props.store(output, "Confirugação de banco de dados");
            return true;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, String.format("Não foi possível criar arquivo para configuração de banco de dados\n", Util.extractException(ex)));
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return false;
    }

}
