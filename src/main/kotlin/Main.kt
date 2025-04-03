package prog2425.dam1.seguros

import prog2425.dam1.seguros.data.*
import prog2425.dam1.seguros.ui.Consola
import prog2425.dam1.seguros.utils.Ficheros
import prog2425.dam1.seguros.utils.Seguridad

/*
fun main(){
    val consola = Consola()

    fun validarNombreVacioYMayorQue5(nombre: String): Boolean{
        return nombre.isNotEmpty() && nombre.length >= 5
    }

    val nombre = consola.pedirInfo("Introduce un nombre")
    if (!validarNombreVacioYMayorQue5(nombre)){
        consola.mostrarError("Nombre incorrecto!")
    }

    val nombre1 = consola.pedirInfo("Introduce un nombre", "Nombre incorrecto",::validarNombreVacioYMayorQue5)
}

 */

fun main() {

    // Crear dos variables con las rutas de los archivos de texto donde se almacenan los usuarios y seguros.
    // Estos ficheros se usarán solo si el programa se ejecuta en modo de almacenamiento persistente.
    val rutaUsuarios = "./res/Usuarios.txt"
    val rutaSeguros = "./res/Seguros.txt"


    // Instanciamos los componentes base del sistema: la interfaz de usuario, el gestor de ficheros y el módulo de seguridad.
    // Estos objetos serán inyectados en los diferentes servicios y utilidades a lo largo del programa.
    val ui = Consola()
    val fich = Ficheros(ui)
    val seguridad = Seguridad()


    // Limpiamos la pantalla antes de comenzar, para que la interfaz esté despejada al usuario.
    ui.limpiarPantalla()


    // Preguntamos al usuario si desea iniciar en modo simulación.
    // En modo simulación los datos no se guardarán en archivos, solo estarán en memoria durante la ejecución.

    val modoSimulacion = ui.preguntar("¿Quieres ejecutar en modo simulación (s/n)? ")


    // Declaramos los repositorios de usuarios y seguros.
    // Se asignarán más abajo dependiendo del modo elegido por el usuario.

    val repoUsuario: IRepoUsuarios
    val repoSeguro: IRepoSeguros


    // Si se ha elegido modo simulación, se usan repositorios en memoria.
    // Si se ha elegido almacenamiento persistente, se instancian los repositorios que usan ficheros.
    // Además, creamos una instancia del cargador inicial de información y lanzamos la carga desde los ficheros.

    if (modoSimulacion) {
        repoUsuario = RepoUsuariosMem()
        repoSeguro = RepoSegurosMem()
    }else{
        repoUsuario = RepoUsuariosFich(rutaUsuarios, fich)
        repoSeguro = RepoSegurosFich()


    }

    // Se crean los servicios de lógica de negocio, inyectando los repositorios y el componente de seguridad.


    // Se inicia el proceso de autenticación. Se comprueba si hay usuarios en el sistema y se pide login.
    // Si no hay usuarios, se permite crear un usuario ADMIN inicial.


    // Si el login fue exitoso (no es null), se inicia el menú correspondiente al perfil del usuario autenticado.
    // Se lanza el menú principal, **iniciarMenu(0)**, pasándole toda la información necesaria.



}