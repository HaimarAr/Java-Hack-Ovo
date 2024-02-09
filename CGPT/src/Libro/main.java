package Libro;

public class main {
	
    public static void main(String[] args) {
        // Crear instancias de libros, ejemplares y la biblioteca
        LibroPrestable libro1 = new LibroPrestable("Java Programming", "John Doe", 2020, 3);
        LibroPrestable libro2 = new LibroPrestable("Data Structures", "Jane Smith", 2019, 2);
        

        // Crear la biblioteca y agregar libros
        Biblioteca biblioteca = new Biblioteca(2);
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        // Realizar operaciones de préstamo y devolución
        biblioteca.prestarLibro("Java Programming");
        biblioteca.prestarLibro("Data Structures");
        biblioteca.devolverLibro("Java Programming");
        biblioteca.prestarLibro("Java Programming");
    }
}

/*class Dog extends Animal {
void eat() {
    super.eat(); // Llama al método eat de la superclase Animal
    System.out.println("Dog is eating");
}*/