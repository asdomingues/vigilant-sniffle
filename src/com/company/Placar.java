import java.util.Arrays;

/**
 * Esta classe representa o placar de um jogo de Bozó. Permite que combinações de dados sejam alocadas às posições e
 * mantém o escore de um jogador.
 * @author Created by Eduardo Garcia Misiuk and Allan Silva Domingues on 12/03/16.
 */
public class Placar {
    private int[] tabelaNumeros = new int[10];
    private boolean[] tabelaUsados = new boolean[10];
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
        int[] aux = dados.clone (); // Clonando os dados dos dados;
        int[] quantidade = new int[6];
        int i, j;
        String ex;
        boolean trinca, dupla, quina;
        
        Arrays.sort (aux); // Deixando-os em ordem crescente para facilitar a manipulação;
        
        dupla = trinca = quina = false;
        
        // Calculando a quantidade de repetições de cada número no intervalo [1, 6];
        for (i = 0; i < 5; i++) {
            quantidade[aux[i]-1]++;
        }
        
        // Verificando se a posição que a pessoa digitou está dentro dos limites;
        if (posicao < 1 || posicao > 10) throw new IllegalArgumentException ("A posição"
                + " deveria estar no intervalo [1,10]."); 
        
        // Verificando se a posição digitada já foi utilizada;
        if (tabelaUsados[posicao-1]) throw new IllegalArgumentException("A posição " + posicao + " já foi utilizada.");
        
        // Calculando as pontuações;
        switch (posicao) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            /* FALL THROUGH */
                for (i = 0, j = 0; i < 5; i++) if(aux[i] == posicao) j++;
                tabelaNumeros[posicao-1] = j * posicao;
                score += tabelaNumeros[posicao-1];
                tabelaUsados[posicao-1] = true;
                break;
                
            // Full hand;
            case 7:
                for (i = 0; i < 6; i++) {
                    if (quantidade[i] == 2) dupla = true;
                    if (quantidade[i] == 3) trinca = true;
                    if (quantidade[i] == 5) quina = true;
                }
                if ((dupla & trinca) | quina) {
                    tabelaNumeros[posicao-1] = 15;
                    score += tabelaNumeros[posicao-1];
                }
                tabelaUsados[posicao-1] = true;
                break;
                
            // Sequência;
            case 8:
                for (i = 0; i < 4 && aux[i] == aux[i+1] - 1; i++);
                if (i == 4) {
                    tabelaNumeros[posicao-1] = 20;
                    score += tabelaNumeros[posicao-1];
                }
                tabelaUsados[posicao-1] = true;
                break;
                
            // Quadra;
            case 9:
                for (i = 0; i < 6 && quantidade[i] < 4; i++);
                if (i < 6 && quantidade[i] >= 4) {
                    tabelaNumeros[posicao-1] = 30;
                    score += tabelaNumeros[posicao-1];
                }
                tabelaUsados[posicao-1] = true;
                break;

            // Quina;
            case 10:
                for (i = 0; i < 6 && quantidade[i] < 5; i++);
                if (i < 6 && quantidade[i] == 5) {
                    tabelaNumeros[posicao-1] = 40;
                    score += tabelaNumeros[posicao-1];
                }
                tabelaUsados[posicao-1] = true;
                break;
                
            default:
                break;
        }
    }

    /**
     * Computa a soma dos valores obtidos, considerando apenas as posições que já estão ocupadas.
     * @return o valor da soma.
     */
    public int getScore () { return this.score; }

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
        int i;
        int[] aux = {1, 7, 4, 2, 8, 5, 3, 9, 6, 10};

        for (i = 0; i < 9; i++) {
            if(i == 0) {
                placar += " ";
            }
            else if (i % 3 == 0) {
            placar += "\n--------------------------\n ";
            }
            else {
                placar += "   ";
            }
            placar += (tabelaUsados[aux[i]-1] == true ?
                    tabelaNumeros[aux[i]-1] + " "
                        + (tabelaNumeros[aux[i]-1] < 10 ? " " : "")
                            : "(" + aux[i] + ")");
            placar += "    " + ((i+1) % 3 != 0 ? "|" : "");
        }
        placar += "\n--------------------------\n ";
        placar += "       |   ";
        placar += (tabelaUsados[aux[i]-1] == true ?
                    tabelaNumeros[aux[i]-1] + "  "
                        + (tabelaNumeros[aux[i]-1] < 10 ? " " : "")
                            : "(" + aux[i] + ")");
        placar += "   |\n";
        placar += "        +----------+\n";

        return placar;
    }
}
