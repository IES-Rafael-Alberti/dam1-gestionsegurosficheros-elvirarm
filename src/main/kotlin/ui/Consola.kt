package prog2425.dam1.seguros.ui

import jdk.internal.org.jline.reader.EndOfFileException
import jdk.internal.org.jline.reader.LineReaderBuilder
import jdk.internal.org.jline.reader.UserInterruptException
import jdk.internal.org.jline.terminal.TerminalBuilder

class Consola: IEntradaSalida {

    override fun mostrar(msj: String, salto: Boolean, pausa: Boolean) {

        if(msj.isNotEmpty()){

            if (pausa){
                pausar("Pulsa enter para continuar...")
            } else{

                when(salto){
                    true -> println(msj + "\n")
                    false -> print(msj)
                }

            }
        }

    }

    override fun mostrarError(msj: String, pausa: Boolean) {
        if(msj.startsWith("ERROR - ")){
            println(msj)
            }else{
                println("ERROR - " + msj)
        }
    }

    override fun pedirInfo(msj: String): String {
        if(msj.isNotEmpty()){
            mostrar(msj,salto = false, pausa = false)}
            return readln().trim()
        }


    override fun pedirInfo(msj: String, error: String, debeCumplir: (String) -> Boolean): String {
        val entrada = pedirInfo(msj)
        require(debeCumplir(entrada)){error}
        return entrada
    }

    override fun pedirDouble(
        prompt: String,
        error: String,
        errorConv: String,
        debeCumplir: (Double) -> Boolean
    ): Double {
        println(prompt)
        val double = readln().replace(",",".").toDoubleOrNull()
        require(double is Double){errorConv}
        require(debeCumplir(double)){error}
        return double
    }

    override fun pedirEntero(prompt: String, error: String, errorConv: String, debeCumplir: (Int) -> Boolean): Int{
        println(prompt)
        val int = readln().toIntOrNull()
        require(int is Int){errorConv}
        require(debeCumplir(int)){error}
        return int
    }


    override fun pedirInfoOculta(prompt: String): String {
        return try {
            val terminal = TerminalBuilder.builder()
                .dumb(true) // Para entornos no interactivos como IDEs
                .build()

            val reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .build()

            reader.readLine(prompt, '*') // Oculta la contraseña con '*'
        } catch (e: UserInterruptException) {
            mostrarError("Entrada cancelada por el usuario (Ctrl + C).", pausa = false)
            ""
        } catch (e: EndOfFileException) {
            mostrarError("Se alcanzó el final del archivo (EOF ó Ctrl+D).", pausa = false)
            ""
        } catch (e: Exception) {
            mostrarError("Problema al leer la contraseña: ${e.message}", pausa = false)
            ""
        }
    }

    override fun pausar(msj: String) {

        var entradaUsuario = pedirInfo(msj)

        while(entradaUsuario.isNotEmpty()){
            entradaUsuario = pedirInfo(msj)
            }
    }


    /*
    ver cómo funciona
     */
    override fun limpiarPantalla(numSaltos: Int) {
        if (System.console() != null) {
            mostrar("\u001b[H\u001b[2J", false)
            System.out.flush()
        } else {
            repeat(numSaltos) {
                mostrar("")
            }
        }
    }

    override fun preguntar(mensaje: String): Boolean {
        var entrada = pedirInfo(mensaje).lowercase()
        val mensajesValidos = listOf("s", "n")
        while (entrada !in mensajesValidos){
            entrada = pedirInfo(mensaje).lowercase()
        }
        when (entrada){
            "s" -> return true
            "n" -> return false
            else -> return false
    }
}
    }