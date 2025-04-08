package prog2425.dam1.seguros.service


import prog2425.dam1.seguros.data.IRepoUsuarios
import prog2425.dam1.seguros.data.RepoUsuariosMem
import prog2425.dam1.seguros.model.Perfil
import prog2425.dam1.seguros.model.Usuario
import prog2425.dam1.seguros.utils.IUtilSeguridad

class GestorUsuarios(private val repoUsuarios: IRepoUsuarios, private val seguridad: IUtilSeguridad): IServUsuarios, IUtilSeguridad {

    override fun iniciarSesion(nombre: String, clave: String): Perfil? {
        val usuario = repoUsuarios.buscarUsuario(nombre)
        return if (usuario != null && seguridad.verificarClave(clave, usuario.clave)) usuario.perfil else null
    }

    override fun agregarUsuario(nombre: String, clave: String, perfil: Perfil): Boolean {


        if (repoUsuarios.buscarUsuario(nombre) != null) {
            return false
        }
        val claveEncriptada = seguridad.encriptarClave(clave)
        val nuevoUsuario = Usuario(nombre, claveEncriptada, perfil)
        return repoUsuarios.agregarUsuario(nuevoUsuario)

    }

    override fun eliminarUsuario(nombre: String): Boolean {

        val usuarioAEliminar = buscarUsuario(nombre)

        if (usuarioAEliminar != null) {
            repoUsuarios.eliminar(nombre)
            return true
        }else{
            return false
        }
    }

    override fun cambiarClave(usuario: Usuario, nuevaClave: String): Boolean {
        val nuevaClaveEncriptada = seguridad.encriptarClave(nuevaClave)
        usuario.cambiarClave(nuevaClaveEncriptada)
        return repoUsuarios.cambiarClave(usuario, nuevaClaveEncriptada)
    }

    override fun buscarUsuario(nombre: String): Usuario? {
        return repoUsuarios.buscarUsuario(nombre)
    }

    override fun consultarTodos(): List<Usuario> {

        return repoUsuarios.obtenerTodos()
    }

    override fun consultarPorPerfil(perfil: Perfil): List<Usuario> {
       return repoUsuarios.obtener(perfil)
    }

    override fun encriptarClave(clave: String, nivelSeguridad: Int): String {
        return seguridad.encriptarClave(clave, nivelSeguridad)
    }

    override fun verificarClave(claveIngresada: String, hashAlmacenado: String): Boolean {
        return seguridad.verificarClave(claveIngresada,hashAlmacenado)
    }
}