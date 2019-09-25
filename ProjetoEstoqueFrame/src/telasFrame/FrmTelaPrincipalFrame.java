package telasFrame;

import dados.Login;
import javax.swing.JFrame;

public class FrmTelaPrincipalFrame extends javax.swing.JFrame
{

    public static String usuLogado;
    public static int codLogado;
    public static Login dadosUsuarioLogado = new Login();

    FrmCadastroFuncionario telaCadFun = new FrmCadastroFuncionario();
    FrmCadastroLogin telaCadLog = new FrmCadastroLogin();
    FrmCadastroLoginSimples telaCadLogSimples = new FrmCadastroLoginSimples();
    FrmCadastroLoginRadio telaCadLogRadio = new FrmCadastroLoginRadio();
    FrmCadastroProduto telaCadPro = new FrmCadastroProduto();

    FrmConsultaFuncionario telaConFun = new FrmConsultaFuncionario();
    FrmConsultaLogin telaConLog = new FrmConsultaLogin();
    FrmConsultaProduto telaConPro = new FrmConsultaProduto();

    FrmControleAcesso telaVerAce = new FrmControleAcesso();
    FrmEstoque telaEstoque;// = new FrmEstoque();

    public FrmTelaPrincipalFrame()
      {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        verificaLogin();

      }

    private void verificaLogin()
      {
        if (dadosUsuarioLogado.getNivel() == 1)
          {
            mniCadLog.setEnabled(false);
            mniConLog.setEnabled(false);
            mniAcesso.setEnabled(false);
            mniCLR.setEnabled(false);
            mniCLS.setEnabled(false);
          }
        else if (dadosUsuarioLogado.getNivel() == 2)
          {
            mniCadFun.setEnabled(false);
            mniCadLog.setEnabled(false);
            mniCadPro.setEnabled(false);
            mniCadLog.setEnabled(false);
            mniConLog.setEnabled(false);
            mniAcesso.setEnabled(false);
            mniCLR.setEnabled(false);
            mniCLS.setEnabled(false);
          }
        String n = null;
        switch (dadosUsuarioLogado.getNivel())
          {
            case 0:
                n = "Administrador";
                break;
            case 1:
                n = "Usuário";
                break;
            case 2:
                n = "Convidado";
                break;
          }
        lblUsuLogado.setText("USUÁRIO: " + usuLogado);
        lblUsuCargo.setText("NIVEL DE ACESSO: " + n);
      }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        lblUsuLogado = new javax.swing.JLabel();
        lblUsuCargo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        mniCadFun = new javax.swing.JMenuItem();
        mniConFun = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mniCadPro = new javax.swing.JMenuItem();
        mniConPro = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        mniCadLog = new javax.swing.JMenuItem();
        mniConLog = new javax.swing.JMenuItem();
        mniCLS = new javax.swing.JMenuItem();
        mniCLR = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniAcesso = new javax.swing.JMenuItem();
        mnuEstoque = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblUsuLogado.setText("-");

        lblUsuCargo.setText("-");

        jMenu1.setText("Organização");

        jMenu3.setText("Funcionários");

        mniCadFun.setText("Cadastro");
        mniCadFun.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mniCadFunActionPerformed(evt);
            }
        });
        jMenu3.add(mniCadFun);

        mniConFun.setText("Consulta");
        mniConFun.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mniConFunActionPerformed(evt);
            }
        });
        jMenu3.add(mniConFun);

        jMenu1.add(jMenu3);

        jMenu4.setText("Produtos");

        mniCadPro.setText("Cadastro");
        mniCadPro.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mniCadProActionPerformed(evt);
            }
        });
        jMenu4.add(mniCadPro);

        mniConPro.setText("Consulta");
        mniConPro.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mniConProActionPerformed(evt);
            }
        });
        jMenu4.add(mniConPro);

        jMenu1.add(jMenu4);

        jMenu5.setText("Login");

        mniCadLog.setText("Cadastro");
        mniCadLog.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mniCadLogActionPerformed(evt);
            }
        });
        jMenu5.add(mniCadLog);

        mniConLog.setText("Consulta");
        mniConLog.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mniConLogActionPerformed(evt);
            }
        });
        jMenu5.add(mniConLog);

        mniCLS.setText("Cadastro Simples");
        mniCLS.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mniCLSActionPerformed(evt);
            }
        });
        jMenu5.add(mniCLS);

        mniCLR.setText("Cadastro Radio");
        mniCLR.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mniCLRActionPerformed(evt);
            }
        });
        jMenu5.add(mniCLR);

        jMenu1.add(jMenu5);
        jMenu1.add(jSeparator1);

        mniAcesso.setText("Acesso");
        mniAcesso.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mniAcessoActionPerformed(evt);
            }
        });
        jMenu1.add(mniAcesso);

        jMenuBar1.add(jMenu1);

        mnuEstoque.setText("Estoque");
        mnuEstoque.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                mnuEstoqueMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuEstoque);

        jMenu2.setText("Logout");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(478, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuCargo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuLogado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblUsuLogado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 524, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jMenu2MouseClicked
    {//GEN-HEADEREND:event_jMenu2MouseClicked
        FrmAcessoLogin tela = new FrmAcessoLogin();
        this.dispose();
        tela.setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void mniCadFunActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mniCadFunActionPerformed
    {//GEN-HEADEREND:event_mniCadFunActionPerformed
        telaCadFun.setVisible(true);
    }//GEN-LAST:event_mniCadFunActionPerformed

    private void mniConFunActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mniConFunActionPerformed
    {//GEN-HEADEREND:event_mniConFunActionPerformed
        telaConFun.setVisible(true);
    }//GEN-LAST:event_mniConFunActionPerformed

    private void mniCadProActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mniCadProActionPerformed
    {//GEN-HEADEREND:event_mniCadProActionPerformed
        telaCadPro.setVisible(true);
    }//GEN-LAST:event_mniCadProActionPerformed

    private void mniConProActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mniConProActionPerformed
    {//GEN-HEADEREND:event_mniConProActionPerformed
        telaConPro.setVisible(true);
    }//GEN-LAST:event_mniConProActionPerformed

    private void mniCadLogActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mniCadLogActionPerformed
    {//GEN-HEADEREND:event_mniCadLogActionPerformed
        telaCadLog.setVisible(true);
    }//GEN-LAST:event_mniCadLogActionPerformed

    private void mniConLogActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mniConLogActionPerformed
    {//GEN-HEADEREND:event_mniConLogActionPerformed
        telaConLog.setVisible(true);
    }//GEN-LAST:event_mniConLogActionPerformed

    private void mniAcessoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mniAcessoActionPerformed
    {//GEN-HEADEREND:event_mniAcessoActionPerformed
        telaVerAce.setVisible(true);
    }//GEN-LAST:event_mniAcessoActionPerformed

    private void mnuEstoqueMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_mnuEstoqueMouseClicked
    {//GEN-HEADEREND:event_mnuEstoqueMouseClicked
        telaEstoque = new FrmEstoque();
        telaEstoque.setVisible(true);

    }//GEN-LAST:event_mnuEstoqueMouseClicked

    private void mniCLSActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mniCLSActionPerformed
    {//GEN-HEADEREND:event_mniCLSActionPerformed
        telaCadLogSimples.setVisible(true);
    }//GEN-LAST:event_mniCLSActionPerformed

    private void mniCLRActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mniCLRActionPerformed
    {//GEN-HEADEREND:event_mniCLRActionPerformed
        telaCadLogRadio.setVisible(true);
    }//GEN-LAST:event_mniCLRActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblUsuCargo;
    private javax.swing.JLabel lblUsuLogado;
    private javax.swing.JMenuItem mniAcesso;
    private javax.swing.JMenuItem mniCLR;
    private javax.swing.JMenuItem mniCLS;
    private javax.swing.JMenuItem mniCadFun;
    private javax.swing.JMenuItem mniCadLog;
    private javax.swing.JMenuItem mniCadPro;
    private javax.swing.JMenuItem mniConFun;
    private javax.swing.JMenuItem mniConLog;
    private javax.swing.JMenuItem mniConPro;
    private javax.swing.JMenu mnuEstoque;
    // End of variables declaration//GEN-END:variables
}
