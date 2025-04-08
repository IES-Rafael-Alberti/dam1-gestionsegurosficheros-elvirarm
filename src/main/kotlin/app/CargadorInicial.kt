package prog2425.dam1.seguros.app

import prog2425.dam1.seguros.data.ICargarSegurosIniciales
import prog2425.dam1.seguros.data.ICargarUsuariosIniciales
import prog2425.dam1.seguros.data.RepoSegurosFich
import prog2425.dam1.seguros.data.RepoUsuariosFich
import prog2425.dam1.seguros.model.Seguro
import prog2425.dam1.seguros.ui.IEntradaSalida

class CargadorInicial (val ui: IEntradaSalida, val repoUsuarios: RepoUsuariosFich, val repoSeguros: RepoSegurosFich ) {

    fun cargarUsuarios(){
       try{
           repoUsuarios.cargarUsuario()
       }catch(e: IllegalArgumentException){
       ui.mostrarError("Error al convertir los datos")}

        catch(e: Exception){
            ui.mostrarError("No se pueden cargar los usuarios")
        }
    }

    fun cargarSeguros(){
        try {
            repoSeguros.cargarSeguros(ConfiguracionesApp.mapaCrearSeguro)
        }catch(e: Exception){

        }
    }

}