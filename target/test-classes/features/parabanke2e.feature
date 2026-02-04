Feature: Flujo E2E ParaBank - registro, login, retiro y transferencia

  Scenario: Usuario se registra, inicia sesión, realiza retiro y transfiere fondos
    Given el usuario se registra en ParaBank con datos válidos
    When el usuario inicia sesión con el usuario registrado
    And transfiere "15.6" desde la primera cuenta a la segunda
    Then debe ver mensajes de confirmación para retiro y transferencia