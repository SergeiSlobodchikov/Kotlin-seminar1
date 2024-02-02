data class Contact(val name: String, var phone: String?, var email: String?) {
    fun add(type: String, value: String) {
        if (type == "phone" && value.matches("^\\+?\\d+$".toRegex())) {
            this.phone = value
            println("Добавлен $name телефон $value")
        } else if (type == "email" && value.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$".toRegex())) {
            this.email = value
            println("Добавлен $name телефон $value")
        } else {
            println("Ошибка: $type должен быть либо email, либо phone")
        }
    }

    override fun toString(): String {
        return "Имя: $name Телефон: $phone email: $email"
    }
}
