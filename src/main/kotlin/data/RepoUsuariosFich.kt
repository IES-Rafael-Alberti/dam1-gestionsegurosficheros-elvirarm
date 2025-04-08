package prog2425.dam1.seguros.data

import prog2425.dam1.seguros.model.Usuario
import prog2425.dam1.seguros.utils.IUtilFicheros

//HACER


class RepoUsuariosFich (val rutaArchivo: String, val fich: IUtilFicheros):RepoUsuariosMem(), ICargarUsuariosIniciales {

    override fun agregarUsuario(usuario: Usuario): Boolean {


            if (fich.agregarLinea(rutaArchivo, usuario.serializar())) {
                return super.agregarUsuario(usuario)

            }
            return false
        }



    override fun eliminar(usuario: Usuario): Boolean {

        return if (fich.escribirArchivo(rutaArchivo, listaUsuariosMem.filter { it != usuario })) {
            super.eliminar(usuario)
        } else {
            false
        }
    }


    override fun cargarUsuario(): Boolean {

        var usuarioCargado = false

        for (linea in fich.leerArchivo(rutaArchivo)) {
            val campos = linea.split(";")
            val usuario = Usuario.crearUsuario(campos)

            if (usuario != null) {
                agregarUsuario(usuario)
                usuarioCargado = true
            }
        }
        return usuarioCargado
    }
}
