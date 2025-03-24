package utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter


object Fecha {

    open fun obtenerAnio(fecha: LocalDate): Int {
        val formatter = DateTimeFormatter.ofPattern("yyyy")
        val anio = formatter.format(fecha)

        return anio.toInt()

    }

}