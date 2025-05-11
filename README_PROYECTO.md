# 📚 Sistema de Gestión de Biblioteca

Este proyecto implementa un sistema de gestión de biblioteca utilizando **Spring Boot**, aplicando una arquitectura en capas y los principios **SOLID**. Permite administrar libros, usuarios y préstamos, todo utilizando una base de datos en memoria (sin persistencia real).

---

## 🛠️ Tecnologías Utilizadas

- Java 21
- Spring Boot 3.3.11
- Maven
- JUnit 5.10.1
- Mockito 5.8.0
- Spring Web
- Spring Test
- Lombok (opcional)

---

## ⚙️ Requisitos del Sistema

- Java 21 o superior
- Maven 3.9.0 o superior

---

## 🚀 Instrucciones de Instalación y Ejecución

1. Clonar el repositorio:

```bash
git clone https://github.com/usuario/sistema-biblioteca.git
cd sistema-biblioteca
```

2. Ejecutar la aplicación:

```bash
./mvnw spring-boot:run
```

La API REST estará disponible en: [http://localhost:8080](http://localhost:8080)

3. Ejecutar los tests:

```bash
./mvnw test
```

---

## 📦 Estructura del Proyecto

```
src/
├── main/
│   └── java/
│       └── com.biblioteca.sistema_biblioteca/
│           ├── controller/   # Controladores REST
│           ├── model/        # Clases de dominio (Libro, Usuario, Prestamo)
│           ├── repository/   # Repositorios en memoria
│           └── service/      # Lógica de negocio
└── test/
    └── java/
        └── com.biblioteca.sistema_biblioteca/
            ├── controller/   # Tests de controladores con MockMvc
            ├── repository/   # Tests unitarios de repositorios
            └── service/      # Tests de lógica de negocio
```

---

## 🔗 Endpoints Disponibles

### 📘 Libros

| Método | Endpoint           | Descripción             |
|--------|--------------------|-------------------------|
| GET    | `/api/libros`      | Listar todos los libros |
| GET    | `/api/libros/{id}` | Obtener libro por ID    |
| POST   | `/api/libros`      | Crear un nuevo libro    |
| PUT    | `/api/libros/{id}` | Actualizar libro        |
| DELETE | `/api/libros/{id}` | Eliminar libro          |

### 👤 Usuarios

| Método | Endpoint              | Descripción             |
|--------|-----------------------|-------------------------|
| GET    | `/api/usuarios`       | Listar todos los usuarios |
| GET    | `/api/usuarios/{id}`  | Obtener usuario por ID  |
| POST   | `/api/usuarios`       | Crear un nuevo usuario  |
| PUT    | `/api/usuarios/{id}`  | Actualizar usuario      |
| DELETE | `/api/usuarios/{id}`  | Eliminar usuario        |

### 🔁 Préstamos

| Método | Endpoint               | Descripción               |
|--------|------------------------|---------------------------|
| GET    | `/api/prestamos`       | Listar todos los préstamos |
| GET    | `/api/prestamos/{id}`  | Obtener préstamo por ID   |
| POST   | `/api/prestamos`       | Registrar nuevo préstamo  |
| PUT    | `/api/prestamos/{id}`  | Actualizar préstamo       |
| DELETE | `/api/prestamos/{id}`  | Eliminar préstamo         |

---

## 🧪 Estado de los Tests

```bash
./mvnw test
```

- ✅ 19 tests ejecutados
- ✅ 0 errores / 0 fallos
- 💯 Cobertura sobre servicios, repositorios y controladores
- ✔️ Tests automatizados con JUnit 5 y Mockito

---

## 🧱 Decisiones de Diseño

- Arquitectura basada en capas (`controller`, `service`, `repository`, `model`)
- Aplicación estricta de los principios SOLID:
  - SRP: Cada clase tiene una única responsabilidad
  - DIP/ISP: Interfaces separadas para lógica y acceso a datos
- Repositorios en memoria con `Map<Long, T>`
- Tests organizados por paquete: servicios, repositorios y controladores
- Controladores REST documentados y probados con `MockMvc`

---

## 📝 Licencia

Proyecto con fines educativos para el **Trabajo Práctico N°4 - Programación II**  
Facultad de Ingeniería en Informática – Universidad
