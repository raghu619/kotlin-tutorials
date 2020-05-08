package Acquarium

fun main (args:Array<String>){
val testList = listOf<Int>(11,12,13,14,15,16,17,18,19,20)
    println(reverseLIst(testList))
val symptoms = mutableListOf("white spots","red spots","not eating","bloated","belly up")

    symptoms.add("white fungus")
    symptoms.remove("red")
    symptoms.contains("red")
    symptoms.contains("red spots")
    println(symptoms.subList(4,symptoms.size))
    listOf(1,5,3).sum() // 9
    listOf("a","b","cc").sumBy { it.length } //4

    val cures = mapOf("white spots" to "Ich", "red sores" to "hole disease" )

    println(cures.get("white spots"))
    println(cures["white spots"])
    println(cures.getOrDefault("bloating","sorry I don't know"))
    cures.getOrElse("bloating"){"No cure for this"}
    val inventory = mutableMapOf("fish net" to 1)
    inventory.put("tank scrubber",3)
    inventory.remove("fish net")


    val allBooks = setOf("Macbeth", "Romeo and Juliet", "Hamlet", "A Midsummer Night's Dream")
    val library = mapOf("Shakespeare" to allBooks)
    println(library.any { it.value.contains("Hamlet") })

    val moreBooks = mutableMapOf<String, String>("Wilhelm Tell" to "Schiller")
    moreBooks.getOrPut("Jungle Book") { "Kipling" }
    moreBooks.getOrPut("Hamlet") { "Shakespeare" }
    println(moreBooks)

}

fun reverseLIst(list :List<Int>):List<Int>{
    val result = mutableListOf<Int>()
    for (i in 0..list.size-1){

        result.add(list[list.size-i-1])
    }
      return  result
}


fun reverseListAgain(list :List<Int>):List<Int>{
    val result = mutableListOf<Int>()
    for (i in list.size-1 downTo 0){

        result.add(list[i])
    }
    return  result
}