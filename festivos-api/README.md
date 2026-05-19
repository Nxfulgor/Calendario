# API Festivos - Spring Boot

## Descripción

API que consume un servicio externo de festivos y genera un calendario anual clasificando días laborales, festivos y fines de semana.

## Tecnologías

- Java 17 / 21
- Spring Boot
- PostgreSQL

## Endpoints

### Verificar festivo

/api/festivos/verificar/{anio}/{mes}/{dia}

### Obtener festivos

/api/festivos/obtener/{anio}

### Generar calendario

/api/calendario/generar/{anio}

### Obtener calendario

/api/calendario/{anio}

## Ejecución

./mvnw spring-boot:run
