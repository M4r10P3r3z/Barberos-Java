package main.Clases;

import java.util.ArrayDeque;
import java.util.Deque;

public class Barberia {
    private final Deque<Cliente> clientes = new ArrayDeque<>();
    private final int MAX_CLIENTES = 5;
    public synchronized void cortarPelo() throws InterruptedException {
        while (clientes.isEmpty()) {
            System.out.println("El peluquero se echa a dormir porque no hay clientes");
            wait();
        }
        System.out.println("El peluquero comienza a cortar el pelo al cliente "
                + clientes.peekFirst().toString());
    }

    public synchronized void finalizarCorte() {
        System.out.println("El cliente " + clientes.pollFirst().toString() + " sale de la barbería");
        notifyAll();
    }

    public synchronized void  nuevoCliente(Cliente cliente) throws InterruptedException {
        System.out.println("Un nuevo cliente " + cliente + " llega a la barbería.");
        if (clientes.size()==MAX_CLIENTES) {
            System.out.println("La barbería está llena. " + cliente + " se va");
        } else {
            System.out.println("Tiene " + clientes.size() + " personas por delante.");
            clientes.addLast(cliente);
        }
    }

    public synchronized void esperar(Cliente cliente) throws InterruptedException {
        while (clientes.size()>1) {
            wait();
            if (!clientes.contains(cliente)) {
                break;
            }
        }
        notify();
    }
}
