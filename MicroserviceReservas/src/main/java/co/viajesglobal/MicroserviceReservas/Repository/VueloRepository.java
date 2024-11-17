package co.viajesglobal.MicroserviceReservas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.viajesglobal.MicroserviceReservas.Entity.Vuelo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repositorio para manejar las operaciones de acceso a datos relacionadas con los vuelos.
 * Este repositorio extiende JpaRepository, proporcionando métodos estándar de CRUD y consultas personalizadas 
 * para la gestión de entidades de tipo `Vuelo`.
 */
@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {

    /**
     * Encuentra vuelos disponibles que coincidan con un origen, destino y un rango de fechas de salida.
     * 
     * @param origen el lugar de origen del vuelo.
     * @param destino el lugar de destino del vuelo.
     * @param fechaSalidaInicio la fecha de inicio del rango de salida.
     * @param fechaSalidaFin la fecha de fin del rango de salida.
     * @return una lista de vuelos disponibles que coinciden con los parámetros.
     */
    List<Vuelo> findByOrigenAndDestinoAndFechaSalidaBetween(
            String origen, 
            String destino, 
            LocalDateTime fechaSalidaInicio, 
            LocalDateTime fechaSalidaFin
    );

    /**
     * Encuentra vuelos que coincidan con un origen, destino y fechas exactas de salida y llegada.
     * 
     * @param origen el lugar de origen del vuelo.
     * @param destino el lugar de destino del vuelo.
     * @param fechaSalida la fecha de salida del vuelo.
     * @param fechaLlegada la fecha de llegada del vuelo.
     * @return una lista de vuelos que coinciden con las fechas exactas de salida y llegada.
     */
    List<Vuelo> findByOrigenAndDestinoAndFechaSalidaAndFechaLlegada(
            String origen, 
            String destino, 
            LocalDateTime fechaSalida, 
            LocalDateTime fechaLlegada
    );

    /**
     * Obtiene una lista de los lugares de origen distintos disponibles en los vuelos.
     * 
     * @return una lista de lugares de origen sin duplicados.
     */
    @Query("SELECT DISTINCT v.origen FROM Vuelo v")
    List<String> findDistinctOrigen();

    /**
     * Obtiene una lista de los lugares de destino distintos disponibles en los vuelos.
     * 
     * @return una lista de lugares de destino sin duplicados.
     */
    @Query("SELECT DISTINCT v.destino FROM Vuelo v")
    List<String> findDistinctDestino();
    
    /**
     * Encuentra vuelos disponibles que coincidan con un origen, destino y fecha de salida exacta.
     * 
     * @param origen el lugar de origen del vuelo.
     * @param destino el lugar de destino del vuelo.
     * @param fechaSalida la fecha exacta de salida.
     * @return una lista de vuelos disponibles para la fecha indicada.
     */
    List<Vuelo> findByOrigenAndDestinoAndFechaSalida(String origen, String destino, LocalDateTime fechaSalida);
}
