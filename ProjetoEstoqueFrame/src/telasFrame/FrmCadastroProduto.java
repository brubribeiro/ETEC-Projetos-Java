/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasFrame;

import banco.LoginAcesso;
import banco.ProdutosGer;
import dados.Produto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FrmCadastroProduto extends javax.swing.JFrame
{

    Produto dadosProduto = new Produto();
    ProdutosGer acessaBDProdutos = new ProdutosGer();

    ArrayList<Produto> produtosFicha = new ArrayList<>();

    int codigo;
    String operacao;
    int posNavegacao = 0;

    public FrmCadastroProduto()
      {
        initComponents();
        cancelar();
        primeraPosicao();
      }

    private void analisaNivel()
      {
        if (FrmTelaPrincipalFrame.dadosUsuarioLogado.getNivel() == 1)
          {
            btnAtualiza.setEnabled(false);
            btnEditar.setEnabled(false);
            btnExclui.setEnabled(false);
          }
        if (FrmTelaPrincipalFrame.dadosUsuarioLogado.getNivel() == 2){
            btnCadastrar.setEnabled(false);
            btnAtualiza.setEnabled(false);
            btnEditar.setEnabled(false);
            btnExclui.setEnabled(false);
        }
      }

    public void carregaPosicao(int pos)
      {
        produtosFicha.clear();
        acessaBDProdutos.consultaBD(dadosProduto, 2);
        if (acessaBDProdutos.listaDados.isEmpty())
          {
            JOptionPane.showMessageDialog(null, "Tabela Vazia");
          }
        else
          {
            produtosFicha = acessaBDProdutos.listaDados;
            carregarDados(pos);

          }
      }

    public final void carregarDados(int pos)
      {

        if (produtosFicha.size() > 0)
          {
            codigo = produtosFicha.get(pos).getCodigoProduto();
            txtNome.setText(produtosFicha.get(pos).getNomeProduto());
            txtQuantidade.setText(String.valueOf(produtosFicha.get(pos).getQuantidadeProduto()));
            txtValor.setText(String.valueOf(produtosFicha.get(pos).getValorProduto()));
            txtLocal.setText(produtosFicha.get(pos).getLocalProduto());
            btnCadastrar.setEnabled(false);

            dadosProduto.setCodigoProduto(codigo);
            dadosProduto.setNomeProduto(txtNome.getText());
            dadosProduto.setQuantidadeProduto(Integer.parseInt(txtQuantidade.getText()));
            dadosProduto.setValorProduto(Float.parseFloat(txtValor.getText()));
            dadosProduto.setLocalProduto(txtLocal.getText());
          }
        else
          {
            JOptionPane.showMessageDialog(null, "A tabela está vazia. Não existem cadastros.");
            limpar();
            btnCadastrar.setEnabled(false);
            btnExclui.setEnabled(false);
            btnProx.setEnabled(false);
            btnUlt.setEnabled(false);
          }
      }

    public void limpar()
      {
        txtNome.setText(null);
        txtQuantidade.setText(null);
        txtValor.setText(null);
        txtLocal.setText(null);
        txtNome.grabFocus();
      }

    public void recebeDados(int opc)
      {
        try
          {
            dadosProduto.setCodigoProduto(codigo);
            dadosProduto.setNomeProduto(txtNome.getText());
            dadosProduto.setQuantidadeProduto(Integer.parseInt(txtQuantidade.getText()));
            dadosProduto.setValorProduto(Float.parseFloat(txtValor.getText()));
            dadosProduto.setLocalProduto(txtLocal.getText());

            if (opc == 1)
              {
                cadastrar();
              }
            else
              {
                alterar();
              }
          }
        catch (NumberFormatException e)
          {
            JOptionPane.showMessageDialog(this, "Digite os valores corretamente");
          }
      }

    public void alterar()
      {

        if (acessaBDProdutos.alterarProduto(dadosProduto) > 0)
          {
            JOptionPane.showMessageDialog(null, "Dados Alterados com sucesso!");
            cancelar();
          }
        else
          {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar!");
          }

      }

    public void cadastrar()
      {

        if (acessaBDProdutos.cadastraProduto(dadosProduto) > 0)
          {
            JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!");
            cancelar();
          }
        else
          {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar!");
          }

      }

    private void primeraPosicao()
      {
        try
          {
            //indica a posição ZERO
            posNavegacao = 0;
            //chama o metodo que carrega os dados
            carregaPosicao(posNavegacao);
            //bloqueia o primeiro e anterior
            btnAnt.setEnabled(false);
            btnPri.setEnabled(false);
            //libera o proximo e ultimo
            btnProx.setEnabled(true);
            btnUlt.setEnabled(true);
          }
        catch (Exception ex)
          {
            System.out.println(ex.getMessage());
          }
      }

    public void anteriorPosicao()
      {
        //verifica se não está no primeiro regsitro
        if (posNavegacao != 0)
          {
            //decrementa um e chama o metodo que carrega os dados
            posNavegacao--;
            carregaPosicao(posNavegacao);
            btnProx.setEnabled(true);
            btnUlt.setEnabled(true);
          }
        else
          {
            //caso esteja no primeiro registro informa ao usuário
            //bloqueia o primeiro e anterior
            //libera o proximo e ultimo
            JOptionPane.showMessageDialog(null, "Primeiro Registro!");
            btnAnt.setEnabled(false);
            btnPri.setEnabled(false);
            btnProx.setEnabled(true);
            btnUlt.setEnabled(true);
          }
      }

    public void proximaPosicao()
      {
        //Busca a quantidade de registros presentes no Arraylist
        int ultimo = produtosFicha.size();
        //caso o valor não seja o ultimo disponivel
        //incrementa um e chama o metodo que busca e carrega os valores
        if (posNavegacao != ultimo - 1)
          {
            posNavegacao++;
            carregaPosicao(posNavegacao);
            btnAnt.setEnabled(true);
            btnPri.setEnabled(true);
          }
        else
          {
            //indica que esta no ultimo registro 
            //bloqueia os botões proximo e ultimo
            //libera os primeiros e anterioes
            JOptionPane.showMessageDialog(null, "Último Registro!");
            btnProx.setEnabled(false);
            btnUlt.setEnabled(false);
            btnAnt.setEnabled(true);
            btnPri.setEnabled(true);
          }
      }

    public void ultimaPosicao()
      {
        //Busca a quantidade de registros presentes no Arraylist
        //aqui o valor é absoluto, isto é, vai indicar o total de registros
        posNavegacao = acessaBDProdutos.listaDados.size();
        //é retirado um para que indique a posição visto que as posições
        // do arraylist começam em ZERO 
        posNavegacao--;
        //chama o método que busca os dados e carrega de acordo com a posição
        carregaPosicao(posNavegacao);
        //Libera os botões que podem ser uteis 
        btnAnt.setEnabled(true);
        btnPri.setEnabled(true);
        //Bloqueia os botões que não são necessários para esta operação
        btnProx.setEnabled(false);
        btnUlt.setEnabled(false);
      }

    private void cancelar()
      {
        posNavegacao = 0;
        carregaPosicao(posNavegacao);
        //Libera os botões que podem ser uteis 
        btnNovo.setEnabled(true);
        btnProx.setEnabled(true);
        btnUlt.setEnabled(true);
        btnExclui.setEnabled(true);
        btnSair.setEnabled(true);
        btnEditar.setEnabled(true);
        //Bloqueia os botões que não são necessários para esta operação
        btnAtualiza.setEnabled(false);
        btnLimpar.setEnabled(false);
        btnCadastrar.setEnabled(false);
        btnCancel.setEnabled(false);
        //deixa as JtextFields bloqueadas para edição
        txtNome.setEditable(false);
        txtQuantidade.setEditable(false);
        txtValor.setEditable(false);
        txtLocal.setEditable(false);
      }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnAnt = new javax.swing.JButton();
        btnProx = new javax.swing.JButton();
        btnUlt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnAtualiza = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        txtQuantidade = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnExclui = new javax.swing.JButton();
        btnPri = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtLocal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/anterior.png"))); // NOI18N
        btnAnt.setMnemonic('t');
        btnAnt.setText("Anterior");
        btnAnt.setToolTipText("Ir para o registro anterior");
        btnAnt.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAntActionPerformed(evt);
            }
        });

        btnProx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/proximo.png"))); // NOI18N
        btnProx.setMnemonic('r');
        btnProx.setText("Próximo");
        btnProx.setToolTipText("Ir para o próximo registro");
        btnProx.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnProxActionPerformed(evt);
            }
        });

        btnUlt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ultimo.png"))); // NOI18N
        btnUlt.setMnemonic('i');
        btnUlt.setText("Último");
        btnUlt.setToolTipText("Ir para o último registro");
        btnUlt.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnUltActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome Produto");

        jLabel3.setText("Valor");

        txtNome.setEditable(false);

        txtValor.setEditable(false);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/sair.png"))); // NOI18N
        btnSair.setMnemonic('s');
        btnSair.setText("Sair");
        btnSair.setToolTipText("Sair do sistema");
        btnSair.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSairActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/editar.png"))); // NOI18N
        btnEditar.setMnemonic('d');
        btnEditar.setText("Editar");
        btnEditar.setToolTipText("Alterar o registro atual");
        btnEditar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnEditarActionPerformed(evt);
            }
        });

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        btnCadastrar.setMnemonic('a');
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setToolTipText("Salvar o cadastro");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnAtualiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/atualiza.png"))); // NOI18N
        btnAtualiza.setMnemonic('u');
        btnAtualiza.setText("Atualizar");
        btnAtualiza.setToolTipText("Salvar alterações feitas");
        btnAtualiza.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAtualizaActionPerformed(evt);
            }
        });

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/limpar.png"))); // NOI18N
        btnLimpar.setMnemonic('L');
        btnLimpar.setText("Limpar");
        btnLimpar.setToolTipText("Limpar todos os campos");
        btnLimpar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLimparActionPerformed(evt);
            }
        });

        jLabel5.setText("Quantidade");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/novo.png"))); // NOI18N
        btnNovo.setMnemonic('N');
        btnNovo.setText("Novo");
        btnNovo.setToolTipText("Novo cadastro");
        btnNovo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnNovoActionPerformed(evt);
            }
        });

        txtQuantidade.setEditable(false);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancelar.png"))); // NOI18N
        btnCancel.setMnemonic('C');
        btnCancel.setText("Cancelar");
        btnCancel.setToolTipText("Cancelar cadastro ou atualização");
        btnCancel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCancelActionPerformed(evt);
            }
        });

        btnExclui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/apagar.png"))); // NOI18N
        btnExclui.setMnemonic('E');
        btnExclui.setText("Excluir");
        btnExclui.setToolTipText("Apagar o registro atual");
        btnExclui.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnExcluiActionPerformed(evt);
            }
        });

        btnPri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/primeiro.png"))); // NOI18N
        btnPri.setMnemonic('P');
        btnPri.setText("Primeiro");
        btnPri.setToolTipText("Ir para o primeiro registro");
        btnPri.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnPriActionPerformed(evt);
            }
        });

        jLabel2.setText("Local");

        txtLocal.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPri, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAnt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnProx, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUlt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAtualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExclui, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExclui, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPri, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProx, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUlt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAntActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAntActionPerformed
    {//GEN-HEADEREND:event_btnAntActionPerformed
        anteriorPosicao();
    }//GEN-LAST:event_btnAntActionPerformed

    private void btnProxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnProxActionPerformed
    {//GEN-HEADEREND:event_btnProxActionPerformed
        proximaPosicao();
    }//GEN-LAST:event_btnProxActionPerformed

    private void btnUltActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnUltActionPerformed
    {//GEN-HEADEREND:event_btnUltActionPerformed
        ultimaPosicao();
    }//GEN-LAST:event_btnUltActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSairActionPerformed
    {//GEN-HEADEREND:event_btnSairActionPerformed
        // TODO add your handling code here:
        int escolha = (JOptionPane.showConfirmDialog(null, "Deseja realmente sair?",
                "Sair", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE));
        if (escolha == 0)
          {
            //  System.exit(0);
            dispose();
          }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnEditarActionPerformed
    {//GEN-HEADEREND:event_btnEditarActionPerformed
        if (LoginAcesso.nivelAcesso == 0)
          {
            btnNovo.setEnabled(false);
            btnPri.setEnabled(false);
            btnAnt.setEnabled(false);
            btnProx.setEnabled(false);
            btnUlt.setEnabled(false);
            btnSair.setEnabled(false);
            btnExclui.setEnabled(false);
            btnEditar.setEnabled(false);
            btnLimpar.setEnabled(false);
            btnCadastrar.setEnabled(false);
            btnAtualiza.setEnabled(true);
            btnCancel.setEnabled(true);
            txtNome.setEditable(true);
            txtQuantidade.setEditable(true);
            txtValor.setEditable(true);

          }
        else
          {
            JOptionPane.showMessageDialog(null, "Operação Cancelada! \nSeu Nivel de Acesso não permite tal operação ");
          }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCadastrarActionPerformed
    {//GEN-HEADEREND:event_btnCadastrarActionPerformed
        // chama metodo que recebe os dados da txt e direcionada para metodo de cadastro
        recebeDados(1);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAtualizaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAtualizaActionPerformed
    {//GEN-HEADEREND:event_btnAtualizaActionPerformed
        // chama metodo que recebe os dados da txt e direcionada para metodo de cadastro
        recebeDados(2);
        btnEditar.setEnabled(true);
        btnAtualiza.setEnabled(false);
    }//GEN-LAST:event_btnAtualizaActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLimparActionPerformed
    {//GEN-HEADEREND:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnNovoActionPerformed
    {//GEN-HEADEREND:event_btnNovoActionPerformed
        limpar();
        //Bloqueia os botões que não são necessários para esta operação
        btnNovo.setEnabled(false);
        btnPri.setEnabled(false);
        btnAnt.setEnabled(false);
        btnProx.setEnabled(false);
        btnUlt.setEnabled(false);
        btnSair.setEnabled(false);
        btnExclui.setEnabled(false);
        btnEditar.setEnabled(false);
        btnAtualiza.setEnabled(false);
        //Libera os botões que podem ser uteis
        btnLimpar.setEnabled(true);
        btnCadastrar.setEnabled(true);
        btnCancel.setEnabled(true);
        //deixa as JtextFields liberadas para edição
        txtNome.setEditable(true);
        txtQuantidade.setEditable(true);
        txtValor.setEditable(true);
        txtLocal.setEditable(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCancelActionPerformed
    {//GEN-HEADEREND:event_btnCancelActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnExcluiActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnExcluiActionPerformed
    {//GEN-HEADEREND:event_btnExcluiActionPerformed
        //verifica se o usuário logado tem permissão para realizar esta operação
        if (LoginAcesso.nivelAcesso == 0)
          {
            String nome;
            nome = txtNome.getText();
            int escolha = (JOptionPane.showConfirmDialog(null, "Você excluirá "
                    + nome + "\nDeseja realmente apagar este registro?",
                    "Excuir Registro", JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE));
            if (escolha == 0)
              {
                //chama o metodo que realiza a exclusão
                acessaBDProdutos.excluirProduto(dadosProduto);
                //faz a busca para atualizar o arraylist
                acessaBDProdutos.consultaBD(dadosProduto, 2);
                //busca a quantidade de registros armazenados no arraylist
                posNavegacao = acessaBDProdutos.listaDados.size();
                //chama o método carrega posição para o ultimo registro armazenado no banco de dados
                carregaPosicao(posNavegacao - 1);

              }
          }
        else
          {
            JOptionPane.showMessageDialog(null, "Operação Cancelada! \nSeu Nivel de Acesso não permite tal operação ");
          }
    }//GEN-LAST:event_btnExcluiActionPerformed

    private void btnPriActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnPriActionPerformed
    {//GEN-HEADEREND:event_btnPriActionPerformed
        primeraPosicao();
    }//GEN-LAST:event_btnPriActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnt;
    private javax.swing.JButton btnAtualiza;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExclui;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPri;
    private javax.swing.JButton btnProx;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnUlt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
