fun main() {
    println(calculateFee("Visa", 500000, 150000))
}

fun calculateFee(cardSystem: String = "Mir", lastTransfer: Int = 0, allTransfer: Int): Any {
    if (allTransfer > 150000) {
        println("Превышен суточный лимит!")
    }
    if ((lastTransfer + allTransfer) > 600000) {
        println("Превышен месячный лимит!")
    }
    return when (cardSystem) {
        "Mastercard" -> {
            val monthLimit = 75000
            val allAboveLimit = (lastTransfer + allTransfer) - monthLimit

            if (allAboveLimit <= 0) {
                0
            } else {
                val allFee = if (allAboveLimit > allTransfer) {
                    allTransfer
                } else {
                    allAboveLimit
                }
                (allFee * 0.006 + 20).toInt()
            }
        }

        "Visa" -> {
            val fee = allTransfer * 0.0075
            if (fee > 35) fee.toInt() else 35
        }

        "Mir" -> 0
        else -> println("Неизвестная карта!")
    }
}