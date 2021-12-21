import java.util.*

class ParkingSpace (var vehicle: Vehicle) {
    
    private val MINUTES_IN_MILISECONDS = 60000

    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS

}