package arnxxau.matorikkusu
open class MatrixTools (m: mutableMatrix){
    private val base = m



    fun createMirrorUnitary(): MutableList<MutableList<Double>> {
        return MatrixProcessing().createUnitary(base.size, base[0].size)
    }
    fun createMirrorReversedUnitary(): MutableList<MutableList<Double>> {
        return MatrixProcessing().createUnitary(base[0].size, base.size)
    }

    fun verifyIntegrity(): Boolean{
        val arr = arrayListOf<Int>()
        var b = true
        for (subArray in base){
            arr.add(subArray.size)
        }
        for (i in arr){
            if (i != arr[0]){
                b = false
            }
        }
        return b
    }

    fun isSquare(): Boolean{
        val arr = arrayListOf<Int>()
        var b = false
        for (subArray in base){
            arr.add(subArray.size)
        }
        if (verifyIntegrity()){
            if (arr[0] == arr.size){
                b = true
            }
        }
        return b
    }

    fun getSize(): Pair<Int, Int> {
        val numberOfRows = base.size
        val numberOfColumns = base[0].size
        return Pair(numberOfRows, numberOfColumns)
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

    fun gaussRowEchelonReduction(): Pair<mutableMatrix, Int> {

        val (outputtedM, numberOfChanges) = matrixReorganizer()
        //the for will be looped until the number of loops matches the number of columns
        var lead = 0
        val colCount = base[0].size
        while (lead != colCount) {
            for ((i, row) in outputtedM.withIndex()) {
                val mainPivot = outputtedM[lead][lead]
                //omits the pivot row, in the first loop it will be the first sub array
                if (i > lead) {
                    if (mainPivot == 0.0) {
                        lead++
                    }
                    //a div number between the
                    val div: Double = (row[lead] / mainPivot)
                    for (c in 0 until colCount) {
                        if (c + 1 != lead) {
                            val new = row[c] - outputtedM[lead][c] * div
                            row[c] = new
                        }
                    }
                }
            }
            lead++
        }
        return Pair(outputtedM, numberOfChanges)
    }


    fun determinant(): Double? {
        val mList = mutableListOf<Double>()
        val (m, numberOfChanges) = gaussRowEchelonReduction()
        if (verifyIntegrity() && isSquare()) {
            for (l in 0 until m.size) {
                mList.add(m[l][l])
            }
            return mList.reduce { acc, d ->
                acc * d
            } * numberOfChanges.signCriteria()
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

        for ((firstIndex, subArray) in base.withIndex()){
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