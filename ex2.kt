fun sortByChoice(array: Array<Int>): Array<Int>{
    val n = array.size - 1
    for (i in n downTo 0){
        var indexMax = i
        var max = array[i]
        for (j in 0 until i) {
            if(array[j] > max){
                max = array[j]
                indexMax = j
            }
        }
        if (max > array[i]){
            array[i] += array[indexMax]
            array[indexMax] = array[i] - array[indexMax]
            array[i] = array[i] - array[indexMax]
        }
    }
    return array
}

fun printArray(array: Array<Int>) {
    for (num in array) print("$num ")
}

fun main() {
    var arr = arrayOf(1, 4, 2, 9, 0, 5, 2)
    print("Исходный массив: ")
    printArray(arr)
    arr = sortByChoice(arr)
    print("\nОтсортированный массив: ")
    printArray(arr)
}
