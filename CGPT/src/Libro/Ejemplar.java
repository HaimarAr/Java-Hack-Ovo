package Libro;

class Ejemplar implements Prestable {
    private boolean prestado;

    @Override
    public void prestar() {
        if (!prestado) {
            prestado = true;
            System.out.println("Ejemplar prestado");
        } else {
            System.out.println("Ejemplar no disponible");
        }
    }

    @Override
    public void devolver() {
        if (prestado) {
            prestado = false;
            System.out.println("Ejemplar devuelto");
        } else {
            System.out.println("El ejemplar no estaba prestado");
        }
    }

    public boolean estaPrestado() {
        return prestado;
    }
}