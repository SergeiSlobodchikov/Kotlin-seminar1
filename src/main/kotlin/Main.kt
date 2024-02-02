import java.util.*

class Main
fun main() {
    val scanner = Scanner(System.`in`)
    val contacts = mutableListOf<Contact>()
    while (true) {
        println("Введите команду:")
        val command = scanner.nextLine()
        val (action) = command.split(" ").toList().map { it.trim() }.filter { it.isNotEmpty() }.take(1).toTypedArray()
        when (action) {
            "exit" -> break
            "help" -> printHelp()
            "show" -> {
                val (action, arg1) = command.split(" ").toList().map { it.trim() }.filter { it.isNotEmpty() }.take(2).toTypedArray()
                when (action) {
                    "show" -> {
                        val contact = contacts.find { it.name == arg1 }
                        if (contact != null) {
                            println(contact.toString())
                        } else {
                            println("Контакт $arg1 не найден")
                        }
                    }
                    else -> {
                        println("Ошибка: неизвестная команда $command")
                    }
                }
            }
            "add" -> {
                val (action, arg1, arg2, arg3) = command.split(" ").toList().map { it.trim() }.filter { it.isNotEmpty() }.take(4).toTypedArray()
                when (action) {
                    "add" -> {
                        val contact = contacts.find { it.name == arg1 }
                        if (contact == null) {
                            val newContact = Contact(arg1, null, null)
                            newContact.add(arg2, arg3)
                            contacts.add(newContact)
                        } else {
                            contact.add(arg2, arg3)
                            contacts.add(contact)
                        }
                    }
                    else -> {
                        println("Ошибка: неизвестная команда $command")
                    }
                }
            }
        }
    }
}