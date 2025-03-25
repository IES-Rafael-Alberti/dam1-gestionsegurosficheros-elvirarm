package data

//HACER

import model.Usuario
import java.io.File

class RepoUsuariosFich (rutaArchivo: String, utilFicheros: IUtilFicheros):RepoUsuariosMem(), ICargarUsuariosIniciales {

    override fun agregarUsuario(usuario: Usuario): Boolean {
        if(buscarUsuario(usuario) != usuario){
            if(agregarLinea()){
                super.agregarUsuario(usuario)
                }
        }else{
            return false
        }


        return super.agregarUsuario(usuario)
    }

    override fun eliminar(usuario: Usuario): Boolean {
        if (listaUsuarios.filter{it.usuario == usuario}){
            if(escribirArchivo()){
                listaUsuarios.remove(usuario)
            }else{
                return false
            }
        }
        return false
    }

    override fun eliminar(nombreUsuario: String): Boolean {
        return super.eliminar(nombreUsuario)
    }

    override fun cargarUsuario(): Boolean {
        val archivo = File.readLines()
        Usuario.crearUsuario(datos)
    }
}