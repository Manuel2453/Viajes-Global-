package co.viajesglobal.MicroserviceReservas.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import co.viajesglobal.MicroserviceReservas.Entity.Traslado;

@Repository
public interface TrasladoRepository extends JpaRepository<Traslado, Long> {
	
	@Query("SELECT t FROM Traslado t WHERE t.ciudad = :ciudad AND " +
		       "t.fechaInicioDisponible <= :fecha AND t.fechaFinDisponible >= :fecha AND " +
		       ":hora BETWEEN t.horaInicio AND t.horaFin AND t.disponible = TRUE")
	List<Traslado> findAvailableTraslados(
	        @Param("ciudad") String ciudad,
	        @Param("fecha") LocalDate fecha,
	        @Param("hora") LocalTime hora);
}
