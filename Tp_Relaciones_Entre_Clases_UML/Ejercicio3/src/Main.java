public class Main {
    public static void main(String[] args) {
        Pais argentina = new Pais("Argentina");
        Provincia cordoba = new Provincia("Cordoba");
        argentina.agregarProvincia(cordoba);

        Ciudad capital = new Ciudad("Ciudad de Cordoba", 1_400_000);
        capital.agregarImpuesto(new Impuesto(TipoImpuesto.IMP1, 1000));
        capital.agregarImpuesto(new Impuesto(TipoImpuesto.IMP2, 1000));
        capital.agregarImpuesto(new Impuesto(TipoImpuesto.IMP3, 1000));
        capital.agregarImpuesto(new Impuesto(TipoImpuesto.IMP4, 1000));
        capital.agregarImpuesto(new Impuesto(TipoImpuesto.IMP5, 1000));
        capital.agregarGasto(new Gasto(6000, "Bacheo de calles"));
        cordoba.agregarCiudad(capital);

        System.out.println("Ciudades en deficit: " + argentina.getCiudadesEnDeficit());
        System.out.println("Provincias en deficit: " + argentina.getProvinciasEnDeficit());
    }
}