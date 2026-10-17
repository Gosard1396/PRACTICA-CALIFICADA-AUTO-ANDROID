package com.nttdata.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static com.nttdata.screens.AppConfigScreen.getDriver;


public class SauceLabsLoginScreen {

    private static final Duration TIMEOUT = Duration.ofSeconds(20);

    // Localizadores de la aplicación My Demo App
    private final By tituloCatalogo = AppiumBy.accessibilityId("test-Catalog");
    private final By btnPlus = AppiumBy.accessibilityId("test-Increase item quantity");
    private final By btnAddToCart = AppiumBy.accessibilityId("test-Add To Cart");
    private final By badgeCarrito = AppiumBy.accessibilityId("test-Cart number");

    public void validarGaleria() {
        AndroidDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement catalogo = wait.until(ExpectedConditions.presenceOfElementLocated(tituloCatalogo));
        System.out.println("[SauceLabsLoginScreen] Galería de productos visible: " + catalogo.isDisplayed());
    }

    public void seleccionarProducto(String producto) {
        AndroidDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

        // Declaración del localizador dinámico
        By lblProducto = By.xpath("//android.widget.TextView[@text='" + producto + "']");

        WebElement elProducto = wait.until(ExpectedConditions.elementToBeClickable(lblProducto));
        elProducto.click();
        System.out.println("[SauceLabsLoginScreen] Producto seleccionado: " + producto);
    }

    public void agregarUnidades(int unidades) {
        AndroidDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

        // Si se requieren más de 1 unidad, aumentamos con el botón '+'
        for (int i = 1; i < unidades; i++) {
            WebElement masBtn = wait.until(ExpectedConditions.elementToBeClickable(btnPlus));
            masBtn.click();
        }

        // Hacemos clic en Agregar al Carrito
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart));
        addBtn.click();
        System.out.println("[SauceLabsLoginScreen] Se agregaron " + unidades + " unidades al carrito.");
    }

    public boolean validarCarritoActualizado() {
        AndroidDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement badge = wait.until(ExpectedConditions.presenceOfElementLocated(badgeCarrito));
        String cantidad = badge.getText();
        System.out.println("[SauceLabsLoginScreen] Cantidad detectada en el carrito: " + cantidad);
        return !cantidad.isEmpty() && Integer.parseInt(cantidad) > 0;
    }
}