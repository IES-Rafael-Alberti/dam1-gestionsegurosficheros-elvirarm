package data

import model.Seguro

open class RepoSegurosMem: IRepoSeguros {

    var seguros: MutableList<Seguro> = mutableListOf()

    override fun agregar(seguro: Seguro): Boolean {
        if(seguros.add(seguro)){
            return true
        }else{
            return false
        }
    }

    override fun buscar(numPoliza: Int): Seguro? {
        return seguros.find{it.numPoliza == numPoliza}
        }


    override fun eliminar(seguro: Seguro): Boolean {
        if(seguros.remove(seguro)){
            return true
        }else{
            return false
        }
    }

    override fun eliminar(numPoliza: Int): Boolean {

        val seguroAEliminar = buscar(numPoliza)

        if (seguroAEliminar != null){
            eliminar(seguroAEliminar)
            return true
        } else {
            return false
        }
    }

    override fun obtenerTodos(): List<Seguro> {
        return seguros
    }

    override fun obtener(tipoSeguro: String): List<Seguro> {
        return seguros.filter{it.tipoSeguro() == tipoSeguro }
    }
}