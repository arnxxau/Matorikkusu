package arnxxau.matorikkusu

internal class MatrixProcessing {

    fun createUnitary(numberOfRows: Int, numberOfColumns: Int): MutableList<MutableList<Double>> {
        val newMatrix = mutableListOf(mutableListOf<Double>())
        for (i in 0 until numberOfRows){
            if (i != 0) {
                newMatrix.add(arrayListOf())
            }
            for (p in 0 until numberOfColumns){
                if ( i == p){
                    newMatrix[i].add(1.0)
                }else{
                    newMatrix[i].add(0.0)
                }
            }
        }
        return newMatrix
    }

    fun arraySortedOrNot(arr: MutableList<Boolean>, n: Int): Boolean {

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

    fun compatibleMatrix(m1: MatrixLoader.Matrix, m2: MatrixLoader.Matrix): Boolean{
        return m1.size.second == m2.size.first
    }
}

