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
public class EstaticaCurso {

    private static String nome;
    private static int id;

    public static String getNome() {
        return nome;
    }

    public static void setNome(String aNome) {
        nome = aNome;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int aId) {
        id = aId;
    }

}
