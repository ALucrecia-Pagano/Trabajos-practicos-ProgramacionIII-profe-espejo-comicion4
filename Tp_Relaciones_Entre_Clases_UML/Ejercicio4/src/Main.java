public class Main {
    public static void main(String[] args) {
        Mineral nitrogeno = new Mineral("Nitrogeno", TipoInteres.PRIMARIO);
        Mineral fosforo = new Mineral("Fosforo", TipoInteres.SECUNDARIO);

        Lote loteA = new Lote("Lote A");
        loteA.agregarMineral(nitrogeno);
        loteA.agregarMineral(fosforo);

        GranoCosechaGruesa maiz = new GranoCosechaGruesa("Maiz");
        maiz.agregarMineralRequerido(fosforo);

        Cooperativa coop = new Cooperativa();
        coop.agregarCereal(maiz);

        System.out.println("Aconsejados para " + loteA + ": " + coop.aconsejarCerealesPara(loteA));
    }
}
