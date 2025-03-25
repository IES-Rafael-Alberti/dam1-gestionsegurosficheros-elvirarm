package data

import model.Perfil
import model.Usuario

interface IRepoUsuarios {

    fun agregarUsuario(usuario: Usuario): Boolean

    fun buscarUsuario(nombreUsuario: String): Usuario?

    fun eliminar(usuario: Usuario): Boolean

    fun eliminar(nombreUsuario: String): Boolean

    fun obtenerTodos(): List<Usuario>

    fun obtener(perfil: Perfil): List<Usuario>

    fun cambiarClave(usuario: Usuario, nuevaClave: String): Boolean

}