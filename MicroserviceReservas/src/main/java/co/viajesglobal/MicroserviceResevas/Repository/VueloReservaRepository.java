package co.viajesglobal.MicroserviceResevas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.viajesglobal.MicroserviceResevas.Entity.VueloReserva;

@Repository
public interface VueloReservaRepository extends JpaRepository<VueloReserva, Long> {
    // Aquí también podemos agregar consultas personalizadas si es necesario
}
