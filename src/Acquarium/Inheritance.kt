package Acquarium

fun main(args: Array<String>){
delegate()

}

fun delegate(){
  val pleco = Plecostomus()
  println("Fish has color ${pleco.color}")
  pleco.eat()

}

interface FishAction{
    fun eat()
}

interface  FishColor{
    val color :String
}
class  Plecostomus(fishColor: FishColor=GoldColor) :FishAction by PrintingFishAction("a lot of algae"),FishColor by fishColor




val GoldColor= object : FishColor{
    override val color: String
        get() = "gold"
}

object  RedColor : FishColor{
    override val color: String
        get() = "red"

}

class  PrintingFishAction(val food:String):FishAction{
    override fun eat() {
        print(food)
    }

}
