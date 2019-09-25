/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasFrame;

import banco.ControleOperacao;
import java.util.ArrayList;
import banco.LoginGer;
import dados.Acesso;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import tabelas.BaseTabelas;

public class FrmControleAcesso extends javax.swing.JFrame
{
    ArrayList ListaDados = new ArrayList<>();
    ControleOperacao acessaTabelaAcesso = new ControleOperacao();

    public FrmControleAcesso()
      {
        initComponents();
      }
    
    
    public void carregaTabela(ArrayList<Acesso> dados)
    {
        String colunas[] =
        {
            "Código Usuário", "Data", "Hora", "Ação"
        };
        ListaDados.clear();

        for (int i = 0; i < dados.size(); i++)
        {
            ListaDados.add(new Object[]
            {
                dados.get(i).getCodigoUsuario(),
                dados.get(i).getData(),
                dados.get(i).getHora(),
                dados.get(i).getAcao()
            });
        }

        try
        {
            BaseTabelas modelo = new BaseTabelas(ListaDados, colunas);
            tabelaAcessos.setModel(modelo);
            //   System.out.println("2");

            tabelaAcessos.getColumnModel().getColumn(0).setPreferredWidth(130);
            tabelaAcessos.getColumnModel().getColumn(0).setResizable(false);

            //atributo para definir o tamanho da coluna, tamanho em pixel
            tabelaAcessos.getColumnModel().getColumn(1).setPreferredWidth(200);
            //atributo para controlar se a coluna vai ser alterado o tamanho
            tabelaAcessos.getColumnModel().getColumn(1).setResizable(false);

            tabelaAcessos.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabelaAcessos.getColumnModel().getColumn(2).setResizable(false);

            tabelaAcessos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tabelaAcessos.getColumnModel().getColumn(3).setResizable(false);

          
            //cabeçalho da tabela - reordenar a alocação
            tabelaAcessos.getTableHeader().setReorderingAllowed(false);
            //não redimensionar a tabela
            tabelaAcessos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            //definir quantas linhas podem ser selecionadas
            tabelaAcessos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
            
            

        }
        catch (Exception e)
        {
            BaseTabelas modelo = new BaseTabelas(ListaDados, colunas);
            tabelaAcessos.setModel(modelo);
            //System.out.println("3");

        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grbBusca = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        rdbCodigo = new javax.swing.JRadioButton();
        rdbData = new javax.swing.JRadioButton();
        rdbHora = new javax.swing.JRadioButton();
        rdbAcao = new javax.swing.JRadioButton();
        btnTabela = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAcessos = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Valor pesquisado:");

        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValorKeyReleased(evt);
            }
        });

        grbBusca.add(rdbCodigo);
        rdbCodigo.setText("Código Usuário");

        grbBusca.add(rdbData);
        rdbData.setSelected(true);
        rdbData.setText("Data");

        grbBusca.add(rdbHora);
        rdbHora.setText("Hora");

        grbBusca.add(rdbAcao);
        rdbAcao.setText("Ação");

        btnTabela.setText("Tabela completa");
        btnTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTabelaActionPerformed(evt);
            }
        });

        tabelaAcessos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaAcessos);

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdbCodigo)
                                .addGap(18, 18, 18)
                                .addComponent(rdbData)
                                .addGap(18, 18, 18)
                                .addComponent(rdbHora)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdbAcao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbCodigo)
                    .addComponent(rdbData)
                    .addComponent(rdbHora)
                    .addComponent(rdbAcao)
                    .addComponent(btnTabela))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtValorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyReleased
        int campo = 1;
        if (rdbCodigo.isSelected())
        {
            campo = 1;
        }
        else if (rdbData.isSelected())
        {
            campo = 2;
        }
        else if (rdbHora.isSelected())
        {
            campo = 3;
        }
        else if (rdbAcao.isSelected())
        {
            campo = 4;
        }

        String valor = txtValor.getText();

        acessaTabelaAcesso.consultaBD(valor, campo);
        carregaTabela(acessaTabelaAcesso.listaDados);
    }//GEN-LAST:event_txtValorKeyReleased

    private void btnTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTabelaActionPerformed
        int campo = 5;
        acessaTabelaAcesso.consultaBD("", campo);
        carregaTabela(acessaTabelaAcesso.listaDados);
    }//GEN-LAST:event_btnTabelaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

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
            java.util.logging.Logger.getLogger(FrmControleAcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        catch (InstantiationException ex)
          {
            java.util.logging.Logger.getLogger(FrmControleAcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        catch (IllegalAccessException ex)
          {
            java.util.logging.Logger.getLogger(FrmControleAcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
          {
            java.util.logging.Logger.getLogger(FrmControleAcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
              {
                new FrmControleAcesso().setVisible(true);
              }
        });
      }
    
    
    
                 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTabela;
    private javax.swing.ButtonGroup grbBusca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbAcao;
    private javax.swing.JRadioButton rdbCodigo;
    private javax.swing.JRadioButton rdbData;
    private javax.swing.JRadioButton rdbHora;
    private javax.swing.JTable tabelaAcessos;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
