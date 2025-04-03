package prog2425.dam1.seguros.model


class SeguroAuto: Seguro{

    var descripcion: String
    var combustible: Double
    var tipoAuto: Auto
    var cobertura: Cobertura
    var asistenciaCarretera: Boolean
    var numPartes: Int


    companion object{
        private const val PORCENTAJE_INCREMENTO_PARTES = 2

        var numPolizasAuto = 400000

        private fun generarPoliza(): Int{
            return ++numPolizasAuto
        }

        fun crearSeguro(datos:List<String>): SeguroAuto{
            val dniTitular = datos[0]
            val importe = datos[1]
            val descripcion = datos[2]
            val combustible = datos[3]
            val tipoAuto = Auto.getAuto(datos[4])
            val cobertura = Cobertura.getCobertura(datos[5])
            val asistenciaCarretera = datos[6]
            val numPartes = datos[7]
            return SeguroAuto(dniTitular, importe.toDouble(), descripcion, combustible.toDouble(), tipoAuto, cobertura, asistenciaCarretera.toBoolean(),numPartes.toInt())
        }

    }

    constructor(dniTitular: String, importe: Double, descripcion: String, combustible: Double, tipoAuto: Auto, cobertura: Cobertura, asistenciaCarretera: Boolean, numPartes: Int):super(generarPoliza(), dniTitular, importe){

        this.descripcion = descripcion
        this.combustible = combustible
        this.tipoAuto = tipoAuto
        this.cobertura = cobertura
        this.asistenciaCarretera = asistenciaCarretera
        this.numPartes = numPartes

    }

    private constructor(numPoliza: Int, dniTitular: String, importe: Double, descripcion: String, combustible: Double, tipoAuto: Auto, cobertura: Cobertura, asistenciaCarretera: Boolean, numPartes: Int):super(numPoliza, dniTitular, importe){

        this.descripcion = descripcion
        this.combustible = combustible
        this.tipoAuto = tipoAuto
        this.cobertura = cobertura
        this.asistenciaCarretera = asistenciaCarretera
        this.numPartes = numPartes

    }

    override fun calcularImporteAniosSiguiente(interes: Double): Double {
        val importeAnioSiguiente = importe * (1 + interes + (numPartes * PORCENTAJE_INCREMENTO_PARTES)) / 100
        return importeAnioSiguiente
    }



    override fun serializar(separador: String): String {
        return "$numPoliza$separador${obtenerDni()}$separador$importe$separador$descripcion$separador$combustible$separador$tipoAuto$separador$Cobertura$separador$asistenciaCarretera$separador$numPartes$separador${tipoSeguro()}"
    }

    override fun toString(): String {
        return "Seguro Auto(numPoliza=$numPolizasAuto, dniTitular=${obtenerDni()}, importe=$importe, descripcion = $descripcion, combustible = $combustible, tipoAuto = $tipoAuto, cobertura = $cobertura, asistenciaCarreta = $asistenciaCarretera)"
    }
}