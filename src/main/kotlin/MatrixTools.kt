package arnxxau.matorikkusu
class MatrixTools (m: Array<Array<Double>>){
    private val matrixBase = m



    fun createMirrorUnitary(): MutableList<MutableList<Double>> {
        return MatrixProcessing().createUnitary(matrixBase.size, matrixBase[0].size)
    }
    fun createMirrorReversedUnitary(): MutableList<MutableList<Double>> {
        return MatrixProcessing().createUnitary(matrixBase[0].size, matrixBase.size)
    }

    fun verifyIntegrity(): Boolean{
        val a = arrayListOf<Int>()
        var b = true
        for (subArray in matrixBase){
            a.add(subArray.size)
        }
        for (i in a){
            if (i != a[0]){
                b = false
            }
        }
        return b
    }

    fun isSquare(): Boolean{
        val a = arrayListOf<Int>()
        var b = false
        for (subArray in matrixBase){
            a.add(subArray.size)
        }
        if (verifyIntegrity()){
            if (a[0] == a.size){
                b = true
            }
        }
        return b
    }

    fun getSize(): Array<Int>{
        val numberOfRows = matrixBase.size
        val numberOfColumns = matrixBase[0].size
        return arrayOf(numberOfRows, numberOfColumns)
    }




    data class GaussOutput(val matrix: MutableList<MutableList<Double>>, val numberOfChanges: Int)
    fun gaussRowEchelonReduction(): GaussOutput {

        val newMatrix = matrixBase.staticToMutable()
        val booleanArray = mutableListOf<Boolean>()

        var zeroChecker = false
        var loopBreaker0: Boolean
        var loopBreaker1: Boolean
        var orderLead = 0
        var numberOfChanges = 0

        //orders the matrix
        fun matrixReorganizer(): Int {
            //creates a boolean list mirroring the inputted matrix
            fun booleanListCreator() {
                loopBreaker0 = true
                //searches for the column that has to be ordered
                while (loopBreaker0) {
                    booleanArray.clear()
                    //0 entries will be classified as false
                    for (r in newMatrix) {
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
                return -1
            }

            loopBreaker1 = true
            //changes the row position with the row containing false
            while (loopBreaker1) {
                for ((i, b) in booleanArray.withIndex()) {
                    if (!b) {
                        zeroChecker = true
                    }
                    if (zeroChecker && b) {
                        val a1 = newMatrix[i - 1]
                        val a2 = newMatrix[i]
                        newMatrix[i] = a1
                        newMatrix[i - 1] = a2
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
            return 0
        }


        //the for will be looped until the number of loops matches the number of columns

        matrixReorganizer()
        var lead = 0
        val colCount = matrixBase[0].size
        while (lead != colCount) {
            for ((i, row) in newMatrix.withIndex()) {
                val mainPivot = newMatrix[lead][lead]
                //omits the pivot row, in the first loop it will be the first sub array
                if (i > lead) {
                    if (mainPivot == 0.0) {
                        lead++
                    }
                    //a div number between the
                    val div: Double = (row[lead] / mainPivot)
                    for (c in 0 until colCount) {
                        if (c + 1 != lead) {
                            val new = row[c] - newMatrix[lead][c] * div
                            row[c] = new
                            //row[c] = round(new * 1000000000000000) / 1000000000000000
                        }
                    }
                }
            }
            lead++
        }
        return GaussOutput(newMatrix, numberOfChanges)
    }


    fun determinant(): Double? {
        val mList = mutableListOf<Double>()
        val gaussResult = gaussRowEchelonReduction()
        val m = gaussResult.matrix
        if (verifyIntegrity() && isSquare()) {
            for (l in 0 until m.size) {
                mList.add(m[l][l])
            }
            return mList.reduce { acc, d ->
                acc * d
            } * gaussResult.numberOfChanges.signCriteria()
        }
        return null
    }











    fun matrixDisplayer(){
        println("|ᴍᴀᴛʀɪx INFO|")
        print("- ")

        if (isSquare()){
            println("\uD835\uDE68\uD835\uDE66\uD835\uDE6A\uD835\uDE56\uD835\uDE67\uD835\uDE5A")
        }else{
            println("\uD835\uDE63\uD835\uDE64\uD835\uDE69 \uD835\uDE68\uD835\uDE66\uD835\uDE6A\uD835\uDE56\uD835\uDE67\uD835\uDE5A")
        }
        println("------------")

        for ((firstIndex, subArray) in matrixBase.withIndex()){
            for ((secondIndex, element) in subArray.withIndex()){
                if (secondIndex == 0){
                    print("")
                }
                print("$element ")
            }
            print("\n")
        }

        println("------------")
        println("by ᴍᴀᴛᴏʀɪᴋᴋᴜꜱᴜ\n")
    }
}