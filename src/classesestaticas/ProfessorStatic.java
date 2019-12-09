/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesestaticas;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 */
public class ProfessorStatic {

    private static int id;
    private static String nome;
    private static String CPF;
    private static String status;
    private static String nivel;
    private static String tipo;
    
    
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

    public static String getCPF() {
        return CPF;
    }

    public static void setCPF(String aCPF) {
        CPF = aCPF;
    }

    public static String getNivel() {
        return nivel;
    }

    public static void setNivel(String aNivel) {
        nivel = aNivel;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String aStatus) {
        status = aStatus;
    }

    public static String getTipo() {
        return tipo;
    }

    public static void setTipo(String aTipo) {
        tipo = aTipo;
    }

}
