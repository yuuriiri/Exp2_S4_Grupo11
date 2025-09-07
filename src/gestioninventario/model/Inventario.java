package gestioninventario.model;

import java.util.HashMap;
import java.util.Scanner;

public class Inventario {

    private final Scanner scanner = new Scanner(System.in);
    private HashMap<Integer, Producto> productos;

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
    
    public void ingresarProducto() {
         System.out.println("== AGREGAR PRODUCTO ==");
         
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

    // Método para eliminar producto del inventario
    public void eliminarProducto(Producto producto) {
        productos.remove(producto.getId(), producto);
    }

    // Método para buscar productos por nombre en el inventario 
    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto p : productos.values()) {
            if (p.getNombre().equalsIgnoreCase(nombre)){
                return p;
            }
        }
        return null;
    }

    // Método para generar informes del inventario
    public Producto generarInforme(Producto producto) {
        for (Producto p : productos.values()) {
            System.out.println(p);
        }
        return producto;
    }
}
