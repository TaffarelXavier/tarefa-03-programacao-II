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
import modelos.Aluno;
import modelos.AlunoMatricula;
import modelos.Professor;
import servicos.Conexao;
import static servicos.Funcoes.getTotalDeRegistros;

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
     * @param peridoLetivo
     * @param dataMatricula
     * @param resultado
     * @return
     */
    public static int incluir(int alunoFkId, int turmaPkId,
            double media, int cursoFK_ID, int peridoLetivo, String dataMatricula, String resultado) {
        try {

            String sql = "INSERT INTO `matricula` (`codaluno`, `codturma`, `curso_fk_id`, `periodo_letivo`,`media`, `data_matricula`, `resultado`) VALUES (?,?,?,?,?,?,?);";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, alunoFkId);
            preparedStatement.setInt(2, turmaPkId);
            preparedStatement.setInt(3, cursoFK_ID);
            preparedStatement.setInt(4, peridoLetivo);
            preparedStatement.setDouble(5, media);
            preparedStatement.setString(6, dataMatricula);
            preparedStatement.setString(7, resultado);

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

    public static AlunoMatricula[] getMatriculaPorAluno(int alunoFkId) throws Exception {

        PreparedStatement stm;

        try {
//matricula_id, codaluno, nomecurso, data_matricula, periodo_letivo
            stm = Conexao.conectar().prepareStatement("SELECT * FROM `matricula` as t1 JOIN curso AS t2 ON t1.curso_fk_id = t2.codcurso JOIN turma as t3 ON t1.codturma = t3.codturma WHERE codaluno = ?; ");

            stm.setInt(1, alunoFkId);

            ResultSet rs = stm.executeQuery();

            if (!rs.next()) {
                System.out.println("Nenhum registro encontrado.");
            } else {
                AlunoMatricula[] matriculas = new AlunoMatricula[getTotalDeRegistros(rs)];

                int i = 0;

                while (rs.next()) {
                    matriculas[i] = new AlunoMatricula(
                            rs.getInt("matricula_id"),
                            rs.getInt("codaluno"),
                            rs.getString("nomecurso"),
                            rs.getString("data_matricula"),
                            rs.getInt("periodo_letivo")
                    );
                    System.out.println(i);
                    ++i;
                }

                return matriculas;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
}
