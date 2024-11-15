package co.viajesglobal.MicroserviceReservas.Repository;

import co.viajesglobal.MicroserviceReservas.Entity.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {

    @Query("SELECT a FROM Actividad a WHERE a.destino = :destino AND a.fechaInicio <= :fecha AND a.fechaFin >= :fecha")
    List<Actividad> findByDestinoAndFecha(
        @Param("destino") String destino,
        @Param("fecha") LocalDate fecha
    );

    @Query("SELECT DISTINCT a.destino FROM Actividad a")
    List<String> findDistinctDestinos();
}
