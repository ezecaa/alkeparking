//add vehicles like Set because

class Parking(var vehicles: MutableSet<Vehicle>) {

    val maxCapacity = 20
    fun addVehicle(vehicle: Vehicle): Boolean {
        return if (maxCapacity > vehicles.count()) {
            vehicles.add(vehicle)
        } else false
    }
}