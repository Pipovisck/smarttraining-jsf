package br.cefetmg.inf.controller.mb;

import br.cefetmg.inf.model.domain.RegiaoCorporal;
import br.cefetmg.inf.model.services.IManterRegiaoCorporal;
import br.cefetmg.inf.proxy.ManterRegiaoCorporalProxy;
import java.sql.SQLException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("regiao")
public class RegiaoCorporalMB {
        
    private RegiaoCorporal regiaoCorporal;
    
    
     public String cadastrar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterRegiaoCorporal manterRegiaoCorporal = new ManterRegiaoCorporalProxy();
            manterRegiaoCorporal.cadastrar(regiaoCorporal, regiaoCorporal.getListaMusculos());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar região corporal!");
        }
        return jsf;
    }

    public String pesquisar() {
        String jsf = "AlterarRegiaoCorporal";
        try {
            IManterRegiaoCorporal manterRegiaoCorporal = new ManterRegiaoCorporalProxy();
            regiaoCorporal = manterRegiaoCorporal.pesquisarRegiaoCorporal(regiaoCorporal.getNroSequenciaRegiaoCorporal());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar região corporal!");
        }
        return jsf;
    }

    public String alterar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterRegiaoCorporal manterRegiaoCorporal = new ManterRegiaoCorporalProxy();
            manterRegiaoCorporal.alterar(regiaoCorporal);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar região corporal!");
        }
        return jsf;
    }

    public String deletar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterRegiaoCorporal manterRegiaoCorporal = new ManterRegiaoCorporalProxy();
            manterRegiaoCorporal.excluir(regiaoCorporal.getNroSequenciaRegiaoCorporal());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir região corporal!");
        }
        return jsf;
    }

    public RegiaoCorporal getRegiaoCorporal() {
        return regiaoCorporal;
    }

    public void setRegiaoCorporal(RegiaoCorporal regiaoCorporal) {
        this.regiaoCorporal = regiaoCorporal;
    }
    
}
