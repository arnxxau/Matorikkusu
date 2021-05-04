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