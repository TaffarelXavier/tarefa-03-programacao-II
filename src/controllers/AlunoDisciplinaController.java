/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import servicos.Conexao;

/**
 *
 * @author Taffrel Xavier <taffarel_deus@hotmail.com>
 */
public class AlunoDisciplinaController {

    /**
     * 
     * @param alunoFkId
     * @param disciplinaFkId
     * @param matriculaFkId
     * @return 
     */
    public static int incluir(int alunoFkId, int disciplinaFkId, int matriculaFkId) {
        try {
            
            String sql = "INSERT INTO aluno_disciplina (aluno_fk_id, disciplina_fk_id, matricula_fk_id) VALUES (?,?,?);";
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, alunoFkId);
            preparedStatement.setInt(2, disciplinaFkId);
            preparedStatement.setInt(3, matriculaFkId);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção: erro!", 1);
        }
        return 0;
    }

}
