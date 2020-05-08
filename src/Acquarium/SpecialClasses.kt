package Acquarium
// singleton pattern
object  MobyDickWhale{
    val author = "Herman Melville"
    fun jump(){


    }

}

enum class Color (val rgb :Int){
        RED(0xFF0000),
        GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0x0000FF)

}

sealed class Seal

class SeaLion : Seal()
class Walrus : Seal()

fun match(seal :Seal) :String {

    return when (seal) {
        is Walrus -> "walrus"
        // is SeaLion -> "sea lion"  // if you don't all of the seal sub class kotlin compiler will throw an error
        is SeaLion -> "sealion"
    }
}
    interface SpiceColor2 {
        val color: Color
    }

    object YellowSpiceColor : SpiceColor2 {
        override val color = Color.YELLOW
    }
