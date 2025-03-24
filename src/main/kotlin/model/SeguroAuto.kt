package model

class SeguroAuto: Seguro{

    val numPoliza = generarPoliza()

    var descripcion: String
    var combustible: Double
    var tipoAuto: Auto
    var cobertura: Cobertura
    var asistenciaCarretera: Boolean
    var numPartes: Int


    companion object{

        private var numPolizasAuto = 400000

        private fun generarPoliza(): Int{
            return ++numPolizasAuto
        }

        fun crearSeguro(datos:List<String>): SeguroAuto{
            val dniTitular = datos[0]
            val importe = datos[1]
            val descripcion = datos[2]
            val combustible = datos[3]
            val tipoAuto = datos[4]
            val cobertura = datos[5]
            val asistenciaCarretera = datos[6]
            val numPartes = datos[7]
            return SeguroAuto(datos[0], datos[1].toDouble(), datos[2], datos[3].toDouble(), datos[4], datos[5], datos[6].toBoolean(),datos[7].toInt())
            //TODO validar datos
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
        TODO("Not yet implemented")
    }

    override fun tipoSeguro(): String {
        TODO("Not yet implemented")
    }

    override fun serializar(separador: String): String {
        return "$numPoliza$separador$dniTitular$separador$importe$separador$descripcion$separador$combustible$separador$tipoAuto$separador$tipoCobertura$separador$asistenciaCarretera$separador$numPartes$separador${tipoSeguro}"
    }

}