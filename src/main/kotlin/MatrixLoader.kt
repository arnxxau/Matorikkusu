package arnxxau.matorikkusu

internal var mArr = mutableListOf<MatrixLoader.Matrix>()

class MatrixLoader {
    fun createMatrix(name: String, inputtedM: mutableMatrix): Matrix? {
        val mtx = MatrixTools(inputtedM)
        return if (mtx.verifyIntegrity()){
            Matrix(name,
                inputtedM,
                mtx.isSquare(),
                mtx.getSize())
        } else null
    }

    fun loadMatrix(arr: Array<staticMatrix>){
        var c = 1
        for (m in arr){
            val base = m.staticToMutable()

            val loadedM = createMatrix(MatrixProcessing().nameGenerator(c), base)
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