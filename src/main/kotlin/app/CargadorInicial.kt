package prog2425.dam1.seguros.app

import prog2425.dam1.seguros.data.ICargarSegurosIniciales
import prog2425.dam1.seguros.data.ICargarUsuariosIniciales
import prog2425.dam1.seguros.model.Seguro
import prog2425.dam1.seguros.ui.IEntradaSalida

class CargadorInicial: ICargarUsuariosIniciales, ICargarSegurosIniciales, IEntradaSalida {


    override fun cargarUsuario(): Boolean {
        TODO("Not yet implemented")
    }

    override fun cargarSeguros(mapa: Map<String, (List<String>) -> Seguro>): Boolean {
        TODO("Not yet implemented")
    }

    override fun mostrar(msj: String, salto: Boolean, pausa: Boolean) {
        TODO("Not yet implemented")
    }

    override fun mostrarError(msj: String, pausa: Boolean) {
        TODO("Not yet implemented")
    }

    override fun pedirInfo(msj: String): String {
        TODO("Not yet implemented")
    }

    override fun pedirInfo(msj: String, error: String, debeCumplir: (String) -> Boolean): String {
        TODO("Not yet implemented")
    }

    override fun pedirDouble(
        prompt: String,
        error: String,
        errorConv: String,
        debeCumplir: (Double) -> Boolean
    ): Double {
        TODO("Not yet implemented")
    }

    override fun pedirEntero(prompt: String, error: String, errorConv: String, debeCumplir: (Int) -> Boolean): Int {
        TODO("Not yet implemented")
    }

    override fun pedirInfoOculta(prompt: String): String {
        TODO("Not yet implemented")
    }

    override fun pausar(msj: String) {
        TODO("Not yet implemented")
    }

    override fun limpiarPantalla(numSaltos: Int) {
        TODO("Not yet implemented")
    }

    override fun preguntar(mensaje: String): Boolean {
        TODO("Not yet implemented")
    }
}