package Producto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CarritoDeCompras {
    private List<Producto> productos;

    public CarritoDeCompras() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto agregado al carrito: " + producto.getNombre());
    }

    public void quitarProductoPorId(int id) {
        Iterator<Producto> iterator = productos.iterator();
        while (iterator.hasNext()) {
            Producto producto = iterator.next();
            if (producto.getId() == id) {
                iterator.remove();
                System.out.println("Producto eliminado del carrito: " + producto.getNombre());
                return;
            }
        }
        System.out.println("Producto con ID " + id + " no encontrado en el carrito.");
    }

    public void mostrarProductosEnCarrito() {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Productos en el carrito:");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }
}
