package model

class SeguroAuto(dniTitular: String, importe: Double,
                 val descripcion: String,
                 val combustible: String,
                 val tipoAuto: TipoAuto,
                 val tipoCobertura: String,
                 val asistenciaCarretera: Boolean,
                 val numPartes: Int): Seguro(dniTitular, importe) {

    val numPoliza = generarPoliza()



    companion object{

        private var numeroPolizaTemporal = 400000

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
        return "$numPoliza, $dniTitular, $importe, $descripcion, $combustible, $tipoAuto, $tipoCobertura, $asistenciaCarretera, $numPartes, /*tipoSeguro*/"
    }

}