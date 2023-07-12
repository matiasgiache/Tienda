package tienda.servicio;

import java.util.Collection;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class ProductoServicio {

    private ProductoDAO dao;

    public ProductoServicio() {
        this.dao = new ProductoDAO();
    }

    public void crearProducto(String nombre, double precio, int codigo_fabricante) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Tiene que indicar un nombre para el producto.");
            }
            if (precio <= 0) {
                throw new Exception("El precio no puede ser menor que 0.");
            }
            if (codigo_fabricante <= 0) {
                throw new Exception("El codigo de fabricante no puede ser 0 o menor.");
            }
            if (buscarProductoPorNombre(nombre) != null) {
                throw new Exception("Ya existe un producto con el nombre ingresado.");
            }
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigo_fabricante(codigo_fabricante);

            dao.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarPrecioProducto(String nombre, double precioNuevo) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Tiene que indicar un nombre para el producto.");
            }
            if (precioNuevo <= 0) {
                throw new Exception("El precio no puede ser menor que 0.");
            }

            Producto producto = dao.buscarProductoPorNombre(nombre);
            producto.setPrecio(precioNuevo);

            dao.modificarPrecioProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarNombreProducto(String nombreActual, String nombreNuevo) throws Exception {
        try {
            if (nombreActual == null || nombreActual.trim().isEmpty()) {
                throw new Exception("Tiene que indicar un nombre para el producto.");
            }
            if (nombreNuevo == null || nombreNuevo.trim().isEmpty()) {
                throw new Exception("Tiene que indicar un nombre para el producto.");
            }

            Producto producto = dao.buscarProductoPorNombre(nombreActual);
            producto.setNombre(nombreNuevo);

            dao.modificarNombreProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarProducto(int codigo) throws Exception{
        try {
            if (codigo <= 0) {
                throw new Exception("El codigo del producto no puede ser 0 o negativo.");
            }
            dao.eliminarProducto(codigo);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Producto buscarProductoPorNombre(String nombre) throws Exception{
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Tiene que indicar un nombre para el producto.");
            }
            Producto producto = dao.buscarProductoPorNombre(nombre);
            return producto;
        } catch (Exception e) {
            throw e;
        }
    }
    public Producto buscarProductoPorCodigo(int codigo) throws Exception{
        try {
            if (codigo <= 0) {
                throw new Exception("El codigo del producto no puede ser 0 o negativo.");
            }
            Producto producto = dao.buscarProductoPorCodigo(codigo);
            return producto;
        } catch (Exception e) {
            throw e;
        }
    }
    public void listarProductosPorPrecio(){
        try {
            Collection<Producto> prods = listarProductos();
            if (prods.isEmpty()) {
                throw new Exception("No hay nada que mostrar.");
            }else{
                for (Producto p : prods) {
                    if (p.getPrecio() > 120d && p.getPrecio()<= 202d) {
                        System.out.println(p);
                    }
                }
            }
        } catch (Exception e) {
        }
    }
    public Collection<Producto> listarProductos() throws Exception{
        try {
            Collection<Producto> productos = dao.listarProductos();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    public void imprimirPortatiles() throws Exception{
        try {
            Collection<Producto> prods = dao.listarPortatiles();
            if (prods.isEmpty()) {
                throw new Exception("No hay nada que mostrar.");
            }else{
                for (Producto prod : prods) {
                    System.out.println(prod);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public void imprmirMasBarato() throws Exception{
        try {
            Collection<Producto> prods = dao.listarProductos();
            Producto barato = new Producto();
            barato.setPrecio(100000000d);
            for (Producto p : prods) {
                if (p.getPrecio()< barato.getPrecio()) {
                    barato = p;
                }
            }
            System.out.println(barato);
        } catch (Exception e) {
            throw e;
        }
    }
    public void imprimirNombres() throws Exception{
        try {
            Collection<Producto> productos = listarProductos();
            if (productos.isEmpty()) {
                throw new Exception("No hay productos para imprimir.");
            }else{
                for (Producto p : productos) {
                    System.out.println(p.getNombre());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public void imprimirNombresyPrecios() throws Exception{
        try {
            Collection<Producto> prods = listarProductos();
            if (prods.isEmpty()) {
                throw new Exception("No hay nada que mostrar.");
            }else{
                for (Producto prod : prods) {
                    System.out.println("Nombre: " + prod.getNombre() + " Precio: " + prod.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public void imprimirProductos() throws Exception{
        try {
            Collection<Producto> productos = listarProductos();
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
