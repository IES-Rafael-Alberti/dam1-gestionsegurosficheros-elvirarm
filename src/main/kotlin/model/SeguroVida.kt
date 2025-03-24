package model

class SeguroVida(numPoliza: Int, dniTitular: String, importe: Double, val fechaNac: String, val nivelRiesgo: Riesgo, val indemnizacion: Double): Seguro(numPoliza = generarPoliza(), dniTitular, importe) {


    companion object{
        var numPolizaAuto = 800000

        private fun generarPoliza(): Int{
            return ++numPolizaAuto
        }
    }

    override fun calcularImporteAniosSiguiente(interes: Double): Double {
        TODO("Not yet implemented")
    }

    override fun tipoSeguro(): String {
        TODO("Not yet implemented")
    }

    override fun serializar(): String {
        return ("$numPolizaAuto, ${obtenerDni()}, $importe, $fechaNac, $nivelRiesgo, $indemnizacion, /*tipoSeguro*/")
    }
}