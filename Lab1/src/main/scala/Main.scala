package main
object Hello {
    def main(args: Array[String]) = {
        println("Hello, world")
        val firstSet = List((-1, 1), (-2, 4), (1,1), (2,2), (3,3))
        val secondSet = List((2,1), (3,1), (1,2), (2,3), (-1, 5), (-1, 5))
        println(findIntersection(firstSet, secondSet))
    }

    def findIntersection(firstSet: List[(Int, Int)], secondSet: List[(Int, Int)]): List[(Int, Int)] = {
        if(firstSet.isEmpty || secondSet.isEmpty) return Nil
        val index: Int = indexOfElementInSet(firstSet.head._1, secondSet)
        if (index == -1)
          findIntersection(firstSet.tail, secondSet)
        else 
            findCountOfPair(firstSet.head, secondSet(index)) ++ findIntersection(firstSet.tail, secondSet.patch(index, Nil, 1))
    }

    def indexOfElementInSet(element: Int, set: List[(Int, Int)]): Int = 
        set.indexWhere(_._1 == element)


    def findCountOfPair(firstPair: (Int, Int), secondPair: (Int, Int)): List[(Int, Int)] =
        if (firstPair._2 < 1 || secondPair._2 < 1) return Nil
        else if (firstPair._2 < secondPair._2) List(firstPair)
        else List(secondPair)
}