package prog2425.dam1.seguros.data

import prog2425.dam1.seguros.model.*
import prog2425.dam1.seguros.utils.IUtilFicheros


class RepoSegurosFich(val fich: IUtilFicheros, val ruta: String):RepoSegurosMem(), ICargarSegurosIniciales {

    override fun cargarSeguros(mapa: Map<String, (List<String>) -> Seguro>): Boolean {
        val lineas = fich.leerArchivo(ruta)
        seguros.clear()

        for (linea in lineas) {
            val datos = linea.split(";").toMutableList()
            val tipoSeguro = datos.removeAt(-1)
            val parametros = datos
            val crearSeguro = mapa[tipoSeguro]

            if (crearSeguro != null) {
                seguros.add(crearSeguro(parametros))
            } else {
                seguros.clear()
                return false
            }
        }
        return true
    }


    override fun agregar(seguro: Seguro): Boolean {
        if (fich.agregarLinea(ruta, seguro.serializar())) {
            return super.agregar(seguro)
        } else {
            return false
        }
    }

    override fun eliminar(seguro: Seguro): Boolean {
        if (fich.escribirArchivo(ruta, seguros.filter { it != seguro })) {
            return super.eliminar(seguro)
        }
        return false
    }


    private fun actualizarContadores(seguros: List<Seguro>) {
        // Actualizar los contadores de polizas del companion object según el tipo de seguro
        val maxHogar = seguros.filter { it.tipoSeguro() == "SeguroHogar" }.maxOfOrNull { it.numPoliza }
        val maxAuto = seguros.filter { it.tipoSeguro() == "SeguroAuto" }.maxOfOrNull { it.numPoliza }
        val maxVida = seguros.filter { it.tipoSeguro() == "SeguroVida" }.maxOfOrNull { it.numPoliza }

        if (maxHogar != null) SeguroHogar.numPolizasHogar = maxHogar
        if (maxAuto != null) SeguroAuto.numPolizasAuto = maxAuto
        if (maxVida != null) SeguroVida.numPolizasVida = maxVida
    }
}