Feature: Automatizacion de Api Rest
  Yo como junior
  Necesito automatizar la ejecucion de una api
  Para aprender a interactuar con los servicios

  Scenario: Consultar informacion de usuario
    Given "Juanito" establece la base url "https://gorest.co.in/" del servicio
    When consulta en el endpoint "public-api/users/" por id "3109324"
    Then valida que el status code sea 200 y la respuesta contenga el nombre "Tommy Pickles"