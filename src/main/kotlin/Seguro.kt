abstract class Seguro (protected val dniTitular: String, protected val importe: Double){

    companion object{

        fun validarDni(dniTitular: String): Boolean{
            return dniTitular.matches(Regex("^[0-9]{8}[A-Z]$"))
        }

    }

    abstract fun calcularImporteAniosSiguiente(interes: Double): Double

    abstract fun tipoSeguro(): String

    /*
    Convierte el objeto a formato TXT
     */
    abstract fun serializar(): String

}