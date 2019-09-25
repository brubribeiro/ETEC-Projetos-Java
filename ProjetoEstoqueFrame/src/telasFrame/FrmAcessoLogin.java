

package telasFrame;

import banco.LoginAcesso;
import dados.Login;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;


public class FrmAcessoLogin extends javax.swing.JFrame
{

    LoginAcesso acessaLoginBD = new LoginAcesso();
    Login dadosLogin = new Login();
    static int nivel;
    FrmTelaPrincipalFrame telaPrincipal;
    int contaTentativas = 3;

    public FrmAcessoLogin()
      {
        initComponents();
      }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnAcessar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jpsSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario");

        jLabel2.setText("Senha");

        btnAcessar.setText("Acessar");
        btnAcessar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAcessarActionPerformed(evt);
            }
        });
        btnAcessar.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                btnAcessarKeyPressed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
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
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpsSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAcessar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jpsSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcessar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public String geraHash(String senha){
        
        String sha1 = senha;
        
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(senha.getBytes("utf-8"));
            sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        }
        catch(UnsupportedEncodingException | NoSuchAlgorithmException e){
            e.getMessage();
        }
        return sha1;
    }
    
    
    public void analisaSenha()
      {
        acessaLoginBD.verificaSenhaBanco(dadosLogin);

        int valida = acessaLoginBD.acessar();

        switch (valida)
          {
            case 1:
              {
                //usuario correto e Ativo igual a False
                JOptionPane.showMessageDialog(null,
                        " Usuário não está ativo no momento\n"
                        + " Favor procurar o administrador do sistema ");
                contaTentativas--;
                verificaTentativas();
                break;
              }
            case 2:
              {
                //Senha Correta
              
                telaPrincipal = new FrmTelaPrincipalFrame();
                telaPrincipal.setVisible(true);
                this.dispose();
                break;
              }
            case 3:
              {
                ///senha Incorreta
                JOptionPane.showMessageDialog(null,
                        "Usuario ou Senha Invalidos");
                contaTentativas--;
                verificaTentativas();
                break;
              }
          }
      }

    public void verificaTentativas()
      {
        if (contaTentativas == 0)
          {
            JOptionPane.showMessageDialog(null,
                    "Número máximo de tentativas \n Finalizando a aplicação");
            System.exit(0);
          }
      }

    public void logar()
      {
        dadosLogin.setUsuario(txtUsuario.getText());
        
        dadosLogin.setSenha(String.valueOf(jpsSenha.getPassword()));        
        analisaSenha();
      }

    private void btnAcessarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAcessarActionPerformed
    {//GEN-HEADEREND:event_btnAcessarActionPerformed
        logar();
    }//GEN-LAST:event_btnAcessarActionPerformed

    private void btnAcessarKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_btnAcessarKeyPressed
    {//GEN-HEADEREND:event_btnAcessarKeyPressed
        logar();
    }//GEN-LAST:event_btnAcessarKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCancelarActionPerformed
    {//GEN-HEADEREND:event_btnCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcessar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jpsSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
