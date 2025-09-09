package gestioninventario.model;

public class Producto { 

    // Atributos
    private int id; 
    private String nombre;
    private String descripcion; 
    private double precio; 
    private int stock; 

    // Constructor
    public Producto(int id, String nombre, String descripcion, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters
    public int getId() { return id; }

    public String getNombre() { return nombre; }

    public String getDescripcion() { return descripcion; }

    public double getPrecio() { return precio; }

    public int getStock() { return stock; }

    // Setters
    public void setId(int id) { this.id = id; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public void setPrecio(double precio) { this.precio = precio; }

    public void setStock(int stock) { this.stock = stock; }

    // Método para actualizar el precio del producto 
    public void actualizarPrecio(double nuevoPrecio) { this.precio = nuevoPrecio; }
    
    // Método para actualizar el stock del producto
    public void actualizarStock(int nuevoStock) { this.stock = nuevoStock; }

    // Método para descripción detallada del producto 
    @Override
    public String toString(){
        return "ID: " + id + 
               " | NOMBRE: " + nombre +
               " | PRECIO: $" + precio + 
               " | DESCRIPCION: " + descripcion +
               " | STOCK: " + stock; 
    }
} 
