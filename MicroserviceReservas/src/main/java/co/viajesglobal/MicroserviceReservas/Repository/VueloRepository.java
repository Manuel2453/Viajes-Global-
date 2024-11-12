package co.viajesglobal.MicroserviceReservas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.viajesglobal.MicroserviceReservas.Entity.Vuelo;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {

    List<Vuelo> findByOrigenAndDestinoAndFechaSalidaBetween(
            String origen, 
            String destino, 
            LocalDateTime fechaSalidaInicio, 
            LocalDateTime fechaSalidaFin
    );

    List<Vuelo> findByOrigenAndDestinoAndFechaSalidaAndFechaLlegada(
            String origen, 
            String destino, 
            LocalDateTime fechaSalida, 
            LocalDateTime fechaLlegada
    );

    @Query("SELECT DISTINCT v.origen FROM Vuelo v")
    List<String> findDistinctOrigen();

    @Query("SELECT DISTINCT v.destino FROM Vuelo v")
    List<String> findDistinctDestino();
}

