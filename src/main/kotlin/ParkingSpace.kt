import java.util.*

class ParkingSpace(var vehicle: Vehicle, val parking: Parking) {

    private val MINUTES_IN_MILISECONDS = 60000


    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS

    fun checkOutVehicle(plate: String, onSuccess: (Int) -> Int, onError: (String) -> String) {
        if (parking.vehicles.contains(vehicle)) {
            //mantener referencia del vehicle
            val discount = (vehicle.discountCard != "NO_DISCOUNT")
            onSuccess(calculateFee(vehicle.type, parkedTime.toInt(), discount))
            parking.vehicles.remove(vehicle)
        } else {
            onError(plate)
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

}