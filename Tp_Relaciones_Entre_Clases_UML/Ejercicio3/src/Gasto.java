public class Gasto {
    private double monto;
    private String concepto;

    public Gasto(double monto, String concepto) {
        this.monto = monto;
        this.concepto = concepto;
    }

    public double getMonto() {
        return monto;
    }

    public String getConcepto() {
        return concepto;
    }
}
