package banco;

import dados.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;


public class LoginGer
{

    Conecta objConecta = new Conecta();
    PreparedStatement stmt;
    //novos usados para tela de login
    ResultSet rs = null;
    public static boolean correto;
    Login dadosLogin = new Login();

    //novo - criar - Antes criar a classe TabCad para utilizar esta classe!
    public ArrayList<Login> listaDados = new ArrayList<>();

    //MÉTODO PARA CADASTRAR PESSOAS 
    //Não alterou nada
    public int cadastraLogin(Login crudLogin)
      {
        int linha = 0;
        objConecta.conectandoBanco();
        try
          {
            String sql = "insert into tblogin (usuario, senha, ativo, nivel, codfun) values (?,?,?,?,?)";
            stmt = objConecta.conn.prepareStatement(sql);
            stmt.setString(1, crudLogin.getUsuario());
            stmt.setString(2, crudLogin.getSenha());
            stmt.setBoolean(3, crudLogin.isAtivo());
            stmt.setInt(4, crudLogin.getNivel());
            stmt.setInt(5, crudLogin.getCodFuncionario());
            stmt.execute();
            stmt.close();
            linha = 1;
          }
        catch (SQLException ex)
          {
            System.out.println(ex.getMessage());
          }
        objConecta.desconecta();
        return linha;
      }

    //  Ocorreram alterações
    public int alterarLogin(Login crudLogin)
      {
        int res = 0;
        objConecta.conectandoBanco();
        String sql = "update tblogin set usuario=?, senha=?, ativo = ? , nivel = ? where codigo=?";
        try
          {
            stmt = objConecta.conn.prepareStatement(sql);

            stmt.setString(1, crudLogin.getUsuario());
            stmt.setString(2, crudLogin.getSenha());
            stmt.setBoolean(3, crudLogin.isAtivo());
            stmt.setInt(4, crudLogin.getNivel());
            stmt.setInt(5, crudLogin.getCodigo());

            res = stmt.executeUpdate();
            stmt.close();
          }
        catch (SQLException ex)
          {
            System.out.println(ex.getMessage());
          }

        objConecta.desconecta();
        return res;
      }

    //não alterado
    public int excluirLogin(Login crudLogin)
      {
        int res = 0;
        objConecta.conectandoBanco();
        String sql = "delete from tblogin where codigo = ?";

        try
          {
            stmt = objConecta.conn.prepareStatement(sql);
            stmt.setInt(1, crudLogin.getCodigo());

            res = stmt.executeUpdate();
            stmt.close();

          }
        catch (SQLException ex)
          {
            System.out.println("Erro ao excluir!\n Erro:"
                    + ex.getMessage()
                    + Arrays.toString(ex.getStackTrace()));

          }
        objConecta.desconecta();
        return res;
      }

    //novo metodo - criar
    public void geraLista(ResultSet rs)
      {
        Login cad;
        listaDados.clear();
        try
          {
            while (rs.next())
              {
                cad = new Login();
                cad.setCodigo(rs.getInt("codigo"));
                cad.setUsuario(rs.getString("usuario"));
                cad.setSenha(rs.getString("senha"));
                cad.setAtivo((rs.getBoolean("ativo")));
                cad.setNivel(rs.getInt("nivel"));
                cad.setCodFuncionario((rs.getInt("codfun")));
                listaDados.add(cad);
              }
          }
        catch (SQLException ex)
          {
            System.out.println(ex.getMessage() + "\nErro ao gerar Lista");
          }
      }

    //Ocorreram alterações
    public boolean consultaBD(Login crudLogin, int opc)
      {
        boolean encontrado = false;
        objConecta.conectandoBanco();
        String sql;
        try
          {
            switch (opc)
              {
                case 1:
                    sql = "Select * from tblogin where usuario = ?";
                    stmt = objConecta.conn.prepareStatement(sql);
                    stmt.setString(1, crudLogin.getUsuario());
                    break;
                case 2:
                    //pesquisa no banco de dados ordenando os valores por ordem
                    sql = "Select * from tblogin order by codigo";
                    stmt = objConecta.conn.prepareStatement(sql);
                    break;
                case 3:
                    sql = "Select * from tblogin where nivel = ?";
                    stmt = objConecta.conn.prepareStatement(sql);
                    stmt.setInt(1, crudLogin.getNivel());
                    break;
                case 4:
                    sql = "Select * from tblogin where ativo = ?";
                    stmt = objConecta.conn.prepareStatement(sql);
                    stmt.setBoolean(1, crudLogin.isAtivo());
                    break;

              }
            objConecta.rs = stmt.executeQuery();
            geraLista(objConecta.rs);
            stmt.close();
            encontrado = true;
          }
        catch (SQLException ex)
          {
            System.out.println("Erro ao executar o comando executaSql -  SQL!\n"
                    + ex.getMessage());
          }
        objConecta.desconecta();
        return encontrado;
      }

   
}
