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

        var orderLead = 0; var numberOfChanges = 0
        //creates a boolean list mirroring the inputted matrix
        fun booleanListCreator() {
            //searches for the column that has to be ordered
            //the while loop will finish only if the array contains any number not equal to 0
            //if not, a new array of booleans will be created referencing the next column
            booleanArray.clear()
            while (!booleanArray.contains(true)) {
                booleanArray.clear()
                //0 entries will be classified as false
                for (row in outputtedM) {
                    if (row[orderLead] == 0.0) booleanArray.add(false)
                    else booleanArray.add(true)
                }
                orderLead++
            }
        }
        //if a matrix of 0's is inputted, it will be outputted without any changes
        booleanListCreator()
        if (booleanArray.contains(true)
            && !booleanArray.contains(false)
        ) return Pair(base, 0)
        /*
        This is a simple algorithm that detects 0's between other numbers and interchanges them.
        The previous generated bool list will look something like this: (true,false,true,false)
        Reflecting to a column of a matrix: (1,0,1,0)
        The approach to solve this consists of iterating through the bool list saving the previous
        'false' found and interchange it with the next 'true' found. The results after some iterations
        is the ordered matrix.
        true,false->/saves false idx/,true->/finds a true/,false
        Then are interchanged leading to the final result -> true, true, false, false
        After every iteration the array is checked in order to see if it is sorted or not.
         */
        //changes the row position with the row containing false
        //stops the process when all the trues are classified
        var zeroChecker = false
        while (!MatrixProcessing().arraySortedOrNot(booleanArray, booleanArray.size)) {
            for ((idx, bool) in booleanArray.withIndex()) {
                if (!bool) zeroChecker = true
                if (zeroChecker && bool) {
                    //as the bool list is a mirror of the matrix column the index are the same, so we can use them
                    val a1 = outputtedM[idx - 1]
                    val a2 = outputtedM[idx]
                    outputtedM[idx] = a1
                    outputtedM[idx - 1] = a2
                    zeroChecker = false
                    numberOfChanges++
                }
            }
            //updates the bool list
            booleanListCreator()
        }
        return Pair(outputtedM, numberOfChanges)
    }
}