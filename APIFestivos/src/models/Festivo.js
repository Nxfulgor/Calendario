// src/models/Festivo.js
const mongoose = require("mongoose");

const festivoSchema = new mongoose.Schema(
  {
    nombre: {
      type: String,
      required: true,
    },
    tipo: {
      type: Number,
      required: true,
    },
    dia: {
      type: Number,
      default: null,
    },
    mes: {
      type: Number,
      default: null,
    },
    diasPascua: {
      type: Number,
      default: null,
    },
  },
  {
    timestamps: true,
  },
);

module.exports = mongoose.model("Festivo", festivoSchema);
