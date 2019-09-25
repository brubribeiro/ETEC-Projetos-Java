package dados;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Gordramos
 */
public class ManipulaDatas {

    private java.sql.Date dataJDBC;
    private java.sql.Time horaJDBC;

    public void dataSql() {
        //cria um objeto date para buscar a data e hora do sistema
        Date data = new Date();
        //conversor de data do sistema em dia
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        //conversor de data do sistema em hora
        SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");
        //transformando a data e hora em string
        String dia = formatoData.format(data);
        String hora = formatoHora.format(data);
        // objeto que vai receber a data no formato esperado
        Date dataUtil = new Date();
        Time horaUtil = Time.valueOf(hora);

        //trecho que realiza a conversão
        try {
            dataUtil = formatoData.parse(dia);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        setDataJDBC(new java.sql.Date(dataUtil.getTime()));
        setHoraJDBC(horaUtil);
    }

    /**
     * @return the dataJDBC
     */
    public java.sql.Date getDataJDBC() {
        return dataJDBC;
    }

    /**
     * @param dataJDBC the dataJDBC to set
     */
    public void setDataJDBC(java.sql.Date dataJDBC) {
        this.dataJDBC = dataJDBC;
    }

    /**
     * @return the horaJDBC
     */
    public java.sql.Time getHoraJDBC() {
        return horaJDBC;
    }

    /**
     * @param horaJDBC the horaJDBC to set
     */
    public void setHoraJDBC(java.sql.Time horaJDBC) {
        this.horaJDBC = horaJDBC;
    }

}
