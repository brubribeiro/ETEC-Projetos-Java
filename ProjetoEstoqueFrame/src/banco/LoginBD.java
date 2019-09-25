/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import dados.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gordramos
 */
public class LoginBD {

    Conecta objConecta = new Conecta();
    PreparedStatement stmt;
    private ArrayList<Login> listaLogin = new ArrayList<>();

    public int cadastra(Login cadLogin, String operacao)
    {
        objConecta.conectandoBanco();
        int linha = 0;
        if (operacao.equals("cadastrar"))
        {
            try
            {
                String sql = "insert into tblogin (usuario, senha, nivel, ativo) values (?,?,?,?)";

                stmt = objConecta.conn.prepareStatement(sql);

                stmt.setString(1, cadLogin.getUsuario());
                stmt.setString(2, cadLogin.getSenha());
                stmt.setInt(3, cadLogin.getNivel());
                stmt.setBoolean(4, cadLogin.isAtivo());

                stmt.execute();

                stmt.close();
                linha = 1;
            }
            catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        else
        {
            int escolha = JOptionPane.showConfirmDialog(null, "Deseja realmente"
                    + "editar os dados?", "Editar", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (escolha == 0)
            {
                String sql = "update tblogin set usuario=?, senha=?, nivel=?, ativo = ?  where codigo=?";
                try
                {
                    stmt = objConecta.conn.prepareStatement(sql);

                    stmt.setString(1, cadLogin.getUsuario());
                    stmt.setString(2, cadLogin.getSenha());
                    stmt.setInt(3, cadLogin.getNivel());
                    stmt.setBoolean(4, cadLogin.isAtivo());
                    stmt.setInt(5, cadLogin.getCodigo());

                    stmt.execute();
                    stmt.close();

                    linha = 2;
                }
                catch (SQLException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            else
            {

                linha = 3;
            }
        }
        objConecta.desconecta();
        return linha;
    }

    public ArrayList<Login> geraLista(ResultSet rs)
    {
        getListaLogin().clear();
        try
        {
            while (rs.next())
            {
                Login log = new Login();
                log.setCodigo(rs.getInt("codigo"));
                log.setUsuario(rs.getString("usuario"));
                log.setSenha(rs.getString("senha"));
                log.setNivel(rs.getInt("nivel"));
                log.setAtivo(rs.getBoolean("ativo"));
                listaLogin.add(log);
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage()
                    + "\nErro ao gerar Lista");
        }
        return getListaLogin();
    }

    public void executaConsulta(String sql)
    {
        objConecta.conectandoBanco();
        try
        {

            objConecta.stm = objConecta.conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            objConecta.rs = objConecta.stm.executeQuery(sql);

            geraLista(objConecta.rs);

        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null,
                    "Erro ao executar o comando executaSql -  SQL!\n"
                    + ex.getMessage());
        }
        objConecta.desconecta();
    }

    public int excluir(int codigo)
    {
        objConecta.conectandoBanco();

        String sql = "delete from tblogin where codigo = ?";
        int resul = 0;// indica erro na exclusão
        try
        {

            stmt = objConecta.conn.prepareStatement(sql);
            stmt.setInt(1, codigo);

            stmt.execute();
            stmt.close();

            resul = 1; // indicação de exclusão correta

        }
        catch (SQLException ex)
        {

            System.out.println("Erro ao excluir!\n Erro:" + ex.getMessage());
            System.out.println(ex.getStackTrace());

        }
        objConecta.desconecta();
        return resul;
    }

    public ArrayList<Login> getListaLogin()
    {
        return listaLogin;
    }

    public void setListaLogin(ArrayList<Login> listaLogin)
    {
        this.listaLogin = listaLogin;
    }

}
