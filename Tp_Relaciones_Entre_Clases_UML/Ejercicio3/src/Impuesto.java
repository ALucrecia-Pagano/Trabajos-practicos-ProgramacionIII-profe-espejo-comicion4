public class Impuesto {
    private TipoImpuesto tipo;
    private double monto;

    public Impuesto(TipoImpuesto tipo, double monto) {
        this.tipo = tipo;
        this.monto = monto;
    }

    public TipoImpuesto getTipo() {
        return tipo;
    }

    public double getMonto() {
        return monto;
    }
}
