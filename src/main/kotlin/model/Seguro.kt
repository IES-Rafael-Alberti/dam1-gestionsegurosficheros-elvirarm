package model

abstract class Seguro (
    val numPoliza: Int,
    private val dniTitular: String,
    protected val importe: Double): IExportable{

    companion object{

        fun validarDni(dniTitular: String): Boolean{
            return dniTitular.matches(Regex("^[0-9]{8}[A-Z]$"))
        }



    }

    protected fun obtenerDni(): String = dniTitular

    abstract fun calcularImporteAniosSiguiente(interes: Double): Double

    abstract fun tipoSeguro(): String


    /*
    Convierte el objeto a formato TXT
     */
    override fun serializar(separador: String): String {
        return "$numPoliza$separador$dniTitular$separador$importe"
    }


    override fun toString(): String {
        //TODO redondear a dos decimales
        return "Seguro(numPoliza=$numPoliza, dniTitular=$dniTitular, importe=$importe)"
    }

    override fun hashCode(): Int {
        //TODO Ver cómo puedo hacerlo bien
        return numPoliza.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        // TODO revisar
        return other is Seguro && numPoliza == other.numPoliza
    }
}