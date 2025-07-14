Feature: Búsqueda simple de fórmulas moleculares

  Como usuario del sistema de búsqueda,
  quiero ingresar una cadena en el campo de búsqueda
  para ver fórmulas moleculares que la contengan

  Scenario: Buscar fórmulas que contengan la cadena C7
    Given que estoy en la página de búsqueda de fórmulas moleculares
    When realizo la búsqueda con la cadena "C7"
    And espero a que se actualice la tabla de resultados
    Then la tabla muestra fórmulas que contienen la cadena "C7"
    And la fórmula "C7H8N4O2" aparece en los resultados
