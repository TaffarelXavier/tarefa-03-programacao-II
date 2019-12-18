/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesestaticas;

import modelos.Funcionario;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 * @author Ramon Deyvid <ramon.dayvid08@gmail.com>
 */
public class FuncionarioStatic {

    private static int id;
    private static String nome;
    private static String cpf;
    private static String senha;
    private static String nivel;
    private static String cargo;
    private static boolean permitirLogin;
    private static Funcionario funcionario;

    public static int getId() {
        return id;
    }

    public static void setId(int aId) {
        id = aId;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String aNome) {
        nome = aNome;
    }

    public static String getCpf() {
        return cpf;
    }

    public static void setCpf(String aCpf) {
        cpf = aCpf;
    }

    public static String getSenha() {
        return senha;
    }

    public static void setSenha(String aSenha) {
        senha = aSenha;
    }

    public static String getNivel() {
        return nivel;
    }

    public static void setNivel(String aNivel) {
        nivel = aNivel;
    }

    public static String getCargo() {
        return cargo;
    }

    public static void setCargo(String aCargo) {
        cargo = aCargo;
    }

    public static boolean isPermitirLogin() {
        return permitirLogin;
    }

    public static void setPermitirLogin(boolean aPermitirLogin) {
        permitirLogin = aPermitirLogin;
    }

    public static Funcionario getFuncionario() {
        return funcionario;
    }

    public static void setFuncionario(Funcionario aFuncionario) {
        funcionario = aFuncionario;
    }

}
