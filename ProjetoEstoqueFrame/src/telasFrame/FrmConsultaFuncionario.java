/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasFrame;

import banco.FuncionariosGer;
import banco.ControleOperacao;
import banco.Conecta;
import java.util.ArrayList;
import dados.Funcionario;
import java.io.InputStream;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import tabelas.BaseTabelas;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Gordramos
 */
public class FrmConsultaFuncionario extends javax.swing.JFrame
{
       FuncionariosGer objCad = new FuncionariosGer(); 
       ArrayList ListaDados = new ArrayList<>();
       ControleOperacao gerAcao = new ControleOperacao();
       String nomeConsultaRelatorio;
       Conecta conn = new Conecta();
       
       FuncionariosGer gerExcAlt = new FuncionariosGer();
       Funcionario crudFuncionario = new Funcionario();
       
    
    public FrmConsultaFuncionario()
      {
        initComponents();
      }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        funcionarios = new javax.swing.ButtonGroup();
        lblValor = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        txtValor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCadastro = new javax.swing.JTable();
        btnTabela = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        rdbNome = new javax.swing.JRadioButton();
        rdbCodigo = new javax.swing.JRadioButton();
        btnGerar = new javax.swing.JButton();
        btnRelatorioNome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblValor.setText("Valor:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
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

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        funcionarios.add(rdbNome);
        rdbNome.setText("Nome");

        funcionarios.add(rdbCodigo);
        rdbCodigo.setText("Código");

        btnGerar.setText("Gerar Relatório");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        btnRelatorioNome.setText("Relatório por nome");
        btnRelatorioNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdbNome)
                                .addGap(18, 18, 18)
                                .addComponent(rdbCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPesquisar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTabela)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGerar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRelatorioNome))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar)
                    .addComponent(btnTabela)
                    .addComponent(rdbNome)
                    .addComponent(rdbCodigo)
                    .addComponent(btnGerar)
                    .addComponent(btnRelatorioNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btnSair)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTabelaActionPerformed
        
        if (true == objCad.consultaBD(crudFuncionario, 2))
          {
            carregaTabela(objCad.listaDados);
          }
        else
          {
            JOptionPane.showMessageDialog(null, " Banco de Dados Vazio");
          }
        
    }//GEN-LAST:event_btnTabelaActionPerformed

    public void carregaTabela(ArrayList<Funcionario> dados)
      {
        String colunas[] =
          {
            "Código", "Nome", "Cargo","Telefone"
          };
        ListaDados.clear();

        for (int i = 0; i < dados.size(); i++)
          {
            ListaDados.add(new Object[]
              {
                dados.get(i).getCodigo(),
                dados.get(i).getNome(),
                dados.get(i).getCargo(),
                dados.get(i).getTelefone()
              });
          }
        try
          {
            BaseTabelas modelo = new BaseTabelas(ListaDados, colunas);
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
            BaseTabelas modelo = new BaseTabelas(ListaDados, colunas);
            tabelaCadastro.setModel(modelo);
            //System.out.println("3");
          }         
      }
    
    
    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

        
        public void gerarRelatorio()
      {
        try
          {
            //caminho do arquivo. Dentro projeto
            InputStream caminho = getClass().getResourceAsStream("../relatorio/RptFuncionario.jrxml");
            //
            JasperReport report = JasperCompileManager.compileReport(caminho);

            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(objCad.listaDados);

            JasperPrint imprime = JasperFillManager.fillReport(report, null, ds);

            JasperExportManager.exportReportToPdfFile(imprime, "c:/Relatorios/".concat(nomeConsultaRelatorio));

            JasperViewer visao = new JasperViewer(imprime, false);

            visao.setVisible(true);

            gerAcao.cadastraAcao("Relatório Geral");

          }
        catch (JRException ex)
          {
            System.out.println(ex.getMessage());
          }
      }
        
    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        // TODO add your handling code here:
        /*if (objCad.listaDados.isEmpty())
          {
            JOptionPane.showMessageDialog(null, "Realize uma pesquisa antes de gerar um relatório!");
          }
        else
          {
            gerarRelatorio();
          }*/
        
        //gerando um relatório de cadastros
        JasperPrint imprime;
        try
          {
            InputStream caminho = getClass().getResourceAsStream("../relatorio/RptFuncionario.jasper");

            imprime = JasperFillManager.fillReport(caminho, null, conn.conectandoBanco());
          

            JasperViewer.viewReport(imprime, false);
          }
        catch (JRException ex)
          {
            System.out.println(ex.getMessage());
          }

    }//GEN-LAST:event_btnGerarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        if (rdbCodigo.isSelected())
        {
            crudFuncionario.setCodigo(Integer.parseInt(txtValor.getText()));
            objCad.consultaBD(crudFuncionario, 5);
        }
        else
        {
            crudFuncionario.setNome(txtValor.getText());
            rdbNome.setSelected(true);
            objCad.consultaBD(crudFuncionario, 1);
        }

        //listadados é o arraylist que recebe o resultado da consulta
        //se ele estiver vazio, significa que o dado pesquisado não
        //se encontra cadastrado na tabela
        if (!objCad.listaDados.isEmpty())
        {
            carregaTabela(objCad.listaDados);
        }
        else
        {
            JOptionPane.showMessageDialog(null, " O dado pesquisado não está cadastrado no banco de dados");
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnRelatorioNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioNomeActionPerformed
        // TODO add your handling code here:
        if (txtValor.getText().isEmpty())
          {
            JOptionPane.showMessageDialog(null, "Digite um nome para gerar um relatório!");
          }
        else
          {
            HashMap parametro = new HashMap<>();
            // pegando o valor a ser pesquisaddo
            parametro.put("nome", txtValor.getText());
            //gerando um relatório de cadastros
            JasperPrint imprime;
            try
              {
                InputStream caminho = getClass().getResourceAsStream("../relatorio/rptNomes.jasper");
                imprime = JasperFillManager.fillReport(caminho, parametro, conn.conectandoBanco());
                JasperViewer.viewReport(imprime, false);
              }
            catch (JRException ex)
              {
                System.out.println(ex.getMessage());
              }
          }
    }//GEN-LAST:event_btnRelatorioNomeActionPerformed

    
     private void tabelaMouseClicked(java.awt.event.MouseEvent evt)                                    
    {                                        
        int linhaSelecionada = tabelaCadastro.getSelectedRow();
        String nome = String.valueOf(tabelaCadastro.getValueAt(linhaSelecionada, 0));
        txtValor.setText(nome);
    }
     
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)                                         
    {                                             
        if (rdbNome.isSelected())
          {
            crudFuncionario.setNome(txtValor.getText());
            objCad.consultaBD(crudFuncionario, 3);
          }
        else
          {
            crudFuncionario.setCargo(txtValor.getText());
            rdbCodigo.setSelected(true);
            objCad.consultaBD(crudFuncionario, 1);
          }

        //listadados é o arraylist que recebe o resultado da consulta
        //se ele estiver vazio, significa que o dado pesquisado não 
        //se encontra cadastrado na tabela
        if (!objCad.listaDados.isEmpty())
          {
            carregaTabela(objCad.listaDados);
          }
        else
          {
            JOptionPane.showMessageDialog(null, " O dado pesquisado não está cadastrado no banco de dados");
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
            java.util.logging.Logger.getLogger(FrmConsultaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        catch (InstantiationException ex)
          {
            java.util.logging.Logger.getLogger(FrmConsultaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        catch (IllegalAccessException ex)
          {
            java.util.logging.Logger.getLogger(FrmConsultaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
          {
            java.util.logging.Logger.getLogger(FrmConsultaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
              {
                new FrmConsultaFuncionario().setVisible(true);
              }
        });
      }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRelatorioNome;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTabela;
    private javax.swing.ButtonGroup funcionarios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblValor;
    private javax.swing.JRadioButton rdbCodigo;
    private javax.swing.JRadioButton rdbNome;
    private javax.swing.JTable tabelaCadastro;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
