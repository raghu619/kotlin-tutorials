package Aquarium5

data class Fish (var name:String)

fun main(args:Array<String>){
  fishExamples()

    val numbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    print(numbers.divisibleBy { it.rem(3) })

}

fun fishExamples(){
    val fish =Fish("splashy")
    // with is a higher order function
    with(fish.name){
        // object is implicitly reference by this
        // here we are saying fish.name capitalize
     //   this.capitalize()
        capitalize()

    }

    myWith(fish.name){
             println(chunked(2))

       // capitalize returns the copy of the past in string
        // it does not change the original string
    }

 // It takes one lambda as its argument and returns the result of executing the lambda
  println(  fish.run { name } )
// apply is similar to run  and can also be used on all data types
// unlike run which returns of the block function
// apply returns the object it's applied to
 // if its applied to fish it returns fish object
 // can be really useful calling functions on a newly created object
 println(fish.apply {  })
  // use case of apply
  // we create a new fish and before we assign it to a variable, we can call apply
  // common pattern for initailizing objects
  val fish2 = Fish("splahy").apply { name = "Sharky" }
  println(fish2.name)

 // let returns the copy of the changed object
  // let is particularly useful for chaining manipulations together

  println(fish.let { it.name.capitalize() }
          .let { it+ "fish" }
          .let{it.length}
          .let { it+31 })







}

// custom higher order function example
fun myWith(name:String,block: String.() -> Unit){
// block as function name because function needs a name
// so we can use it in the body of the myWith Function
// Extending functions like class String.() so that we can use myWith on it
 // We  want to use myWith on a string
 // the class we are is often called the receiver object
 // Unit is used since we are not returning anything
 // so locally, inside the function body of myWith,
 // block is now an extension function on a string object and we can apply it on a string
 // we can apply it on a string
  // so, we can apply the parsed in function to the parsed in argument


    name.block()




}


fun List<Int>.divisibleBy(block: (Int)-> Int) :List<Int>{
        val result = mutableListOf<Int>()
        for (item in this){
             if(block(item)== 0){
                  result.add(item)

             }

        }

       return  result


}


