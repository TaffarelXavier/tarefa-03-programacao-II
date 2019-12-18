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
import modelos.Funcionario;
import servicos.Conexao;
import static servicos.Funcoes.getTotalDeRegistros;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 * @author Ramon Deyvid <ramon.dayvid08@gmail.com>
 */
public class FuncionarioController {

    /**
     *
     * @param nome
     * @param cpf
     * @param senha
     * @param nivel
     * @param cargo
     * @param permitiLogin
     * @return
     */
    public static int incluir(String nome, String cpf,
            String senha, String nivel, String cargo, boolean permitiLogin) {
        try {
            String sql = "INSERT INTO funcionarios (func_nome, func_cpf,"
                    + " func_senha, func_nivel, func_cargo, func_permitir_login) VALUES (?,?,?,?,?, ?);";
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, nome.trim());
            preparedStatement.setString(2, cpf);
            preparedStatement.setString(3, senha);
            preparedStatement.setString(4, nivel);
            preparedStatement.setString(5, cargo);
            preparedStatement.setBoolean(6, permitiLogin);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                JOptionPane.showMessageDialog(null, "A criação do funcionário falhou!", "Atenção", 1);
                return -1;
            }

            ResultSet rs = preparedStatement.getGeneratedKeys();

            int generatedKey = 0;

            if (rs.next()) {
                generatedKey = rs.getInt(1); //Retorna o ID da inserção.
            } else {
                JOptionPane.showMessageDialog(null, "A criação do funcionário falhou!", "Atenção", 1);
                return -1;
            }

            return generatedKey;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção: erro!", 1);
        }
        return 0;
    }

    /**
     *
     * @param alunoId
     * @return
     */
    public static int excluir(int alunoId) {
        String sql = "DELETE FROM aluno WHERE codaluno = ?;";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = Conexao.conectar().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, alunoId);
            return preparedStatement.executeUpdate();
        } catch (Exception ex) {
        }
        return 0;
    }

    /**
     *
     * @param nome
     * @param cpf
     * @param senha
     * @param nivel
     * @param cargo
     * @param permitiLogin
     * @param funcionarioId
     * @return
     */
    public static int alterar(String nome, String cpf,
            String senha, String nivel, String cargo, boolean permitiLogin, int funcionarioId) {
        try {
            String sql = "UPDATE funcionarios SET func_nome = ?, func_cpf =?,"
                    + " func_senha = ?, func_nivel =?, func_cargo=?, func_permitir_login = ? WHERE func_id = ?";
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, nome.trim());
            preparedStatement.setString(2, cpf);
            preparedStatement.setString(3, senha);
            preparedStatement.setString(4, nivel);
            preparedStatement.setString(5, cargo);
            preparedStatement.setBoolean(6, permitiLogin);
            preparedStatement.setInt(7, funcionarioId);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção: erro!", 1);
        }
        return 0;
    }

    public static Funcionario[] listarTodos() throws Exception {

        PreparedStatement stm;

        try {

            stm = Conexao.conectar().prepareStatement("SELECT * FROM `funcionarios`");

            ResultSet rs = stm.executeQuery();

            if (!rs.next()) {
                System.out.println("Nenhum registro encontrado.");
            } else {

                Funcionario[] funcionarios = new Funcionario[getTotalDeRegistros(rs)];

                int i = 0;

                while (rs.next()) {
                    //String nomeALuno, int codigoAluno, String , String , String , String 
                    funcionarios[i] = new Funcionario(
                            rs.getInt("func_id"),
                            rs.getString("func_nome"),
                            rs.getString("func_cpf"),
                            rs.getString("func_senha"),
                            rs.getString("func_nivel"),
                            rs.getString("func_cargo"),
                            rs.getBoolean("func_permitir_login")
                    );
                    ++i;
                }

                return funcionarios;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    public static Object login(String cpf, String senha) throws Exception {

        PreparedStatement stm;

        try {
            //Professor Ancelmo, no futuro, criptografaremos a senha, por enquanto, somente para demonstração ela está em texto puro.
            stm = Conexao.conectar().prepareStatement("SELECT * FROM `funcionarios` WHERE func_cpf = ? && func_senha = ?;");
            stm.setString(1, cpf);
            stm.setString(2, senha);
            ResultSet rs = stm.executeQuery();

            if (!rs.next()) {
                System.out.println("a");
                return "404";
            } else {

                if (!rs.getBoolean("func_permitir_login")) {
                    System.out.println("C");
                    return "403";
                } else {

                    Funcionario funcionario = new Funcionario(rs.getInt("func_id"),
                            rs.getString("func_nome"), rs.getString("func_cpf"),
                            rs.getString("func_senha"), rs.getString("func_nivel"),
                            rs.getString("func_cargo"), rs.getBoolean("func_permitir_login"));
                    return funcionario;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

//    public static Aluno[] filtrarDadosAluno(String filtro, String filtroTipo) throws Exception {
//
//        PreparedStatement preparedStatement = null;
//
//        try {
//            String sql;
//
//            ResultSet rs = null;
//
//            if (filtroTipo.toLowerCase().equals("nome".toLowerCase())) {
//                sql = "SELECT * FROM aluno WHERE nomealuno LIKE ?;";
//                preparedStatement = Conexao.conectar().prepareStatement(sql);
//                preparedStatement.setString(1, "%" + filtro + "%");
//            } else if (filtroTipo.toLowerCase().equals("cpf".toLowerCase())) {
//                sql = "SELECT * FROM aluno WHERE cpf = ?;";
//                preparedStatement = Conexao.conectar().prepareStatement(sql);
//                preparedStatement.setString(1, filtro);
//
//            }
//            rs = preparedStatement.executeQuery();
//
//            if (!rs.next()) {
//                System.out.println("Nenhum registro encontrado para alunos.");
//            } else {
//
//                Aluno[] alunos = new Aluno[getTotalDeRegistros(rs)];
//
//                int i = 0;
//
//                while (rs.next()) {
//                    //String nomeALuno, int codigoAluno, String , String , String , String 
//                    alunos[i] = new Aluno(rs.getString("nomealuno"),
//                            rs.getInt("codaluno"),
//                            rs.getString("data_nascimento"),
//                            rs.getString("cpf"),
//                            rs.getString("email"),
//                            rs.getString("telefone")
//                    );
//                    ++i;
//                }
//                return alunos;
//            }
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
//        return null;
//    }
    public static Funcionario getDadosPorIdFuncionaio(int funcionarioId) {

        try {
            PreparedStatement preparedStatement;

            preparedStatement = Conexao.conectar().prepareStatement("SELECT * FROM `funcionarios` WHERE funcionarios.func_id = ?;");

            preparedStatement.setInt(1, funcionarioId);

            ResultSet rs = preparedStatement.executeQuery();

            if (!rs.next()) {
                System.out.println("Nenhum registro encontrado para alunos.");
            } else {

                Funcionario funcionario = new Funcionario(rs.getInt("func_id"),
                        rs.getString("func_nome"), rs.getString("func_cpf"),
                        rs.getString("func_senha"), rs.getString("func_nivel"),
                        rs.getString("func_cargo"), rs.getBoolean("func_permitir_login"));

                return funcionario;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
}
