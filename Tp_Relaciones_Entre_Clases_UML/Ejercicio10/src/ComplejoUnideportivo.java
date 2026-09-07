public class ComplejoUnideportivo extends ComplejoDeportivo{
    private String deportePrincipal;


    //Constructor
    public ComplejoUnideportivo(String nombre, String localizacion, String jefeOrganizacion, double areaOcupada, String deportePrincipal) {
        super(nombre, localizacion, jefeOrganizacion, areaOcupada);
        this.deportePrincipal = deportePrincipal;
    }
}
