package arnxxau.matorikkusu.testFiles

import arnxxau.matorikkusu.Matorikkusu
import arnxxau.matorikkusu.MatrixLoader
import arnxxau.matorikkusu.intToDouble

fun main (){
    val matrix1: Array<Array<Int>> =
        arrayOf(
            arrayOf(1,2,3),
            arrayOf(4,5,6))

    val matrix2: Array<Array<Int>> =
        arrayOf(
            arrayOf(10,11),
            arrayOf(20,21),
            arrayOf(30,31))

    val matrix3: Array<Array<Int>> =
        arrayOf(
            arrayOf(0,3,4,7),
            arrayOf(9,2,1,5),
            arrayOf(0,8,4,2),
            arrayOf(5,7,3,2))

    val arrM = arrayOf(matrix1.intToDouble(), matrix2.intToDouble(), matrix3.intToDouble())

    MatrixLoader().loadMatrix(arrM)

    println(
        Matorikkusu().loadOperators("C").matrixReorganizer()
    )
}


