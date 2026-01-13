# Demo UI Automation Framework

Este proyecto es un framework de automatización de pruebas UI robusto y escalable, desarrollado en **Java** utilizando **Selenium WebDriver** y **Cucumber (BDD)**, gestionado por **Maven**. Implementa el patrón de diseño **Page Object Model (POM)** separando estrictamente los localizadores de las acciones para facilitar el mantenimiento.

## 📋 Requisitos Previos

Antes de ejecutar las pruebas, asegúrate de tener instalado y configurado lo siguiente en tu sistema:

1.  **Java JDK 17**: El proyecto requiere Java 17.
    *   Verificar versión: `java -version`
2.  **Apache Maven 3.8+**: Para la gestión de dependencias y ejecución de tareas.
    *   Verificar versión: `mvn -version`
3.  **Google Chrome**: Navegador donde se ejecutarán las pruebas (WebDriverManager se encarga de descargar el driver compatible).

## 🚀 Instalación

1.  **Clonar el repositorio** (si aplica) o navegar a la carpeta del proyecto:
    ```bash
    cd demo-ui-automation
    ```

2.  **Descargar dependencias y compilar**:
    ```bash
    mvn clean install -DskipTests
    ```

## ⚙️ Configuración

El archivo de configuración principal se encuentra en:
`src/main/resources/config.properties`

Parámetros configurables:
*   `url`: La URL base de la aplicación (actualmente: `https://mmiguel40.github.io/clima-app/dev/`).
*   `username` / `password`: Credenciales de prueba por defecto.
*   `headless`: Define si el navegador se muestra (`false`) o se ejecuta en segundo plano (`true`).

## ▶️ Ejecución de Pruebas

Puedes ejecutar las pruebas directamente desde la terminal utilizando los siguientes comandos.

### 1. Ejecutar todas las pruebas
Ejecuta todos los escenarios definidos en los archivos `.feature`.
```bash
mvn clean test
```

### 2. Ejecutar por Tags (Escenarios Específicos)
El proyecto utiliza etiquetas (tags) para agrupar funcionalidades.

*   **✅ Login Exitoso**:
    ```bash
    mvn clean test -Dcucumber.filter.tags="@validCredentials"
    ```

*   **🚫 Casos Borde de Login (Credenciales Inválidas)**:
    ```bash
    mvn clean test -Dcucumber.filter.tags="@invalidCredentials"
    ```

*   **🚪 Funcionalidad de Logout**:
    ```bash
    mvn clean test -Dcucumber.filter.tags="@logout"
    ```

*   **🗺️ Búsqueda de Mapas**:
    ```bash
    mvn clean test -Dcucumber.filter.tags="@searchMap"
    ```

*   **Combinación (Ej. Login O Logout)**:
    ```bash
    mvn clean test -Dcucumber.filter.tags="@validCredentials or @logout"
    ```

### 3. Ejecutar un Feature File específico
Si deseas correr solo un archivo de características en particular:
```bash
mvn clean test -Dcucumber.features="src/test/resources/features/Login.feature"
```

## 📊 Reportes Generados

Al finalizar la ejecución, el framework genera reportes detallados automáticamente. Los encontrarás en la carpeta `target/extent-reports/`:

*   **📄 Reporte PDF**: `target/extent-reports/PdfReport.pdf` (Ideal para compartir).
*   **🌐 Reporte HTML (Spark)**: `target/extent-reports/SparkReport.html` (Interactivo).
*   **cucumber-reports**: `target/cucumber-reports.html`.

> **Nota**: Los reportes incluyen capturas de pantalla automáticas después de cada paso para facilitar la depuración.

## 🏗️ Estructura del Proyecto (POM)

El código está organizado para maximizar la mantenibilidad:

*   `src/main/java/.../pages/locators`: **Solo** constantes `By` (IDs, XPaths, CSS). Aquí se definen los elementos.
*   `src/main/java/.../pages/actions`: Clases que usan los *locators* para interactuar con la web (click, sendKeys, etc.).
*   `src/test/java/.../steps`: Definiciones de pasos Cucumber (Given, When, Then) que llaman a las *actions*.
*   `src/test/resources/features`: Archivos Gherkin con los escenarios de prueba en lenguaje natural.

---
*Creado por Anderson Duque*
