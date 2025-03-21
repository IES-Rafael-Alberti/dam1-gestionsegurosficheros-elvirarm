package model

enum class Cobertura(desc: String) {

    TERCEROS, TERCEROS_AMPLIADO, FRANQUICIA_200, FRANQUICIA_300, FRANQUICIA_400, FRANQUICIA_500, TODO_RIESGO

    // Ver cómo añado la descripción

    companion object{
        fun getCobertura(valor: String): Cobertura{
            //TODO
            return
        }
    }

}