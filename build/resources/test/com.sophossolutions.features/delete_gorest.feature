Feature: Automatizacion de Api Rest
  Yo como junior
  Necesito automatizar la ejecucion de una api
  Para aprender a interactuar con los servicios

  Scenario: Eliminar usuario con metodo delete
    Given "Juanchete" establece la base url "https://gorest.co.in/" del servicio
    When se consulta en el endpoint "public-api/users/" el usuario a eliminar por id "3109324"
    Then se valida que el status code sea 200 y el code sea 204