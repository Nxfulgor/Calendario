const express = require("express");
const router = express.Router();
const { seedDB } = require("../controllers/seedController");

router.get("/", seedDB);

module.exports = router;
