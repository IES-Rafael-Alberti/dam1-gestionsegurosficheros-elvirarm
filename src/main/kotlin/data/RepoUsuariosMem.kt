package data

import model.Perfil
import model.Usuario

class RepoUsuariosMem: IRepoUsuarios {

    private var listaUsuariosMem: MutableList<Usuario> = mutableListOf()


    override fun agregarUsuario(usuario: Usuario): Boolean {
        if(buscarUsuario(usuario) == usuario){
            listaUsuariosMem.add(usuario)
            return true
        }else{
            return false
        }
    }

    override fun buscarUsuario(usuario: Usuario): Usuario? {
       return listaUsuariosMem.find{it.nombre == usuario.nombre}
    }

    override fun eliminar(usuario: Usuario): Boolean {

        if(buscarUsuario(usuario) == usuario){
            listaUsuariosMem.remove(usuario)
            return true}
            else{
                return false
        }
    }

    override fun eliminar(nombreUsuario: String): Boolean {

        //TODO seguir pensando cómo usar la función buscarUsuario

        val usuarioAEliminar = listaUsuariosMem.find{it.nombre == nombreUsuario}
        if(usuarioAEliminar != null){
            listaUsuariosMem.remove(usuarioAEliminar)
            return true
        }else{
                return false
            }
    }

    override fun obtenerTodos(): List<Usuario> {
        return listaUsuariosMem
    }

    override fun obtener(perfil: Perfil): List<Usuario> {
        return listaUsuariosMem.filter{it.perfil == perfil}
    }


    override fun cambiarClave(usuario: Usuario, nuevaClave: String): Boolean {
        //TODO está mal, ver cómo lo cambio
        usuario.cambiarClave(nuevaClave)
        return true
    }

}