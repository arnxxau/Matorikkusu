class MatrixTools (m: Array<Array<Int>>){
    private val matrixBase = m



    fun unitaryCreator(): ArrayList<ArrayList<Int>> {
        val newMatrix = arrayListOf(arrayListOf<Int>())
        for (i in matrixBase.indices){
            if (i != 0) {
                newMatrix.add(arrayListOf())
            }
            for (p in matrixBase[0].indices){
                if ( i == p){
                    newMatrix[i].add(1)
                }else{
                    newMatrix[i].add(0)
                }
            }
        }
        return newMatrix
    }
    fun unitaryReversedCreator(): ArrayList<ArrayList<Int>> {
        val newMatrix = arrayListOf(arrayListOf<Int>())
        for (i in matrixBase[0].indices){
            if (i != 0) {
                newMatrix.add(arrayListOf())
            }
            for (p in matrixBase.indices){
                if ( i == p){
                    newMatrix[i].add(1)
                }else{
                    newMatrix[i].add(0)
                }
            }
        }
        return newMatrix
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


    fun reducedRowEchelonForm(){
        var lead = 0
        val rowCount = matrixBase.size
        val colCount = matrixBase[0].size


        for (r in 0 until rowCount){
            if (colCount <= lead) return

            var i = r

            while (matrixBase[i][lead] == 0){
                i++
                if (rowCount == i){
                    i = r
                    lead++

                    if (colCount == lead) return
                }
            }

            val temp = matrixBase[i]
            matrixBase[i] = matrixBase[r]
            matrixBase[r] = temp



        }



    }


    private fun arraySortedOrNot(arr: MutableList<Boolean>, n: Int): Boolean {

        var b = false
        if (n == 1 || n == 0){
            return true
        }
        if (arr[n - 1]){
            b = true
        }

        if (!arr[n - 2] && b){
            return false
        }

        return arraySortedOrNot(arr, n - 1)
    }

    fun gaussRowEchelonReduction(): MutableList<MutableList<Double>> {

        val newMatrix = matrixBase.map {
            it.map {
                it.toDouble() }.toMutableList()
        }.toMutableList()
        val booleanArray = mutableListOf<Boolean>()

        var zeroChecker = false
        var loopBreaker0: Boolean
        var loopBreaker1: Boolean
        var orderLead = 0

        fun matrixReorganizer(): Int {
            fun booleanListCreator(){
                loopBreaker0 = true
                while (loopBreaker0) {
                    booleanArray.clear()
                    for (r in newMatrix) {
                        if (r[orderLead] == 0.0) {
                            booleanArray.add(false)
                        } else {
                            booleanArray.add(true)
                        }
                    }
                    if (booleanArray.contains(true)){
                        loopBreaker0 = false
                    } else{
                        orderLead++
                    }
                }
            }

            booleanListCreator()
            if (booleanArray.contains(true)
                &&! booleanArray.contains(false)) {
                return -1
            }

            loopBreaker1 = true
            while (loopBreaker1){
                for ((i, b) in booleanArray.withIndex()){
                    if (!b){
                        zeroChecker = true
                    }
                    if (zeroChecker && b){
                        println(i)
                        val a1 = newMatrix[i-1]
                        val a2 = newMatrix[i]
                        newMatrix[i] = a1
                        newMatrix[i-1] = a2
                        zeroChecker =  false
                    }
                }
                booleanListCreator()
                val n = booleanArray.size
                if (arraySortedOrNot(booleanArray, n)){
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
             for ((i, row) in newMatrix.withIndex()){
                 val mainPivot = newMatrix[lead][lead]
               //omits the pivot row, in the first loop it will be the first sub array
               if (i > lead) {
                   if (mainPivot == 0.0){
                       lead++
                   }
                   //a div number between the
                   val div: Double = (row[lead] / mainPivot)
                   //print(div)
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
        return newMatrix
    }


    fun matrixDeterminant(): Double? {
        val mList = mutableListOf<Double>()
        val m = gaussRowEchelonReduction()
        if (verifyIntegrity() && isSquare()){
            for (l in 0 until m.size){
                mList.add(m[l][l])
            }
            return mList.reduce {
                acc, d ->  acc * d
            }
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