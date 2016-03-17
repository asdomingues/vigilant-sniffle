import java.lang.String;

/**
 * Simula um dado de número de lados variados. Ao criar o objeto é possível estabelecer o número de lados.
 * A rolagem do dado é feita por meio de um gerador de números aleatórios (Random).
 * Autores: Eduardo Garcia Misiuk e Allan da Silva Domingues.
 */
public class Dado {

    Random r;
    int nLados;
    int ultimoLado;

    // Constructors

    /**
     * Cria um dado com 6 lados.
     */
    public Dado () {
        this (6);
    }

    /**
     * Cria um dado com n lados
     * @param n numero de lados do dado
     */
    public Dado (int n) {
        this.r = new Random ();
        this.nLados = n;
        this.ultimoLado = 1;
    }

    // Métodos

    /**
     * Recupera o ultimo numero selecionado.
     * @return o numero do ultimo lado selecionado.
     */
    public int getLado () { return this.ultimoLado; }

    /**
     * Simula a rolagem de um dado por meio de um gerador aleatorio.
     * @return o numero que foi sorteado.
     */
    public int rolar () {
        this.ultimoLado = r.getIntRand (1, 7);
        return this.ultimoLado;
    }

    @Override
    /**
     * Transforma representação do dado em String. É mostrada uma representação do dado que está para cima.
     * Note que só funciona corretamente para dados de 6 lados. Exemplo:
     *
     +-----+
     |*   *|
     |  *  |
     |*   *|
     +-----+
     */
    public String toString () {
        String face;

        face = "+-----+\n";
        switch (this.ultimoLado) {
            case 1:
                face += "|     |\n";
                face += "|  *  |\n";
                face += "|     |\n";
                break;

            case 2:
                face += "|*    |\n";
                face += "|     |\n";
                face += "|    *|\n";
                break;

            case 3:
                face += "|    *|\n";
                face += "|  *  |\n";
                face += "|*    |\n";
                break;

            case 4:
                face += "|*   *|\n";
                face += "|     |\n";
                face += "|*   *|\n";
                break;

            case 5:
                face += "|*   *|\n";
                face += "|  *  |\n";
                face += "|*   *|\n";
                break;

            case 6:
                face += "|*   *|\n";
                face += "|*   *|\n";
                face += "|*   *|\n";
                break;

            default:
                break;
        }

        face += "+-----+\n";

        return face;
    }

}
