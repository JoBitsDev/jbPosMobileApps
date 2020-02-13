package com.controllers;

import com.services.models.InsumoAlmacenModel;
import com.services.web_connections.AlmacenWCS;

import java.util.List;

public class CentroElaboracionController {

    private final AlmacenWCS almWCS;

    public CentroElaboracionController() {
        this.almWCS = new AlmacenWCS(null);
    }

    /**
     * Obtiene todos los productos disponibles con los que se pueden hacer combinacion con su cantidad en 0.
     *
     * @return List<InsumoAlmacenModel> la lista con los productos
     * @throws Exception
     */
    public List<InsumoAlmacenModel> getProductosDisponibles() throws Exception {
        List<InsumoAlmacenModel> lista = almWCS.getPrimerAlmacen();
        for (InsumoAlmacenModel obj : lista) {
            obj.setCantidad(0f);
        }
        return lista;
    }

    /**
     * Obtiene todos los productos con los que se pueden hacer combinacion con su cantidad en 0.
     *
     * @return List<InsumoAlmacenModel> la lista con los productos
     * @throws Exception
     */
    public List<InsumoAlmacenModel> getCombinacionesCon(List<InsumoAlmacenModel> lista) throws Exception {
        return almWCS.getCombinacionesCon(lista);
    }

    private void test() {
        /*new LoadingHandler<List<InsumoAlmacenModel>>(act, new LoadingProcess<List<InsumoAlmacenModel>>() {
            @Override
            public List<InsumoAlmacenModel> process() throws Exception {
                return controller.getCombinacionesCon(lista);
            }

            @Override
            public void post(List<InsumoAlmacenModel> answer) {

            }
        });*/
    }
}
