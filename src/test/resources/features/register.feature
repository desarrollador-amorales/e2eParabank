Feature: Registro ParaBank (data-driven externo csv)

  Scenario Outline: Registrar usuario desde CSV
    Given el usuario navega a ParaBank
    And carga el usuario "<userId>" desde "features/data/users.csv"
    When el usuario se registra con el usuario cargado
    Then debe ver mensaje de bienvenida de ParaBank

    Examples:
      | userId |
      | U1     |
      | U2     |