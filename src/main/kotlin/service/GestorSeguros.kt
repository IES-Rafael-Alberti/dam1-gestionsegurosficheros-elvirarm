package prog2425.dam1.seguros.service


import prog2425.dam1.seguros.data.IRepoSeguros

import prog2425.dam1.seguros.model.*
import java.time.LocalDate

class GestorSeguros(
    private val repoSeguros: IRepoSeguros
): IServSeguros {

    override fun contratarSeguroHogar(
        dniTitular: String,
        importe: Double,
        metrosCuadrados: Int,
        valorContenido: Double,
        direccion: String,
        anioConstruccion: Int
    ): Boolean {
       val seguroHogar = SeguroHogar(dniTitular,importe,metrosCuadrados,valorContenido,direccion, anioConstruccion)
       return if (repoSeguros.agregar(seguroHogar)) true else false
    }

    override fun contratarSeguroAuto(
        dniTitular: String,
        importe: Double,
        descripcion: String,
        combustible: Double,
        tipoAuto: Auto,
        cobertura: Cobertura,
        asistenciaCarretera: Boolean,
        numPartes: Int
    ): Boolean {
        val seguroAuto = SeguroAuto(dniTitular, importe, descripcion, combustible, tipoAuto, cobertura, asistenciaCarretera, numPartes)
        return if (repoSeguros.agregar(seguroAuto)) true else false
    }

    override fun contratarSeguroVida(
        dniTitular: String,
        importe: Double,
        fechaNacimiento: LocalDate,
        nivelRiesgo: Riesgo,
        indemnizacion: Double
    ): Boolean {
        val seguroVida = SeguroVida(dniTitular, importe, fechaNacimiento, nivelRiesgo, indemnizacion)
        return if (repoSeguros.agregar(seguroVida)) return true else false
    }

    override fun eliminarSeguro(numPoliza: Int): Boolean {
        return if (repoSeguros.eliminar(numPoliza)) true else false
    }

    override fun consultarTodos(): List<Seguro> {
        return repoSeguros.obtenerTodos()
    }

    override fun consultarPorTipo(tipoSeguro: String): List<Seguro> {
        return repoSeguros.obtenerTodos().filter { it.tipoSeguro() == tipoSeguro }
    }
}
