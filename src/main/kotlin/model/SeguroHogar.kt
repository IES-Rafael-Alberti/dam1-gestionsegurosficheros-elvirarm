package model
import utils.Fecha


class SeguroHogar: Seguro{


    /* Lo usaremos en la Contratacíon de un NUEVO seguro (genera un número de póliza automáticamente, gracias a una propiedad privada numPolizasAuto que comienza en el número 100000)*/
    constructor(numPoliza:Int = generarPoliza(), dniTitular: String, importe: Double, metrosCuadrados: Int, valorContenido: Double, direccion: String, anioConstruccion: Int): super(numPoliza, dniTitular, importe)


    /*
    Lo usaremos para crear una póliza ya existente (es decir, cuando recuperamos los seguros desde la persistencia de datos). Este segundo constructor no se podrá llamar desde fuera de la clase.
     */
    private constructor(numPoliza: Int, dniTitular: String, importe: Double): super(numPoliza, dniTitular, importe)





    companion object{

        private var numPolizasAuto = 100000

        private fun generarPoliza(): Int{
            return ++numPolizasAuto
        }

    }

    override fun calcularImporteAniosSiguiente(interes: Double): Double {


        var anioAntiguedadTemporal = 0
        val anioAntiguedad = anioConstruccion - fechaActual
        // TODO Arreglar variables

        while (anioAntiguedad > 5){
            anioAntiguedadTemporal = anioAntiguedad - 5
            return anioAntiguedad

    }

        // TODO Arreglar el cálculo con la condición que se sume por cada 5 años??
        var interesResidual = anioAntiguedad * 0.02
        val importeAnioSiguiente =  (importe * interes) + interesResidual
        // Por qué no me deja usar el +?
        return importeAnioSiguiente
    }

    override fun tipoSeguro(): String {
        /*
         Retornar el nombre de la clase usando this::class.simpleName y el operador elvis para indicar al compilador que si simpleName es null (cosa que nunca debe pasar, ya que la clase tiene un nombre), entonces deberá retornar el valor "Desconocido".
         */
        TODO("Not yet implemented")
    }

    /*override fun serializar(): String {
        //TODO Arreglar

        return "$numPoliza; $dniTitular; $importe; $metrosCuadrados; $valorContenido; $direccion; ${tipoSeguro()}"

    }*/

    fun crearSeguro(datos: List<String>): SeguroHogar{
        //TODO controlar la conversión de datos
        return SeguroHogar(datos[0], datos[1], datos[2], datos[3])
    }

    /*override fun toString(): String {
        return "Seguro Hogar(numPoliza=$numPoliza, dniTitular=$dniTitular, importe=$importe, metrosCuadrados = $metrosCuadrados, valorContenido: $valorContenido, direccion: $direccion, anioConstruccion: $anioConstruccion)"
    }
    //TODO ver cómo lo puedo arreglar
     */
}