Feature: Login ParaBank (data-driven externo csv)

  Scenario Outline: Login con usuario desde CSV
    Given el usuario navega a ParaBank
    And carga el usuario "<userId>" desde "features/data/users.csv"
    And el usuario ya está registrado con el usuario cargado
    When el usuario inicia sesión con el usuario cargado
    Then debe ver el username en el panel de bienvenida

    Examples:
      | userId |
      | U3     |
