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
public class Disciplina {

    private int codigoDisciplina;
    private String titulo;
    private String creditos;

    /**
     *
     * @param codigoDisciplina
     * @param nomeDisciplina
     * @param creditos
     */
    public Disciplina(int codigoDisciplina, String nomeDisciplina, String creditos) {
        this.codigoDisciplina = codigoDisciplina;
        this.titulo = nomeDisciplina;
        this.creditos = creditos;
    }

    public int getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(int codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

}
