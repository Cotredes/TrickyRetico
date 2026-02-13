import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // 1. CONFIGURACIÓN INICIAL
        Aventurero[] jugadores = new Aventurero[3];
        Tablero mapa = new Tablero(); // Aqui va tu tablero jefe
        boolean juegoTerminado = false;

        // Registro de aventureros
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println("Registro del Aventurero " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nom = teclado.nextLine();
            System.out.print("Tipo (Fuerza, Inteligencia, Destreza, Velocidad): ");
            String tip = teclado.nextLine();

            jugadores[i] = new Aventurero(nom, tip);
        }

        System.out.println("\n--- ¡COMIENZA LA AVENTURA EN EL XTART! ---");

        // 2. BUCLE PRINCIPAL DE TURNOS
        while (juegoTerminado == false) {
            int aventurerosMuertos = 0; // Contador para saber si todos han muerto

            for (int i = 0; i < jugadores.length; i++) {
                Aventurero actual = jugadores[i];

                // Solo juega si está vivo
                if (actual.isVivo() == true) {
                    System.out.println("\n>>> Turno de: " + actual.getNombre() + " (" + actual.getTipo() + ")");

                    // Lanzar dado y mover
                    int resultadoDado = Dado.lanzar();
                    System.out.println("Te ha salido un " + resultadoDado);

                    actual.mover(resultadoDado);
                    System.out.println("📍 Te mueves a la casilla: " + actual.getPosicion());

                    // --- CONEXIÓN CON ÁNGEL ---
                    // Aplicamos el efecto de la casilla donde ha caído
                    mapa.ejecutarCasilla(actual);

                    // Mostramos la salud restante después del evento
                    System.out.println("Tu salud actual es: " + actual.getSalud());

                    // Comprobar si ha ganado
                    if (actual.getPosicion() >= 60) {
                        System.out.println("\n🏆 ¡" + actual.getNombre() + " ha llegado al final y derrotas a Fernando!");
                        System.out.println("¡TESORO CONSEGUIDO!");
                        juegoTerminado = true;
                        break;
                    }
                } else {
                    // Si no está vivo, sumamos uno al contador de bajas
                    aventurerosMuertos++;
                }
            }

            // 3. COMPROBACIÓN TÉCNICA: ¿Han muerto todos?
            if (aventurerosMuertos == jugadores.length) {
                System.out.println("\n💀 Todos los aventureros han muerto en la isla...");
                System.out.println("GAME OVER - Ha ganado DON FERNANDO.");
                juegoTerminado = true;
            }

            // Nota: Aquí iría el Thread.sleep para la pausa de 2 segundos
            // pero como no hemos dado excepciones (try-catch), lo dejamos así.
        }

        teclado.close();
    }
}