/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Conecta
{

    //RESPONSÁVEL POR PREPARAR E REALIZAR
    //PESQUISAS E INSERÇÕES NO BANCO DE DADOS
    public Statement stm;

    //RESPONSÁVEL POR ARMAZENAR O RESULTADO DE 
    //UMA PESQUISA PASSADA PARA O STATEMENT
    public ResultSet rs;

    //REALIZA A CONEXÃO COM O BANCO DE DADOS
    public Connection conn = null;

    String connectionUrl = "jdbc:mysql://localhost:3306/bdestoque";
    String usuario = "root";
    String senha = "";

    public Conecta()
      {

      }

    //MÉTODO DE CONEXÃO COM O BANCO DE DADOS

    public Connection conectandoBanco()
      {

        try
          {
            conn = DriverManager.getConnection(connectionUrl, usuario, senha);
          }
        catch (SQLException ex)
          {
            JOptionPane.showMessageDialog(null, "Erro de conexão! \n"
                    + ex.getMessage()
                    + Arrays.toString(ex.getStackTrace()));
          }
        return conn;
      }

    public void desconecta()
      {
        try
          {
            conn.close();
          }
        catch (SQLException ex)
          {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão! "
                    + "/\n erro:"
                    + ex.getMessage());
          }
      }

}
