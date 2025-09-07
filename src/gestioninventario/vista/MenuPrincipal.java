package gestioninventario.vista;

import gestioninventario.model.Inventario;
import gestioninventario.model.Producto;
import java.util.Scanner;

public class MenuPrincipal {

    private final Scanner scanner = new Scanner(System.in);
    private final Inventario inventario;
    private final Producto producto = null;

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
                scanner.nextLine();

                switch (opcionMenu) {
                    case 1 -> {
                        inventario.generarInforme(producto);
                    }
                    case 2 -> {
                        inventario.ingresarProducto();
                    }
                    case 3 -> {
                        
                    }
                    case 4 -> {
                        
                    }
                    case 5 -> {
                        System.out.println("Saliendo del sistema...");
                    }
                    default ->
                        System.out.println("Opcion no valida.");
                }
            } else {
                System.out.println("Entrada no valida. Ingrese un numero.");
                scanner.nextLine();
            }
        } while (opcionMenu != 5);
    }

    public void mostrarMenu() {
        for (int i = 0; i < opcionesMenu.length; i++) {
            System.out.println(opcionesMenu[i]);
        }
    }

    static String[] opcionesMenu = {
        "------------------------",
        "1) Mostrar productos disponibles.",
        "2) Agregar productos.",
        "3) Eliminar productos.",
        "4) Buscar productos por ID.",
        "5) Salir del programa.",
        "------------------------",};
}
