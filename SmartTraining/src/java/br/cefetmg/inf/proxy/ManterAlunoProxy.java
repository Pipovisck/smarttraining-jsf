package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterUsuario;
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

public class ManterAlunoProxy implements IManterUsuario {

    Cliente cliente;

    public ManterAlunoProxy() {
        try {
            this.cliente = Cliente.getInstancia();
        } catch (SocketException ex) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Usuario pesquisarPorCpf(String codCpf) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();
        
        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codCpf));
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_ALUNO_CPF, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        Usuario aluno = gson.fromJson(pacoteRecebido.getDados().get(0), Usuario.class);
        return aluno;
    }

    @Override
    public Usuario pesquisarPorNome(String nome) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(nome));
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_ALUNO_NOME, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        Usuario aluno = gson.fromJson(pacoteRecebido.getDados().get(0), Usuario.class);
        return aluno;
    }

    @Override
    public ArrayList<Usuario> pesquisarTodos() throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        pacoteEnviado = new Pacote(TipoOperacao.LISTA_ALUNO, null);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        ArrayList<Usuario> listaAlunos = gson.fromJson(pacoteRecebido.getDados().get(0), 
                new TypeToken<ArrayList<Usuario>>() {}.getType());
        return listaAlunos;
    }

    @Override
    public void cadastrar(Usuario aluno) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(aluno));
        pacoteEnviado = new Pacote(TipoOperacao.CAD_ALUNO, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void alterar(Usuario aluno) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(aluno));
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_ALUNO, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void excluir(String codCpf) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codCpf));
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_ALUNO, dados);

        cliente.requisicao(pacoteEnviado);
    }

}
