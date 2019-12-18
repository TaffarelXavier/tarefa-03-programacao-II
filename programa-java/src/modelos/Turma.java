package modelos;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 * @author Ramon Deyvid <ramon.dayvid08@gmail.com>
 */
public class Turma {

    private int turmaID;
    private String periodLetivo;
    private String codigoSala;
    private String bloco;
    private String sala;
    private int capacidade;
    private String turno;
    private int anoLetivo;

    public Turma(int codigoTurma, String periodLetivo, String codigoSala, String bloco, String sala, int capacidade,
            String turno, int anoLetivo) {
        this.turmaID = codigoTurma;
        this.periodLetivo = periodLetivo;
        this.codigoSala = codigoSala;
        this.bloco = bloco;
        this.sala = sala;
        this.capacidade = capacidade;
        this.turno = turno;
        this.anoLetivo = anoLetivo;
    }

    public int getTurmaID() {
        return turmaID;
    }

    public void setTurmaID(int turmaID) {
        this.turmaID = turmaID;
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

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(int anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

}
