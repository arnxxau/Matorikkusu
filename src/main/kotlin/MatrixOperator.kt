package arnxxau.matorikkusu

class MatrixOperator internal constructor (m: mutableMatrix){
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
        for (firstIndex in 0 until base.size){
            for (secondIndex in 0 until base.size){
                base[firstIndex][secondIndex] *= n
            }
        }
        return base
    }

    fun divideByNumber(n: Double): mutableMatrix {
        return multiplyByNumber(1/n)
    }


    //orders the matrix
    fun matrixReorganizer(): Pair<mutableMatrix, Int> {
        val outputtedM = base
        val booleanArray = mutableListOf<Boolean>()

        var zeroChecker = false

        var orderLead = 0
        var numberOfChanges = 0

        //creates a boolean list mirroring the inputted matrix
        fun booleanListCreator() {

            var loopBreaker0 = true
            //searches for the column that has to be ordered
            while (loopBreaker0) {
                booleanArray.clear()
                //0 entries will be classified as false
                for (r in outputtedM) {
                    if (r[orderLead] == 0.0) {
                        booleanArray.add(false)
                    } else {
                        booleanArray.add(true)
                    }
                }
                if (booleanArray.contains(true)) {
                    loopBreaker0 = false
                } else {
                    orderLead++
                }
            }
        }

        booleanListCreator()
        if (booleanArray.contains(true)
            && !booleanArray.contains(false)
        ) {
            return Pair(base, 0)
        }

        var loopBreaker1 = true
        //changes the row position with the row containing false
        while (loopBreaker1) {
            for ((i, b) in booleanArray.withIndex()) {
                if (!b) {
                    zeroChecker = true
                }
                if (zeroChecker && b) {
                    val a1 = outputtedM[i - 1]
                    val a2 = outputtedM[i]
                    outputtedM[i] = a1
                    outputtedM[i - 1] = a2
                    zeroChecker = false
                    numberOfChanges++
                }
            }
            booleanListCreator()
            val n = booleanArray.size
            //stops the process when all the trues are classified
            if (MatrixProcessing().arraySortedOrNot(booleanArray, n)) {
                loopBreaker1 = false
            }
        }
        return Pair(outputtedM, numberOfChanges)
    }
}