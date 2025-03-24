package model

import utils.FechaActual


class SeguroHogar: Seguro{

    private var metrosCuadrados: Int
    private var valorContenido: Double
    private var direccion: String
    private var anioConstruccion: Int


    /* Lo usaremos en la Contratacíon de un NUEVO seguro (genera un número de póliza automáticamente, gracias a una propiedad privada numPolizasAuto que comienza en el número 100000)*/
    constructor(dniTitular: String, importe: Double, metrosCuadrados: Int, valorContenido: Double, direccion: String, anioConstruccion: Int): super(
        generarPoliza(), dniTitular, importe){

        this.direccion = direccion
        this.valorContenido = valorContenido
        this.metrosCuadrados = metrosCuadrados
        this.anioConstruccion = anioConstruccion
    }


    /*
    Lo usaremos para crear una póliza ya existente (es decir, cuando recuperamos los seguros desde la persistencia de datos). Este segundo constructor no se podrá llamar desde fuera de la clase.
     */
    private constructor(numPoliza: Int, dniTitular: String, importe: Double, metrosCuadrados: Int, valorContenido: Double, direccion: String, anioConstruccion: Int): super(numPoliza, dniTitular, importe){

        this.direccion = direccion
        this.valorContenido = valorContenido
        this.metrosCuadrados = metrosCuadrados
        this.anioConstruccion = anioConstruccion
    }


    companion object{

        private const val PORCENTAJE_INCREMENTO_ANIOS = 0.02
        private const val CICLO_ANIOS_INCREMENTO = 5

        private var numPolizasAuto = 100000

        private fun generarPoliza(): Int{
            return ++numPolizasAuto
        }

    }

    override fun calcularImporteAniosSiguiente(interes: Double): Double {


        val anioAntiguedad = anioConstruccion - FechaActual.obtenerAnioActual()
        var anioAntiguedadTemporal = anioAntiguedad
        var contador = 0

        while (anioAntiguedadTemporal > CICLO_ANIOS_INCREMENTO){
            anioAntiguedadTemporal = anioAntiguedad - CICLO_ANIOS_INCREMENTO
            contador++

    }
        val interesResidual = contador * PORCENTAJE_INCREMENTO_ANIOS
        val importeAnioSiguiente =  (importe * interes) + interesResidual
        return importeAnioSiguiente
    }

    override fun tipoSeguro(): String {
        /*
         Retornar el nombre de la clase usando this::class.simpleName y el operador elvis para indicar al compilador que si simpleName es null (cosa que nunca debe pasar, ya que la clase tiene un nombre), entonces deberá retornar el valor "Desconocido".
         */
        return this::class.simpleName?: "Desconocido"
    }

    override fun serializar(): String {
        return "$numPolizasAuto; ${obtenerDni()}; $importe; $metrosCuadrados; $valorContenido; $direccion; ${tipoSeguro()}"
    }

    fun crearSeguro(datos: List<String>): SeguroHogar{
        //TODO controlar la conversión de datos
        val dniTitular = datos[0]
        val importe = datos[1]
        val metrosCuadrados = datos[2]
        val valorContenido = datos[3]
        val direccion = datos[4]
        val anioConstruccion = datos[5]
        return SeguroHogar(datos[0], datos[1].toDouble(), datos[2].toInt(), datos[3].toDouble(), datos[4], datos[5].toInt())
    }

    override fun toString(): String {
        return "Seguro Hogar(numPoliza=$numPolizasAuto, dniTitular=${obtenerDni()}, importe=$importe, metrosCuadrados = $metrosCuadrados, valorContenido: $valorContenido, direccion: $direccion, anioConstruccion: $anioConstruccion)"
    }
}