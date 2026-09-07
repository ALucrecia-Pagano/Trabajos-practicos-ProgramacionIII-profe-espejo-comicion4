public class Guarda extends Cargo{
    private String tipoVehiculo;
    private String matriculaVehiculo;
    private Area areaAsignada;


    //Constructor
    public Guarda(String tipoVehiculo, String matriculaVehiculo, Area areaAsignada) {
        this.tipoVehiculo = tipoVehiculo;
        this.matriculaVehiculo = matriculaVehiculo;
        this.areaAsignada = areaAsignada;
    }

    @Override
    public String getDescripcionCargo() {
        return "Guarda en Área '" + areaAsignada.getNombre() + "' [Vehículo: " + tipoVehiculo + " (" + matriculaVehiculo + ")]";
    }
}
