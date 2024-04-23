# backend-postgresql" 
Aplicación backend hecha en Spring Boot con validaciones, JPA, Postgresql. De adjunta carpeta `base_datos` donde estan el script sql para creacion de tabla e inserción de datos, asi como también archivo docker compose para levantar contenedor de base de datos.

## Consideraciones
- La aplicación esta seteada para ser compilada por Maven
- En el archivo `src/main/reosurces/application.properties` quedaron en plano los valores para la conexión a la base de datos.
- Se consideran validaciones para el endpoint de creación de puntos de carga.