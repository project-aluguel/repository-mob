package school.sptech.renthouse

import kotlin.properties.Delegates

object SessaoItemMetrica {

    lateinit var tituloMetrica: String
    lateinit var fotoMetrica : String
    lateinit var idItemMetrica: String

    fun initIdItemMetrica(idItemMetrica:String){
        this.idItemMetrica = idItemMetrica
    }


    fun initTituloMetrica(tituloMetrica: String){
        this.tituloMetrica = tituloMetrica;
    }

    fun initFotoMetrica(fotoMetrica: String){
        this.fotoMetrica = fotoMetrica;
    }


}