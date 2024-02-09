package Libro;

class Biblioteca {
    private LibroPrestable[] libros;

    public Biblioteca(int numLibros) {
        libros = new LibroPrestable[numLibros];
    }

    public void prestarLibro(String titulo) {
        for (LibroPrestable libro : libros) {
            if (libro != null && libro.getTitulo().equals(titulo)) {
                libro.prestarEjemplar();
                return;
            }
        }
        System.out.println("Libro no encontrado en la biblioteca");
    }

    public void devolverLibro(String titulo) {
        for (LibroPrestable libro : libros) {
            if (libro != null && libro.getTitulo().equals(titulo)) {
                libro.devolverEjemplar();
                return;
            }
        }
        System.out.println("Libro no encontrado en la biblioteca");
    }
    
    public void agregarLibro(LibroPrestable libro) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] == null) {
                libros[i] = libro;
                System.out.println("Libro agregado a la biblioteca: " + libro.getTitulo());
                return;
            }
        }
        System.out.println("La biblioteca está llena, no se puede agregar más libros");
    }
}
