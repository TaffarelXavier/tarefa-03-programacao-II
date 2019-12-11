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
public class AlunoMatricula{

    private int matricula_id;
    private int codaluno;
    private String nomecurso;
    private String data_matricula;
    private int periodo_letivo;

    public AlunoMatricula(int matricula_id, int codaluno, String nomecurso, String data_matricula, int periodo_letivo) {
        this.matricula_id = matricula_id;
        this.codaluno = codaluno;
        this.nomecurso = nomecurso;
        this.data_matricula = data_matricula;
        this.periodo_letivo = periodo_letivo;
    }

    public int getMatricula_id() {
        return matricula_id;
    }

    public void setMatricula_id(int matricula_id) {
        this.matricula_id = matricula_id;
    }

    public int getCodaluno() {
        return codaluno;
    }

    public void setCodaluno(int codaluno) {
        this.codaluno = codaluno;
    }

    public String getNomecurso() {
        return nomecurso;
    }

    public void setNomecurso(String nomecurso) {
        this.nomecurso = nomecurso;
    }

    public String getData_matricula() {
        return data_matricula;
    }

    public void setData_matricula(String data_matricula) {
        this.data_matricula = data_matricula;
    }

    public int getPeriodo_letivo() {
        return periodo_letivo;
    }

    public void setPeriodo_letivo(int periodo_letivo) {
        this.periodo_letivo = periodo_letivo;
    }
    
    

}
