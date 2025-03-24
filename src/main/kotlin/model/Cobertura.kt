package model

enum class Cobertura(desc: String) {

    TERCEROS("Terceros"),
    TERCEROS_AMPLIADO("Terceros +"),
    FRANQUICIA_200("Todo Riesgo con Franquicia de 200€"),
    FRANQUICIA_300 ("Todo Riesgo con Franquicia de 300€"),
    FRANQUICIA_400 ("Todo Riesgo con Franquicia de 400€"),
    FRANQUICIA_500 ("Todo Riesgo con Franquicia de 500€"),
    TODO_RIESGO ("Todo Riesgo");


    companion object{
        fun getCobertura(valor: String): Cobertura{
            when (valor.uppercase().trim()){
                "TERCEROS" -> return TERCEROS
                "TERCEROS_AMPLIADOS" -> return TERCEROS_AMPLIADO
                "FRANQUICIA_200" -> return FRANQUICIA_200
                "FRANQUICIA_300" -> return FRANQUICIA_300
                "FRANQUICIA_400" -> return FRANQUICIA_400
                "FRANQUICIA_500" -> return FRANQUICIA_500
                "TODO_RIESGO" -> return TODO_RIESGO
                else -> return TERCEROS
            }
        }
    }

}