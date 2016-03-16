package com.company;

/**
 * Esta classe representa o placar de um jogo de Bozó. Permite que combinações de dados sejam alocadas às posições e
 * mantém o escore de um jogador.
 * @author Created by Eduardo Garcia Misiuk and Allan Silva Domingues on 12/03/16.
 */
public class Placar {
    private int[] tabelaNumeros = new int[10];
    private int score = 0;
    private String excecao = "";

    /**
     * Adiciona uma sequencia de dados em uma determinada posição do placar. Após a chamada, aquela posição torna-se
     * ocupada e não pode ser usada uma segunda vez.
     *
     * @param posicao Posição a ser preenchida. As posições 1 a 6 correspondem às quantidas de uns até seis, ou seja,
     *                as laterais do placar. As outas posições são: 7 - full hand; 8 - sequencia; 9 - quadra; e
     *                10 - quina.
     *
     * @param dados um array de inteiros, de tamanho 5. Cada posição corresponde a um valor de um dado.
     *              Supões-se que cada dado pode ter valor entre 1 e 6.
     *
     * @throws IllegalArgumentException se a posição estiver ocupada ou se for passado um valor de posição inválido,
     * essa exceção é lançada. Não é feita nenhuma verificação quanto ao tamanho do array nem quanto ao seu conteúdo.
     */
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
                    for (int i = 0; i < 11; i++) tabelaNumeros[posicao-1] += dados[i];
                    break;
                case 8:
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

    /**
     * Computa a soma dos valores obtidos, considerando apenas as posições que já estão ocupadas.
     * @return o valor da soma.
     */
    public int getScore () {
        return this.score;
    }

    @Override
    /**
     * A representação na forma de string, mostra o placar completo, indicando quais são as posições livres
     * (com seus respectivos números) e o valor obtido nas posições já ocupadas. Por exemplo:

     (1)    |   (7)    |   (4)
     --------------------------
     (2)    |   20     |   (5)
     --------------------------
     (3)    |   30     |   (6)
     --------------------------
     |   (10)   |
     +----------+


     mostra as posições 8 (sequencia) e 9 (quadra) ocupadas.
     */
    public String toString () {
        String placar = "";

        return placar;
    }
}
