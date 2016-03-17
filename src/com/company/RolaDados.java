import java.util.concurrent.TimeUnit;

/**
 * Essa é uma classe auxiliar que permite gerencia um conjunto de vários dados simultaneamente.
 * Operações como rolar alguns dos dados ou exibir o resultado de todos eles, são implementadas.
 * Created by Eduardo Garcia Misiuk and Allan Silva Domingues on 10/03/16.
 */
public class RolaDados {

    private Dado[] d; // Dados;
    private int n; // Número de dados;
    private int[] v; // Valor do último lado de cada dado;

    // Constructors;
    /**
     * Construtor que cria e armazena vários objetos do tipo Dado.
     * Usa para isso o construtor padrão daquela classe, ou seja, um dado de 6 lados
     * e gerando sempre uma semente aleatória para o gerador de números aleatórios.
     * Os dados criados podem ser referenciados por números, entre 1 e n.
     * @param n Número de dados a serem criados.
     */
    public RolaDados (int n) {
        this.d = new Dado[n];
        this.n = n;
        this.v = new int[n];

        for (int i = 0; i < n; i++) d[i] = new Dado ();
    }

    // Methods

    /**
     * Rola todos os dados.
     * @return Retorna o valor de cada um dos dados, inclusive os que não foram rolados.
     * Nesse caso, o valor retornado é o valor anterior que ele já possuia.
     */
    public int[] rolar () {
        for (int i = 0; i < this.n; i++) {
            d[i].rolar ();
            v[i] = d[i].ultimoLado;
        }

        return this.v;
    }

    /**
     * Rola alguns dos dados.
     * @param s É um String que possui o número dos dados a serem rolados.
     *          Por exemplo "1 4 5" indica que os dados 1 4 e cinco devem ser rolados.
     *          Os números devem ser separados por espaços.
     *          Se o valor passado no string estiver fora do intervalo válido, ele é ignorado simplesmente.
     * @return Retorna o valor de cada um dos dados, inclusive os que não foram rolados.
     * Nesse caso, o valor retornado é o valor anterior que ele já possuia.
     */
    public int[] rolar (String s) {
        int number;

        int j, i;

        for (i = 0; i < s.length (); i = j + 1) {

            // Achando até onde vai o número;
            for (j = i; j < s.length () && s.charAt (j) != ' '; j++);

            try {
                number = Integer.parseInt (s.substring (i, j))-1;
                this.d[number].rolar ();
                this.v[number] = this.d[number].ultimoLado;
            }

            catch (Exception e) {  }

        }

        return this.v;
    }

    /**
     * Rola alguns dos dados.
     * @param quais É um array de booleanos que indica quais dados devem ser rolados.
     *              Cada posição representa um dos dados.
     *              Ou seja, a posição 0 do array indica se o dado 1 deve ser rolado ou não, e assim por diante.
     * @return Retorna o valor de cada um dos dados, inclusive os que não foram rolados.
     * Nesse caso, o valor retornado é o valor anterior que ele já possuia.
     */
    public int[] rolar(boolean[] quais) {
        int i;

        for (i = 0; i < n; i++) {
            if (quais[i]) {
                this.d[i].rolar();
                this.v[i] = d[i].ultimoLado;
            }
        }

        return this.v;
    }

    @Override
    /**
     * Usa a representação em string do dados, para mostrar o valor de todos os dados do conjunto. Exibe os dados horisontalmente, por exemplo:

     1          2          3          4          5
     +-----+    +-----+    +-----+    +-----+    +-----+
     |*   *|    |     |    |*    |    |*    |    |*   *|
     |  *  |    |  *  |    |     |    |  *  |    |     |
     |*   *|    |     |    |    *|    |    *|    |*   *|
     +-----+    +-----+    +-----+    +-----+    +-----+

     */
    public String toString() {
        int i, j;
        String parteDado = "";

        for (i = 0; i < n; i++) {
            parteDado += " " + (i+1) + "         ";
        }
        parteDado += "\n";

        for (i = 0; i < n; i++) {
            parteDado += d[i].toString ().substring (0, 7);
            parteDado += "    ";
        }
        parteDado += "\n";

        for (j = 8; j < 32; j += 8) {
            for (i = 0; i < n; i++) {
                parteDado += d[i].toString ().substring (j, j+7);
                parteDado += "    ";
            }
            parteDado += "\n";
        }

        for (i = 0; i < n; i++) {
            parteDado += d[i].toString().substring(0, 7);
            parteDado += "    ";
        }

        return parteDado;
    }
}