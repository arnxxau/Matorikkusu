package arnxxau.matorikkusu

open class MatrixOperator (m: mutableMatrix){
    private val base = m

    fun transpose(): mutableMatrix {

        val rUnitary = MatrixTools(base).createMirrorReversedUnitary()

        for ((firstIndex, subArray) in base.withIndex()){
            for ((secondIndex, element) in subArray.withIndex()){
                rUnitary[secondIndex][firstIndex] = element
            }
        }
        return rUnitary
    }

    fun multiplyByNumber(n: Double): mutableMatrix {
        for (firstIndex in 0..base.size){
            for (secondIndex in 0..base.size){
                base[firstIndex][secondIndex] *= n
            }
        }
        return base
    }

    fun divideByNumber(n: Double): mutableMatrix {
        return multiplyByNumber(1/n)
    }



}