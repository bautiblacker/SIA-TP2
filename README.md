## TP2: Algoritmos Geneticos
_Aplicación de diferentes metodos de seleccion, cruza, mutacion y reemplazo para encontrar el jugador mas optimo_.

### Pre-requisitos
Al ejecutable se le necesita pasar como parámetro por linea de comando un archivo json con las configuraciones asi como tomabien un directorio con los diferentes datasets. El archivo debe cumplir con el siguiente formato:
```
{
  "MAX_LINES": (Integer) Number of lines in datasets files
  "PLAYER_TYPE": ("WARRIOR" | "ARCHER" | "INSIDER" | "DEFENDER"),
  "POPULATION": (Integer) numero positivo que reprensenta el tamaño de la poblacion (N),
  "SELECTION_LIMIT": (Integer) numero positivo que reprenta la cantidad a seleccionar (K),

  "MUTATION": ("COMPLETE" | "GEN" | "LIMITEDMULTIGEN" | "UNIFORMMULTIGEN"),
  "MUTATION_PROB": (Double) numero entre 0 y 1 que reprenta la probabilidad de mutacion,
  "LIMITED_MULTIGEN_M": (Integer) numero entero mayor a 0 que reprenseta el indice hasta el cual se puede mutar,

  "CROSSOVER": ( "SINGLEPOINT" | "TWOPOINTS" | "ANNULAR" | "UNIFORM"),
  "CROSSOVER_PROB": (Double) probabilidad entre 0 y 1 de cruzar dos genes,
  "UNIFORM_THRESHOLD": Parametro especifico para la cruza uniforme. Valor entre 0 y 1,

  "SELECTION_METHOD_A": ( "ELITE" | "ROULETTE" | "UNIVERSAL" | "BOLTZMANN" | "TOURNAMENTDET" | "TOURNAMENTPROB" | "RANKING" ) Metodos de seleccion,
  "SELECTION_METHOD_B": ( "ELITE" | "ROULETTE" | "UNIVERSAL" | "BOLTZMANN" | "TOURNAMENTDET" | "TOURNAMENTPROB" | "RANKING" ) Metodos de seleccion,
  "SELECTION_METHOD_PROB": (Double) Porcentaje que se aplica en la seleccion de padres siguiendo la siguiente regla: a*(metodo1) + (1-a)*(metodo2).

  "REPLACEMENT_METHOD_A": ( "ELITE" | "ROULETTE" | "UNIVERSAL" | "BOLTZMANN" | "TOURNAMENTDET" | "TOURNAMENTPROB" | "RANKING" ) Metodos de seleccion,
  "REPLACEMENT_METHOD_B": ( "ELITE" | "ROULETTE" | "UNIVERSAL" | "BOLTZMANN" | "TOURNAMENTDET" | "TOURNAMENTPROB" | "RANKING" ) Metodos de seleccion,
  "REPLACEMENT_METHOD_PROB": (Double) Porcentaje que se aplica en la seleccion de padres siguiendo la siguiente regla: b*(metodo3) + (1-b)*(metodo4),

  "TOURNAMENT_PROB_THRESHOLD":(Double) numero entre 0 y 1 que reprenta la probabilidad de seleccion para el metodo de seleccion Torneo Probabilistico,
  "TOURNAMENT_DET_M": (Integer) numero natural que representa el tamaño de la ventana para el metodo de seleccion Torneo Deterministico,

  "BOLTZMANN_T0": (Double) Temperatura inicial para el metodo de Boltzmann,
  "BOLTZMANN_TK": (Double) Temperatura base para el metodo de Boltzmann,

  "IMPLEMENTATION_METHOD": ("FILLALL" | "FILLPARENTS") Metodos de Implementaciones. Seleccionan a los sobrevivientes,

  "CRITERIA": ( "GENERATIONS" | "TIMEOUT" | "ACCEPTABLE_SOLUTION" | "CONTENT" | "STRUCTURE") Criterios de corte,
  "CRITERIA_PARAM": (Number) Es el parametro para que el criterio de corte justamente, corte. 
                    - GENERATIONS seria la cantidad de generaciones limite.
                    - TIMEOUT el tiempo en milisegundos
                    - ACCEPTABLE_SOLUTIONS el fitness aceptado como respuesta
                    - CONTENT marca la cantidad de generaciones por la que un fitness se mantiene
                    - STRUCTURE es la cantidad de generaciones por la cual un gran porcentaje de la poblacion no presento cambios.
  "STRUCTURE_PERCENTAGE": (Double) El porcentaje elegido por el cual esa gran porcentaje de la poblacion no presente cambios. Aplicable solo para STRUCTURE.
}
```
Descargar archivo de ejemplo en: https://github.com/bautiblacker/SIA-TP2/ . 

## Ejecución
Correr la siguiente linea en la terminal
```
Java -jar TP1.jar [path config] [path directiorio datasets]
```
## Analizando resultados
Luego de una exitosa ejecucion, le deberia aparecer algo similar a:
```
Warrior: 32.65798
```

## Autores
* Ignacio Grasso - [igrasso](https://github.com/igrasso98)
* Bautista Blacker - [bblacker](https://github.com/bautiblacker)

