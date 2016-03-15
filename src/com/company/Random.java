package com.company;

import java.sql.Time;
import java.util.Calendar;
import java.lang.String;
import java.util.concurrent.TimeUnit;

public class Random {
    private long p = 2147483648l;
    private long m = 843314861;
    private long a = 453816693;

    private long xi = 1023;

    // Construtores;
    public Random (long seed){
        xi = seed;
    }
    public Random (){
        // Sem usar delay, em quase todas as vezes em que testamos, ele dava números
        // iguais. Portanto, colocando 1 ms de delay, ele troca o número.
        try { TimeUnit.MILLISECONDS.sleep (1); }
        catch (Exception e) {  }
        xi = Calendar.getInstance().getTimeInMillis() % p;
    }

    public double getRand (){
        double d;
        xi = (a+m*xi)%p;
        d = xi;
        return d/p;
    }

    public int getIntRand (int max) {
        return (int) (getRand ()*max);
    }

    public int getIntRand (int min, int max) throws IllegalArgumentException {
        if (max <= min){
            throw new
                    IllegalArgumentException ("Parâmetros inválidos");
        }
        return (int) (min + getIntRand (max - min));
    }

    public int getIntRand () {
        return (int) getRand ()*Integer.MAX_VALUE;
    }

    public void setSemente (int seed){
        xi = seed;
    }

    public void printSemente (){
        System.out.println (xi);
    }

    @Override
    public String toString () {
        return "Esse é meu objeto Random";
    }
}