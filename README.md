# backend-postgresql 
Aplicación backend hecha en Spring Boot con validaciones, JPA, Postgresql. De adjunta carpeta `base_datos` donde estan el script sql para creacion de tabla e inserción de datos, asi como también archivo docker compose para levantar contenedor de base de datos.

## Consideraciones
- La aplicación esta seteada para ser compilada por Maven
- En el archivo `src/main/reosurces/application.properties` quedaron en plano los valores para la conexión a la base de datos.
- Se consideran validaciones para el endpoint de creación de puntos de carga.

## Ejecución
- Primero iniciar docker (debe estar instalado) y ejecutar desde la carpeta `base_datos` el siguiente comando `docker compose up -d`. Esto instalara y configurará la base de datos solicitada.
- Luego en el directorio de la aplicación compilar el proyecto de la siguiente manera `mvn clean package`, esto generará una carpeta llamada `target` y dentro un archivo JAR.
- Finalmente, ejecutar archivo JAR con el siguiente comando: `java -jar target/backend-postgresl-0.0.1.jar`