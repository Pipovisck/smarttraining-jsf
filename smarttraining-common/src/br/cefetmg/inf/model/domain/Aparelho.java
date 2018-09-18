package br.cefetmg.inf.model.domain;

/**
 *
 * @author Tomatinho
 */

public class Aparelho {
    private int nroAparelho;
    private String nomAparelho;

    public Aparelho() {
        
    }

    public Aparelho(int codAparelho, String nomAparelho) {
        this.nroAparelho = codAparelho;
        this.nomAparelho = nomAparelho;
    }
    
    public int getNroAparelho() {
        return nroAparelho;
    }

    public void setNroAparelho(int nroAparelho) {
        this.nroAparelho = nroAparelho;
    }

    public String getNomAparelho() {
        return nomAparelho;
    }

    public void setNomAparelho(String nomAparelho) {
        this.nomAparelho = nomAparelho;
    }
    
    
    
    
}
