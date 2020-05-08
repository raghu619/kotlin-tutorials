package sam

// SAM is an acronym for single Abstract Method
// SAM examples Runnable and Callable
// Basically SAM just means an Interface with one method on it
interface  Runnable{

    fun run()
}
// Runnable has a abstract method run and callable has a single method call

interface Callable<T>{
    fun call():T
}

// java example

fun example(){

    val runnable =  object : Runnable{
        override fun run() {
            print("I'm a runnable")
        }

    }
    JavaRun.runNow(runnable)
    // best kotlin way
//    JavaRun.runNow{
//            println("Passing a lambda as a runnable")
//    }

    // we can use the  last parameter call syntax to specify the lambda outside of the prints
}