/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 * @author Ramon Deyvid <ramon.dayvid08@gmail.com>
 */

public class Funcoes {

    /**
     * <p>
     * Retorna o total de registros de uma busca.</p>
     *
     * @param rs ResultSet
     * @return Inteiro
     * @throws SQLException
     */
    public static int getTotalDeRegistros(ResultSet rs) throws SQLException {
        int total;
        rs.last();
        total = rs.getRow();
        rs.beforeFirst();
        return total;
    }
    /**
     * 
     * @return 
     */
    public static String getAtualDataDD_MM_YYYY(){
        String pattern = "dd-MM-yyyy";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        return dateInString;
    }
}
