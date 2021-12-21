import java.util.*

class ParkingSpace(var vehicle: Vehicle, val parking: Parking) {

    private val MINUTES_IN_MILISECONDS = 60000


    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS

    fun checkOutVehicle(plate: String, onSuccess: (Int) -> Int, onError: (String) -> String) {
        if (parking.vehicles.contains(vehicle)) {
            //mantene referencia del vehicle
            parking.vehicles.remove(vehicle)
            onSuccess(300)
        } else {
            onError("Error")
        }
    }

}