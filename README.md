# Matorikkusu! マトリックス ![GitHub release (latest by date)](https://img.shields.io/github/v/release/arnxxau/Matorikkusu)

Matorikkusu (**マトリックス!!**) is a Kotlin library for operating with Matrix.  
![Alt Text](https://i.imgur.com/ZnLUeJR.gif)
## Installation
#### Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:


	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

#### Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.arnxxau:Matorikkusu:v1.0.0-beta'
	}


## Usage
### 1- First we need to load Matorikkusu with the Matrix that we want to operate.
Matrix exist inside Matorikkusu as an _**arrays of arrays containing Double numbers**_ -> `Array<Array<Double>>`  
Alternatively we can use an existing extension within Matorikkusu called `.intToDouble` which will convert `Array<Array<Int>>` into `Array<Array<Double>>` as shown in the example.

    //Declaring the Matrix
    val matrix1: Array<Array<Double>> =
        arrayOf(
            arrayOf(1.0,2.0,3.0),
            arrayOf(4.0,5.0,6.0))

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



    //Here we create an Array of Matrix in order to load them all
    var arrayOfMatrix = arrayOf(matrix1, matrix2.intToDouble(), matrix.intToDouble())
    //Loading the arrayOfMatrix into Matorikkusu
    MatrixLoader().loadMatrix(arrayOfMatrix)

### 2- After loading the Matrix into Matorikkusu we can then start to operate with them.
It is important to know that Matorikkusu **will assign a name to each loaded Matrix**. For example looking at the piece of code shown above:

    matrix1 -> "A"  
    matrix2 -> "B"   
    matrix3 -> "C"

This is helpful to know when using functions that only require one loaded Matrix:

    //The name of the Matrix that we want to operate with is specified
    Matorikkusu().loadOperators("A").transpose()


## Available operations
### MatrixOperator() ; contains core functions in order to operate with a single Matrix
Loaded using `Matorikkusu().loadOperators("A")`. It is necessary to specify the Matrix's name.
Contains:
~~~
.transpose()  
.multiplyByNumber()  
.divideByNumber()  
.matrixReorganizer()
~~~

### MultiMatrixOperator() ; contains core functions in order to operate between two or more Matrix
Loaded using `Matorikkusu().loadMultiOperators()`. It is not necessary to specify the Matrix's name.
Contains:
~~~
.chainMultiplication()  
.chainSum()  
.chainSubtraction()
~~~
### MatrixTools() ; basic tools to find specific properties about a Matrix or to create new ones
Loaded using `Matorikkusu().loadTools("A")`. It is necessary to specify the Matrix's name.
Contains:
~~~
.createMirrorUnitary()   
.createMirrorReversedUnitary()  
.verifyIntegrity()  
.isSquare()
.getSize()  
.determinant()  
.matrixDisplayer()
~~~

## Future updates
It is expected for Matorikkusu to contain an Operator Interpreter in order to operate between Matrix without having to call the specified function:
`"(A * B + C) * D"`.  
It is also expected to run some code optimisations regarding the multiplication algorithm which seems to be the most resource demanding at the moment.
## Thanks for using Matorikkusu :)!
![AltText](https://i.imgur.com/3ioUsPp.gif)