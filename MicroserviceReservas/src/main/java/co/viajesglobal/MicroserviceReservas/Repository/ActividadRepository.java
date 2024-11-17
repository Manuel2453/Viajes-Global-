package co.viajesglobal.MicroserviceReservas.Repository;

import co.viajesglobal.MicroserviceReservas.Entity.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repositorio para gestionar las operaciones de acceso a datos relacionadas con la entidad {@link Actividad}.
 * Extiende {@link JpaRepository} para proporcionar métodos CRUD básicos y permite la definición de consultas personalizadas.
 */
@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {

    /**
     * Busca actividades en un destino específico que estén activas en una fecha determinada.
     *
     * @param destino el destino de la actividad.
     * @param fecha   la fecha en la que se verifica si la actividad está activa.
     * @return una lista de actividades que coincidan con el destino y estén activas en la fecha especificada.
     */
    @Query("SELECT a FROM Actividad a WHERE a.destino = :destino AND a.fechaInicio <= :fecha AND a.fechaFin >= :fecha")
    List<Actividad> findByDestinoAndFecha(
        @Param("destino") String destino,
        @Param("fecha") LocalDate fecha
    );

    /**
     * Obtiene una lista de destinos únicos disponibles en las actividades registradas.
     *
     * @return una lista de destinos distintos.
     */
    @Query("SELECT DISTINCT a.destino FROM Actividad a")
    List<String> findDistinctDestinos();
}
