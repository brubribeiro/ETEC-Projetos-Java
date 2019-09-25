/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasFrame;

import banco.ProdutosGer;
import dados.Produto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import tabelas.BaseTabelas;

/**
 *
 * @author Gordramos
 */
public class FrmEstoque extends javax.swing.JFrame
{

    ProdutosGer objCad = new ProdutosGer();
    ArrayList listaProdutos = new ArrayList<>();
    Produto crud = new Produto();
    int quantidadeProduto;

    public FrmEstoque()
      {
        initComponents();
        buscaDados();
      }

    private void buscaDados()
      {
        objCad.consultaBD(crud, 2);
        if (!objCad.listaDados.isEmpty())
          {
            carregaTabela(objCad.listaDados);
          }
      }

    public void carregaTabela(ArrayList<Produto> dados)
      {
        String colunas[] =
          {
            "Codigo", "Nome", "Quantidade", "Valor", "Local"
          };
        listaProdutos.clear();

        for (int i = 0; i < dados.size(); i++)
          {
            listaProdutos.add(new Object[]
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
            BaseTabelas modelo = new BaseTabelas(listaProdutos, colunas);
            //jtable  presente no formulário
            tabela.setModel(modelo);
            //atributo para definir o tamanho da coluna, tamanho em pixel
            tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
            //atributo para controlar se a coluna vai ser alterado o tamanho
            tabela.getColumnModel().getColumn(0).setResizable(false);
            for (int i = 1; i < colunas.length; i++)
              {
                //atributo para definir o tamanho da coluna, tamanho em pixel
                tabela.getColumnModel().getColumn(i).setPreferredWidth(200);
                //atributo para controlar se a coluna vai ser alterado o tamanho
                tabela.getColumnModel().getColumn(i).setResizable(false);
              }
            //cabeçalho da tabela - reordenar a alocação
            tabela.getTableHeader().setReorderingAllowed(false);
            //não redimensionar a tabela
            tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            //definir quantas linhas podem ser selecionadas
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            // Manipulando o orientação dos campos da tabela
            DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            DefaultTableCellRenderer direita = new DefaultTableCellRenderer();

            esquerda.setHorizontalAlignment(SwingConstants.LEFT);
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            direita.setHorizontalAlignment(SwingConstants.RIGHT);

            tabela.getColumnModel().getColumn(0).setCellRenderer(esquerda);
            tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            tabela.getColumnModel().getColumn(2).setCellRenderer(direita);

          }
        catch (Exception e)
          {
            BaseTabelas modelo = new BaseTabelas(listaProdutos, colunas);
            tabela.setModel(modelo);
          }
      }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        portaTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        btnBaixa = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {},
                {},
                {},
                {}
            },
            new String []
            {

            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                tabelaMouseClicked(evt);
            }
        });
        portaTabela.setViewportView(tabela);

        jLabel1.setText("Produto:");

        jLabel2.setText("Quantidade Disponível:");

        txtProduto.setEditable(false);

        txtQuantidade.setEditable(false);

        btnBaixa.setText("Dar Baixa");
        btnBaixa.setEnabled(false);
        btnBaixa.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBaixaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(portaTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBaixa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jLabel1))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(portaTabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBaixa)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tabelaMouseClicked
    {//GEN-HEADEREND:event_tabelaMouseClicked

        int linhaTabela = tabela.getSelectedRow();

        crud.setCodigoProduto(Integer.parseInt(String.valueOf(tabela.getValueAt(linhaTabela, 0))));
        crud.setNomeProduto((String.valueOf(tabela.getValueAt(linhaTabela, 1))));
        crud.setQuantidadeProduto(Integer.parseInt(String.valueOf(tabela.getValueAt(linhaTabela, 2))));
        crud.setValorProduto(Float.parseFloat(String.valueOf(tabela.getValueAt(linhaTabela, 3))));
        crud.setLocalProduto((String.valueOf(tabela.getValueAt(linhaTabela, 4))));

        quantidadeProduto = crud.getQuantidadeProduto();

        txtProduto.setText(crud.getNomeProduto());
        txtQuantidade.setText(String.valueOf(crud.getQuantidadeProduto()));
        btnBaixa.setEnabled(true);
        btnCancelar.setEnabled(true);


    }//GEN-LAST:event_tabelaMouseClicked

    public void cancelar()
      {
        txtProduto.setText("");
        txtQuantidade.setText("");
        btnBaixa.setEnabled(false);
        btnCancelar.setEnabled(false);
      }
    private void btnBaixaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBaixaActionPerformed
    {//GEN-HEADEREND:event_btnBaixaActionPerformed
        int valorDigitado = 0;
        try
          {
            valorDigitado = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de: " + crud.getNomeProduto() + " retirada:"));
          }
        catch (NumberFormatException n)
          {
            System.out.println("Formato Incorreto");
          }
        if (valorDigitado > quantidadeProduto)
          {
            JOptionPane.showMessageDialog(null, "Valor informado maior que o disponivel");
          }
        else
          {
            int novaQuantidade = quantidadeProduto - valorDigitado;
            crud.setQuantidadeProduto(novaQuantidade);
            objCad.alterarProduto(crud);
            cancelar();
            buscaDados();
          }
    }//GEN-LAST:event_btnBaixaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCancelarActionPerformed
    {//GEN-HEADEREND:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaixa;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane portaTabela;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
