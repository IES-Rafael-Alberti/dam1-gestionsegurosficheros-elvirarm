package prog2425.dam1.seguros.data

import prog2425.dam1.seguros.model.Seguro


class RepoSegurosFich:RepoSegurosMem(), ICargarSegurosIniciales {

    override fun cargarSeguros(mapa: Map<String, (List<String>) -> Seguro>): Boolean {
        TODO("Not yet implemented")
    }


    override fun agregar(seguro: Seguro): Boolean{
        TODO("Not yet implemented")
    }

    override fun eliminar(seguro: Seguro): Boolean{
        TODO("Not yet implemented")    }

    /*override fun cargarSeguros(mapa: Map<String, (List<String>) -> Seguro>): Boolean{
        TODO("Not yet implemented")    }
    */

    fun actualizarContadores(seguros: List<Seguro>){
        TODO("Not yet implemented")
    }

}