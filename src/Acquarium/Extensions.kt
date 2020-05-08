package Acquarium

import java.util.*

// extension allow you to add functions to an existing class without having to its code


// you coud declare a  class as extensions.kt  as part of your package


//fun String.hasSpaces() :Boolean{
//    val found : Char? = this.find { it==' ' }
//    return  found !=null
//}
fun String.hasSpaces() = find { it == ' ' } != null

fun extensionExample() {

    "Does it have spaces?".hasSpaces()
}

// you can also use it to separate the core API from helper methods on classes you do own
open class AquariumPlant(val color: String , private val size: Int)
class GreenLeafyPlant(size:Int) : AquariumPlant("Green",size)
fun AquariumPlant.isRed() = color == "Red"

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")
fun staticExample(){
    val plant = GreenLeafyPlant(size =50)
    plant.print() // GreenLeafyPlant
    val aquariumPlant : AquariumPlant = plant
    aquariumPlant.print() // AquariumPlant  this is because it resloved at statically compile time Aquarium plant is a Aquarium plant
}

// extension properties

val AquariumPlant.isGreen : Boolean
    get() =  color == "Green"

fun propertyExample(){

    val plant = AquariumPlant("Green",50)
    plant.isGreen// true
}
// receiver nullable
// this variable used in the body can be null
fun AquariumPlant?.pull(){
           this?.apply { println("removing $this") }

}

fun nullableExample(){

    val plant : AquariumPlant? = null
    plant.pull() // can be null
    // if the callers will want to call your extension function on nullable variables or
    // if you want to provide a default behavior when your function is applied to know
}

fun Book.weight() : Double { return (pages * 1.5) }
fun Book.tornPages(torn: Int) = if (pages >= torn) pages -= torn else pages = 0

class Puppy() {
    fun playWithBook(book: Book) {
        book.tornPages(Random().nextInt(12))
    }
}

fun main (args:Array<String>) {
    val puppy = Puppy()
    val book = Book("Oliver Twist", "Charles Dickens", 1837)

    while (book.pages > 0) {
        puppy.playWithBook(book)
        println("${book.pages} left in ${book.title}")
    }
    println("Sad puppy, no more pages in ${book.title}. ")
}