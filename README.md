# README

## Descripción del Proyecto

Este proyecto es una aplicación Java orientada a la consulta de información sobre series de televisión utilizando la API pública de OMDb. Permite al usuario buscar una serie, visualizar información de temporadas, episodios y realizar filtrados y análisis estadísticos de los datos obtenidos.

## Estructura de Clases y Métodos

A continuación, se explican las principales clases utilizadas y sus responsabilidades:

### 1. `Principal`

- Clase principal de la aplicación, contiene el método `muestraElMenu()` que es el punto de entrada para la interacción con el usuario.
- Se encarga de coordinar la obtención de datos, su procesamiento y la visualización de resultados en consola.

#### Métodos relevantes:
- **`muestraElMenu()`**: 
    - Solicita al usuario el nombre de una serie.
    - Realiza consultas a la API OMDb para obtener información general y por temporada.
    - Convierte los datos obtenidos en objetos Java.
    - Muestra por consola estadísticas y permite búsquedas filtradas.
    - Ejemplos de operaciones: top 5 episodios por evaluación, filtrado de episodios por fecha, búsqueda por título, promedio de evaluaciones por temporada.

### 2. `ConsumoAPI` (ubicada en `com.aluracursos.screenmatch.service`)

- Encapsula la lógica de conexión y consumo de la API OMDb.
- Permite desacoplar la consulta HTTP del resto de la lógica de negocio.
- Expone al menos el método: 
    - **`obtenerDatos(String url)`**: Devuelve el resultado JSON de la petición.

### 3. `ConvierteDatos` (ubicada en `com.aluracursos.screenmatch.service`)

- Encapsula la lógica de conversión de datos desde JSON hacia objetos Java.
- Promueve reutilización y separación de responsabilidades.
- Expone al menos el método: 
    - **`obtenerDatos(String json, Class<T> clase)`**: Convierte el JSON al objeto de la clase indicada.

### 4. Modelos de Datos

- **`DatosSerie`**: Estructura que representa la información general de la serie (título, cantidad de temporadas, etc).
- **`DatosTemporadas`**: Estructura que representa los datos de cada temporada, incluyendo la lista de episodios.
- **`DatosEpisodio`**: Representa la información de cada episodio individual (título, evaluación, fecha de lanzamiento, etc).
- **`Episodio`**: Clase de dominio para manipular episodios con información adicional y métodos propios, como obtener evaluación, título, fecha, etc.

## Buenas Prácticas Utilizadas

- **Separación de responsabilidades:**  
  Cada clase (servicio, conversor, modelo) tiene una única responsabilidad clara, facilitando la mantenibilidad y escalabilidad.
  
- **Uso de Colecciones Java y Streams:**  
  Se utilizan funcionalidades de la librería estándar como `List`, `Map`, y las APIs Stream para el procesamiento eficiente, filtrado y agrupamiento de datos.

- **Manejo seguro del input del usuario:**  
  El programa utiliza `Scanner` y validaciones para interactuar adecuadamente por consola.

- **Procesamiento funcional:**  
  Uso de operaciones como `filter`, `map`, `collect`, `flatMap`, evitando código repetitivo y permitiendo expresiones declarativas.

- **Encapsulamiento y reutilización:**  
  Métodos como `obtenerDatos` o el uso de objetos modelo promueven la reutilización y el encapsulamiento.

- **Buenas prácticas de nombrado:**  
  Los nombres de clases, variables y métodos son descriptivos y autoexplicativos, siguiendo el estándar camelCase de Java.
  
- **Uso de estadísticas y agrupadores:**  
  Ejemplo con `Collectors.averagingDouble` y `DoubleSummaryStatistics` que facilitan el análisis de datos numéricos.

- **Uso de Optional:**  
  Para búsquedas más seguras evitando posibles `NullPointerException`, por ejemplo en la búsqueda de episodios por título.

- **Documentación y comentarios:**  
  Se incluyen comentarios explicativos que ayudan a comprender el propósito de bloques de código o fragmentos comentados que pueden ser activados según el interés del usuario.

---

## Ejecución

1. Ejecuta la clase `Principal` y sigue las instrucciones en consola.
2. Introduce el nombre de la serie deseada.
3. Explora la información de temporadas, episodios y estadísticas que se despliegan.

---

## Recomendaciones

- Si deseas modificar la fuente de datos o el idioma de la API, revisa la clase `ConsumoAPI`.
- Para extender filtrados o visualizaciones, utiliza las capacidades que Java Streams y las estructuras de datos proveen eficientemente.

---
