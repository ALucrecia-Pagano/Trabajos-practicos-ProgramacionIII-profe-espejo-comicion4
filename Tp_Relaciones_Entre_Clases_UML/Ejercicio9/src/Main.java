import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Museo museo = new Museo("Museo de Bellas Artes");


        Artista monet = new Artista("Claude Monet", LocalDate.of(1840, 11, 14), LocalDate.of(1926, 12, 5),
                "Francia", "Siglo XIX-XX", "Impresionismo", "Pintor clave del impresionismo.");

        ColeccionExterna museoLouvre = new ColeccionExterna("Museo del Louvre", "Museo Estatal",
                "Colección histórica", "París, Francia", "+33 1 40 20 50 50", "Jean Dupont");


        Pertenencia permanenteEnExpo = new ColeccionPermanente(LocalDate.of(2010, 5, 20), 450000.0, true);
        Pertenencia prestamoLouvre = new EnPrestamo(LocalDate.of(2026, 1, 15), LocalDate.of(2026, 12, 31), museoLouvre);


        ObjetoArte cuadroMonet = new Pintura(101, "Nenúfares", "Serie de pinturas al óleo", 1916,
                monet, "Francia", "Occidental", "Contemporánea", permanenteEnExpo,
                "Óleo", "Lienzo", "Impresionismo");

        ObjetoArte estatuaRomana = new Escultura(202, "Busto Romano", "Retrato en mármol de emperador", null,
                null, "Italia", "Romana", "Clásica", prestamoLouvre,
                "Mármol", 0.75, 45.0, "Clásico");


        museo.agregarObjetoAlInventario(cuadroMonet);
        museo.agregarObjetoAlInventario(estatuaRomana);


        Exposicion expoVerano = new Exposicion("Grandes Clásicos Europeos",
                LocalDate.of(2026, 6, 1), LocalDate.of(2026, 9, 30));
        expoVerano.agregarObjeto(cuadroMonet);
        expoVerano.agregarObjeto(estatuaRomana);
        museo.registrarExposicion(expoVerano);


        museo.mostrarInventarioGeneral();
        expoVerano.mostrarCatalogoExposicion();
    }
}
