/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.domain.RegiaoCorporal;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public interface IRegiaoCorporalDao {

    public RegiaoCorporal getRegiaoCorporal(int codRegiao) throws SQLException;

    public void postRegiaoCorporal(RegiaoCorporal regiao, int codMusculo) throws SQLException;

    public void putRegiaoCorporal(RegiaoCorporal regiao) throws SQLException;

    public void deleteRegiaoCorporal(int codRegiaoCorporal) throws SQLException;

    public void fechaConexao();
}
