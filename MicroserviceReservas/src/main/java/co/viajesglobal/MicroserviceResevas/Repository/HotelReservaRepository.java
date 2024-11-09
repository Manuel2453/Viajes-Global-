package co.viajesglobal.MicroserviceResevas.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.viajesglobal.MicroserviceResevas.Entity.HotelReserva;

@Repository
public interface HotelReservaRepository extends JpaRepository<HotelReserva, Long> {
    // Aquí podemos agregar consultas personalizadas si es necesario
}
