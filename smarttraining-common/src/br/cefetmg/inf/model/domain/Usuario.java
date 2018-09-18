package br.cefetmg.inf.model.domain;
import java.time.LocalDate;

/**
 *
 * @author Tomatinho
 */

public class Usuario {
    protected String codCpf;
    protected String nomUsuario;
    protected char idtTipoUsuario;
    protected String txtSenha;
    protected String desEmail;
    protected LocalDate datNascimento;

    public Usuario(){
            
    }
    
    public Usuario(String codCpf, String nomUsuario, char idtTipoUsuario, 
                   String txtSenha, String desEmail, LocalDate datNascimento){
        this.codCpf = codCpf;
        this.nomUsuario = nomUsuario;
        this.idtTipoUsuario = idtTipoUsuario;
        this.txtSenha = txtSenha;
        this.desEmail = desEmail;
        this.datNascimento = datNascimento;
    }
    
    public void setCodCpf(String codCpf) {
        this.codCpf = codCpf;
    }
    
    public String getCodCpf() {
        return codCpf;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }
    
    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setIdtTipoUsuario(char idtTipoUsuario) {
        this.idtTipoUsuario = idtTipoUsuario;
    }

    public char getIdtTipoUsuario() {
        return idtTipoUsuario;
    }

    public void setTxtSenha(String txtSenha) {
        this.txtSenha = txtSenha;
    }

    public String getTxtSenha() {
        return txtSenha;
    }

    public void setDesEmail(String desEmail) {
        this.desEmail = desEmail;
    }

    public String getDesEmail() {
        return desEmail;
    }

    public void setDatNascimento(LocalDate datNascimento) {
        this.datNascimento = datNascimento;
    }

    public LocalDate getDatNascimento() {
        return datNascimento;
    }   
}
