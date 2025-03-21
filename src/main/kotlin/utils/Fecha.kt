package utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter


open class Fecha {

    open fun obtenerAnioActual(): String {
        val fechaActual = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy")
        val anioActual = formatter.format(fechaActual)

        return anioActual

    }

}