package banco;

import dados.Funcionario;
import dados.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class FuncionariosGer
{

    Conecta objConecta = new Conecta();
    PreparedStatement stmt;

    //novo - criar - Antes criar a classe TabCad para utilizar esta classe!
    public ArrayList<Funcionario> listaDados = new ArrayList<>();

    //MÉTODO PARA CADASTRAR PESSOAS 
    //Não alterou nada
    public int cadastraFuncionario(Funcionario crudFuncionario)
      {
        int linha = 0;
        objConecta.conectandoBanco();
        try
          {
            String sql = "insert into tbfuncionario (nome, cargo, telefone) values (?,?,?)";
            stmt = objConecta.conn.prepareStatement(sql);
            stmt.setString(1, crudFuncionario.getNome());
            stmt.setString(2, crudFuncionario.getCargo());
            stmt.setString(3, crudFuncionario.getTelefone());
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
    public int alterarFuncionario(Funcionario crudFuncionario)
      {
        int res = 0;
        objConecta.conectandoBanco();
        String sql = "update tbfuncionario set nome=?, cargo=?, telefone = ?  where codigo=?";
        try
          {
            stmt = objConecta.conn.prepareStatement(sql);

            stmt.setString(1, crudFuncionario.getNome());
            stmt.setString(2, crudFuncionario.getCargo());
            stmt.setString(3, crudFuncionario.getTelefone());
            stmt.setInt(4, crudFuncionario.getCodigo());

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
    public int excluirFuncionario(Funcionario crudFuncionario)
      {
        int res = 0;
        objConecta.conectandoBanco();
        String sql = "delete from tbfuncionario where codigo = ?";

        try
          {
            stmt = objConecta.conn.prepareStatement(sql);
            stmt.setInt(1, crudFuncionario.getCodigo());

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
        Funcionario cad;
        listaDados.clear();
        try
          {
            while (rs.next())
              {
                cad = new Funcionario();
                cad.setCodigo(rs.getInt("codigo"));
                cad.setNome(rs.getString("nome"));
                cad.setCargo(rs.getString("cargo"));
                cad.setTelefone(rs.getString("telefone"));
                listaDados.add(cad);

              }
          }
        catch (SQLException ex)
          {
            System.out.println(ex.getMessage() + "\nErro ao gerar Lista");
          }
      }

    //Ocorreram alterações
    public boolean consultaBD(Funcionario crudFuncionario, int opc)
      {
        boolean encontrado = false;
        objConecta.conectandoBanco();
        String sql;
        try
          {
            switch (opc)
              {
                case 1:
                    sql = "Select * from tbfuncionario where nome = ?";
                    stmt = objConecta.conn.prepareStatement(sql);
                    stmt.setString(1, crudFuncionario.getNome());
                    break;
                case 2:
                    //pesquisa no banco de dados ordenando os valores por ordem
                    sql = "Select * from tbfuncionario order by codigo";
                    stmt = objConecta.conn.prepareStatement(sql);
                    break;
                case 3:
                    sql = "Select * from tbfuncionario where cargo = ?";
                    stmt = objConecta.conn.prepareStatement(sql);
                    stmt.setString(1, crudFuncionario.getCargo());
                    break;
                case 4:
                    sql = "Select * from tbfuncionario where nome like ? order by nome";
                    stmt = objConecta.conn.prepareStatement(sql);
                    stmt.setString(1, "%" + crudFuncionario.getNome() + "%");
                    break;
                case 5:
                    sql = "Select * from tbfuncionario where codigo = ? ";
                    stmt = objConecta.conn.prepareStatement(sql);
                    stmt.setInt(1, crudFuncionario.getCodigo());
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
