class SeguroHogar(dniTitular: String, importe: Double, val metrosCuadrados: Int, val valorContenido: Double, val direccion: String): Seguro(dniTitular, importe){

    val numPoliza = generarPoliza()

    companion object{

        private var numeroPolizaTemporal = 100000

        private fun generarPoliza(): Int{
            return ++numeroPolizaTemporal
        }

    }

    override fun calcularImporteAniosSiguiente(interes: Double): Double {
        TODO("Not yet implemented")
    }

    override fun tipoSeguro(): String {
        TODO("Not yet implemented")
    }

    override fun serializar(): String {
        return "$numPoliza, $dniTitular, $importe, $metrosCuadrados, $valorContenido, $direccion, /*tipoSeguro*/"
    }
}