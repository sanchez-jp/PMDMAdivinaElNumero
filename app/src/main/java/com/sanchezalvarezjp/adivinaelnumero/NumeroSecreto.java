package com.sanchezalvarezjp.adivinaelnumero;

import java.util.Random;

/**
 * Created by alumno on 22/09/2017.
 */

public class NumeroSecreto {
    int numero;

    public NumeroSecreto() {
        numero =new Random().nextInt(10)+1;
    }

    public int getNumero() {
        return numero;
    }

    public boolean checkNumber(int numero){
        return numero == this.numero;
    }
}
