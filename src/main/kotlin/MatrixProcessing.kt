class MatrixProcessing {

    fun mutableMatrixConverter(m: Array<Array<Double>>): MutableList<MutableList<Double>> {
        return m.map {
            it.map {
                it.toDouble() }.toMutableList()
        }.toMutableList()
    }

    fun IntMatrixConverter(m: Array<Array<Int>>): Array<Array<Double>> {
        return m.map {
            it.map {
                it.toDouble() }.toTypedArray()
        }.toTypedArray()
    }
}