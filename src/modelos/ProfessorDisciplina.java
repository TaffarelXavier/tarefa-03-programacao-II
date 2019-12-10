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
public class ProfessorDisciplina {

    private int disciplina_id;
    private String profNome;
    private String tituloDisciplina;
    

   /**
    * 
    * @param disciplina_id
    * @param tituloDisciplina 
    */
    public ProfessorDisciplina(int disciplina_id, String tituloDisciplina) {
        this.disciplina_id = disciplina_id;
        this.tituloDisciplina = tituloDisciplina;
    }

    public String getTituloDisciplina() {
        return tituloDisciplina;
    }

    public void setTituloDisciplina(String tituloDisciplina) {
        this.tituloDisciplina = tituloDisciplina;
    }

    public int getDisciplina_id() {
        return disciplina_id;
    }

    public void setDisciplina_id(int disciplina_id) {
        this.disciplina_id = disciplina_id;
    }

    public String getProfNome() {
        return profNome;
    }

    public void setProfNome(String profNome) {
        this.profNome = profNome;
    }

    
    
}
