package com.company;

public class Main {

    /**
     * Função main simples demonstrando o funcionamento do objeto Dado.
     * @param args sem uso
     */
    public static void main(String[] args) {
        RolaDados r = new RolaDados (5);

        r.rolar ();

        System.out.println (r.toString());

        boolean[] v = {true, true, false, false, true};
        r.rolar (v);
        System.out.println (r.toString());

        r.rolar("3 5");
        System.out.println (r.toString());
    }
}
