package com.nttdata.stepsdefinitions;

import com.nttdata.steps.SauceLabsLoginSteps;
import com.nttdata.support.ScreenshotAttacher;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.es.*;
import org.junit.Assert;
import com.nttdata.screens.AppConfigScreen;

public class SauceLabsStepDefs {

    private final SauceLabsLoginSteps sauceLabsLoginSteps = new SauceLabsLoginSteps();
    private Scenario scenario;

    @Before
    public void configurarScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Dado("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicacionDeSauceLabs() {

        new AppConfigScreen().iniciarAplicacion("saucelabs");
        System.out.println("[SauceLabsStepDefs] Aplicación iniciada correctamente.");
    }

    @Y("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        sauceLabsLoginSteps.validarGaleriaProductos();
        ScreenshotAttacher.attach(scenario, "Galeria de Productos");
    }

    @Cuando("agrego {int} del siguiente producto {string}")
    public void agregoUNIDADESDelSiguienteProducto(int unidades, String producto) {
        sauceLabsLoginSteps.seleccionarProducto(producto);
        sauceLabsLoginSteps.agregarUnidades(unidades);
        ScreenshotAttacher.attach(scenario, "Producto Agregado");
    }

    @Entonces("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        boolean resultado = sauceLabsLoginSteps.validarCarrito();
        Assert.assertTrue("El carrito no se actualizo correctamente", resultado);
        ScreenshotAttacher.attach(scenario, "Carrito Actualizado");
    }
}