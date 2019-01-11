package src



fun main( args: Array<String>){

    println(listOf(1, 2, 3, 4).sum())
    val heroes = listOf(
        Hero("The Captain", 60, Sextype.MALE),
        Hero("Frenchy", 42, Sextype.MALE),
        Hero("The Kid", 9, Sextype.FEMALE),
        Hero("Lady Lauren", 29, Sextype.FEMALE),
        Hero("First Mate", 29, Sextype.MALE),
        Hero("Sir Stephen", 37, Sextype.MALE))

    println(heroes.all { it.age < 50 })//asking for all the indexes all of them are minor than 50

    val mapByAge: Map<Int, List<Hero>> = heroes.groupBy { it.age }
    val (age, group) = mapByAge.maxBy { (_, group) -> group.size }!!
    println(age)

    val mapByName: Map<String, Hero> = heroes.associateBy { it.name }
    println(mapByName["Frenchy"]?.age)//access with [] brackets returns null getValue() doesn't return NoSuchElementException


    val unknownHero = Hero("Unknown", 0, null)
    mapByName.getOrElse("unknown") { unknownHero }.age


     val allPossiblePairs = heroes.flatMap { first ->
         heroes.map { second-> first to second } // what this line does is all the possiuble pairs
     }
    val (oldest, youngest)= allPossiblePairs
        .maxBy { it.first.age - it.second.age }!!

    println("oldest: " + oldest.name + " \nYoungest: "+ youngest.name)
    val sum: (Int, Int) -> Int = { x, y -> x + y }

    val isEven = { i: Int -> i % 2 == 0 }

    val result = isEven(sum(2,4))
    println("This is the result of the Lambda Functions \n isEven(sum(2,4)) : "+result.toString())

    println(message = heroes.filter{isEven(it.age)})//we can also send a lambda function as a filter


    //we can return from lambdas using the labels


    //preicates

    val listNumbers = listOf(1,2,3)
    listNumbers.allNonZero()
    listNumbers.allNonZero1()
    listNumbers.allNonZero2()

    listNumbers.containsZero()
    listNumbers.containsZero1()
    listNumbers.containsZero2()

    println("abba".isNice())





}



data class Hero(val name: String, val age: Int, val sex : Sextype?)

fun String.isNice(): Boolean {
    var vowels  = 0
    var reps = false
    var coups = false
    if(this.contains("bu") || this.contains("ba") || this.contains("be"))
        coups =  true
    vowels = this.count { c: Char -> c == 'a' || c=='e' || c =='i' || c=='o' || c=='u' }
    var arr = this.toCharArray()
    var size = arr.size
    var iteration = 0
    do{
        if (iteration+1<size && arr[iteration] == arr[iteration+1])
            reps = true

        iteration++
    }while (iteration <=size)


    return (vowels>=3 && reps) || (vowels>=3 && !coups) || (reps && !coups )
}

enum class Sextype{
    MALE,FEMALE
}

fun String?.isEmptyOrNull() = this == null || this.isEmpty()

fun List<Int>.sum():Int {
    var total = 0
    for(i in this){
        total+=i
    }
    return total

}



