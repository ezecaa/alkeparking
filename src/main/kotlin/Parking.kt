//add vehicles like Set because

class Parking(var vehicles: MutableSet<Vehicle>) {

    val maxCapacity = 20
    fun addVehicle(vehicle: Vehicle): Boolean {
        return if (maxCapacity > vehicles.count()) {
            vehicles.add(vehicle)
        } else false
    }

    // Exercise 11
    var earnings: Pair<Int, Int> = Pair(0, 0)

    fun increase(parkedTicket: Int): Unit {
        earnings = Pair(earnings.first + 1, earnings.second + parkedTicket)
        println("${earnings.first} vehicles have checked out and have earnings of $ ${earnings.second}")
    }

    fun listVehicle() {
        println("Parked Vehicles")
        println("----------------")
        for (vehicle in vehicles){
        println(vehicle.plate)
      }
    }
}