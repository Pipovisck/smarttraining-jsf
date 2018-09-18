package br.cefetmg.inf;

import br.cefetmg.inf.adapter.AdapterService;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class Servidor {

    private static DatagramSocket socketServidor;
    private static InetAddress enderecoIP;
    private static int porta;

    public static void main(String[] args) throws SocketException {
        porta = 6969;
        socketServidor = new DatagramSocket(porta);
        while (true) {
            recebeDados();
        }
    }

    private static synchronized void recebeDados() {
        byte[] bufferRecebido = new byte[3];
        byte[][] pacotes = null;
        Gson gson = new Gson();

        DatagramPacket pacoteRecebido;
        pacoteRecebido = new DatagramPacket(bufferRecebido, 3);

        try {
            socketServidor.receive(pacoteRecebido);
            enderecoIP = pacoteRecebido.getAddress();
            porta = pacoteRecebido.getPort();
            
            int numeroPacotes = Integer.parseInt(new String(pacoteRecebido.getData()).trim());

            if (numeroPacotes < 10) {
                pacotes = new byte[numeroPacotes][1025];
                bufferRecebido = new byte[1025];
            } else if (numeroPacotes >= 10 && numeroPacotes < 100) {
                pacotes = new byte[numeroPacotes][1026];
                bufferRecebido = new byte[1026];
            } else {
                pacotes = new byte[numeroPacotes][1027];
                bufferRecebido = new byte[1027];
            }
            
            for (int i = 0; i < numeroPacotes; i++) {
                pacoteRecebido = new DatagramPacket(bufferRecebido, pacotes[0].length);
                socketServidor.receive(pacoteRecebido);
                pacotes[i] = pacoteRecebido.getData();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        bufferRecebido = PadronizadorPacotes.agrupaPacotes(pacotes);

        JsonReader leitor = new JsonReader(new StringReader(new String(bufferRecebido)));
        leitor.setLenient(true);

        Pacote pacote = gson.fromJson(leitor, Pacote.class);

        AdapterService adapter = new AdapterService(enderecoIP, porta, pacote);
        Thread threadAdapter = new Thread(adapter);
        threadAdapter.start();
    }

    public static void enviaDados(InetAddress enderecoIP, int portaCliente, Pacote pacoteTemporario) {
        try {
            byte[][] pacotes = PadronizadorPacotes.separaPacote(pacoteTemporario);
            DatagramPacket pacoteEnviado;
            byte[] pacoteNumero = String.valueOf(pacotes.length).getBytes();
            
            pacoteEnviado = new DatagramPacket(pacoteNumero, pacoteNumero.length, enderecoIP, porta);
            socketServidor.send(pacoteEnviado);
            
            for (byte[] aux : pacotes) {
                pacoteEnviado = new DatagramPacket(aux, aux.length, enderecoIP, porta);
                socketServidor.send(pacoteEnviado);
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
