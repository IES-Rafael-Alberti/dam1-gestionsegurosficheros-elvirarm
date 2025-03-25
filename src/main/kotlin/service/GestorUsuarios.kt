package service

import model.Perfil
import model.Usuario

class GestorUsuarios: IServUsuarios, IUtilSeguridad {

    override fun iniciarSesion(nombre: String, clave: String): Perfil? {
        if(buscarUsuario(nombre) != null && verificarClave(clave) != null){
            return perfil
        }else{
            return null
        }
    }

    override fun agregarUsuario(nombre: String, clave: String, perfil: Perfil): Boolean {
        TODO("Not yet implemented")
    }

    override fun eliminarUsuario(nombre: String): Boolean {

        val usuarioAEliminar = buscarUsuario(nombre)

        if (usuarioAEliminar != null) {
            eliminarUsuario(nombre)
            return true
        }else{
            return false
        }
    }

    override fun cambiarClave(usuario: Usuario, nuevaClave: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun buscarUsuario(nombre: String): Usuario? {
        TODO("Not yet implemented")
    }

    override fun consultarTodos(): List<Usuario> {
        TODO()
        // return listaUsuariosRegistrados
    }

    override fun consultarPorPerfil(perfil: Perfil): List<Usuario> {
        TODO("Not yet implemented")
    }
}