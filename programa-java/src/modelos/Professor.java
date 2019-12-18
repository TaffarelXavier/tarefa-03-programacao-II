package modelos;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 * @author Ramon Deyvid <ramon.dayvid08@gmail.com>
 */
public class Professor {

    private int id;
    private static int idStatic;
    private String CPF;
    private String nome;
    private String senha;
    private String status;
    private String nivel;

    public static int getstr() {
        return idStatic;
    }

    public Professor(int id, String CPF, String nome, String senha, String status, String nivel) {
        this.id = id;
        this.CPF = CPF;
        this.nome = nome;
        this.senha = senha;
        this.status = status;
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

}
