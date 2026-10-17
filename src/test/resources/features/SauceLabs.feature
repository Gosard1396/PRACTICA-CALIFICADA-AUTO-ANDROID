# language: es
@saucelabs
Característica: Validación del carrito de compras en SauceLabs

  Esquema del escenario: Agregar productos al carrito y validar la actualización
    Dado estoy en la aplicación de SauceLabs
    Y valido que carguen correctamente los productos en la galeria
    Cuando agrego <UNIDADES> del siguiente producto "<PRODUCTO>"
    Entonces valido el carrito de compra actualice correctamente

    Ejemplos:
      | PRODUCTO                 | UNIDADES |
      | Sauce Labs Backpack      | 1        |
      | Sauce Labs Bolt - TShirt | 1        |
      | Sauce Labs Bike Light    | 2        |