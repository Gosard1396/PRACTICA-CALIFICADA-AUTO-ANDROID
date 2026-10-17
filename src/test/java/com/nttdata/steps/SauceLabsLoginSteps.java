package com.nttdata.steps;

import com.nttdata.screens.SauceLabsLoginScreen;

/**
 * Steps para la navegación y flujo de compras en Sauce Labs.
 */
public class SauceLabsLoginSteps {

    private final SauceLabsLoginScreen screen = new SauceLabsLoginScreen();

    public void validarGaleriaProductos() {
        screen.validarGaleria();
    }

    public void seleccionarProducto(String producto) {
        screen.seleccionarProducto(producto);
    }

    public void agregarUnidades(int unidades) {
        screen.agregarUnidades(unidades);
    }

    public boolean validarCarrito() {
        return screen.validarCarritoActualizado();
    }
}