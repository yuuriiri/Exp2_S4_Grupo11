package gestioninventario.model;

import java.util.HashMap;
import java.util.Scanner;

public class Inventario {

    private final Scanner scanner = new Scanner(System.in);
    private final HashMap<Integer, Producto> productos;

    public Inventario() {
        productos = new HashMap<>();
        productos.put(1, new Producto(1, "Polera Basica Hombre", "Linda polera blanca", 14990, 8));
        productos.put(2, new Producto(2, "Jeans Skinny Mujer", "Lindo Jeans", 39990, 10));
        productos.put(3, new Producto(3, "Chaqueta de Cuero", "Buena chaqueta", 79990, 3));
        productos.put(4, new Producto(4, "Zapatillas Air Max", "Zapatillas deportivas", 89990, 6));
        productos.put(5, new Producto(5, "Vestido Estampado", "Vestido formal lindo", 29990, 12));
        productos.put(6, new Producto(6, "Poleron Oversize", "Poleron de algodon", 34990, 7));
    }

    // Método para agregar productos al inventario 
    public void agregarProducto(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    // Método para ingresar un nuevo producto desde consola
    public void ingresarProducto() {
        System.out.println("\n== AGREGAR PRODUCTO ==");

        System.out.println("\nIngrese el ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (productos.containsKey(id)) {
            System.out.println("\nID ya existe. Intente con otro");
            return;
        }

        System.out.println("\nIngrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.println("\nIngrese la descripcion del producto: ");
        String descripcion = scanner.nextLine();

        System.out.println("\nIngrese el precio del producto: ");
        double precio = scanner.nextDouble();

        System.out.println("\nIngrese el stock del producto: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        Producto nuevo = new Producto(id, nombre, descripcion, precio, stock);
        agregarProducto(nuevo);
    }

    // Método para eliminar un producto por ID
    public void eliminarProducto() {
        System.out.println("\n== ELIMINAR PRODUCTO ==");
        System.out.println("\nIngrese el ID del producto que desea eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Producto eliminado = productos.remove(id);
        if (eliminado != null) {
            System.out.println("Se elimino el producto: " + eliminado);
        } else {
            System.out.println("No se encontro un producto con ID: " + id);
        }
    }

    // Método para actualizar información de un producto
    public void actualizarInformacion() {
        System.out.println("\n== ACTUALIZAR INFORMACION ==");
        System.out.println("\nIngrese el ID del producto que desea actualizar: ");
        int idBuscar = scanner.nextInt();
        scanner.nextLine();

        Producto encontrado = productos.get(idBuscar);
        if (encontrado == null) {
            System.out.println("No se encontro un producto con ID: " + idBuscar);
            return;
        }

        System.out.println("Se encontro el producto: " + encontrado.getNombre());
        System.out.println("---------");
        System.out.println("Que le gustaria actualizar?");
        System.out.println("\n1) Precio\n2) Stock");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1 -> {
                System.out.println("\n-- ACTUALIZAR PRECIO --");
                System.out.println("El precio actual es: $" + encontrado.getPrecio());
                System.out.println("Ingrese el nuevo precio: ");
                double nuevoPrecio = scanner.nextDouble();
                scanner.nextLine();
                encontrado.actualizarPrecio(nuevoPrecio);
                System.out.println("El precio se actualizo correctamente. Nuevo precio: $" + encontrado.getPrecio());
            }
            case 2 -> {
                System.out.println("\n-- ACTUALIZAR STOCK --");
                System.out.println("El stock actual es: " + encontrado.getStock());
                System.out.println("Ingrese el nuevo stock: ");
                int nuevoStock = scanner.nextInt();
                scanner.nextLine();
                encontrado.actualizarStock(nuevoStock);
                System.out.println("El stock se actualizo correctamente. Nuevo stock: " + encontrado.getStock());
            }
            default -> System.out.println("Opcion no valida.");
        }
    }

    // Buscar producto por nombre
    public Producto buscarProductoPorNombre() {
        System.out.println("\n== BUSCAR PRODUCTO POR NOMBRE ==");
        System.out.println("\nIngrese el nombre del producto: ");
        String nombreBuscar = scanner.nextLine();

        for (Producto p : productos.values()) {
            if (p.getNombre().equalsIgnoreCase(nombreBuscar)) {
                System.out.println("Se encontro el producto: " + p);
                return p;
            }
        }

        System.out.println("Producto no encontrado con nombre: " + nombreBuscar);
        return null;
    }

    // Buscar producto por ID
    public Producto buscarProductoPorId() {
        System.out.println("\n== BUSCAR PRODUCTO POR ID ==");
        System.out.println("\nIngrese el id del producto: ");
        int idBuscar = scanner.nextInt();
        scanner.nextLine();

        Producto encontrado = productos.get(idBuscar);
        if (encontrado != null) {
            System.out.println("Se encontro el producto: " + encontrado);
        } else {
            System.out.println("Producto no encontrado con ID: " + idBuscar);
        }

        return encontrado;
    }

    // Generar informe del inventario
    public void generarInforme() {
        System.out.println("\n== PRODUCTOS DISPONIBLES ==");
        for (Producto p : productos.values()) {
            System.out.println(p);
        }
    }
}
