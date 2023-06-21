Feature: Automatizacion de Api Rest
  Yo como junior
  Necesito automatizar la ejecucion de una api
  Para aprender a interactuar con los servicios

  Scenario Outline: Crear un usuario con metodo Post
    Given "Juanchete" establece la base url "https://gorest.co.in/" del servicio
    When proporciona la informacion del usuario "public-api/users"
      | name   | <name>   |
      | gender | <gender> |
      | email  | <email>  |
      | status | <status> |
    Then valida que la respuesta tenga el nombre "<name>" y el status code sea 200

    Examples:
      | name          | gender | email                  | status |
      | Tommy Pickles | Male   | TommyPickles@falso.com | Active |
