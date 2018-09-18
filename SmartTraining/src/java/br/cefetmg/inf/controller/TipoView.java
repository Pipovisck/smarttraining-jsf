package br.cefetmg.inf.controller;

import javax.servlet.http.HttpServletRequest;

public enum TipoView {
    HTML("html"), JSON("json");
    public String tipoView;
    
    TipoView(String tipoView){
        this.tipoView = tipoView;
    }
    
    public void visitaRequest(HttpServletRequest request){
        request.setAttribute("tipoView", tipoView);
    }
}
