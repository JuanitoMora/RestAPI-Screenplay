Feature: Automatizacion de Api Rest
  Yo como junior
  Necesito automatizar la ejecucion de una api
  Para aprender a interactuar con los servicios

  Scenario: Modificar usuario con metodo patch
    Given "Juanchete" establece la base url "https://gorest.co.in/" del servicio
    When se envia la informacion del usuario a modificar a traves del endpoint "public-api/users/" por id "3109324"
      | name   | Dil Pickles |
      | status | active      |
    Then se valida que el status code sea 200 contenga el nombre "Dil Pickles" y el estatus "active"