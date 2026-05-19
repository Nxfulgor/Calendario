const express = require("express");
const app = express();

app.use(express.json());

// TODO: Ruta de prueba
app.get("/", (req, res) => {
  res.send("API de festivos funcionando");
});

// TODO: Ruta para insertar los datos automaticamente
app.use("/seed", require("./routes/seedRoutes"));

// TODO: Ruta para verificar si una fecha es festiva
app.use("/festivo", require("./routes/festivoRoutes"));

module.exports = app;
