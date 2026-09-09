import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        //  Crear Parque, Entradas y Áreas
        ParqueNatural parque = new ParqueNatural("Sierra Nevada", LocalDate.of(1999, 1, 14));
        Entrada entrada1 = new Entrada(1);
        Entrada entrada2 = new Entrada(2);
        parque.agregarEntrada(entrada1);
        parque.agregarEntrada(entrada2);

        Area areaNorte = new Area("Zona Norte - Cumbres", 450.5);
        Area areaSur = new Area("Zona Sur - Bosque", 320.0);
        parque.agregarArea(areaNorte);
        parque.agregarArea(areaSur);

        //  Crear Especies y registrar censos
        EspecieVegetal pino = new EspecieVegetal("Pinus sylvestris", "Pino Silvestre", true, "Primavera");
        EspecieAnimal lobo = new EspecieAnimal("Canis lupus", "Lobo Ibérico", "Enero-Febrero", TipoAlimentacion.CARNIVORO);
        EspecieAnimal ciervo = new EspecieAnimal("Cervus elaphus", "Ciervo Común", "Septiembre-Octubre", TipoAlimentacion.HERBIVORO);

        ciervo.agregarAlimento(pino);
        lobo.agregarAlimento(ciervo);

        areaSur.registrarCenso(pino, 15000);
        areaSur.registrarCenso(ciervo, 120);
        areaNorte.registrarCenso(lobo, 15);

        //  Crear Personal y demostrar el rol multifunción (Guarda + Investigador)
        Personal empleadoMultirrol = new Personal("12345678A", "Carlos Méndez", "Av. del Parque 45", "555-1234", 2500.0, "SS-998877");

        // Asignar rol Guarda
        Guarda rolGuarda = new Guarda("4x4 Todoterreno", "8833-JKL", areaSur);
        empleadoMultirrol.asignarCargo(rolGuarda);

        // Asignar rol Investigador simultáneo
        Investigador rolInvestigador = new Investigador("Dr. en Biología");
        ProyectoInvestigacion proyectoLobo = new ProyectoInvestigacion("Monitoreo del Lobo", 50000.0, LocalDate.of(2026, 1, 1), LocalDate.of(2026, 12, 31));
        proyectoLobo.agregarEspecie(lobo);
        rolInvestigador.asignarProyecto(proyectoLobo);
        empleadoMultirrol.asignarCargo(rolInvestigador);

        // Personal con rol Celador
        Personal celadorPedro = new Personal("87654321B", "Pedro Gómez", "Calle Roble 12", "555-4321", 1400.0, "SS-112233");
        Celador rolCelador = new Celador(entrada1);
        celadorPedro.asignarCargo(rolCelador);

        parque.contratarPersonal(empleadoMultirrol);
        parque.contratarPersonal(celadorPedro);

        //  Visitantes, Alojamientos y Excursiones
        Visitante visitante = new Visitante("44556677C", "Lucía Fernández", "Calle Mayor 8", "Arquitecta");
        rolCelador.registrarVisita(visitante, LocalDate.of(2026, 8, 20));

        Alojamiento refugio = new Alojamiento("Refugio Los Pinos", 30, "3 Estrellas");
        refugio.registrarEstancia("Habitación 102", LocalDate.of(2026, 8, 20), LocalDate.of(2026, 8, 25), visitante);

        Excursion excursionCumbres = new Excursion("EXC-01", LocalDate.of(2026, 8, 22), LocalTime.of(9, 30));
        excursionCumbres.inscribirVisitante(visitante);
        refugio.agregarExcursion(excursionCumbres);
        parque.agregarAlojamiento(refugio);

        //Mostrar resumen general
        parque.mostrarResumen();
    }
}
