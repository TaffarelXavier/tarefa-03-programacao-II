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
public class Funcionario {

    private int id;
    private String nome;
    private String cpf;
    private String senha;
    private String nivel;
    private String cargo;
    private boolean permitirLogin;

    public Funcionario(int id, String nome, String cpf, String senha, String nivel, String cargo, boolean permitirLogin) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.nivel = nivel;
        this.cargo = cargo;
        this.permitirLogin = permitirLogin;
    }

    public Funcionario() {

    }

    public boolean isPermitirLogin() {
        return permitirLogin;
    }

    public void setPermitirLogin(boolean permitirLogin) {
        this.permitirLogin = permitirLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
