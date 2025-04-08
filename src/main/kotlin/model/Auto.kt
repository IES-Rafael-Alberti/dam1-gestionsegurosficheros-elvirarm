package prog2425.dam1.seguros.model

enum class Auto {

    COCHE, MOTO, CAMION;

    companion object{

        // entries.find{it.name.equals(valor, ignoreCase = true)?:TERCEROS
        // Como lo ha hecho Diego
        fun getAuto(valor: String): Auto{
            when(valor.uppercase().trim()){
                "COCHE" -> return COCHE
                "MOTO" -> return MOTO
                "CAMION" -> return CAMION
                else -> return COCHE
            }

        }

    }

}