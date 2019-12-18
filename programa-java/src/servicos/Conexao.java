package servicos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Faz as conexões com o banco de dados.
 *  Mude a string de conexão conforme sua arquitetura do seu computador.
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 * @author Ramon Deyvid <ramon.dayvid08@gmail.com>
 */
public class Conexao {

    private static Connection conn;

    /**
     * <p style="font:16px arial">Strings de conexões</p>
     */
    private static final String[][] DSNS = {
        { /*Índice:0*/
            "com.mysql.jdbc.Driver",
            "jdbc:mysql://localhost:3306/sge_db",
            "root",
            "chkdsk"
        },
        { /*Índice:1*/
            "org.postgresql.Driver",
            "jdbc:postgresql://localhost:5432/banco_ifto",
            "postgres",
            "chkdsk"
        }
    };

    /**
     * <h2>Abre a conexão com o banco.</h2>
     *
     * @return
     * @throws Exception
     */
    public static Connection conectar() throws Exception {
        try {
            int index = 0; //Com 0, conecta ao banco Mysql; com 1, conecta ao banco postgre.
            // Registrar o driver
            Class.forName(DSNS[index][0]).newInstance();
            // Capturar a conexão
            conn = DriverManager.getConnection(DSNS[index][1], DSNS[index][2], DSNS[index][3]);
            // Retorna a conexao aberta
            return conn;
        } catch (SQLException e) {
            switch (e.getSQLState()) {
                case "28000":
                    JOptionPane.showMessageDialog(null, "A senha do banco está incorreta.\n" + e.getMessage(), "Atenção", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                case "08S01":
                    JOptionPane.showMessageDialog(null, "O servidor de banco de dados SQL não está ligado.\n" + e.getMessage().replaceAll("\\.", "\n"),
                            "Atenção", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Houve um erro.\n" + e.getMessage(), "Atenção", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
        return null;
    }

    /**
     * Fecha a Conexão
     *
     * @return
     * @throws Exception
     */
    public static boolean fecharConexao() throws Exception {

        try {

            conectar().close();
            return true;

        } catch (SQLException e) {

            return false;

        }

    }
}
