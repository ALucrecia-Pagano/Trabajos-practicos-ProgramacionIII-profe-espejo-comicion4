public class Inscripcion {
    private Prueba prueba;
    private ParticipanteEnPrueba participante;
    private int dorsal;

    public Inscripcion(Prueba prueba, ParticipanteEnPrueba participante, int dorsal) {
        this.prueba = prueba;
        this.participante = participante;
        this.dorsal = dorsal;
    }

    public String getCodigo() { return prueba.getNombre() + "-" + dorsal; }
    public ParticipanteEnPrueba getParticipante() { return participante; }

    @Override
    public String toString() { return getCodigo() + " (" + participante.getNombreParticipante() + ")"; }
}