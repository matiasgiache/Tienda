package tienda.persistencia;

import tienda.entidades.Fabricante;

public final class FabricanteDAO extends DAO {
    
    public void guardarFabricante(Fabricante fabricante) throws Exception{
        try {
            if (fabricante == null) {
                throw new Exception("Debe ingresar un fabricante.");
            }
            String query = "INSERT INTO fabricante (nombre) VALUE + ('"  + fabricante.getNombre() + "');";
            
            insertarModificarEliminar(query);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    public Fabricante buscarFabricantePorNombre(String nombre) throws Exception {
        try {
            String query = "SELECT * FROM producto WHERE nombre = '" + nombre + "';";

            consultarBase(query);
            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
}
