package main.Clases;

public class Cliente implements Runnable {
    private final String nombre;
    private final Barberia barberia;

    public Cliente(String nombre, Barberia barberia) {
        this.nombre = nombre;
        this.barberia = barberia;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public void run() {
        try {
            barberia.nuevoCliente(this);
            barberia.esperar(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
