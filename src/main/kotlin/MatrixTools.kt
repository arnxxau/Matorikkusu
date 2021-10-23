package arnxxau.matorikkusu
class MatrixTools internal constructor (m: mutableMatrix){
    private val base = m



    fun createMirrorUnitary(): mutableMatrix {
        return MatrixProcessing().createUnitary(base.size, base[0].size)
    }
    fun createMirrorReversedUnitary(): mutableMatrix {
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

    fun gaussRowEchelonReduction(): Pair<mutableMatrix, Int> {

        val (outputtedM, numberOfChanges) = MatrixOperator(base).matrixReorganizer()
        //the for will be looped until the number of loops matches the number of columns
        var lead = 0; val colCount = base[0].size
        while (lead != colCount && MatrixTools(outputtedM).isSquare()) {
            for ((idx, row) in outputtedM.withIndex()) {
                val mainPivot = outputtedM[lead][lead]
                //omits the pivot row, in the first loop it will be the first sub array
                if (idx > lead) {
                    if (mainPivot == 0.0) lead++
                    //a div number between the
                    val div: Double = (row[lead] / mainPivot)
                    for (clm in 0 until colCount) {
                        if (clm + 1 != lead) {
                            val new = row[clm] - outputtedM[lead][clm] * div
                            row[clm] = new
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