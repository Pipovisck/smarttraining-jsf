/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.util;

import com.google.gson.Gson;
import org.apache.commons.lang.ArrayUtils;

/**
 *
 * @author gabriel
 */
public class PadronizadorPacotes {

    public static byte[][] separaPacote(Pacote pacote) {
        Gson gson = new Gson();
        byte[][] pacotes;
        byte[] pacoteBytes = gson.toJson(pacote).getBytes();
        int tamanhoPacote = pacoteBytes.length;
        int tamUltimoPacote = tamanhoPacote % 1024;

        int numPacotes = (int) Math.ceil((double) (tamanhoPacote / 1024));
        if ((double) numPacotes < (double) tamanhoPacote / 1024) {
            numPacotes++;
        }

        if (numPacotes < 10) {                                  //se tiver menos de 10 pacotes
            pacotes = new byte[numPacotes][1025];
            for (int i = 0; i < numPacotes; i++) {
                pacotes[i][0] = String.valueOf(i).getBytes()[0];
                for (int j = 0; j < 1024; j++) {
                    
                    if (i == numPacotes - 1 && j == tamUltimoPacote) {
                        break;
                    }
                    
                    pacotes[i][j+1] = pacoteBytes[j + (1024*i)];
                    
                }
                byte aux = String.valueOf(i).getBytes()[0];
            }
        } else if (numPacotes >= 10 && numPacotes < 100) {     //se tiver entre 10 e 100 pacotes
            pacotes = new byte[numPacotes][1026];
            for (int i = 0; i < numPacotes; i++) {

                for (int j = 0; j < 1025; j++) {
                    pacotes[i][j] = pacoteBytes[j + (1024*i)];
                }
                
                pacotes[i][0] = String.valueOf(i).getBytes()[0];
                pacotes[i][1] = String.valueOf(i).getBytes()[1];

            }
        } else {                                                //se tiver mais de 100 pacotes
            pacotes = new byte[numPacotes][1027];
            for (int i = 0; i < numPacotes; i++) {

                for (int j = 0; j < 1026; j++) {
                    pacotes[i][j] = pacoteBytes[j + (1024*i)];
                }
                
                pacotes[i][0] = String.valueOf(i).getBytes()[0];
                pacotes[i][1] = String.valueOf(i).getBytes()[1];
                pacotes[i][2] = String.valueOf(i).getBytes()[2];
                
            }
        }
        return pacotes;
    }

    public static byte[] agrupaPacotes(byte[][] pacotes) {
        byte[][] pacotesAgrupados = new byte[pacotes.length][1024];

        switch (pacotes[0].length) {
            case 1025: {
                for (byte[] pacote : pacotes) {
                    int indicePacote = Integer.parseInt(String.valueOf((char) pacote[0]));
                    System.arraycopy(pacote, 1, pacotesAgrupados[indicePacote], 0, pacote.length - 1);
                }
                break;
            }
            case 1026: {
                for (byte[] pacote : pacotes) {
                    int indicePacote = Integer.parseInt(String.valueOf((char) pacote[0])
                            + String.valueOf((char) pacote[1]));
                    System.arraycopy(pacote, 2, pacotesAgrupados[indicePacote], 0, pacote.length - 1);
                }
                break;
            }
            case 1027: {
                for (byte[] pacote : pacotes) {
                    int indicePacote = Integer.parseInt(String.valueOf((char) pacote[0])
                            + String.valueOf((char) pacote[1])
                            + String.valueOf((char) pacote[2]));
                    System.arraycopy(pacote, 3, pacotesAgrupados[indicePacote], 0, pacote.length - 1);
                }
                break;
            }
        }

        byte[] pacoteOriginal = null;
        for (int i = 0; i < pacotesAgrupados.length; i++) {
            pacoteOriginal=ArrayUtils.addAll(pacoteOriginal, pacotesAgrupados[i]);
        }
        return pacoteOriginal;
    }
}
