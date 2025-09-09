package gestioninventario.vista;

import gestioninventario.model.Inventario;
import gestioninventario.model.Producto;
import java.util.Scanner;

public class MenuPrincipal {

    private final Scanner scanner = new Scanner(System.in);
    private final Inventario inventario;

    public MenuPrincipal(Inventario inventario) {
        this.inventario = inventario;
    }

    public void menuInteractivo() {
        int opcionMenu = -1;
        System.out.println("..:: Bienvenido a nuestra Tienda! ::..");

        do {
            mostrarMenu();
            if (scanner.hasNextInt()) {
                opcionMenu = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer

                switch (opcionMenu) {
                    case 0 ->
                        ejecutarPruebasManual();
                    case 1 ->
                        inventario.generarInforme();
                    case 2 ->
                        inventario.ingresarProducto();
                    case 3 ->
                        inventario.eliminarProducto();
                    case 4 ->
                        inventario.actualizarInformacion();
                    case 5 -> {
                        Producto encontrado = inventario.buscarProductoPorNombre();
                        if (encontrado == null) {
                            System.out.println("Producto no encontrado.");
                        }
                    }
                    case 6 -> {
                        Producto encontrado = inventario.buscarProductoPorId();
                        if (encontrado == null) {
                            System.out.println("Producto no encontrado.");
                        }
                    }
                    case 7 ->
                        System.out.println("Saliendo del sistema...");
                    default ->
                        System.out.println("Opcion no valida.");
                }
            } else {
                System.out.println("Entrada no valida. Ingrese un numero.");
                scanner.nextLine();
            }
        } while (opcionMenu != 7);
    }

    private void mostrarMenu() {
        String[] opcionesMenu = {
            "------------------------",
            "1) Mostrar productos disponibles.",
            "2) Agregar productos.",
            "3) Eliminar productos.",
            "4) Actualizar informacion de producto.",
            "5) Buscar productos por Nombre.",
            "6) Buscar productos por ID.",
            "7) Salir del programa.",
            "------------------------"
        };

        for (String opcion : opcionesMenu) {
            System.out.println(opcion);
        }
    }

    private void ejecutarPruebasManual() {
        System.out.println("\n== INICIANDO PRUEBAS MANUALES ==");

        // 1) Crear un producto
        Producto p = new Producto(100, "Traje de banio Test", "Prueba", 500.0, 10);
        System.out.println("Producto creado: " + p);

        // 2) Actualizar precio
        p.actualizarPrecio(550.0);
        System.out.println("Precio actualizado: " + p.getPrecio());

        // 3) Actualizar stock
        p.actualizarStock(15);
        System.out.println("Stock actualizado: " + p.getStock());

        // 4) Agregar al inventario
        inventario.agregarProducto(p);
        System.out.println("Inventario despues de agregar:");
        inventario.generarInforme();

        // 5) Buscar por ID
        Producto buscado = inventario.buscarProductoPorId();
        System.out.println("Producto buscado por ID: " + buscado);

        // 6) Buscar por nombre
        Producto buscadoPorNombre = inventario.buscarProductoPorNombre();
        System.out.println("Producto buscado por nombre: " + buscadoPorNombre);

        // 7) Eliminar producto
        inventario.eliminarProducto();
        System.out.println("Inventario despues de eliminar:");
        inventario.generarInforme();

        System.out.println("== PRUEBAS MANUALES FINALIZADAS ==");
    }
}
