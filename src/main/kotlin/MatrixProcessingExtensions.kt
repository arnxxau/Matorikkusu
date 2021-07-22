package arnxxau.matorikkusu


fun staticMatrix.staticToMutable(): mutableMatrix{
    return this.map {
        it.map {
            it }.toMutableList()
    }.toMutableList()
}

fun mutableMatrix.mutableToStatic(): staticMatrix{
    return this.map {
        it.map {
            it }.toTypedArray()
    }.toTypedArray()
}

fun Array<Array<Int>>.intToDouble(): staticMatrix{
    return this.map {
        it.map {
            it.toDouble() }.toTypedArray()
    }.toTypedArray()
}

fun Int.signCriteria(): Int{
    var y = -1
    for (i in 0..this){
        y*=-1
    }
    return y
}