import java.util.Random;
public class Dado {

    public static int lanzar() {
        // Usamos la clase Random de Java para generar el número
        Random random = new Random();

        // .nextInt(6) genera de 0 a 5, por lo que sumamos 1 para que sea de 1 a 6
        return random.nextInt(6) + 1;
    }
}