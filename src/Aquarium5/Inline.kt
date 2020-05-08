package Aquarium5

fun main(args:Array<String>){


}


data class Fish1(val name:String)

fun fishExamples1(){
    val fish = Fish1("splashy")
    // long hand version of myWith1
   // Creating an instance of function one every time myWith is called takes CPU
    // time and memory
    // overhead may if lambda is more complex
    // to solve this we use inline

    myWith1(fish.name,object : Function1<String,Unit>{
        override fun invoke(name: String) {
            name.capitalize()
        }


    })
    myWith1(fish.name){
        capitalize()
    }

    // with inline case no object is created, and lambda body  is inlined here
    fish.name.capitalize()
}

// block:String.() is a extension
// in the body it applies the extension lambda to the name
// we're parsing it a lambda which we'll call capitalize on the same

// ** every time we call myWith Kotlin will make a new Lambda object** //
// yes lambdas are objects

// that is a promise that every time myWith is called it will actually transform the
// source code to inLine, the function that is compiler will change the code to
// replace the lambda with the instructions inside the lambda that means zero overhead
// when inline function is applied the call to the lambda is replaced with the contents of
// the function body of the lambda
// it is worth noting that inline functions does increase does increase your code size
// so it's best used for simple functions like myWith
inline  fun myWith1(name:String,block: String.()-> Unit){

        name.block()

}
