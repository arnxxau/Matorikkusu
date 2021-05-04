fun main (){
    val matrixTEST: Array<Array<Int>> =
        arrayOf(
            arrayOf(3,2,4),
            arrayOf(4,2,3),
            arrayOf(4,2,3),
            arrayOf(22,9,0))

    val transposed = MatrixOperator(matrixTEST).Transpose()

    MatrixTools(transposed).matrixDisplayer()

    MatrixTools(matrixTEST).matrixDisplayer()

}


