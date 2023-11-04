package main;

import main.Clases.Barberia;
import main.Clases.Barbero;
import main.Clases.Cliente;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Barberia barberia = new Barberia();
        new Thread(new Barbero(barberia)).start();
        for (int i=1;true;i++) {
            Thread.sleep(1000);
            new Thread(new Cliente("Cliente: " + i, barberia)).start();
        }
    }
}
