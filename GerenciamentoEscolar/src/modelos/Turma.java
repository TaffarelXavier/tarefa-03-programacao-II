package modelos;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 */
public class Turma {
    
    private int periodLetivo;
    private int codigoSala;
    private int codigoProfessor;
    private int codigoDisciplina;

    public Turma(int periodLetivo, int codigoSala, int codigoProfessor, int codigoDisciplina) {
        this.periodLetivo = periodLetivo;
        this.codigoSala = codigoSala;
        this.codigoProfessor = codigoProfessor;
        this.codigoDisciplina = codigoDisciplina;
    }

}
