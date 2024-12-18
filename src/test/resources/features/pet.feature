Feature: Validar la creación y consulta de órdenes en la tienda PetStore

  @TestAssertion
  Scenario Outline: Crear una orden en la tienda
    Given que el endpoint de la API de Store está disponible
    When realizo una petición POST a "/store/order" con los datos:
      | id       | <id>     |
      | petId    | <petId>  |
      | quantity | <qty>    |
      | status   | <status> |
    Then el código de respuesta debe ser 200
    And el ID de la orden debe ser "<id>"

    Examples:
      | id   | petId | qty | status   |
      | 1001 | 101   | 2   | placed   |
      | 1002 | 102   | 1   | approved |

  Scenario Outline: Consultar una orden existente
    Given que existe una orden con ID "<orderId>"
    When realizo una petición GET a "/store/order/<orderId>"
    Then el código de respuesta debe ser 200
    And la información debe coincidir:
      | petId    | <petId>  |
      | quantity | <qty>    |
      | status   | <status> |

    Examples:
      | orderId | petId | qty | status   |
      | 1001    | 101   | 2   | placed   |
      | 1002    | 102   | 1   | approved |

