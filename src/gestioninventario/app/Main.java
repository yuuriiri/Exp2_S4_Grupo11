package gestioninventario.app;

import gestioninventario.model.Inventario;
import gestioninventario.vista.MenuPrincipal;

public class Main {

    public static void main(String[] args) {
        
        Main app = new Main();
        app.ejecutar();
    }
    
      public void ejecutar() {
            Inventario inventario = new Inventario(); 
            MenuPrincipal menuPrincipal = new MenuPrincipal(inventario);
            menuPrincipal.menuInteractivo();
        }
}
