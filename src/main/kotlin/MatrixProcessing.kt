package arnxxau.matorikkusu

internal class MatrixProcessing {

    fun createUnitary(numberOfRows: Int, numberOfColumns: Int): mutableMatrix {
        val outputtedM = mutableListOf(mutableListOf<Double>())
        for (row in 0 until numberOfRows){
            if (row != 0) outputtedM.add(arrayListOf())
            for (clm in 0 until numberOfColumns){
                if (row == clm)outputtedM[row].add(1.0)
                else outputtedM[row].add(0.0)
            }
        }
        return outputtedM
    }

    fun arraySortedOrNot(arr: MutableList<Boolean>, n: Int): Boolean {
        var b = false
        if (n == 1 || n == 0) return true
        if (arr[n - 1]) b = true
        if (!arr[n - 2] && b) return false
        return arraySortedOrNot(arr, n - 1)
    }

    fun compatibleMatrix(m1: MatrixLoader.Matrix, m2: MatrixLoader.Matrix): Boolean {
        return m1.size.second == m2.size.first
    }

    /*
    Creates a string given an Int. nameGenerator() is used in order
    to create unlimited name combinations while inputting a new Matrix to the system.
    i.e: A...Z, AA,AB...AZ, BA...BZ
    */
    fun nameGenerator(input: Int): String {
        val nameArr = listOf('A','B','C','D', 'E'
            ,'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S',
            'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
        var name = ""
        var n: Int = input
        /*
        The result will be approached by using modulus and division functions.
        The algorithm will start from right to left meaning that at the end it will be necessary
        to reverse the final string.

        The while loop will finish when 'n' is less than 0 as that will mean we reduced
        the input enough times and no more letters have to be displayed.
        This can be easily seen by representing the first numbers of our display as this:
        x2:(((n-1)/26)-1)%26 x1: n-1%26
        n = 1
        x2: 0 x1: 0
        n = 5
        x2: 0 x1: 4
        n = 26
        x2: 0 x1: 25
        n = 27
        x2: 0 x1: 1
        */
        while (n > 0){
            n--
            name += nameArr[n%26]
            n /= 26
        }
        return name.reversed()
    }
}

