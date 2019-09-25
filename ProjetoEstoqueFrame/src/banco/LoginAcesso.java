package banco;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import dados.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import telasFrame.FrmAcessoLogin;
import telasFrame.FrmTelaPrincipalFrame;

public class LoginAcesso
{

    Conecta objConecta = new Conecta();

    PreparedStatement stmt;
    PreparedStatement stmtDois;

    private Login dadosLogin = new Login();
    boolean correto = false;
    public String nomeFuncionario;
    ResultSet rs = null;
    public static int nivelAcesso;

    public void buscaNomeUsuario()
      {
        objConecta.conectandoBanco();
        String sql = "select * from tbfuncionario where codigo = ?";
        correto = false;
        try
          {
            stmtDois = objConecta.conn.prepareStatement(sql);
            stmtDois.setString(1, String.valueOf(getDadosLogin().getCodFuncionario()));
            rs = stmtDois.executeQuery();
            while (rs.next())
              {
                nomeFuncionario = rs.getString("nome");
              }
            rs.close();
            stmtDois.close();
          }
        catch (SQLException ex)
          {
            JOptionPane.showMessageDialog(null, "Erro \n" + ex.getMessage());
          }
        objConecta.desconecta();
      }

    public void verificaSenhaBanco(Login log)
      {
        objConecta.conectandoBanco();
        String sql = "select * from tblogin where usuario = ? and senha = ?";
        correto = false;
        try
          {
            stmt = objConecta.conn.prepareStatement(sql);
            stmt.setString(1, log.getUsuario());
            stmt.setString(2, log.getSenha());
            rs = stmt.executeQuery();
            while (rs.next())
              {
                dadosLogin.setCodFuncionario(rs.getInt("codfun"));
                dadosLogin.setUsuario(rs.getString("usuario"));
                dadosLogin.setSenha(rs.getString("senha"));
                dadosLogin.setAtivo(rs.getBoolean("ativo"));
                dadosLogin.setNivel(Integer.parseInt(rs.getString("nivel")));
              
              }
            correto = true;
            rs.close();
            stmt.close();
            objConecta.desconecta();
          }
        catch (SQLException ex)
          {
            System.out.println("Erro ao executar o Login " + ex.getMessage());
          }
      }

    public int acessar()
      {
        int info;
        if (correto == true)
          {
            buscaNomeUsuario();
            //usuario não ativo
            if (getDadosLogin().isAtivo() == false)
              {
                info = 1;
              }
            else
              {
                //usuario ativo
                info = 2;
                FrmTelaPrincipalFrame.dadosUsuarioLogado.setNivel(dadosLogin.getNivel());
                FrmTelaPrincipalFrame.usuLogado = nomeFuncionario;
                  FrmTelaPrincipalFrame.codLogado = dadosLogin.getCodFuncionario();
              }
            //usuario ou senha incorreta
          }
        else
          {
            info = 3;
          }
        return info;
      }

    /**
     * @return the dadosLogin
     */
    public Login getDadosLogin()
      {
        return dadosLogin;
      }

    /**
     * @param dadosLogin the dadosLogin to set
     */
    public void setDadosLogin(Login dadosLogin)
      {
        this.dadosLogin = dadosLogin;
      }
}
