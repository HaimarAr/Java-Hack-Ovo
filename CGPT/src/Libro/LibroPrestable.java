package Libro;

class LibroPrestable extends Libro {
	
    private Ejemplar[] ejemplares;

    public LibroPrestable(String titulo, String autor, int anioPublicacion, int numEjemplares) {
        super(titulo, autor, anioPublicacion);
        ejemplares = new Ejemplar[numEjemplares];
        for (int i = 0; i < numEjemplares; i++) {
            ejemplares[i] = new Ejemplar();
        }
    }

    public void prestarEjemplar() {
        for (Ejemplar ejemplar : ejemplares) {
            if (!ejemplar.estaPrestado()) {
                ejemplar.prestar();
                return;
            }
        }
        System.out.println("Todos los ejemplares están prestados");
    }

    public void devolverEjemplar() {
        for (Ejemplar ejemplar : ejemplares) {
            if (ejemplar.estaPrestado()) {
                ejemplar.devolver();
                return;
            }
        }
        System.out.println("No hay ejemplares prestados para devolver");
    }
    
   
}
