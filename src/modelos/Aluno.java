/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Taffrel Xavier <taffarel_deus@hotmail.com>
 */
public class Aluno {

    private String nomeALuno;
    private int codigoAluno;

    /**
     * 
     * @param nomeALuno
     * @param codigoAluno 
     */
    public Aluno(String nomeALuno, int codigoAluno) {
        this.nomeALuno = nomeALuno;
        this.codigoAluno = codigoAluno;
    }

    public String getNomeALuno() {
        return nomeALuno;
    }

    public void setNomeALuno(String nomeALuno) {
        this.nomeALuno = nomeALuno;
    }

    public int getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(int codigoAluno) {
        this.codigoAluno = codigoAluno;
    }
    
    

}
