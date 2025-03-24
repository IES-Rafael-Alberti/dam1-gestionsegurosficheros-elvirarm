package model

class Usuario(val nombre: String, clave: String, var perfil: Perfil): IExportable {



    var clave = clave
        private set


    companion object{

        /*
        Retorna una instancia de Usuario. El parámetro que recibe, datos, contiene el valor de cada propiedad en orden y deben ser convertidos según el tipo de la propiedad si es necesario. Muy atentos a controlar su llamada para evitar EXCEPCIONES por conversiones erróneas (aunque si almacenamos bien la info no debería ocurir, pero un buen programador/a lo controla SIEMPRE)
        */
        fun crearUsuario(datos: List<String>): Usuario{
            val nombre = datos[0]
            var clave = datos[1]
            var perfil = Perfil.getPerfil(datos[2])
           return Usuario(nombre, clave, perfil)

        }

    }


   /*
   Actualiza la clave del usuario (este método va a actualizar la clave del usuario directamente, pero en el servicio que gestiona los usuarios debe solicitar la antigua clave, verificarla y pedir la nueva)
    */
    fun cambiarClave(nuevaClaveEncriptada: String){
        clave = nuevaClaveEncriptada
    }

    override fun serializar(separador: String): String {
        return "$nombre$separador$clave$separador$perfil"
    }

}