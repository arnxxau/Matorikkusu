package arnxxau.matorikkusu

class Matorikkusu {


    var base = MatrixProcessing().createUnitary(1,1)
    fun loadTools(name: String): MatrixTools {

        for (m in mArr){
            if (m.name == name){
                base = m.multi_array
            }
        }
        return MatrixTools(base)
    }

    fun loadOperators(name: String): MatrixOperator {
        for (m in mArr){
            if (m.name == name){
                base = m.multi_array
            }
        }
        return MatrixOperator(base)
    }

    fun loadMultiOperators(): MultiMatrixOperator {
        return MultiMatrixOperator()
    }

}