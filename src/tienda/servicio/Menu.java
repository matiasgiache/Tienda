package tienda.servicio;

import java.util.Scanner;

/**
 *
 * @author matia
 */
public class Menu {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    public void Menu() throws Exception{
        String opcion = "N";
        ProductoServicio proSer = new ProductoServicio();
        FabricanteServicio fabSer = new FabricanteServicio();
        System.out.println("Bienvenido...");
        while (!"S".equals(opcion)) {            
            System.out.println("Indique la opcion a ejecutar: ");
            System.out.println("A. Listar el nombre de todos los productos.");
            System.out.println("B. Lista nombre y precios de todos los productos.");
            System.out.println("C. Listar productos cuyo precio este entre 120 y 202.");
            System.out.println("D. Buscar y Listar todos los 'Portatiles' de entre los productos.");
            System.out.println("E. Mostrar nombre y precio del producto mas barato.");
            System.out.println("F. Ingresar un producto a la base de datos.");
            System.out.println("G. Ingresar un fabricante a la base de datos.");
            System.out.println("H. Editar un producto.");
            System.out.println("S. Salir.");
            opcion = leer.next().toUpperCase();
            
            switch (opcion) {
                case "A":
                    System.out.println("Mostrando todos los nombres: ");
                    proSer.imprimirNombres();
                    System.out.println("");
                    break;
                case "B":
                    System.out.println("Mostrando nombres y precios.");
                    proSer.imprimirNombresyPrecios();
                    System.out.println("");
                    break;
                case "C":
                    System.out.println("Mostrando los productos cuyo precio esta entre 120 y 202");
                    proSer.listarProductosPorPrecio();
                    System.out.println("");
                    break;
                case "D":
                    System.out.println("Mostrando los protatiles de entre todos los productos:");
                    proSer.imprimirPortatiles();
                    System.out.println("");
                    break;
                case "E":
                    System.out.println("Mostrando el producto mas barato:");
                    proSer.imprmirMasBarato();
                    System.out.println("");
                    break;
                case "F":
                    System.out.println("Ingresando un producto a la base de datos... ");
                    System.out.println("Ingrese el nombre del producto:");
                    String nombre = leer.next();
                    System.out.println("Ingrese el precio del producto: ");
                    double precio = leer.nextDouble();
                    System.out.println("Ingrese el codigo del fabricante: ");
                    int codigo_fabricante = leer.nextInt();
                    proSer.crearProducto(nombre, precio, codigo_fabricante);
                    System.out.println("Producto ingresado.");
                    System.out.println("");
                    break;
                case "G":
                    System.out.println("Ingresando un nuevo fabricante...");
                    System.out.println("Ingrese el nombre del fabricante: ");
                    fabSer.ingresarFabricante(leer.next());
                    System.out.println("Fabricante ingresado.");
                    System.out.println("");
                    break;
                case "H":
                    System.out.println("Indique el nombre del producto que desea modificar: ");
                    String nombre1 = leer.next();
                    System.out.println("Ingrese el nuevo precio del producto: ");
                    proSer.modificarPrecioProducto(nombre1, leer.nextDouble());
                    System.out.println("Producto modificado.");
                    System.out.println("");
                    break;
                case "S":
                    System.out.println("Saliendo...");
                    break;
            }
        }
    }
}
