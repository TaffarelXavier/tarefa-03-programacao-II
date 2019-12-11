/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 */
public class Aluno {
    
    private int codigoAluno;
    private String nome;
    private String dataDeNascimento;
    private String CPF;
    private String email;
    private String telefone;

    private Disciplina disciplina;
    
    /**
     * 
     * @param nomeALuno
     * @param codigoAluno
     * @param dataDeNascimento
     * @param CPF
     * @param email
     * @param telefone 
     */
    public Aluno(String nomeALuno, int codigoAluno, String dataDeNascimento, String CPF, String email, String telefone) {
        this.nome = nomeALuno;
        this.codigoAluno = codigoAluno;
        this.dataDeNascimento = dataDeNascimento;
        this.CPF = CPF;
        this.email = email;
        this.telefone = telefone;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(int codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    

}
