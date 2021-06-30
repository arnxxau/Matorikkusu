fun main (){
    val matrixTEST: Array<Array<Int>> =
        arrayOf(
            arrayOf(3,2,4),
            arrayOf(4,2,3),
            arrayOf(4,2,3),
            arrayOf(22,9,0))

    val transposed = MatrixTools(matrixTEST).gaussRowEchelonReduction()

    print(transposed)

    MatrixTools(matrixTEST).matrixDisplayer()

}


