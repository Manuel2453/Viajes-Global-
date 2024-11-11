package co.viajesglobal.MicroserviceReservas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.viajesglobal.MicroserviceReservas.Entity.Alojamiento;

import java.util.Date;
import java.util.List;

@Repository
public interface AlojamientoRepository extends JpaRepository<Alojamiento, Integer> {
    List<Alojamiento> findByCiudadAndFechaEntradaLessThanEqualAndFechaSalidaGreaterThanEqual(
        String ciudad, Date fechaEntrada, Date fechaSalida);
}
