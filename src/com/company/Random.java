import java.sql.Time;
import java.util.Calendar;
import java.lang.String;
import java.util.concurrent.TimeUnit;

/**
 * Gerador simples de números aleatórios.
 * @author Eduardo Garcia Misiuk e Allan Silva Domingues.
 */
public class Random {
    private long p = 2147483648l;
    private long m = 843314861;
    private long a = 453816693;
    private long xi = 1023;

    /**
     * Construtor que permite criar o gerador, especificando o valor inicial da semente.
     * @param seed O valor inicial da semente.
     */
    public Random (long seed){
        xi = seed;
    }

    /**
     * Construtor que usa uma semente aleatória, adquerida usando o método Calendar.getTimeInMillis().
     * @author Eduardo Garcia Misiuk e Allan Silva Domingues.
     */
    public Random (){
        // Sem usar delay, em quase todas as vezes em que testamos, ele dava números
        // iguais. Portanto, colocando 1 ms de delay, ele troca o número.
        try { TimeUnit.MILLISECONDS.sleep (1); }
        // Não usaremos a exception para coisa alguma;
        catch (Exception e) {  }
        xi = Calendar.getInstance().getTimeInMillis() % p;
    }

    /**
     * Retorna um número aleatório no intervalo (0,1[.
     * @return O número gerado.
     */
    public double getRand (){
        double d;
        xi = (a+m*xi)%p;
        d = xi;
        return d/p;
    }

    /**
     * Retorna um valor inteiro no intervalo (0,max[.
     * @param max O valor limite para a geração do número inteiro.
     * @return O número gerado.
     */
    public int getIntRand (int max) {
        return (int) (getRand ()*max);
    }

    /**
     * Retorna um valor inteiro no intervalo (min,max[.
     * @param min limite inferior da geração do número.
     * @param max limite superior da geração do número.
     * @return O número gerado.
     * @throws IllegalArgumentException Caso o usuário passe um valor de mínimo que seja maior ou igual ao máximo,
     * retorna um erro.
     */
    public int getIntRand (int min, int max) throws IllegalArgumentException {
        if (max <= min){
            throw new
                    IllegalArgumentException ("Parâmetros inválidos");
        }
        return (int) (min + getIntRand (max - min));
    }

    /**
     * Retorna um valor inteiro no intervalo (0, Integer.MAX_VALUE[.
     * @return O número gerado.
     */
    public int getIntRand () {
        return (int) getRand ()*Integer.MAX_VALUE;
    }

    /**
     * Setter da variável seed.
     * @param seed valor a ser colocado na variável seed.
     */
    public void setSemente (int seed){
        xi = seed;
    }

    /**
     * Imprime o valor da semente.
     */
    public void printSemente (){
        System.out.println (xi);
    }
}