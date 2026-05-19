// TODO: importacion de las validación
const { esFestivo, esFechaValida } = require("../services/festivoService");

const verificarFestivo = async (req, res) => {
  const { anio, mes, dia } = req.params;

  if (!esFechaValida(+dia, +mes, +anio)) {
    return res.status(400).json({
      fecha: `${dia}/${mes}/${anio}`,
      resultado: "Fecha inválida",
    });
  }

  try {
    const nombreFestivo = await esFestivo(+dia, +mes, +anio);

    if (nombreFestivo) {
      return res.json({
        fecha: `${dia}/${mes}/${anio}`,
        resultado: "Es festivo",
        nombre: nombreFestivo,
      });
    }

    res.json({
      fecha: `${dia}/${mes}/${anio}`,
      resultado: "No festivo",
    });
  } catch (error) {
    res.status(500).json({ error: "Error interno" });
  }
};

module.exports = { verificarFestivo };
