package arnxxau.matorikkusu

class MultiMatrixOperator {

    fun multiplyMatrix(m1: MatrixLoader.Matrix, m2: MatrixLoader.Matrix): mutableMatrix {
        val outputtedM = MatrixProcessing().createUnitary(m1.size.first, m1.size.second)

        if (MatrixProcessing().compatibleMatrix(m1, m2)){
            var value = 0.0

            for ((indexRow, row) in outputtedM.withIndex()){
                for (indexClm in 0 until row.size){
                    for (l in 0..m1.size.first){
                        value += m1.multi_array[indexRow][l] * m2.multi_array[l][indexClm]
                    }
                    outputtedM[indexRow][indexClm] = value
                    value = 0.0
                }
            }
        }
        return outputtedM
    }
    fun chainMultiplication(): mutableMatrix {
        return mArr.reduce { acc, matrix ->
            MatrixLoader().createMatrix("r", multiplyMatrix(acc, matrix))  ?:
            MatrixLoader.Matrix("", acc.multi_array, false, Pair(0,0))
        }.multi_array
    }


    fun sumMatrix(m1: MatrixLoader.Matrix, m2: MatrixLoader.Matrix): MutableList<MutableList<Double>> {
        val outputtedM = MatrixTools(m1.multi_array).createMirrorUnitary()
        if (m1.size == m2.size){
            for (firstIndex in 0 until m1.size.first){
                for (secondIndex in 0 until m1.size.second){
                    outputtedM[firstIndex][secondIndex] =
                        m1.multi_array[firstIndex][secondIndex] + m2.multi_array[firstIndex][secondIndex]
                }
            }
        }
        return outputtedM
    }
    fun chainSum(): mutableMatrix {
        return mArr.reduce { acc, matrix ->
            MatrixLoader().createMatrix("r", sumMatrix(acc, matrix))  ?:
            MatrixLoader.Matrix("", acc.multi_array, false, Pair(0,0))
        }.multi_array
    }


    fun subtractMatrix(m1: MatrixLoader.Matrix, m2: MatrixLoader.Matrix): mutableMatrix {
        m2.multi_array = MatrixOperator(m2.multi_array).multiplyByNumber(-1.0)
        return sumMatrix(m1,m2)
    }
    fun chainSubtraction(): mutableMatrix {
        return mArr.reduce { acc, matrix ->
            MatrixLoader().createMatrix("r", subtractMatrix(acc, matrix))  ?:
            MatrixLoader.Matrix("", acc.multi_array, false, Pair(0,0))
        }.multi_array
    }
}