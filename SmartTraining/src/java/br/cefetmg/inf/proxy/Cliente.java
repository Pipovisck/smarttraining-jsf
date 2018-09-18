package br.cefetmg.inf.proxy;

import br.cefetmg.inf.util.Pacote;
import br.cefetmg.inf.util.PadronizadorPacotes;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class Cliente {

    private static Cliente instanciaUnica;

    private final DatagramSocket socketCliente;
    private final String servidor;
    private final int porta;
    private final InetAddress enderecoIP;

    private Cliente() throws SocketException, UnknownHostException {
        socketCliente = new DatagramSocket();
        servidor = "localhost";
        porta = 6969;
        enderecoIP = InetAddress.getByName(servidor);
    }

    public static Cliente getInstancia() throws SocketException, UnknownHostException {
        if (instanciaUnica == null) {
            instanciaUnica = new Cliente();
        }

        return instanciaUnica;
    }

    public Pacote requisicao(Pacote pacoteTemporario) {

        Gson gson = new Gson();

        byte[] bufferRecebido = new byte[1027];
        byte[][] pacotes = PadronizadorPacotes.separaPacote(pacoteTemporario);

        Pacote pacote = new Pacote(null, null);

        try {
            DatagramPacket pacoteEnviado;
            byte[] pacoteNumero = String.valueOf(pacotes.length).getBytes();

            pacoteEnviado = new DatagramPacket(pacoteNumero, pacoteNumero.length, enderecoIP, porta);
            socketCliente.send(pacoteEnviado);

            for (byte[] aux : pacotes) {
                pacoteEnviado = new DatagramPacket(aux, aux.length, enderecoIP, porta);
                socketCliente.send(pacoteEnviado);
            }

            DatagramPacket pacoteRecebido = new DatagramPacket(bufferRecebido, 1027);
            socketCliente.receive(pacoteRecebido);

            pacoteNumero = pacoteRecebido.getData();

            int numeroPacotes = Integer.parseInt(new String(pacoteNumero).trim());

            if (numeroPacotes < 10) {
                bufferRecebido = new byte[1025];
                pacotes = new byte[numeroPacotes][1025];
            } else if (numeroPacotes >= 10 && numeroPacotes < 100) {
                bufferRecebido = new byte[1026];
                pacotes = new byte[numeroPacotes][1026];
            } else {
                bufferRecebido = new byte[1027];
                pacotes = new byte[numeroPacotes][1027];
            }

            for (int i = 0; i < numeroPacotes; i++) {
                bufferRecebido = new byte[bufferRecebido.length];
                pacoteRecebido = new DatagramPacket(bufferRecebido, pacotes[0].length);
                socketCliente.receive(pacoteRecebido);
                pacotes[i] = bufferRecebido;
                System.out.println("");
            }
            
            bufferRecebido = PadronizadorPacotes.agrupaPacotes(pacotes);
            
            JsonReader leitor = new JsonReader(new StringReader(new String(bufferRecebido)));
            leitor.setLenient(true);
            pacote = gson.fromJson(leitor, Pacote.class);

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacote;
    }
}
