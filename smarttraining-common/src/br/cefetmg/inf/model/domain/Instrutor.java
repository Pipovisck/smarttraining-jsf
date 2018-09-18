package br.cefetmg.inf.model.domain;
import java.time.LocalDate;

/**
 *
 * @author Tomatinho
 */

public class Instrutor extends Usuario {
    private String nroCref;

    public Instrutor(){
        
    }

    public Instrutor(String nroCref, String codCpf, String nomUsuario, char idtTipoUsuario, String txtSenha, String desEmail, LocalDate datNascimento) {
        super(codCpf, nomUsuario, idtTipoUsuario, txtSenha, desEmail, datNascimento);
        this.nroCref = nroCref;
    } 
    
    public void setCodCREF(String codCREF) {
        this.nroCref = codCREF;
    }

    public String getCodCREF() {
        return nroCref;
    }
}
