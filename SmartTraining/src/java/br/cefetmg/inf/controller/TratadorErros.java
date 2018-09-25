package br.cefetmg.inf.controller;

import java.util.Iterator;
import java.util.Map;
import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class TratadorErros extends ExceptionHandlerWrapper{
    private ExceptionHandler TratadorExcessao;

    public TratadorErros(ExceptionHandler exceptionHandler) {
        this.TratadorExcessao = exceptionHandler;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return TratadorExcessao;
    }

    @Override
    public void handle() throws FacesException {
        final Iterator<ExceptionQueuedEvent> queue = getUnhandledExceptionQueuedEvents().iterator();

        while (queue.hasNext()){
            ExceptionQueuedEvent item = queue.next();
            ExceptionQueuedEventContext exceptionQueuedEventContext = (ExceptionQueuedEventContext)item.getSource();

            try {
                Throwable throwable = exceptionQueuedEventContext.getException();
                System.err.println("Excessão: " + throwable.getMessage());

                FacesContext context = FacesContext.getCurrentInstance();
                Map<String, Object> requestMap = context.getExternalContext().getRequestMap();
                NavigationHandler nav = context.getApplication().getNavigationHandler();
                
                String mensagem = throwable.getMessage().substring(0, throwable.getMessage().indexOf("**"));
                String paginaAnterior = throwable.getMessage().substring(throwable.getMessage().indexOf("**")+2);
                
                requestMap.put("mensagem-erro", mensagem);
                requestMap.put("pilha-erros", throwable.getStackTrace());
                requestMap.put("pagina-anterior", paginaAnterior);
                nav.handleNavigation(context, null, "/erro");
                context.renderResponse();

            } finally {
                queue.remove();
            }
        }
    }
}
