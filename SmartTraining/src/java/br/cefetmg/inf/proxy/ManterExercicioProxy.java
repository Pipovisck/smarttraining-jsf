package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.AparelhoExercicio;
import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.util.Pacote;
import br.cefetmg.inf.util.TipoOperacao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipe
 */
public class ManterExercicioProxy implements IManterExercicio {

    Cliente cliente;

    public ManterExercicioProxy() {
        try {
            this.cliente = Cliente.getInstancia();
        } catch (SocketException | UnknownHostException ex) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Exercicio pesquisarPorCodigo(int codExercicio) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codExercicio));
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_EXERCICIO_COD, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        Exercicio exercicio = gson.fromJson(pacoteRecebido.getDados().get(0), Exercicio.class);
        return exercicio;
    }

    @Override
    public Exercicio pesquisarPorNome(String nomeExercicio) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(nomeExercicio));
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_EXERCICIO_NOME, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        Exercicio exercicio = gson.fromJson(pacoteRecebido.getDados().get(0), Exercicio.class);
        return exercicio;
    }

    @Override
    public AparelhoExercicio pesquisarAparelhoExercicio(int codExercicio, int nroAparelho) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codExercicio));
        dados.add(gson.toJson(nroAparelho));
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_APARELHOEXERCICIO, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        AparelhoExercicio aparelhoExercicio = gson.fromJson(pacoteRecebido.getDados().get(0), AparelhoExercicio.class);
        return aparelhoExercicio;
    }

    @Override
    public ArrayList<Exercicio> pesquisarPorRegiao(String nomeRegiao) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(nomeRegiao));
        pacoteEnviado = new Pacote(TipoOperacao.LISTA_EXERCICIO_REGIAO, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        ArrayList<Exercicio> listaExercicios = gson.fromJson(pacoteRecebido.getDados().get(0), 
                new TypeToken<ArrayList<Exercicio>>() {}.getType());
        return listaExercicios;
    }

    @Override
    public ArrayList<Exercicio> pesquisarPorMusculo(int codMusculo) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codMusculo));
        pacoteEnviado = new Pacote(TipoOperacao.LISTA_EXERCICIO_MUSCULO, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        ArrayList<Exercicio> listaExercicios = gson.fromJson(pacoteRecebido.getDados().get(0), 
                new TypeToken<ArrayList<Exercicio>>() {}.getType());
        return listaExercicios;
    }

    @Override
    public ArrayList<Exercicio> pesquisarTodos() throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        pacoteEnviado = new Pacote(TipoOperacao.LISTA_EXERCICIO, null);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        ArrayList<Exercicio> listaExercicios = gson.fromJson(pacoteRecebido.getDados().get(0), 
                new TypeToken<ArrayList<Exercicio>>() {}.getType());
        return listaExercicios;
    }

    @Override
    public void cadastrar(Exercicio exercicio, String[] codMusculos) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(exercicio));
        dados.add(gson.toJson(codMusculos));
        pacoteEnviado = new Pacote(TipoOperacao.CAD_EXERCICIO, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void cadastrarAparelhoExercicio(int codExercicio, int nroAparelho, String caminhoImg) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codExercicio));
        dados.add(gson.toJson(nroAparelho));
        dados.add(gson.toJson(caminhoImg));
        pacoteEnviado = new Pacote(TipoOperacao.CAD_APARELHOEXERCICIO, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void alterar(Exercicio exercicio) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(exercicio));
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_EXERCICIO, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void excluir(int codExercicio) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codExercicio));
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_EXERCICIO, dados);

        cliente.requisicao(pacoteEnviado);
    }

}
