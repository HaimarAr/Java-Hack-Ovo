package Producto;

public class Main {
    public static void main(String[] args) {
        // Crear productos
        Producto producto1 = new Producto(1, "Laptop", 999.99);
        Producto producto2 = new Producto(2, "Teléfono", 499.99);
        Producto producto3 = new Producto(3, "Auriculares", 79.99);

        // Crear un carrito de compras
        CarritoDeCompras carrito = new CarritoDeCompras();

        // Agregar productos al carrito
        carrito.agregarProducto(producto1);
        carrito.agregarProducto(producto2);
        carrito.agregarProducto(producto3);

        // Mostrar productos en el carrito
        carrito.mostrarProductosEnCarrito();

        // Quitar un producto por ID
        carrito.quitarProductoPorId(2);

        // Mostrar productos después de quitar uno
        carrito.mostrarProductosEnCarrito();
    }
}
