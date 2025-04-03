
package prog2425.dam1.seguros.model

import prog2425.dam1.seguros.utils.Fecha
import java.time.LocalDate

class SeguroVida:Seguro {

    private var fechaNac: LocalDate
    private var nivelRiesgo: Riesgo
    private var indemnizacion: Double

    companion object{
        private const val INTERES_RESIDUAL = 0.05

        var numPolizasVida = 800000

        private fun generarPoliza(): Int{
            return ++numPolizasVida
        }

        private fun crearSeguro(datos:List<String>):SeguroVida{
            val dniTitular = datos[0]
            val importe = datos[1]
            val fechaNac = LocalDate.parse(datos[2]) // Pasa de string a localdate
            val nivelRiesgo = Riesgo.getRiesgo(datos[3])
            val indemnizacion = datos[4]
            return SeguroVida(dniTitular,importe.toDouble(),fechaNac,nivelRiesgo,indemnizacion.toDouble())
        }

    }

    constructor(dniTitular: String, importe: Double, fechaNac: LocalDate, nivelRiesgo: Riesgo, indemnizacion: Double): super(
        generarPoliza(), dniTitular, importe){
        this.fechaNac = fechaNac
        this.nivelRiesgo = nivelRiesgo
        this.indemnizacion = indemnizacion
    }

    private constructor(numPoliza: Int, dniTitular: String, importe: Double, fechaNac: LocalDate, nivelRiesgo: Riesgo, indemnizacion: Double):super(numPoliza, dniTitular, importe){
        this.fechaNac = fechaNac
        this.nivelRiesgo = nivelRiesgo
        this.indemnizacion = indemnizacion
    }

    override fun calcularImporteAniosSiguiente(interes: Double): Double {
        val anioCumplido = Fecha.obtenerAnio(LocalDate.now()) - Fecha.obtenerAnio(fechaNac)
        return importe * (1 + (interes) + (INTERES_RESIDUAL * anioCumplido) + nivelRiesgo.interesAplicado / 100)
    }

    override fun serializar(separador: String): String {
        return ("$numPolizasVida$separador${obtenerDni()}$separador$importe$separador$fechaNac$separador$nivelRiesgo$separador$indemnizacion$separador${tipoSeguro()}")
    }
}