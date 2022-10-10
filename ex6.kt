import java.util.*

fun main() {
    val list = LinkedList<Int>()
    list.add(5)
    list.add(2)
    list.add(1)
    list.add(4)
    println("Список после добавления элементов: $list")
    list.set(2, 9)
    println("Список после изменения второго(по индексу) элемента: $list")
    val cont = list.contains(2)
    println("Проверка содержится ли элемент(2) в списке: $cont")
    list.remove(9)
    println("Список после удаления 9 из списка: $list")
    val index = list.indexOf(4)
    println("Индекс элемента(4) в списке: $index")
}
