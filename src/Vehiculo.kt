open class Vehiculo (
    val marca: String,
    val modelo: String,
    capacidadCombustible: Float,
    combustibleActual: Float,
    var kilometrosActuales: Int
) {

    val capacidadCombustible = capacidadCombustible.redondear(2)
    var combustibleActual = combustibleActual.redondear(2)
        set(value) {
            field = if (value < 0) 0f else value.redondear(2)
        }

    init{
        require(capacidadCombustible > 0) { "La capacidad del tanque debe ser un valor positivo"}
        require(combustibleActual >= 0) { "El combustible actual no puede ser negativo"}
    }

    companion object {
        const val KM_POR_LITRO = 10.0f //10 km por litro
    }

    fun actualizaKilometraje ()

    fun obtenerInformacion() = "El vehículo puede recorrer ${calcularAutonomia()} km"

    fun calcularAutonomia() = combustibleActual * 10

    fun realizaViaje(distancia: Int) : Int {
        if (calcularAutonomia() <= distancia){
            combustibleActual = 0f
            return (distancia - calcularAutonomia()).toInt()
        } else {
            combustibleActual = distancia - calcularAutonomia()
            return 0
        }
    }

    fun repostar (cantidad: Float = 0f) : Float {
        if (cantidad <= 0 || (cantidad+combustibleActual) > capacidadCombustible){
            return (capacidadCombustible - combustibleActual)
            combustibleActual = capacidadCombustible
        } else {
            combustibleActual+=cantidad
            return cantidad
        }
    }
}