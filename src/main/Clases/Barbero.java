package main.Clases;

public class Barbero implements Runnable {
    private final Barberia barberia;

    public Barbero(Barberia barberia) {
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {
            try {
                barberia.cortarPelo();
                Thread.sleep(5000);
                barberia.finalizarCorte();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
