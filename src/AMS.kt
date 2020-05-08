import java.util.*

fun main(args: Array<String>) {

    println("Hello, world")
    feedTheFish()
    repeat(2){

        print("A fish is swimming")
    }
    eagerExample()
    dirtyProcessor()


}
fun eagerExample(){

    val decorations = listOf("rock","pagoda","plastic plant","alligator","flowerpot")
    val eager = decorations.filter { it[0] == 'p' }
    println(eager)
    // apply filter lazily
    val filtered = decorations.asSequence().filter { it[0]=='p' }
    println(filtered.elementAt(1))
    println(filtered.toList())
    val lazyMap = decorations.asSequence().map {
        print("map : $it")
        it
    }
    println(lazyMap.first())



}
// lambda
var dirty = 20
var k= { println("Hello")}
val waterFilter = {dirty :Int -> dirty/2}
val waterFilter2 : (Int) -> Int ={dirty:Int -> dirty/2}
val waterFilter3 : (Int) -> Int ={dirty -> dirty/2}
fun feedFish(dirty:Int) = dirty +10
fun updateDirty(dirty:Int,operation :(Int) -> Int) :Int{
     return  operation(dirty)
}
fun dirtyProcessor(){

    dirty = updateDirty(dirty,waterFilter3)
    dirty = updateDirty(dirty,::feedFish)
    dirty = updateDirty(dirty){dirty -> dirty +50}
    dirty = updateDirty(dirty,{dirty -> dirty +50})
}
fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    if (shouldChangeWater(day)) {

        println("Change the water today")
    }

}

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {

    val isTooHot = temperature > 30
    val isDirty = dirty > 30
    val isSunday = day == "Sunday"

    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }


}

fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"
fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24): String {
    return when {
        mood == "happy" && weather == "Sunny" -> "go for a walk"
        else -> "Stay home and read."
    }
}

fun randomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Staturday", "Sunday")
    return week[Random().nextInt(7)]
}

fun fishFood(day: String): String {

    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        else -> "fasting"
    }

}