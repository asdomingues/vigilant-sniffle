package com.company;

/**
 * Created by Eduardo Garcia Misiuk and Allan Silva Domingues on 12/03/16.
 */
public class Placar {
    private int[] tabelaNumeros = new int[10];
    private int score = 0;
    String excecao = "";

    public void add (int posicao, int[] dados) throws IllegalArgumentException {
        if (posicao > 0 && posicao < 7) {
            for(int i = 0; i < 6; i++) {
                tabelaNumeros[posicao-1] += (dados[i] == posicao ? dados[i] : 0);
            }
        }
        else if(posicao > 0 && posicao < 11) {
            if(tabelaNumeros[posicao - 1] != 0) {
                switch (posicao) {
                    case 7:
                        excecao = "O Full Hand já foi usado!";
                        break;
                    case 8:
                        excecao = "A sequência já foi usada!";
                        break;
                    case 9:
                        excecao = "A quadra já foi usada!";
                        break;
                    case 10:
                        excecao = "A quina já foi usada!";
                        break;
                    default:
                        break;
                }

                throw new IllegalArgumentException(excecao);
            }
            switch (posicao) {
                case 7:
                    for (int i; i < 11; i++) tabelaNumeros[posicao-1] += dados[i];
                    break;
                case 8:
                    for (int i; i < 11, i++);
                    break;
                case 9:
                    excecao = "A quadra já foi usada!";
                    break;
                case 10:
                    excecao = "A quina já foi usada!";
                    break;
                default:
                    break;
            }
        }
    }
}
