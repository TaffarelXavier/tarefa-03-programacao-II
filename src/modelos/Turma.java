package modelos;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 */
public class Turma {

    private int codigoTurma;
    private String periodLetivo;
    private String codigoSala;
    private int codigoProfessor;
    private int codigoDisciplina;

    public Turma(int codigoTurma, String periodLetivo, String codigoSala, int codigoProfessor, int codigoDisciplina) {
        this.codigoTurma = codigoTurma;
        this.periodLetivo = periodLetivo;
        this.codigoSala = codigoSala;
        this.codigoProfessor = codigoProfessor;
        this.codigoDisciplina = codigoDisciplina;
    }

    public int getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(int codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public String getPeriodLetivo() {
        return periodLetivo;
    }

    public void setPeriodLetivo(String periodLetivo) {
        this.periodLetivo = periodLetivo;
    }

    public String getCodigoSala() {
        return codigoSala;
    }

    public void setCodigoSala(String codigoSala) {
        this.codigoSala = codigoSala;
    }

    public int getCodigoProfessor() {
        return codigoProfessor;
    }

    public void setCodigoProfessor(int codigoProfessor) {
        this.codigoProfessor = codigoProfessor;
    }

    public int getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(int codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

}
