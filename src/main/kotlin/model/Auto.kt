package model

enum class Auto {

    COCHE, MOTO, CAMION;

    companion object{

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