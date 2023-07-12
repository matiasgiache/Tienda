package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;

public final class ProductoDAO extends DAO {

    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe ingresar un producto.");
            }
            String query = "INSERT INTO producto (codigo, nombre, precio, codigo_fabricante) "
                    + "VALUES (" + producto.getCodigo() + ", '" + producto.getNombre() + "', "
                    + producto.getPrecio() + ", " + producto.getCodigo_fabricante() + ");";

            insertarModificarEliminar(query);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarPrecioProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe ingresar un producto.");
            }
            String query = "UPDATE producto SET precio = " + producto.getPrecio()
                    + " WHERE codigo = " + producto.getCodigo() + ";";

            insertarModificarEliminar(query);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarNombreProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe ingresar un producto.");
            }
            String query = "UPDATE producto SET nombre = '" + producto.getNombre()
                    + "' WHERE codigo = " + producto.getCodigo();

            insertarModificarEliminar(query);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarProducto(int codigo) throws Exception {
        try {
            String query = "DELETE FROM producto WHERE codigo = " + codigo;

            insertarModificarEliminar(query);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Producto buscarProductoPorNombre(String nombre) throws Exception {
        try {
            String query = "SELECT * FROM producto WHERE nombre = '" + nombre + "';";

            consultarBase(query);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Producto buscarProductoPorCodigo(int codigo) throws Exception {
        try {
            String query = "SELECT * FROM producto WHERE codigo = " + codigo;

            consultarBase(query);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Producto> listarProductos() throws Exception {
        try {
            String query = "SELECT * FROM producto;";

            consultarBase(query);
            Producto producto = null;
            Collection<Producto> lista = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
                lista.add(producto);
            }
            desconectarBase();
            return lista;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Producto> listarPortatiles() throws Exception {
        try {
            String query = "SELECT * FROM producto WHERE nombre like 'Portátil%';";
            consultarBase(query);
            Producto producto = null;
            Collection<Producto> lista = new ArrayList();
            while (resultado.next()) {
                if (resultado.getString(2).contains("Portátil")) {
                    producto = new Producto();
                    producto.setCodigo(resultado.getInt(1));
                    producto.setNombre(resultado.getString(2));
                    producto.setPrecio(resultado.getDouble(3));
                    producto.setCodigo_fabricante(resultado.getInt(4));
                    lista.add(producto);
                }
            }
            desconectarBase();
            return lista;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
}
