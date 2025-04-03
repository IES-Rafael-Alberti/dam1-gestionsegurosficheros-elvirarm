package prog2425.dam1.seguros.model

import java.util.*

enum class Riesgo(val interesAplicado: Double){

    BAJO(2.0), MEDIO(5.0), ALTO(10.0);

    companion object{
        fun getRiesgo(valor: String): Riesgo{
            when (valor.uppercase().trim()){
                "BAJO" -> return BAJO
                "MEDIO" -> return MEDIO
                "ALTO" -> return ALTO
                else -> return MEDIO
            }
        }
    }

}