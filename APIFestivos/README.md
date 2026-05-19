# 🚀 API para validar días festivos en Colombia

Esta API permite validar si una fecha es festiva, no festiva o inválida, incluyendo festivos fijos, por ley de puente y basados en Pascua.

---

## 📦 Tecnologías utilizadas

- Node.js
- Express
- MongoDB
- Docker

---

## ⚙️ Instalación

1. Clonar el repositorio

```bash
git clone https://github.com/Nxfulgor/APIFestivos.git
cd APIFestivos
```

2. Instalar dependencias

```
npm install
```

3. Configurar variables de entorno
   Crear un archivo .env basado en .env-example

```
MONGO_URI=mongodb://usuario:password@localhost:27017/festivos?authSource=admin
PORT=3000
```

4. Levantar base de datos en docker

```
docker-compose up -d
```

5. Ejecutar la aplicación

```
npm run dev
```

o

```
npm start
```

6. Insertar los datos (Seed)

```
http://localhost:3000/seed
```

7. Verificar endpoint principal

```
GET /festivo/:anio/:mes/:dia
```

Ejemplo:

```
GET /festivo/2023/6/12
```
