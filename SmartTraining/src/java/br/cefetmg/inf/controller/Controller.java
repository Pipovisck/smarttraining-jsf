/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.controller;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author gabriel
 */
public interface Controller {
    public String execute(HttpServletRequest request);
}
