import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Excursion {
    private String codigo;
    private LocalDate dia;
    private LocalTime hora;
    private List<Visitante> inscritos;

    //Constructor
    public Excursion(String codigo, LocalDate dia, LocalTime hora) {
        this.codigo = codigo;
        this.dia = dia;
        this.hora = hora;
        this.inscritos = new ArrayList<>();
    }


    //Metodo para inscribir visitantes
    public void inscribirVisitante(Visitante v) {
        inscritos.add(v);
    }

    public String getCodigo() { return codigo; }
}
