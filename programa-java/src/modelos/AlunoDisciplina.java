/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 * @author Ramon Deyvid <ramon.dayvid08@gmail.com>
 */
public class AlunoDisciplina {

    private int disciplinaId;
    private String tituloDisciplina;

    public AlunoDisciplina(int disciplinaId, String tituloDisciplina) {
        this.disciplinaId = disciplinaId;
        this.tituloDisciplina = tituloDisciplina;
    }

    public String getTituloDisciplina() {
        return tituloDisciplina;
    }

    public void setTituloDisciplina(String tituloDisciplina) {
        this.tituloDisciplina = tituloDisciplina;
    }

    public int getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(int disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

}
