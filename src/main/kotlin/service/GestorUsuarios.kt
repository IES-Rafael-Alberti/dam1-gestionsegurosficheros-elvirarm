package prog2425.dam1.seguros.service


import prog2425.dam1.seguros.data.IRepoUsuarios
import prog2425.dam1.seguros.data.RepoUsuariosMem
import prog2425.dam1.seguros.model.Perfil
import prog2425.dam1.seguros.model.Usuario
import prog2425.dam1.seguros.utils.IUtilSeguridad

class GestorUsuarios(private val repoUsuarios: IRepoUsuarios, private val seguridad: IUtilSeguridad): IServUsuarios, IUtilSeguridad {

    override fun iniciarSesion(nombre: String, clave: String): Perfil? {
        val usuario = repoUsuarios.buscarUsuario(nombre)
        return if (usuario != null && verificarClave(clave, usuario.clave) != null) usuario.perfil else null
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

    override fun cambiarClave(usuario: Usuario, nuevaClave: String): Boolean{
        return if (usuario != null) true else false
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

    override fun encriptarClave(clave: String, nivelSeguridad: Int): String {
        TODO("Not yet implemented")
    }

    override fun verificarClave(claveIngresada: String, hashAlmacenado: String): Boolean {
        TODO("Not yet implemented")
    }
}