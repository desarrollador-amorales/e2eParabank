Feature: Transferencia ParaBank (data-driven externo csv)

  Scenario Outline: Transferir fondos usando datasets externos
    Given el usuario navega a ParaBank
    And carga el usuario "<userId>" desde "features/data/users.csv"
    And carga la transferencia "<transferId>" desde "features/data/transfers.csv"
    And el usuario ya está registrado con el usuario cargado
    And el usuario inicia sesión con el usuario cargado
    And el usuario crea una nueva cuenta para poder transferir
    When el usuario transfiere el monto cargado desde la primera cuenta a la segunda
    Then debe ver confirmación de transferencia

    Examples:
      | userId | transferId |
      | U3     | T1         |
      | U6     | T2         |
