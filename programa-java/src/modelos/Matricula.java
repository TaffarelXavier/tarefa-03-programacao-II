/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Taffaarel Xavier <taffarel_deus@hotmail.com>
 * @author Ramon Deyvid <ramon.dayvid08@gmail.com>
 */
public class Matricula {

    private int codigoALuno;
    private int codigoTurma;
    private double media;
    private String resultado;
    private String dataMatricula;

    public Matricula(int codigoALuno, int codigoTurma, double media, String resultado, String dataMatricula) {
        this.codigoALuno = codigoALuno;
        this.codigoTurma = codigoTurma;
        this.media = media;
        this.resultado = resultado;
        this.dataMatricula = dataMatricula;
    }


    public int getCodigoALuno() {
        return codigoALuno;
    }

    public void setCodigoALuno(int codigoALuno) {
        this.codigoALuno = codigoALuno;
    }

    public int getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(int codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

}
