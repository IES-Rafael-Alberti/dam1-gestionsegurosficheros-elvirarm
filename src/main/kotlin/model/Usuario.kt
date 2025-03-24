package model

class Usuario(nombre: String, clave: Int, perfil: Perfil): IExportable {

    val nombre = nombre
    val clave = clave
    val perfil = perfil

    companion object{

        fun crearUsuario(datos: List<String>): Usuario{
            /*
             Retorna una instancia de Usuario. El parámetro que recibe, datos, contiene el valor de cada propiedad en orden y deben ser convertidos según el tipo de la propiedad si es necesario. Muy atentos a controlar su llamada para evitar EXCEPCIONES por conversiones erróneas (aunque si almacenamos bien la info no debería ocurir, pero un buen programador/a lo controla SIEMPRE)
             */

        }

    }


    fun verificarClave(claveEncriptada: String): Boolean{

        /*
         Retorna si la clave es la misma que la almacenada en el usuario
         */

    }

    fun cambiarClave(nuevaClaveEncriptada: String){
        /*
        Actualiza la clave del usuario (este método va a actualizar la clave del usuario directamente, pero en el servicio que gestiona los usuarios debe solicitar la antigua clave, verificarla y pedir la nueva)
         */
    }

    override fun serializar(separador: String): String {
        return "$nombre$separador$clave$separador$perfil"
    }

}