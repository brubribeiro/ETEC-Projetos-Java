package tabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rodrigo
 */
public class BaseTabelas extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = null;
    
    public BaseTabelas(ArrayList lin, String[] col) {
        setLinhas(lin);
        setColunas(col);
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList dados) {
        linhas = dados;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] nomes) {
        colunas = nomes;
    }

    //métodos para  contar as colunas
    public int getColumnCount() {
        return colunas.length;
    }

    // contar as linhas
    public int getRowCount() {
        // conta o (
        return linhas.size();
    }

    //métodos para saber os nomes das colunas
    public String getColumnName(int numCol) {
        return colunas[numCol];
    }

    // método para montar as tabelas
    public Object getValueAt(int numLin, int numCol) {
        Object[] linha = (Object[]) getLinhas().get(numLin);
        return linha[numCol];
    }


}
