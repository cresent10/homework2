// 햄버거 부모 클래스
open class Burger(val name: String, val price: Double, val ingredients: List<String>) {
    fun displayDetails() {
        println("$name - 가격: $price 원")
        println("재료: ${ingredients.joinToString(", ")}")
    }
}

// 자식 클래스 1
class BigMac : Burger("빅맥", 5000.0, listOf("소스", "패티", "치즈", "양상추", "피클")) {
    val hasSpecialSauce = true

    fun showSpecialSauce() {
        if (hasSpecialSauce) {
            println("맥런치")
        }

        // 자식 클래스 2
        class BulgogiBurger : Burger("불고기 버거", 5500.0, listOf("불고기 패티", "양상추", "마요네즈")) {
            //
        }

        // 음료 클래스
        class Beverage(val name: String, val size: String, val price: Double) {
            fun displayDetails() {
                println("$name - 크기: $size, 가격: $price 원")
            }
        }

        // 주문 클래스
        class Order {
            val burgers = mutableListOf<Burger>()
            val beverages = mutableListOf<Beverage>()

            fun addBurger(burger: Burger) {
                burgers.add(burger)
            }

            fun addBeverage(beverage: Beverage) {
                beverages.add(beverage)
            }

            fun displayOrderDetails() {
                println("주문 내역:")
                burgers.forEach {
                    it.displayDetails()
                }
                beverages.forEach {
                    it.displayDetails()
                }
                println("총 가격: ${calculateTotalPrice()} 원")
            }

            private fun calculateTotalPrice(): Double {
                var total = 0.0
                burgers.forEach {
                    total += it.price
                }
                beverages.forEach {
                    total += it.price
                }
                return total
            }
        }

        fun main() {
            // 메뉴 아이템 생성
            val bigMac = Burger("빅맥", 5200.0, listOf("소스", "패티", "치즈", "양상추"))
            val coke = Beverage("콜라", "M", 1500.0)

            // 주문 생성
            val order = Order()
            order.addBurger(bigMac)
            order.addBeverage(coke)

            // 주문 내역 출력
            order.displayOrderDetails()
