package prog2425.dam1.seguros.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter


object Fecha {

    fun obtenerAnio(fecha: LocalDate): Int {
        val formatter = DateTimeFormatter.ofPattern("yyyy")
        val anio = formatter.format(fecha)
        return anio.toInt()

    }

}