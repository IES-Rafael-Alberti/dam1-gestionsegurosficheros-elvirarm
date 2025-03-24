package utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter


object FechaActual {

    open fun obtenerAnioActual(): Int {
        val fechaActual = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy")
        val anioActual = formatter.format(fechaActual)

        return anioActual.toInt()

    }

}