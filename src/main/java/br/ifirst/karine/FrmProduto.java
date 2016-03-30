/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine;

import br.ifirst.karine.consultas.FrmConsultaProduto;
import br.ifirst.karine.daos.BanhoDao;
import br.ifirst.karine.daos.ProdutoDao;
import br.ifirst.karine.entities.Banho;
import br.ifirst.karine.entities.Produto;
import br.ifirst.karine.entities.ProdutoBanho;
import br.ifirst.karine.tables.TableProdutoBanho;
import br.ifirst.karine.utils.Util;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Wanderson
 */
public class FrmProduto extends javax.swing.JDialog {

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;

    private final BanhoDao banhoDao = new BanhoDao();
    private final ProdutoDao produtoDao = new ProdutoDao();

    private final JFileChooser fc = new JFileChooser();

    private Produto produtoTemp = null;

    /**
     * Creates new form FrmProduto
     *
     * @param parent
     * @param modal
     */
    public FrmProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fieldNomeProduto.requestFocus();

        doLimparTela();

        this.setLocationRelativeTo(parent);

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });

    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        fieldProdutoBanho = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        fieldBanhos = new javax.swing.JComboBox();
        fieldGrama = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fieldValorBanho = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        fieldNomeProduto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fieldComprimento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fieldLargura = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        excluirButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        fieldFileUpload = new javax.swing.JLabel();
        fieldCodigo = new javax.swing.JTextField();
        fieldPainelImagem = new javax.swing.JScrollPane();
        fieldImagem = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fieldReferencia = new javax.swing.JTextField();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton3.setText("...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        fieldProdutoBanho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Gramas", "Banho", "Preço"
            }
        ));
        jScrollPane2.setViewportView(fieldProdutoBanho);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Laçamento de banho"));

        fieldBanhos.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        fieldBanhos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fieldBanhosItemStateChanged(evt);
            }
        });

        fieldGrama.setDocument(new br.ifirst.karine.utils.FieldLimitMoney(4,4));
        fieldGrama.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        fieldGrama.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldGrama.setText("1");
        fieldGrama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldGramaFocusGained(evt);
            }
        });
        fieldGrama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldGramaKeyReleased(evt);
            }
        });

        jLabel8.setText("banho");

        jLabel9.setText("Gramas");

        fieldValorBanho.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        fieldValorBanho.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldValorBanho.setEnabled(false);

        jLabel10.setText("Valor");

        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton2.setText("Adicionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fieldGrama, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(fieldValorBanho, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(fieldBanhos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldBanhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6)
                        .addComponent(fieldGrama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldValorBanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)))))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {fieldGrama, fieldValorBanho, jButton2});

        jLabel4.setText("Produto");

        fieldNomeProduto.setDocument(new br.ifirst.karine.utils.FieldLimitNoCharSpecial(100, true));
        fieldNomeProduto.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N

        jLabel5.setText("Descrição");

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton1.setText("Selecionar imagem");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Comprimento - mm");

        fieldComprimento.setDocument(new br.ifirst.karine.utils.FieldLimitNumber(9));
        fieldComprimento.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        fieldComprimento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldComprimento.setText("1");

        jLabel6.setText("Largura - mm");

        fieldLargura.setDocument(new br.ifirst.karine.utils.FieldLimitNumber(9));
        fieldLargura.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        fieldLargura.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldLargura.setText("1");

        okButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        okButton.setText("Salvar");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        limparButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        limparButton.setText("Novo");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparButtonActionPerformed(evt);
            }
        });

        excluirButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        excluirButton.setText("Excluir");
        excluirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        fieldFileUpload.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N

        fieldCodigo.setDocument(new br.ifirst.karine.utils.FieldLimitNumber(9)
        );
        fieldCodigo.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        fieldCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCodigoKeyPressed(evt);
            }
        });

        fieldPainelImagem.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Imagem do selecionada"));

        fieldImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fieldPainelImagem.setViewportView(fieldImagem);

        jLabel7.setText("Referênia");

        fieldReferencia.setDocument(new br.ifirst.karine.utils.FieldLimit(20,true));
        fieldReferencia.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        fieldReferencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldReferenciaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 73, Short.MAX_VALUE))
                            .addComponent(fieldReferencia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldFileUpload, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limparButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(excluirButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(fieldPainelImagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldComprimento)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldLargura, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, excluirButton, limparButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(fieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(fieldReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldComprimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldLargura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
                    .addComponent(fieldPainelImagem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelButton)
                        .addComponent(okButton)
                        .addComponent(excluirButton)
                        .addComponent(limparButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(fieldFileUpload)))
                .addGap(6, 6, 6))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {fieldCodigo, fieldComprimento, fieldLargura, fieldNomeProduto, fieldReferencia, limparButton, okButton});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {fieldFileUpload, jButton1});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

        doValidaDadosAndSave();

        //doClose(RET_OK);
    }//GEN-LAST:event_okButtonActionPerformed

    private void limparButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparButtonActionPerformed

        int showInternalConfirmDialog = JOptionPane.showConfirmDialog(this, "Deseja limpar tela", "limpar", JOptionPane.OK_CANCEL_OPTION);
        if (showInternalConfirmDialog == JOptionPane.OK_OPTION) {
            doLimparTela();
        }
    }//GEN-LAST:event_limparButtonActionPerformed

    private void excluirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirButtonActionPerformed
        doExcluir();
    }//GEN-LAST:event_excluirButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void fieldBanhosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fieldBanhosItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            doCalcularValorBanho((Banho) evt.getItem());
        }
    }//GEN-LAST:event_fieldBanhosItemStateChanged

    private void fieldGramaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldGramaKeyReleased
        doCalcularValorBanho((Banho) fieldBanhos.getSelectedItem());
    }//GEN-LAST:event_fieldGramaKeyReleased

    private void fieldGramaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldGramaFocusGained
        fieldGrama.selectAll();
    }//GEN-LAST:event_fieldGramaFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        doAddBanhoProduto();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        okButton.doClick();
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fieldFileUpload.setText(fc.getSelectedFile().getAbsolutePath());
            fieldImagem.setToolTipText(fc.getSelectedFile().getAbsolutePath());
            FileInputStream fileInputStream = null;
            try {

                fileInputStream = new FileInputStream(fc.getSelectedFile());
                fieldImagem.setIcon(new ImageIcon(IOUtils.toByteArray(fileInputStream)));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, String.format("Erro ao seleiconar imagem\n%s", ex.getMessage()));
            } finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException ex) {

                    }
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fieldCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCodigoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            long aLong = Util.getLong(fieldCodigo);
            if (aLong > 0) {
                doLimparTela();

                produtoTemp = produtoDao.find(aLong);

                if (produtoTemp != null) {
                    doPreencheForm(produtoTemp);
                } else {
                    JOptionPane.showMessageDialog(this, String.format("Produto com o código [%s] infromado não encotrando", aLong));
                }

            }
        }
    }//GEN-LAST:event_fieldCodigoKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FrmConsultaProduto frmConsultaProduto = new FrmConsultaProduto(this, true);
        frmConsultaProduto.setVisible(true);

        if (frmConsultaProduto.getReturnStatus() == FrmConsultaProduto.RET_OK) {
            produtoTemp = frmConsultaProduto.getProdutoSelecionado();
            doPreencheForm(produtoTemp);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void fieldReferenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldReferenciaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String ref = fieldReferencia.getText().trim();
            if (!ref.isEmpty()) {
                
                produtoTemp = produtoDao.findByReferencia(ref);
                
                if (produtoTemp != null) {
                    doPreencheForm(produtoTemp);
                } else {
                    JOptionPane.showMessageDialog(this, String.format("Produto com a referência [%s] infromado não encotrando", ref));
                }
                
            }

        }
    }//GEN-LAST:event_fieldReferenciaKeyPressed

    private void doCalcularValorBanho(Banho b) {

        if (!fieldGrama.getText().isEmpty()) {
            BigDecimal valorGrama = b.getValorGrama();
            valorGrama = valorGrama.multiply(new BigDecimal(fieldGrama.getText().replaceAll(",", "."))).setScale(2, RoundingMode.HALF_EVEN);
            if (valorGrama.compareTo(BigDecimal.ZERO) > 0) {
                fieldValorBanho.setText(Util.nf.format(valorGrama));

            }
        }

    }

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton excluirButton;
    private javax.swing.JComboBox fieldBanhos;
    private javax.swing.JTextField fieldCodigo;
    private javax.swing.JTextField fieldComprimento;
    private javax.swing.JLabel fieldFileUpload;
    private javax.swing.JTextField fieldGrama;
    private javax.swing.JLabel fieldImagem;
    private javax.swing.JTextField fieldLargura;
    private javax.swing.JTextField fieldNomeProduto;
    private javax.swing.JScrollPane fieldPainelImagem;
    private javax.swing.JTable fieldProdutoBanho;
    private javax.swing.JTextField fieldReferencia;
    private javax.swing.JTextField fieldValorBanho;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limparButton;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;

    private void doValidaDadosAndSave() {

        boolean isErro = false;
        StringBuilder sb = new StringBuilder("Erros no cadastro de banho");

        produtoTemp.setNome(fieldNomeProduto.getText().trim());
        produtoTemp.setLargura(new BigDecimal(fieldLargura.getText()));
        produtoTemp.setComprimento(new BigDecimal(fieldComprimento.getText()));
        produtoTemp.setReferencia(fieldReferencia.getText().trim());

        if (fc.getSelectedFile() != null) {
            FileInputStream fileInputStream = null;
            try {

                fileInputStream = new FileInputStream(fc.getSelectedFile());
                produtoTemp.setFoto(IOUtils.toByteArray(fileInputStream));
            } catch (IOException ex) {
                sb.append("\n").append(String.format("Campo Imagem do produto não informado ou carregada [%s]", ex.getMessage()));
                isErro = true;
            } finally {
                try {
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                } catch (IOException ex) {
                    sb.append("\n").append(String.format("Campo Imagem do produto não informado ou carregada [%s]", ex.getMessage()));
                    isErro = true;
                }
            }
        } else if (produtoTemp.getFoto() == null || produtoTemp.getFoto().length <= 0) {
            sb.append("\n").append(String.format("Campo Foto do produto não informado ou carregada"));
            isErro = true;
        }

        if (produtoTemp.getReferencia().isEmpty() || produtoTemp.getReferencia().length() < 2) {
            sb.append("\n").append(String.format("Campo Referencia do Produto não informado ou menor que 3 digitos [%s]", produtoTemp.getReferencia()));
            isErro = true;
        }

        if (produtoTemp.getNome().isEmpty() || produtoTemp.getNome().length() < 3) {
            sb.append("\n").append(String.format("Campo Nome do Produto não informado ou menor que 3 digitos [%s]", produtoTemp.getNome()));
            isErro = true;
        }

        if (produtoTemp.getComprimento().compareTo(BigDecimal.ZERO) < 1) {
            sb.append("\n").append(String.format("Campo Comprimento do produto tem que ser superior a zero (0)"));
            isErro = true;
        }

        if (produtoTemp.getLargura().compareTo(BigDecimal.ZERO) < 1) {
            sb.append("\n").append(String.format("Campo Largura do produto tem que ser superior a zero (0)"));
            isErro = true;
        }

        if (produtoTemp.getProdutoBanhos().size() < 1) {
            sb.append("\n").append(String.format("Campo Banho para o produto foi não informado, selecione pelo menos um banho"));
            isErro = true;
        }

        if (isErro) {
            JOptionPane.showMessageDialog(this, sb.toString());
        } else {
            doSalvarProduto(produtoTemp);
        }

    }

    private void doLimparTela() {

        produtoTemp = new Produto();
        produtoTemp.setLargura(BigDecimal.valueOf(1).setScale(0));
        produtoTemp.setComprimento(BigDecimal.valueOf(1).setScale(0));
        produtoTemp.setId(0L);
        produtoTemp.setProdutoBanhos(new ArrayList<ProdutoBanho>());

        fieldCodigo.setText("");
        fieldNomeProduto.setText("");
        fieldComprimento.setText(produtoTemp.getComprimento().toString());
        fieldLargura.setText(produtoTemp.getLargura().toString());
        fieldImagem.setText("");
        fieldImagem.setIcon(null);
        fieldReferencia.setText("");

        fieldProdutoBanho.setModel(new TableProdutoBanho((List<ProdutoBanho>) produtoTemp.getProdutoBanhos(), null));

        List<Banho> findAll = banhoDao.findAll();
        if (findAll.size() > 0) {
            fieldBanhos.setModel(new DefaultComboBoxModel(findAll.toArray()));
            fieldBanhos.setSelectedIndex(0);
            doCalcularValorBanho((Banho) fieldBanhos.getSelectedItem());
        }

    }

    private void doExcluir() {
        if (produtoTemp.getId() > 0) {
            int showInternalConfirmDialog = JOptionPane.showConfirmDialog(this, "Deseja excluir cadastro", "excluir", JOptionPane.OK_CANCEL_OPTION);
            if (showInternalConfirmDialog == JOptionPane.OK_OPTION) {

                produtoDao.remove(produtoTemp);
                doLimparTela();
                JOptionPane.showMessageDialog(this, "Produto excluido com sucesso");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto");
        }
    }

    private void doSalvarProduto(Produto p) {
        if (p.getId() > 0) {
            produtoDao.edit(p);
        } else {
            p.setId(null);
            produtoDao.create(p);

        }

        doLimparTela();
        JOptionPane.showMessageDialog(this, "Dados salvos com sucesso");

    }

    private void doPreencheForm(Produto p) {

        fieldCodigo.setText(String.valueOf(p.getId()));
        fieldNomeProduto.setText(p.getNome());
        fieldComprimento.setText(p.getComprimento().setScale(0).toString());
        fieldLargura.setText(p.getLargura().setScale(0).toString());
        if (p.getFoto() != null) {
            fieldImagem.setIcon(new ImageIcon(p.getFoto()));
        }
        fieldReferencia.setText(p.getReferencia());

        fieldProdutoBanho.setModel(new TableProdutoBanho((List<ProdutoBanho>) p.getProdutoBanhos(), null));

    }

    private void doAddBanhoProduto() {

        try {
            if (fieldGrama.getText().isEmpty()) {
                fieldGrama.setText("100");
            }

            TableProdutoBanho tableProdutoBanho = (TableProdutoBanho) fieldProdutoBanho.getModel();

            Banho b = (Banho) fieldBanhos.getSelectedItem();

            doCalcularValorBanho(b);

            ProdutoBanho produtoBanho = new ProdutoBanho();
            produtoBanho.setBanho(b);
            produtoBanho.setProduto(produtoTemp);
            produtoBanho.setGramas(new BigDecimal(Util.nf.parse(fieldGrama.getText()).doubleValue()));
            produtoBanho.setValorTotal(new BigDecimal(Util.nf.parse(fieldValorBanho.getText()).doubleValue()));

            if (tableProdutoBanho.isExists(produtoBanho)) {
                produtoBanho.setId(tableProdutoBanho.get(produtoBanho).getId());
                tableProdutoBanho.update(produtoBanho);
            } else {
                tableProdutoBanho.add(produtoBanho);

            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao converter valor de gramas");
        }

    }
}