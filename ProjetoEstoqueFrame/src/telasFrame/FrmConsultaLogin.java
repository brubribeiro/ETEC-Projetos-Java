/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasFrame;

import banco.LoginGer;
import banco.Conecta;
import java.util.ArrayList;
import dados.Login;
import java.io.InputStream;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import tabelas.BaseTabelas;

/**
 *
 * @author Gordramos
 */
public class FrmConsultaLogin extends javax.swing.JFrame
{
    LoginGer objCad = new LoginGer();
    ArrayList listaDados = new ArrayList<>();
    Conecta conn = new Conecta();

    LoginGer gerExcAlt = new LoginGer();
    Login crudLogin = new Login();

   
    public FrmConsultaLogin()
      {
        initComponents();
      }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCadastro = new javax.swing.JTable();
        btnTabela = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome");

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        tabelaCadastro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaCadastro);

        btnTabela.setText("Tabela completa");
        btnTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTabelaActionPerformed(evt);
            }
        });

        btnRelatorio.setText("Relatorio Login por usuario");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnTabela)
                    .addComponent(btnRelatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        crudLogin.setUsuario(txtNome.getText());
        objCad.consultaBD(crudLogin, 4);
        carregaTabela(objCad.listaDados);
    }//GEN-LAST:event_txtNomeKeyReleased

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTabelaActionPerformed
        if (true == objCad.consultaBD(crudLogin, 2))
          {
            carregaTabela(objCad.listaDados);
          }
        else
          {
            JOptionPane.showMessageDialog(null, " Banco de Dados Vazio");
          }
    }//GEN-LAST:event_btnTabelaActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        // TODO add your handling code here:
        if (txtNome.getText().isEmpty())
          {
            JOptionPane.showMessageDialog(null, "Digite um usuario para gerar um relatório!");
          }
        else
          {
            HashMap parametro = new HashMap<>();
            // pegando o valor a ser pesquisaddo
            parametro.put("usuario", txtNome.getText());
            //gerando um relatório de cadastros
            JasperPrint imprime;
            try
              {
                InputStream caminho = getClass().getResourceAsStream("../relatorio/RptLoginPorUsuario.jasper");
                imprime = JasperFillManager.fillReport(caminho, parametro, conn.conectandoBanco());
                JasperViewer.viewReport(imprime, false);
              }
            catch (JRException ex)
              {
                System.out.println(ex.getMessage());
              }
          }
    }//GEN-LAST:event_btnRelatorioActionPerformed

    public void carregaTabela(ArrayList<Login> dados)
      {
        String colunas[] =
          {
            "Código", "Usuário", "Senha", "Nível", "Status"
          };
        listaDados.clear();

        for (int i = 0; i < dados.size(); i++)
          {
            listaDados.add(new Object[]
              {
                dados.get(i).getCodigo(),
                dados.get(i).getUsuario(),
                dados.get(i).getSenha(),
                dados.get(i).getNivel(),
                dados.get(i).isAtivo()
              });
          }

        try
          {
            BaseTabelas modelo = new BaseTabelas(listaDados, colunas);
            //jtable  presente no formulário
            tabelaCadastro.setModel(modelo);
            //   System.out.println("2");

            tabelaCadastro.getColumnModel().getColumn(0).setPreferredWidth(70);
            tabelaCadastro.getColumnModel().getColumn(0).setResizable(false);

            for (int i = 1; i < colunas.length; i++)
              {
                //atributo para definir o tamanho da coluna, tamanho em pixel
                tabelaCadastro.getColumnModel().getColumn(i).setPreferredWidth(500);
                //atributo para controlar se a coluna vai ser alterado o tamanho
                tabelaCadastro.getColumnModel().getColumn(i).setResizable(false);
              }
            //cabeçalho da tabela - reordenar a alocação
            tabelaCadastro.getTableHeader().setReorderingAllowed(false);
            //não redimensionar a tabela
            tabelaCadastro.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            //definir quantas linhas podem ser selecionadas
            tabelaCadastro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            // Manipulando o orientação dos campos da tabela
            DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            DefaultTableCellRenderer direita = new DefaultTableCellRenderer();

            esquerda.setHorizontalAlignment(SwingConstants.LEFT);
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            direita.setHorizontalAlignment(SwingConstants.RIGHT);

            tabelaCadastro.getColumnModel().getColumn(0).setCellRenderer(esquerda);
            tabelaCadastro.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            tabelaCadastro.getColumnModel().getColumn(2).setCellRenderer(direita);

          }
        catch (Exception e)
          {
            BaseTabelas modelo = new BaseTabelas(listaDados, colunas);
            tabelaCadastro.setModel(modelo);
            //System.out.println("3");
          }
      }
    
    public static void main(String args[])
      {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
          {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
              {
                if ("Nimbus".equals(info.getName()))
                  {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                  }
              }
          }
        catch (ClassNotFoundException ex)
          {
            java.util.logging.Logger.getLogger(FrmConsultaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        catch (InstantiationException ex)
          {
            java.util.logging.Logger.getLogger(FrmConsultaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        catch (IllegalAccessException ex)
          {
            java.util.logging.Logger.getLogger(FrmConsultaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
          {
            java.util.logging.Logger.getLogger(FrmConsultaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
              {
                new FrmConsultaLogin().setVisible(true);
              }
        });
      }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTabela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaCadastro;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
