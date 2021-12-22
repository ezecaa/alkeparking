import java.util.*

fun main(args: Array<String>) {


    val arrayVehicle: Array<Vehicle> = arrayOf(
        Vehicle("AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001"),
        Vehicle("B222BBB", VehicleType.MOTORCYCLE, Calendar.getInstance()),
        Vehicle("CC333CC", VehicleType.MINIBUS, Calendar.getInstance()),
        Vehicle("DD444DD", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_002"),
        Vehicle("AA555AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_003"),
        Vehicle("B666BBB", VehicleType.MOTORCYCLE, Calendar.getInstance()),
        Vehicle("CC777CC", VehicleType.MINIBUS, Calendar.getInstance()),
        Vehicle("DD888DD", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_004"),
        Vehicle("AA999AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_005"),
        Vehicle("B000BBB", VehicleType.MOTORCYCLE, Calendar.getInstance()),
        Vehicle("CA111CC", VehicleType.MINIBUS, Calendar.getInstance()),
        Vehicle("DA222DD", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_006"),
        Vehicle("AA333AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_007"),
        Vehicle("B111BBB", VehicleType.MOTORCYCLE, Calendar.getInstance()),
        Vehicle("CA333CC", VehicleType.MINIBUS, Calendar.getInstance()),
        Vehicle("DA444DD", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_008"),
        Vehicle("BA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_009"),
        Vehicle("A222BBB", VehicleType.MOTORCYCLE, Calendar.getInstance()),
        Vehicle("A222BBB", VehicleType.CAR, Calendar.getInstance()), // repeated
        Vehicle("CC113CC", VehicleType.MINIBUS, Calendar.getInstance()),
        Vehicle("CC233CC", VehicleType.MINIBUS, Calendar.getInstance()),
        Vehicle("DD455DD", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_010")
    )

    val parking = Parking(mutableSetOf())

    for (i in arrayVehicle) {

        if (parking.addVehicle(i)) {
            println("Wellcome to AlkeParking!")
        } else {
            println("Sorry, the check-in failed")
        }
    }

    // Testing calculateFee function
    println()
    println("Testing calculateFee")
    val carPrueba = Vehicle("A222BBB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val parkingSpace = ParkingSpace(carPrueba, parking)
    println(parkingSpace.calculateFee(carPrueba.type, 300, true))

    val carPrueba2 = Vehicle("CC333CC", VehicleType.BUS, Calendar.getInstance())
    val parkingSpace3 = ParkingSpace(carPrueba2, parking)
    println(parkingSpace3.calculateFee(carPrueba2.type, 110, false))

    //val carPrueba3 = Vehicle("A222BBB", VehicleType.MINIBUS, Calendar.getInstance())
    //val parkingSpace4 = ParkingSpace(carPrueba3, parking)
    //println(parkingSpace4.calculateFee(carPrueba3.type, 90, true))

    //val carPrueba4 = Vehicle("A222BBB", VehicleType.MINIBUS, Calendar.getInstance())
    //val parkingSpace5 = ParkingSpace(carPrueba4, parking)
    //println(parkingSpace5.calculateFee(carPrueba3.type, 120, true))

    println()

    // End of Testing calculateFee

    //Testing Check-Out

    println("Testing check-out")
    val carPruebaCheck = Vehicle("DA444DD", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_008")
    val parkingSpace2 = ParkingSpace(carPruebaCheck,parking)
    parkingSpace2.checkOutVehicle(carPruebaCheck.plate)

    val carPruebaCheck2 = Vehicle("B111BBB", VehicleType.BUS, Calendar.getInstance(), "NO_DISCOUNT")
    val parkingSpace8 = ParkingSpace(carPruebaCheck2,parking)
    parkingSpace8.checkOutVehicle(carPruebaCheck2.plate)


    val carPruebaCheckFail = Vehicle("xxxxxx", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_008")
    val parkingSpace6= ParkingSpace(carPruebaCheck,parking)
    parkingSpace6.checkOutVehicle(carPruebaCheckFail.plate)

    parking.listVehicle()
}