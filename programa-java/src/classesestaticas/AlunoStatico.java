/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesestaticas;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 * @author Ramon Deyvid <ramon.dayvid08@gmail.com>
 */
public class AlunoStatico {

    private static int codigoAluno;
    private static String nome;
    private static String dataDeNascimento;
    private static String CPF;
    private static String email;
    private static String telefone;
    private static String tipoDeAcao = "inclusao";

    public static int getCodigoAluno() {
        return codigoAluno;
    }

    public static void setCodigoAluno(int aCodigoAluno) {
        codigoAluno = aCodigoAluno;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String aNome) {
        nome = aNome;
    }

    public static String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public static void setDataDeNascimento(String aDataDeNascimento) {
        dataDeNascimento = aDataDeNascimento;
    }

    public static String getCPF() {
        return CPF;
    }

    public static void setCPF(String aCPF) {
        CPF = aCPF;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String aEmail) {
        email = aEmail;
    }

    public static String getTelefone() {
        return telefone;
    }

    public static void setTelefone(String aTelefone) {
        telefone = aTelefone;
    }

    public static String getTipoDeAcao() {
        return tipoDeAcao;
    }

    public static void setTipoDeAcao(String aTipoDeAcao) {
        tipoDeAcao = aTipoDeAcao;
    }

}
