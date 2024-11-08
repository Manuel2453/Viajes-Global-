package co.viajesglobal.MicroserviceResevas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.viajesglobal.MicroserviceResevas.Entity.PaqueteReserva;

@Repository
public interface PaqueteReservaRepository extends JpaRepository<PaqueteReserva, Long> {
    // Puedes agregar métodos adicionales si es necesario
}
