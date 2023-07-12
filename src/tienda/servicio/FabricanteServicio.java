package tienda.servicio;

import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

/**
 *
 * @author matia
 */
public class FabricanteServicio {
    
    private FabricanteDAO dao;

    public FabricanteServicio() {
        this.dao = new FabricanteDAO();
    }
    
    public void ingresarFabricante(String nombre) throws Exception{
        try {
            if (dao.buscarFabricantePorNombre(nombre) != null) {
                throw new Exception("Ya hay un fabricante con el nombre indicado.");
            }
            Fabricante fab = new Fabricante();
            fab.setNombre(nombre);
            dao.guardarFabricante(fab);
        } catch (Exception e) {
            throw e;
        }
    }
}
