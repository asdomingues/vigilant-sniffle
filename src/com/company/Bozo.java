import java.io.IOException;

/**
 * Essa é a classe inicial do programa Bozó. Possui apenas o método main, que cuida da execução do jogo.
 */
public class Bozo {

    /**
     * Método inicial do programa. Ele cuida da execução do jogo e possui um laço, no qual cada iteração representa
     * uma rodada do jogo. Em cada rodada, o jogador joga os dados até 3 vezes e depois escolhe a posição do placar
     * que deseja preencher. No final das rodadas a pontuação total é exibida.
     * @param args sem uso.
     */
    public static void main(String[] args) throws IOException {
        int i;
        Placar p = new Placar ();
        RolaDados d = new RolaDados (5);
        int[] valores;
        String roll;
        int pos = 0;
        boolean correct, aNumber;

        for (i = 0; i < 10; i++) {

            System.out.print ("Pressione enter para iniciar a rodada...");
            EntradaTeclado.leString ();

            // Primeira vez rodando os dados;
            d.rolar ();
            System.out.println (d.toString());

            // Segunda vez rodando os dados;
            System.out.println ("Digite os dados que deseja rodar, separados por espaço:");
            roll = EntradaTeclado.leString ();
            d.rolar (roll);
            System.out.println (d.toString());

            // Terceira vez rodando os dados;
            System.out.println ("Digite os dados que deseja rodar, separados por espaço:");
            roll = EntradaTeclado.leString ();
            valores = d.rolar (roll);
            System.out.println (d.toString());

            correct = false;
            while (!correct){

                System.out.println (p.toString());
                
                aNumber = false;
                while (!aNumber) {

                    System.out.printf ("Selecione a posição que a sua jogada deverá ocupar: ");
                    aNumber = true;
                    try {
                        pos = EntradaTeclado.leInt ();
                    }
                    
                    catch (Exception ex) {
                        System.out.println ("Valor inválido!");
                        aNumber = false;
                    }

                }
                
                correct = true;
                try {
                    p.add (pos, valores);
                }
                catch (IllegalArgumentException ex) {
                    System.out.println (ex);
                    correct = false;
                }

            }

            System.out.println (p.toString());

        }

        System.out.println ("Sua pontuação final foi: " + p.getScore());
    }
}
