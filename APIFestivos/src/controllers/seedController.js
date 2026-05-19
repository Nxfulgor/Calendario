const Festivo = require("../models/Festivo");
const data = require("../utils/seedData");

const seedDB = async (req, res) => {
  try {
    await Festivo.deleteMany(); // limpia la colección
    await Festivo.insertMany(data);

    res.json({ message: "Datos insertados correctamente 🚀" });
  } catch (error) {
    res.status(500).json({
      error: error.message,
      detalle: error,
    });
  }
};

module.exports = { seedDB };
