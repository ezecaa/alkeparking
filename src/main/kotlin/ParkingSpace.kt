import java.util.*

class ParkingSpace(var vehicle: Vehicle, val parking: Parking) {

    private val MINUTES_IN_MILISECONDS = 60000


    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS

    //onSuccess: (Int) -> Int, onError: (Unit) -> Unit
    fun checkOutVehicle(plate: String) {
        if (parking.vehicles.contains(vehicle)) {
            //mantener referencia del vehicle
            val discount = (vehicle.discountCard != "NO_DISCOUNT")
            onSuccess(calculateFee(vehicle.type, parkedTime.toInt(), discount))
            parking.increase(calculateFee(vehicle.type, parkedTime.toInt(), discount))
            parking.vehicles.remove(vehicle)
        } else {
            onError()
        }
    }

    fun calculateFee(type: VehicleType, parkedTime: Int, hasDiscountCard: Boolean): Int {

        var totalFee: Int = 0

        if (parkedTime <= 120) {
            totalFee = type.fee
        } else {
            val rest = parkedTime - 120
            val fraction = rest / 15
            val mod = rest % 15
            if (mod == 0) {
                totalFee = type.fee + (fraction * 5)
            } else {
                totalFee = type.fee + ((fraction + 1) * 5)
            }
        }

        if (hasDiscountCard) {
            totalFee = (totalFee * 0.85).toInt()
        }
        return totalFee
    }

    fun onSuccess(parkedTicket: Int){
        println("Your fee is $ $parkedTicket. Come back soon.")
    }

    fun onError() {
        println("Sorry, the check out failed")
    }






}