class Motocicleta(
    marca: String,
    modelo: String,
    capacidadCombustible: Float,
    combustibleActual: Float,
    kilometrosActuales: Int,
    cilindrada: Int
) : Vehiculo(marca, modelo, capacidadCombustible, combustibleActual, kilometrosActuales){

    companion object {
        const val KM_POR_LITRO = 20.0f //10 km por litro
        const val KM_POR_CABALLITO = 5.0f //Gasta como 5km por hacer un caballito
    }

    fun calcularAutonomia

}