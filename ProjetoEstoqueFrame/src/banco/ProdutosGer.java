package banco;

import dados.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ProdutosGer
{

    Conecta objConecta = new Conecta();
    PreparedStatement stmt;

    //novo - criar - Antes criar a classe TabCad para utilizar esta classe!
    public ArrayList<Produto> listaDados = new ArrayList<>();

    //MÉTODO PARA CADASTRAR PESSOAS 
    public int cadastraProduto(Produto crud)
      {
        int linha = 0;
        objConecta.conectandoBanco();
        try
          {
            String sql = "insert into tbproduto (nomeproduto, quantidadeproduto, valorproduto,localproduto) values (?,?,?,?)";
            stmt = objConecta.conn.prepareStatement(sql);
            stmt.setString(1, crud.getNomeProduto());
            stmt.setInt(2, crud.getQuantidadeProduto());
            stmt.setFloat(3, crud.getValorProduto());
            stmt.setString(4, crud.getLocalProduto());
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
    public int alterarProduto(Produto crud)
      {
        int res = 0;
        objConecta.conectandoBanco();
        String sql = "update tbproduto set nomeproduto=?, quantidadeproduto=?, valorproduto = ?, localproduto = ?  where codigoproduto=?";
        try
          {
            stmt = objConecta.conn.prepareStatement(sql);

            stmt.setString(1, crud.getNomeProduto());
            stmt.setInt(2, crud.getQuantidadeProduto());
            stmt.setFloat(3, crud.getValorProduto());
            stmt.setString(4, crud.getLocalProduto());
            stmt.setInt(5, crud.getCodigoProduto());

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
    public int excluirProduto(Produto crud)
      {
        int res = 0;
        objConecta.conectandoBanco();
        String sql = "delete from tbproduto where codigoproduto = ?";

        try
          {
            stmt = objConecta.conn.prepareStatement(sql);
            stmt.setInt(1, crud.getCodigoProduto());

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
        Produto cad;
        listaDados.clear();
        try
          {
            while (rs.next())
              {
                cad = new Produto();
                cad.setCodigoProduto(rs.getInt("codigoproduto"));
                cad.setNomeProduto(rs.getString("nomeproduto"));
                cad.setQuantidadeProduto(rs.getInt("quantidadeproduto"));
                cad.setValorProduto(rs.getFloat("valorproduto"));
                cad.setLocalProduto(rs.getString("localproduto"));
                listaDados.add(cad);

              }
          }
        catch (SQLException ex)
          {
            System.out.println(ex.getMessage() + "\nErro ao gerar Lista");
          }
      }

    //Ocorreram alterações
    public boolean consultaBD(Produto crud, int opc)
      {
        boolean encontrado = false;
        objConecta.conectandoBanco();
        String sql;
        try
          {
            switch (opc)
              {
                case 1:
                    sql = "Select * from tbproduto where nomeproduto = ?";
                    stmt = objConecta.conn.prepareStatement(sql);
                    stmt.setString(1, crud.getNomeProduto());
                    break;
                case 2:
                    //pesquisa no banco de dados ordenando os valores por ordem
                    sql = "Select * from tbproduto order by codigoproduto";
                    stmt = objConecta.conn.prepareStatement(sql);
                    break;
                case 3:
                    sql = "Select * from tbproduto where quantidadeproduto = ?";
                    stmt = objConecta.conn.prepareStatement(sql);
                    stmt.setInt(1, crud.getQuantidadeProduto());
                    break;
                case 4:
                    sql = "Select * from tbproduto where nomeproduto like ? order by nomeproduto";
                    stmt = objConecta.conn.prepareStatement(sql);
                    stmt.setString(1, "%" + crud.getNomeProduto() + "%");
                    break;
                case 5:
                    sql = "Select * from tbproduto where codigoproduto = ? ";
                    stmt = objConecta.conn.prepareStatement(sql);
                    stmt.setInt(1, crud.getCodigoProduto());
                    break;
                case 6:
                    sql = "Select * from tbproduto where localproduto = ? ";
                    stmt = objConecta.conn.prepareStatement(sql);
                    stmt.setString(1, crud.getLocalProduto());
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
