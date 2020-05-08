package Acquarium

fun main (args:Array<String>){
    number2(3)
    println(Constants3.BASE_URL + ".html")
}


const val rocks =3
val number = 5 // with val the value that is assigned can be determined during program execution
const val num  = 5  // const val the value is always determined at compile time

// program time val example can be assigned during run time
val number2  : (Int)-> Int ={
            dirty -> dirty/2
}

val number3 = valtest(2)
fun valtest(value:Int):Int{

    return  value/2
}


const val  CONSTANT = "top-level-constant"

object Constants {
       const val  CONSTANT2 ="object constant"
}
val foo = Constants.CONSTANT2
object Constants3 {
    const val BASE_URL = "http://www.turtlecare.net/"
}

fun printUrl() {

}

// kotlin does not have a concept of class level constants

// to define a constant inside a class yout have to wrap them into a companion object
// main difference between companion objects and regular objects is as follows
// Companion objects are initialized from the static constructor of  the containing class
// that is they are created when the object is created
// Plain objects are initailized lazily on the first access to that object
class  MyClass{
    companion object {

        const val CONSTANTS3 = "constant inside companion"
    }


}