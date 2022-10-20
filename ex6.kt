import java.lang.Exception
import java.lang.IndexOutOfBoundsException

class DoublyLinkedList<T: Comparable<T>>{
    class DoublyLinkedNode<T: Comparable<T>> (var value: Comparable<T>) {
        var prev: DoublyLinkedNode <T>? = null
        var next: DoublyLinkedNode <T>? = null
    }

    private var end: DoublyLinkedNode<T>? = null
    private var start: DoublyLinkedNode<T>? = null

    fun add(value: Comparable<T>){
        val node = DoublyLinkedNode(value)
        node.next = null
        node.prev = end
        if (end == null) {
            end = node
            start = end
        } else end!!.next = node
        end = node
    }

    fun set(index: Int, value: Comparable<T>){
        var obj = start
        val node = DoublyLinkedNode(value)
        for (i in 0 until index){
            obj = obj?.next
        }
        if (obj != null) {
            node.next = obj.next
            node.prev = obj.prev
            obj.prev?.next = node
            obj.next?.prev = node
        } else {
            throw IndexOutOfBoundsException("Index: $index")
        }
        if(index == 0){
            start = node
        }
    }

    fun contains(value: Comparable<T>): Boolean{
        var obj = start
        while (obj != null){
            if (obj.value == value) return true
            obj = obj.next
        }
        return false
    }

    fun convertToString(): String{
        var str = ""
        var obj = start
        while (true){
            str += obj?.value.toString() + " "
            obj = obj?.next
            if (obj == null) break
        }
        return str
    }
}

fun main() {
    val list = DoublyLinkedList<Int>()
    list.add(3)
    list.add(6)
    list.add(9)
    list.add(11)
    print("Список после добавления элементов: ")
    println(list.convertToString())
    list.set(2, 7)
    print("Список после изменения второго(по индексу) элемента: ")
    println(list.convertToString())

    val cont = list.contains(3)
    print("Проверка содержится ли элемент(3) в списке: ")
    println(cont)
}
