Feature: Búsqueda específica por número de carbonos

Scenario: Buscar productos con exactamente 5 carbonos
Given que estoy en la página de búsqueda de fórmulas moleculares
When realizo una búsqueda específica con el número 5
Then los resultados muestran "5" en la columna correspondiente
