# Serenity BDD End-to-End Tests

Este proyecto realiza pruebas **End-to-End (E2E)** utilizando **Serenity BDD** y **Cucumber**. A continuación se explica cómo configurar y ejecutar las pruebas con **Maven**.

## Requisitos Previos

- **Java 17** o superior: Verifica con `java -version`.
- **Maven 3.x**: Verifica con `mvn -v`.
- **WebDriver**: Asegúrate de tener **ChromeDriver** o **FirefoxDriver** configurado en el **PATH**.

## Configuración del Proyecto

### 1. Clona el Proyecto

```bash
git clone <URL_DEL_REPOSITORIO>
cd <NOMBRE_DEL_DIRECTORIO_DEL_REPOSITORIO>
```


### 2. Instalar dependencias

```bash
mvn clean install -U
```

### 3. Ejecutar Pruebas

Para ejecutar las pruebas E2E con Chrome WebDriver:
```bash
mvn clean verify -Ddriver=chrome
```

### 3. Verificar Reportes
Ver Reportes

Los reportes de Serenity se generarán en 
```bash
target/site/serenity/index.html.
```
