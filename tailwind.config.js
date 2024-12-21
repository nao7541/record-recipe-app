/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,js}",
    "node_modules/preline/**/*.js",
  ],
  theme: {
    extend: {},
  },
  plugins: [
    require("preline/plugin")
  ],
}

