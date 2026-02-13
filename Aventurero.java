public class Aventurero {

    private String nombre;
    private String tipo; // Fuerza, Inteligencia, Destreza, Velocidad
    private int salud;
    private int posicion;
    private boolean vivo;

    public Aventurero(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.salud = 50;  // Salud inicial fija
        this.posicion = 1; // Empiezan en la casilla 1
        this.vivo = true;
    }

    public void modificarSalud(int cantidad) {
        this.salud += cantidad;
        if (cantidad > 0) {
            System.out.println("💖 " + nombre + " recupera " + cantidad + " de vida.");
        } else if (cantidad < 0) {
            System.out.println("💥 " + nombre + " pierde " + Math.abs(cantidad) + " de vida.");
        }

        if (this.salud <= 0) {
            this.salud = 0;
            this.vivo = false;
            System.out.println("💀 " + nombre + " ha muerto en la jungla..."); [cite: 104]
        }
    }

    // Para movimientos relativos (+2, -3)
    public void mover(int casillas) {
        this.posicion += casillas;
        if (this.posicion < 1) this.posicion = 1;
    }

    // Para movimientos directos (ir a la casilla N)
    public void setPosicion(int nuevaPosicion) {
        this.posicion = nuevaPosicion;
        if (this.posicion < 1) this.posicion = 1;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getSalud() { return salud; }
    public int getPosicion() { return posicion; }
    public boolean isVivo() { return vivo; }
}