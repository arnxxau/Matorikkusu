package arnxxau.matorikkusu

class MatrixOperator (m: Array<Array<Double>>){
    private val matrixBase = m

    fun transpose(): Array<Array<Double>> {
        val zeroMatrix = MatrixTools(matrixBase).createMirrorReversedUnitary()

        for ((firstIndex, subArray) in matrixBase.withIndex()){
            for ((secondIndex, element) in subArray.withIndex()){
                zeroMatrix[secondIndex][firstIndex]=element
            }
        }
        return zeroMatrix.mutableToStatic()
    }

    fun multiplyByNumber(n: Double): Array<Array<Double>> {
        val newMatrix = matrixBase.staticToMutable()

        for ((index, r) in newMatrix.withIndex()){
            for ((index1, c) in newMatrix.withIndex()){
                newMatrix[index][index1] *= n
            }
        }
        return newMatrix.mutableToStatic()
    }

    fun divideByNumber(n: Double): Array<Array<Double>> {
        return multiplyByNumber(1/n)
    }

    fun multiplyMatrix(mArr: Array<staticMatrix>): mutableMatrix? {
        val m1 = mArr[0]
        val m1Size = MatrixTools(m1).getSize()
        val m2 = mArr[1]
        val m2Size = MatrixTools(m2).getSize()


        if (MatrixProcessing().compatibleMatrix(m1, m2)){
            val m = MatrixProcessing().createUnitary(m1Size[0], m2Size[1])
            var r = 0.0

            for ((ixRow, row) in m.withIndex()){
                for ((ixClm, clm) in row.withIndex()){
                    for (l in 0..m1Size[0]){
                        println(ixRow)
                        println(ixClm)
                        r += m1[ixRow][l] * m2[l][ixClm]
                    }
                    m[ixRow][ixClm] = r
                    r = 0.0
                }
            }
            return m
        }
        return null
    }
}