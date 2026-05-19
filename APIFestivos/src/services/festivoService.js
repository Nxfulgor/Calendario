const Festivo = require("../models/Festivo");

// * Validar fecha
function esFechaValida(dia, mes, anio) {
  const fecha = new Date(anio, mes - 1, dia);
  return (
    fecha.getFullYear() === +anio &&
    fecha.getMonth() === mes - 1 &&
    fecha.getDate() === +dia
  );
}

// * Calcular Pascua
function calcularPascua(anio) {
  const a = anio % 19;
  const b = anio % 4;
  const c = anio % 7;
  const d = (19 * a + 24) % 30;

  const dias = d + ((2 * b + 4 * c + 6 * d + 5) % 7);

  const ramos = new Date(anio, 2, 15 + dias);
  const pascua = new Date(ramos);
  pascua.setDate(ramos.getDate() + 7);

  return pascua;
}

// * Mover al siguiente lunes
function siguienteLunes(fecha) {
  const dia = fecha.getDay();

  if (dia !== 1) {
    const diasFaltantes = (8 - dia) % 7;
    fecha.setDate(fecha.getDate() + diasFaltantes);
  }

  return fecha;
}

// * FUNCION PRINCIPAL
async function esFestivo(dia, mes, anio) {
  if (!esFechaValida(dia, mes, anio)) {
    return null;
  }

  const fecha = new Date(anio, mes - 1, dia);
  const festivos = await Festivo.find();
  const pascua = calcularPascua(anio);

  for (let f of festivos) {
    let fechaFestivo;

    if (f.tipo === 1) {
      fechaFestivo = new Date(anio, f.mes - 1, f.dia);
    }

    if (f.tipo === 2) {
      fechaFestivo = new Date(anio, f.mes - 1, f.dia);
      fechaFestivo = siguienteLunes(fechaFestivo);
    }

    if (f.tipo === 3) {
      fechaFestivo = new Date(pascua);
      fechaFestivo.setDate(pascua.getDate() + f.diasPascua);
    }

    if (f.tipo === 4) {
      fechaFestivo = new Date(pascua);
      fechaFestivo.setDate(pascua.getDate() + f.diasPascua);
      fechaFestivo = siguienteLunes(fechaFestivo);
    }

    if (fechaFestivo.toDateString() === fecha.toDateString()) {
      return f.nombre; // * Nombre del festivo en lugar de "Es festivo" para mas información
    }
  }

  return null;
}

module.exports = { esFestivo, esFechaValida };
