package arnxxau.matorikkusu

internal var mArr = mutableListOf<MatrixLoader.Matrix>()

class MatrixLoader {


    fun createMatrix(name: String, inputtedM: mutableMatrix): Matrix? {
        val mt = MatrixTools(inputtedM)
        return if (mt.verifyIntegrity()){
            Matrix(name, inputtedM,
                mt.isSquare(),
                mt.getSize())
        } else{
            null
        }
    }


    fun loadMatrix(arr: Array<staticMatrix>){
        val nameArr = listOf("A","B","C","D", "E"
            ,"F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S",
            "T", "U", "V", "W", "X", "Y", "Z")
        var c = 0
        for (m in arr){
            val base = m.staticToMutable()

            val loadedM = createMatrix(nameArr[c], base)
            if (loadedM != null){
                mArr.add(loadedM)
                c++
            }
        }
    }



    data class Matrix(
        val name: String,
        var multi_array: mutableMatrix,
        val is_square: Boolean,
        val size: Pair<Int, Int>
            )
}