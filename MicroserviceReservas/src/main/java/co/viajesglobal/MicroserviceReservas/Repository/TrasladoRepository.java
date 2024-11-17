package co.viajesglobal.MicroserviceReservas.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import co.viajesglobal.MicroserviceReservas.Entity.Traslado;

/**
 * Repositorio para manejar operaciones de acceso a datos relacionadas con los traslados.
 * Este repositorio extiende JpaRepository para proporcionar métodos estándar de CRUD 
 * y se especializa en consultas personalizadas relacionadas con la disponibilidad de traslados.
 */
@Repository
public interface TrasladoRepository extends JpaRepository<Traslado, Long> {
	
    /**
     * Busca traslados disponibles en una ciudad específica para una fecha y hora determinada.
     * El traslado debe estar dentro del rango de disponibilidad y debe estar marcado como disponible.
     *
     * @param ciudad la ciudad en la que se busca el traslado.
     * @param fecha la fecha en la que se busca disponibilidad.
     * @param hora la hora en la que se busca disponibilidad.
     * @return una lista de traslados disponibles que cumplen con los criterios.
     */
    @Query("SELECT t FROM Traslado t WHERE t.ciudad = :ciudad AND " +
           "t.fechaInicioDisponible <= :fecha AND t.fechaFinDisponible >= :fecha AND " +
           ":hora BETWEEN t.horaInicio AND t.horaFin AND t.disponible = TRUE")
    List<Traslado> findAvailableTraslados(
            @Param("ciudad") String ciudad,
            @Param("fecha") LocalDate fecha,
            @Param("hora") LocalTime hora);
}
