package br.cefetmg.inf.controller;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class TratadorErrosFactory extends ExceptionHandlerFactory{
    private ExceptionHandlerFactory tratadorErrosFactory;

    public TratadorErrosFactory() {
    }

    public TratadorErrosFactory(ExceptionHandlerFactory tratadorErrosFactory) {
        this.tratadorErrosFactory = tratadorErrosFactory;
    }

    @Override
    public ExceptionHandler getExceptionHandler() {
        return new TratadorErros(tratadorErrosFactory.getExceptionHandler());
    }
}
