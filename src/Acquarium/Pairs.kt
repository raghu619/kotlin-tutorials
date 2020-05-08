package Acquarium

fun main(args: Array<String>){
    val fishnet = "fishnet" to "catching fish"
    val fishnetString = fishnet.toString()
    val fishnetList = fishnet.toList()
    val (tool,use) = fishnet
    val (tool1,use1) = giveMeATool()

    val book = Book("Romeon and Juliet", "William Shakespeare", 1597)
    val bookTitleAuthor = book.getTitleAuthor()
    val bookTitleAuthorYear = book.getTitleAuthorYear()

    println("Here is your book ${bookTitleAuthor.first} by ${bookTitleAuthor.second}")

    println("Here is your book ${bookTitleAuthorYear.first} " +
            "by ${bookTitleAuthorYear.second} written in ${bookTitleAuthorYear.third}")



}


fun giveMeATool() :Pair<String,String> {

    return ("fishnet" to "catching")
}










val equipment =  "fishnet" to "catching" to "of big size" to "and strong"

val equip =("fishnet" to "catching fish") to ("of big size" to "and strong")


class Book(val title: String, val author: String, val year: Int) {
    var pages = 45

    fun getTitleAuthor(): Pair<String, String> {
        return (title to author)
    }

    fun getTitleAuthorYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }
}

