package generics

// type hierarchy

open class WaterSupply(var needsProcessed:Boolean)


class  TapWater : WaterSupply(true){

        fun addChemicalCleaners(){
              needsProcessed = false
        }
}

class FishStoreWater:WaterSupply(false)


class LakeWater:WaterSupply(true){
     fun filter(){

         needsProcessed = false
     }

}
// generic classes
// we typically say generic types as type T that is type followed by the name of the generic
class Aquarium<out T:WaterSupply>(val waterSupply: T){
      fun addWater(cleaner: Cleaner<T>){
          if(waterSupply.needsProcessed){

              cleaner.clean(waterSupply)
          }

          // really convient for checking the state of the classes

          // throws an illegal exception when argument is false
          check(!waterSupply.needsProcessed) {"water supply needs processed"}
          println("adding water from $waterSupply")

      }
      inline fun <reified  R:WaterSupply> hasWaterSupplyOfType()  = {
         // R is bound by water supply
        // watersupply is type t
        // this is really saying return true if T is R
        // for this we need to tell kotlin that it's reified
        // reified just means  real
         // when we do that we are saying, declare a type parameter R but make it a real type
          // by using inline key the compiler then figures out what type R would have been and uses the real type
          // if you don't use  reified here type won't be real enough for kotlin to allow isChecks,
          // that's because non reified types are only available at compile time
          // but can't be used in run time by your program
           waterSupply is R
    }


}

 inline  fun<reified T:WaterSupply> WaterSupply.isOfType() = this is T

// * in Aquarium Generics says, I'll take any aquarium no matter what the generic type is
inline fun<reified R:WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R


// now T is available
fun genericExample(){
    val aquarium = Aquarium(TapWater())
    aquarium.waterSupply.addChemicalCleaners()
    aquarium.hasWaterSupplyOfType<TapWater>() // true
    aquarium.waterSupply.isOfType<LakeWater>() // false

    // flaw
//    val aquarium2 =Aquarium("String")
//    println(aquarium2.waterSupply)
// why kotlin even letting me pass null as it's of type T, not T?
  // well it turns out that by default T stands for the nullable any type
//    val aquarium3 = Aquarium(null)
//    aquarium3.waterSupply

    val aquarium4 = Aquarium(LakeWater())
    aquarium4.waterSupply.filter()
  //  aquarium4.addWater()

    val cleaner = TapWaterCleaner()
    val aquarium12 = Aquarium(TapWater())
    aquarium12.addWater(cleaner)
}

open class BaseBuildingMaterial() {
    open val numberNeeded = 1
}

class Wood : BaseBuildingMaterial() {
    override val numberNeeded = 4
}

class Brick : BaseBuildingMaterial() {
    override val numberNeeded = 8
}

class Building< T: BaseBuildingMaterial>(val buildingMaterial: T) {

    val baseMaterialsNeeded = 100
    val actualMaterialsNeeded = buildingMaterial.numberNeeded * baseMaterialsNeeded

    fun build() {
        println(" $actualMaterialsNeeded ${buildingMaterial::class.simpleName} required")
    }
}
fun <T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    if (building.actualMaterialsNeeded < 500) println("Small building")
    else println("large building")
}

fun main(args: Array<String>) {
    Building(Wood()).build()  // we can see that the generic type is only ever returned by the property water supply
    isSmallBuilding(Building(Brick()))
}

fun addItemTo(aquarium: Aquarium<WaterSupply>){
       println("item added")
}

fun genericsExample(){
    val a = Aquarium(TapWater())
    addItemTo(a)

   isWaterClean(a)

}


interface Cleaner<in T:WaterSupply>{

    fun clean(waterSupply:T)


}

class TapWaterCleaner: Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}


// default generic function with out type parameters
//fun isWaterClean(aquarium: Aquarium<WaterSupply>){
//     println("aquarium water is clean: ${aquarium.waterSupply.needsProcessed}")
//
//}
// generic function
// another way to say this T is a type parameter to isWaterClean being used to specify
// the generic type of the aquarium
//  even in the classes they have own generics types
fun <T:WaterSupply> isWaterClean(aquarium: Aquarium<T>){
    println("aquarium water is clean: ${aquarium.waterSupply.needsProcessed}")
}



// out types are type parameters that only ever occur in return values of functions or val properties
// if we try to pass an out type as a parameter to function, kotlin will give us a compile error

// kotlin can ensure that addItemTo won't do anything unsafe with a generic

//interface Source<out T> {
//    fun nextT(): T
//}
//
//fun demo(strs: Source<String>) {
//    val objects: Source<Any> = strs // This is OK, since T is an out-parameter
//    // ...
//}

// In types can be used anytime the generic is only used as an argument to functions
// more specifically, in types can only be passed into an Object
// out types can only be passed out of an object or returned
// There's one special time you can pass an out type
// Constructors can take out types as arguments
// but function never can


// ** Type erasure **
// it'll come up in some error messages that the compiler produces
//  All generics types are only used at compile time by kotlin
// At run time at runtime, all the generics types are erased