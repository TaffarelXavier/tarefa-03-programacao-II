/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import servicos.Conexao;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 */
public class MatriculaController {

    /**
     *
     * @param alunoFkId
     * @param turmaPkId
     * @param media
     * @param cursoFK_ID
     * @param dataMatricula
     * @param resultado
     * @return
     */
    public static int incluir(int alunoFkId, int turmaPkId,
            double media, int cursoFK_ID, String dataMatricula, String resultado) {
        try {

            String sql = "INSERT INTO `matricula` (`codaluno`, `codturma`, `curso_fk_id`, `media`, `data_matricula`, `resultado`) VALUES (?,?,?,?,?,?);";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, alunoFkId);
            preparedStatement.setInt(2, turmaPkId);
            preparedStatement.setInt(3, cursoFK_ID);
            preparedStatement.setDouble(4, media);
            preparedStatement.setString(5, dataMatricula);
            preparedStatement.setString(6, resultado);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("A criação do usuário falhou!");
            }

            ResultSet rs = preparedStatement.getGeneratedKeys();
            
            int generatedKey = 0;

            if (rs.next()) {
                generatedKey = rs.getInt(1); //Retorna o ID da inserção.
            } else {
                throw new SQLException("A criação do usuário falhou!");
            }

            return generatedKey;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção: erro!", 1);
        }
        return 0;
    }
}
