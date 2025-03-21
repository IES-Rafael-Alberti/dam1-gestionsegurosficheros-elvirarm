package model

class SeguroVida(dniTitular: String, importe: Double, val fechaNac: String, val nivelRiesgo: NivelRiesgo, val indemnizacion: Double): Seguro(dniTitular, importe) {

    val numPoliza = generarId()

    companion object{
        var id = 800000

        private fun generarId(): Int{
            return ++id
        }
    }

    override fun calcularImporteAniosSiguiente(interes: Double): Double {
        TODO("Not yet implemented")
    }

    override fun tipoSeguro(): String {
        TODO("Not yet implemented")
    }

    override fun serializar(): String {
        return ("$numPoliza, $dniTitular, $importe, $fechaNac, $nivelRiesgo, $indemnizacion, /*tipoSeguro*/")
    }
}