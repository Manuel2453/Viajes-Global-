## Viajes Global
## 🚀 Requerimientos del proyecto

Para ejecutar este proyecto, asegúrate de cumplir con los siguientes requisitos:

- **JDK en Eclipse**: Versión 21.
- **Spring Boot**: Descargar y configurar en **Eclipse**.
  
 **Lo que debes revisar en el application.properties del proyecto una vez importado a Eclipse:**
- **MySQL**: Configurado en **MySQL Workbench**:
  - **Puerto**: 3306 o usa el puerto que tengas configurado en tu servidor MYSQL
  - **Usuario**: `root`o usa el usuario que tengas configurado en tu servidor de MySQL
  - **Contraseña**: `changeme` o usa la contrseña que tengas configurada en tu servidor de MySQL
- **Maven**: Configurado para gestionar las dependencias.

## 🛠️ Instrucciones para la ejecución

### Importar el proyecto en Eclipse:

1. Puedes descargar directamente el proyecto desde nuestro repositorio **https://github.com/Manuel2453/Viajes-Global-.git**  o descomprimir la carpeta comprimida que fue enviada directamente a el cliente.
2. Abre Eclipse.
3. Selecciona `File > Import > Existing Maven Projects`.
4. Navega a la carpeta descomprimida del proyecto y selecciónala.

### Configurar la base de datos MySQL:

1. En el archivo application.properties puedes realizar cambios a las siguientes líneas según lo indicado en el segundo paso
   - spring.datasource.url=jdbc:mysql://localhost:**3306**/electroshopDB
   - spring.datasource.username=**root**
   - spring.datasource.password=**changeme** 
2. Asegúrate de tener **MySQL** ejecutándose en **MySQL Workbench** con:
  - **Puerto**: 3306 o usa el puerto que tengas configurado en tu servidor MYSQL
  - **Usuario**: `root`o usa el usuario que tengas configurado en tu servidor de MySQL
  - **Contraseña**: `changeme` o usa la contrseña que tengas configurada en tu servidor de MySQL
2. Importa el esquema de base de datos `Schema_Taller_Rendimiento.sql` en el editor de script de **MySQL Workbench**.

**Advertencia:** Si existe algún error durante la importación, <u>copia y pega todo el script dentro de un editor de Query de Workbench<u>

### Verificar la compilación:

1. Una vez importado el proyecto en Eclipse, asegúrate de que se haya construido correctamente sin errores.

### Ejecutar la aplicación:

1. Haz clic derecho sobre el proyecto en Eclipse.
2. Selecciona `Run As > Spring Boot App`.

### Acceder a la API:

**Hay dos maneras para que puedas hacer uso de nuestra API:** 
1. Abre tu navegador y accede a `http://localhost:8080/api/swagger-ui/index.html#/` para interactuar con la API con ayuda de Swagger.
2. Alternativamente, puedes usar herramientas como **Postman** para probar los endpoints, sólo debes ingresar la siguiente URL `http://localhost:8080/api/pedidos/procesar`, asegúrate de usar el métodoo POST, de lo contrario, no podrás utilizar la API.

---

## 💻 Tecnologías utilizadas

- **Java 21** - Plataforma base.
- **Spring Boot** - Framework para el desarrollo de la API.
- **MySQL** - Sistema de gestión de bases de datos.
- **Maven** - Gestión de dependencias.

---

## 📄 Hecho por

- **Valentina Becerra Sastoque**  
- **Catalina Sedano**  
- **Manuel Alejandro Terreros**  
