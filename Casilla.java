public abstract class Casilla {
    String nombreEvento;

    public Casilla(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    // Este es el método que usará el Polimorfismo
    public abstract void aplicarEfecto(Aventurero a);
}
