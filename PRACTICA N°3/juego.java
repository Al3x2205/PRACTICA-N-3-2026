import java.util.Scanner;
import java.util.Random;

class Juego {
    protected int numeroDeVidas;
    protected int vidasIniciales;
    protected int record;

    public Juego(int numeroDeVidas) {
        this.numeroDeVidas = numeroDeVidas;
        this.vidasIniciales = numeroDeVidas;
        this.record = 0;
    }

    public void reiniciaPartida() {
        this.numeroDeVidas = this.vidasIniciales;
    }

    public void actualizaRecord() {
        if (this.numeroDeVidas > this.record) {
            this.record = this.numeroDeVidas;
            System.out.println("¡Nuevo récord alcanzado! Récord actual: " + this.record);
        } else {
            System.out.println("Récord actual: " + this.record);
        }
    }

    public boolean quitaVida() {
        this.numeroDeVidas--;
        return this.numeroDeVidas > 0;
    }
}

class JuegoAdivinaNumero extends Juego {
    protected int numeroAAdivinar;

    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    public void juega() {
        reiniciaPartida();
        Random rand = new Random();
        this.numeroAAdivinar = rand.nextInt(11); // Número aleatorio entre 0 y 10
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== INICIANDO JUEGO: ADIVINA UN NÚMERO (0 - 10) ===");

        while (true) {
            System.out.print("Introduce un número entero entre 0 y 10: ");
            int intento = scanner.nextInt();

            if (intento == this.numeroAAdivinar) {
                System.out.println("¡Acertaste!!");
                actualizaRecord();
                break;
            } else {
                boolean leQuedanVidas = quitaVida();
                if (leQuedanVidas) {
                    if (this.numeroAAdivinar > intento) {
                        System.out.println("El número a adivinar es MAYOR.");
                    } else {
                        System.out.println("El número a adivinar es MENOR.");
                    }
                    System.out.println("Te quedan " + this.numeroDeVidas + " vidas.");
                } else {
                    System.out.println("¡Te has quedado sin vidas! El número era: " + this.numeroAAdivinar);
                    break;
                }
            }
        }
    }
}

public class Aplicacion {
    public static void main(String[] args) {
        JuegoAdivinaNumero juego = new JuegoAdivinaNumero(3);
        juego.juega();
    }
}