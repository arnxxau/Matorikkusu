fun main (){




    val matrixTEST: Array<Array<Int>> =
        arrayOf(
            arrayOf(9,2,1,5),
            arrayOf(3,3,4,7),
            arrayOf(2,8,4,2),
            arrayOf(5,7,3,2))

    //val booleanArray = mutableListOf(true, false , true, false)

   // val n = booleanArray.size
    //println(MatrixTools(matrixTEST).arraySortedOrNot(booleanArray, n))


    val transposed = MatrixTools(matrixTEST).gaussRowEchelonReduction()
    val determinant = MatrixTools(matrixTEST).matrixDeterminant()

    println(transposed)
    println(determinant)

    //MatrixTools(matrixTEST).matrixDisplayer()

}


