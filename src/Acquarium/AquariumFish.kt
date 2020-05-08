package Acquarium

//abstract  class  AquariumFish :FishAction {
//
//    abstract  val color :String
//    override fun eat() {
//       println("swim")
//    }
//}class  Shark() : AquariumFish(),FishAction{
//  override val color: String
//       get() ="gray"
//    override fun eat() {
//        println("hunt and eat fish")
//    }
//}

//class  Plecostomus :AquariumFish(),FishAction{
//    override val color: String
//       get() = "gold"
//    override fun eat() {
//      println("munch on algee")
//    } }
 interface and abstract class usage
//interface FishAction{
//    fun eat()
//}

interface AquariumAction {
     fun eat()
    fun jump()
    fun clean()
    fun catchFish()
    fun swim(){
        println("swim")
   }
}
