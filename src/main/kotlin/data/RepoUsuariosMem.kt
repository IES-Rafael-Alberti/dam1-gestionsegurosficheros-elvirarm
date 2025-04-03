package prog2425.dam1.seguros.data

import prog2425.dam1.seguros.model.Perfil
import prog2425.dam1.seguros.model.Usuario


open class RepoUsuariosMem: IRepoUsuarios {

    private var listaUsuariosMem: MutableList<Usuario> = mutableListOf()


    override fun agregarUsuario(usuario: Usuario): Boolean {
        if(buscarUsuario(usuario.nombre) != null){
            listaUsuariosMem.add(usuario)
            return true
        }else{
            return false
        }
    }

    override fun buscarUsuario(nombreUsuario: String): Usuario? {
       return listaUsuariosMem.find{it.nombre == nombreUsuario}
    }

    override fun eliminar(usuario: Usuario): Boolean {

        val usuarioAEliminar = buscarUsuario(usuario.nombre)

        if(usuarioAEliminar != null){
            listaUsuariosMem.remove(usuarioAEliminar)
            return true
        }
            else{
                return false
        }
    }

    override fun eliminar(nombreUsuario: String): Boolean {

        //TODO seguir pensando cómo usar la función buscarUsuario

        val usuarioAEliminar = buscarUsuario(nombreUsuario)
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