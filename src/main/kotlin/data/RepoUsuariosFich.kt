package prog2425.dam1.seguros.data

import prog2425.dam1.seguros.model.Usuario
import prog2425.dam1.seguros.utils.IUtilFicheros

//HACER

import java.io.File

class RepoUsuariosFich (val rutaArchivo: String, val fich: IUtilFicheros):RepoUsuariosMem(), ICargarUsuariosIniciales {

    /* TODO
    override fun agregarUsuario(usuario: Usuario): Boolean {
        return if (buscarUsuario(usuario.nombre) != null) {
            false

        } else {
            if (fich.agregarLinea(rutaArchivo, linea)) {
                listaUsuariosMem.add(usuario)
            }
            true
        }
    }

     */

    override fun eliminar(usuario: Usuario): Boolean {

        return if (fich.escribirArchivo(rutaArchivo, listaUsuariosMem.filter { it != usuario })) {
            super.eliminar(usuario)
        } else {
            false
        }
    }


    override fun cargarUsuario(): Boolean {

        for (linea in fich.leerArchivo(rutaArchivo)) {
            val campos = linea.split(";")
            val usuario = Usuario.crearUsuario(campos)

            if (usuario != null) {
                agregarUsuario(usuario)
                return true
            }
        }
        return false
    }
}
