/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Atividade;
import br.cefetmg.inf.model.domain.DiaTreino;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public interface IDiaTreinoDao {

    public ArrayList<DiaTreino> getListaDiaTreino(Atividade atividade) throws SQLException;

    public void postDiaTreino(DiaTreino diaTreino) throws SQLException;

    public void fechaConexao();
}
