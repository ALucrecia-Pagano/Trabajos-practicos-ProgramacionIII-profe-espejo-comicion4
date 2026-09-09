import java.util.ArrayList;
import java.util.List;

public abstract class ComplejoDeportivo {
    private String nombre;
    private String localizacion;
    private String jefeOrganizacion;
    private double areaOcupada; // En m²
    private List<AreaDesignada> areas;
    private List<Evento> eventos;


    //Constructor
    public ComplejoDeportivo(String nombre, String localizacion, String jefeOrganizacion, double areaOcupada) {
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.jefeOrganizacion = jefeOrganizacion;
        this.areaOcupada = areaOcupada;
        this.areas = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }


    //Getter
    public String getNombre() { return nombre; }



    //Metodo para agregarun area, celebrar un evento y mostrar la informacion de Ficha
    public void agregarArea(AreaDesignada area) {
        areas.add(area);
    }

    public void celebrarEvento(Evento evento) {
        eventos.add(evento);
    }


    public void mostrarFicha() {
        System.out.println("\n[COMPLEJO] " + nombre + " | Ubicación: " + localizacion + " | Jefe: " + jefeOrganizacion + " | Área: " + areaOcupada + " m²");
        System.out.println("  Áreas designadas:");
        for (AreaDesignada a : areas) {
            System.out.println("    * " + a.getDeporte() + " -> " + a.getSituacion());
        }
        System.out.println("  Eventos programados:");
        for (Evento e : eventos) {
            e.mostrarDetalle();
        }
    }
}
