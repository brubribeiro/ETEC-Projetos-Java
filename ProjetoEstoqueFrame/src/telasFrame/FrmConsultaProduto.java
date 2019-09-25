/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasFrame;

import banco.ProdutosGer;
import java.util.ArrayList;
import dados.Produto;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import tabelas.BaseTabelas;


public class FrmConsultaProduto extends javax.swing.JFrame
{
    ProdutosGer objCad = new ProdutosGer();
    ArrayList listaDados = new ArrayList<>();

    ProdutosGer gerExcAlt = new ProdutosGer();
    Produto crudProduto = new Produto();
    
    public FrmConsultaProduto()
      {
        this.setTitle("Formulário de Consulta");
        initComponents();
      }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnTabela = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCadastro = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Produto:");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnTabela.setText("Tabela Completa");
        btnTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTabelaActionPerformed(evt);
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
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCadastroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCadastro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnConsultar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSair))
                            .addComponent(txtNome))))
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
                    .addComponent(btnConsultar)
                    .addComponent(btnTabela)
                    .addComponent(btnSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed

        crudProduto.setNomeProduto(txtNome.getText());
        objCad.consultaBD(crudProduto, 1);
        //listadados é o arraylist que recebe o resultado da consulta
        //se ele estiver vazio, significa que o dado pesquisado não 
        //se encontra cadastrado na tabela
        if ( !objCad.listaDados.isEmpty())
          {
            carregaTabela(objCad.listaDados);
          }
        else
          {
            JOptionPane.showMessageDialog(null, " O produto " + crudProduto.getNomeProduto()
                    + " não está cadastrado no banco de dados");
          }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTabelaActionPerformed
       
        if (true == objCad.consultaBD(crudProduto, 2))
          {
            carregaTabela(objCad.listaDados);
          }
        else
          {
            JOptionPane.showMessageDialog(null, " Banco de Dados Vazio");
          }
    }//GEN-LAST:event_btnTabelaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void tabelaCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCadastroMouseClicked
        
        int linhaTabela = tabelaCadastro.getSelectedRow();

        crudProduto.setCodigoProduto((int) tabelaCadastro.getValueAt(linhaTabela, 0));
        crudProduto.setNomeProduto((String) tabelaCadastro.getValueAt(linhaTabela, 1));
        crudProduto.setQuantidadeProduto((int) tabelaCadastro.getValueAt(linhaTabela, 2));
        crudProduto.setValorProduto((float) tabelaCadastro.getValueAt(linhaTabela, 3));
        crudProduto.setLocalProduto((String) tabelaCadastro.getValueAt(linhaTabela, 4));

        Object[] options =
          {
            "ALTERAR", "EXCLUIR", "CANCELAR"
          };

        int opc = JOptionPane.showOptionDialog(null, "Você deseja?", "Escolher Ação",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

        switch (opc)
          {
            case 0:
                monta();
                break;
            case 1:
                int escolha = (JOptionPane.showConfirmDialog(null, "Deseja realmente EXCLUIR o registro?",
                        "Editar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
                if (escolha == 0)
                  {
                    if (gerExcAlt.excluirProduto(crudProduto) == 1)
                      {
                        JOptionPane.showMessageDialog(null, "O Registro foi excluido com sucesso do banco de dados");
                      }
                    else
                      {
                        JOptionPane.showMessageDialog(null, "Erro ao Excluir");
                      }
                  }
                break;
            case 2:
                //não faz nada
                break;
            default:
               // JOptionPane.showMessageDialog(null, "opção Invalida");
                break;
          }
        //atualizando os dados da tabela
        if (true == objCad.consultaBD(crudProduto, 2))
          {
            carregaTabela(objCad.listaDados);
          }
        else
          {
            JOptionPane.showMessageDialog(null, " Banco de Dados Vazio");
          }
      
    }//GEN-LAST:event_tabelaCadastroMouseClicked

     public void monta()
      {
        JTextField txtNome = new JTextField(crudProduto.getNomeProduto());
        JTextField txtQuantidade = new JTextField(crudProduto.getQuantidadeProduto());
        JTextField txtValor = new JTextField((int) crudProduto.getValorProduto());
        JTextField txtLocal = new JTextField(crudProduto.getLocalProduto());
        Object[] message =
          {
            "Nome", txtNome, "Quantidade", txtQuantidade,"Valor", txtValor,"Local", txtLocal
          };
        JOptionPane.showMessageDialog(null, message, "Inserir Alterações",
                JOptionPane.OK_CANCEL_OPTION);
        crudProduto.setNomeProduto(txtNome.getText());
        crudProduto.setQuantidadeProduto(Integer.parseInt(txtQuantidade.getText()));
        crudProduto.setValorProduto(Integer.parseInt(txtValor.getText()));
        crudProduto.setLocalProduto(txtLocal.getText());
        
        alterar();
      }
     
     public void alterar()
      {
        int escolha = (JOptionPane.showConfirmDialog(null, "Deseja realmente editar os dados?",
                "Editar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
        if (FrmTelaPrincipalFrame.dadosUsuarioLogado.getNivel() == 0)
          {
            if (escolha == 0)
              {
                int resposta = objCad.alterarProduto(crudProduto);
                //resposta do metodo alterar - banco de dados
                switch (resposta)
                  {
                    case 0:
                        JOptionPane.showMessageDialog(null, " Erro na alteração");
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null,
                                " Alteração realizada com sucesso no banco de dados");
                        break;
                    default:
                        break;
                  }
              }
          
            else
              {
                JOptionPane.showMessageDialog(null, " Operação Cancelada pelo Usuario");
              }
        }
        else
              {
                JOptionPane.showMessageDialog(null, "Usuario sem acesso");
              }
      }
    
    
    public void carregaTabela(ArrayList<Produto> dados)
      {
        String colunas[] ={"Código", "Nome", "Quantidade","Valor","Local"};
        listaDados.clear();

        for (int i = 0; i < dados.size(); i++)
          {
            listaDados.add(new Object[]
              {
                dados.get(i).getCodigoProduto(),
                dados.get(i).getNomeProduto(),
                dados.get(i).getQuantidadeProduto(),
                dados.get(i).getValorProduto(),
                dados.get(i).getLocalProduto()
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
                tabelaCadastro.getColumnModel().getColumn(i).setPreferredWidth(250);
                //atributo para controlar se a coluna vai ser alterado o tamanho
                tabelaCadastro.getColumnModel().getColumn(i).setResizable(false);
              }
            //cabeçalho da tabela - reordenar a alocação
            tabelaCadastro.getTableHeader().setReorderingAllowed(false);
            //não redimensionar a tabela
            tabelaCadastro.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            //definir quantas linhas podem ser selecionadas
            tabelaCadastro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
            java.util.logging.Logger.getLogger(FrmConsultaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        catch (InstantiationException ex)
          {
            java.util.logging.Logger.getLogger(FrmConsultaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        catch (IllegalAccessException ex)
          {
            java.util.logging.Logger.getLogger(FrmConsultaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
          {
            java.util.logging.Logger.getLogger(FrmConsultaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
              {
                new FrmConsultaProduto().setVisible(true);
              }
        });
      }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTabela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaCadastro;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
