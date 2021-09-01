package arnxxau.matorikkusu



typealias mutableMatrix = MutableList<MutableList<Double>>
typealias staticMatrix = Array<Array<Double>>

fun main (){




    val matrixTEST: Array<Array<Int>> =
        arrayOf(
            arrayOf(0,3,4,7),
            arrayOf(9,2,1,5),
            arrayOf(0,8,4,2),
            arrayOf(5,7,3,2))



    val mDouble = matrixTEST.intToDouble()


    val matrix1: Array<Array<Int>> =
        arrayOf(
            arrayOf(1,2,3),
            arrayOf(4,5,6))

    val matrix2: Array<Array<Int>> =
        arrayOf(
            arrayOf(10,11),
            arrayOf(20,21),
            arrayOf(30,31))



    var arrm = arrayOf(matrix1.intToDouble(), matrix2.intToDouble())

    MatrixLoader().loadMatrix(arrm)
    var result = Matorikkusu().loadMultiOperators().chainMultiplication()
    println(result)





    //val booleanArray = mutableListOf(true, false , true, false)

   // val n = booleanArray.size
    //println(MatrixTools(matrixTEST).arraySortedOrNot(booleanArray, n))


    //val transposed = MatrixTools(mDouble).gaussRowEchelonReduction()
    //val determinant = MatrixTools(mDouble).determinant()
    //val mult = MatrixOperator(mDouble).multiplyByNumber(10.0)
    //val mm = MatrixProcessing().createUnitary(3,3)
    //val mml = MatrixOperator(mDouble).transpose()



    //println(transposed)
    //println(determinant)
    //println(mm)


    //MatrixTools(mm).matrixDisplayer()

}


