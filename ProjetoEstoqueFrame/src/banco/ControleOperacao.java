
package banco;

import dados.Acesso;
import dados.ManipulaDatas;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import telasFrame.FrmTelaPrincipalFrame;

public class ControleOperacao {

    Conecta objConecta = new Conecta();
    Acesso controlaAcao = new Acesso();
    ManipulaDatas gerDatas = new ManipulaDatas();
    Acesso cadAcesso = new Acesso();

    PreparedStatement stmt;

    //novo - criar - Antes criar a classe TabCad para utilizar esta classe!
    public ArrayList<Acesso> listaDados = new ArrayList<>();

    public void cadastraAcao(String acao)
    {
        cadAcesso.setCodigoUsuario(FrmTelaPrincipalFrame.codLogado);
        gerDatas.dataSql();
        cadAcesso.setData(gerDatas.getDataJDBC());
        cadAcesso.setHora(gerDatas.getHoraJDBC());
        cadAcesso.setAcao(acao);
        registraAcao(cadAcesso);

    }

    //MÉTODO PARA CADASTRAR PESSOAS 
    //Não alterou nada
    public int registraAcao(Acesso controleUsuario)
    {
        int linha = 0;
        objConecta.conectandoBanco();
        try
        {
            String sql = "insert into tbacesso (codigousuario, data, hora,acao) values (?,?,?,?)";
            stmt = objConecta.conn.prepareStatement(sql);
            stmt.setInt(1, controleUsuario.getCodigoUsuario());
            stmt.setDate(2, (Date) controleUsuario.getData());
            stmt.setTime(3, controleUsuario.getHora());
            stmt.setString(4, controleUsuario.getAcao());

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

    //novo metodo - criar
    public void geraLista(ResultSet rs)
    {
        Acesso cad;
        listaDados.clear();
        try
        {
            while (rs.next())
            {
                cad = new Acesso();
                cad.setCodigoUsuario(rs.getInt("codigousuario"));
                cad.setData(rs.getDate("data"));
                cad.setHora(rs.getTime("hora"));
                cad.setAcao(rs.getString("acao"));

                listaDados.add(cad);
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage()
                    + "\nErro ao gerar Lista");
        }
    }

    //Ocorreram alterações
    public boolean consultaBD(String data, int opc)
    {
        boolean encontrado = false;
        objConecta.conectandoBanco();
        String sql;
        try
        {
            if (opc == 1)
            {
                sql = "Select * from tbacesso where codigousuario = ?";
                stmt = objConecta.conn.prepareStatement(sql);
                stmt.setString(1, data);
            }
            else if (opc == 2)
            {
                sql = "Select * from tbacesso where data like ?";
                stmt = objConecta.conn.prepareStatement(sql);
                stmt.setString(1, data + "%");
            }
            else if (opc == 3)
            {
                sql = "Select * from tbacesso where hora like ?";
                stmt = objConecta.conn.prepareStatement(sql);
                stmt.setString(1, data + "%");
            }
            else if (opc == 4)
            {
                sql = "Select * from tbacesso where acao like ?";
                stmt = objConecta.conn.prepareStatement(sql);
                stmt.setString(1, "%" + data + "%");
            }
            else
            {
                //pesquisa no banco de dados ordenando os valores por ordem
                sql = "Select * from tbacesso";
                stmt = objConecta.conn.prepareStatement(sql);
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

