const express = require("express");
const router = express.Router();
const { verificarFestivo } = require("../controllers/festivoController");

router.get("/:anio/:mes/:dia", verificarFestivo);

module.exports = router;
