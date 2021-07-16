class MatrixOperator (m: Array<Array<Int>>){
    private val matrixBase = m

    fun Transpose(): Array<Array<Int>> {
        val zeroMatrix = MatrixTools(matrixBase).unitaryReversedCreator()

        for ((firstIndex, subArray) in matrixBase.withIndex()){
            for ((secondIndex, element) in subArray.withIndex()){
                zeroMatrix[secondIndex][firstIndex]=element
            }
        }
        return zeroMatrix.map { it.toTypedArray() }.toTypedArray()
    }

    fun multiplyByNumber(){

    }
}