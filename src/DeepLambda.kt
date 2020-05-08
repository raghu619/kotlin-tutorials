

fun main(args:Array<String>){

waterFilter(30)
    val myFish = listOf(Fish("Flipper"),Fish("Moby Dick"),Fish("Dory"))

   println( myFish.filter{it.name.contains("i")}.joinToString(" "){it.name})

    val game = Game()
    println(game.path)
    game.north()
    game.south()
    game.east()
    game.west()
    game.end()
    println(game.path)


}
val newPrint= { println("Hello Fish")}()
val waterFiler = {dirty:Int -> dirty/2 }

data class Fish(val name:String)


enum class Direction {
      NORTH,EAST,WEST,SOUTH,START,END
}
class Game {

    var path = mutableListOf<Direction>(Direction.START)
    val north = { path.add(Direction.NORTH) }
    val south = { path.add(Direction.SOUTH) }
    val east = { path.add(Direction.EAST) }
    val west = { path.add(Direction.WEST) }
    val end = { path.add(Direction.END); println("Game Over: $path"); path.clear(); false }

}

