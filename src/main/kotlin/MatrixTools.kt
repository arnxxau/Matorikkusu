import kotlin.math.round

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

    fun gaussRowEchelonReduction(): MutableList<MutableList<Double>> {
        var lead = 0
        val rowCount = matrixBase.size
        val colCount = matrixBase[0].size
        val newMatrix = matrixBase.map { it.map { it.toDouble() }.toMutableList() }.toMutableList()
        //the for will be looped until the number of loops matches the number of columns
        while (lead != colCount) {
             for ((i, row) in newMatrix.withIndex()){
                 val mainPivot = newMatrix[lead][lead]
               //omits the pivot row, in the first loop it will be the first sub array
               if (i > lead) {
                   //a div number between the
                   val div: Double = (row[lead] / mainPivot)
                   //print(div)
                   for (c in 0 until colCount) {
                       if (c + 1 != lead) {
                           val new = row[c] - newMatrix[lead][c] * div
                           row[c] = round(new * 1000000000000000) / 1000000000000000
                       }
                   }
               }
           }
            lead++
        }
        return newMatrix
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