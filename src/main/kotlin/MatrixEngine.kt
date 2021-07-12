fun main (){
    val matrixTEST: Array<Array<Int>> =
        arrayOf(
            arrayOf(4,1,3),
            arrayOf(1,2,0),
            arrayOf(4,3,4),
            arrayOf(2,8,4))

    val transposed = MatrixTools(matrixTEST).gaussRowEchelonReduction()

    print(transposed)

    //MatrixTools(matrixTEST).matrixDisplayer()

}


