package co.viajesglobal.MicroserviceReservas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.viajesglobal.MicroserviceReservas.Entity.Alojamiento;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AlojamientoRepository extends JpaRepository<Alojamiento, Integer> {
    List<Alojamiento> findByCiudadAndFechaEntradaLessThanEqualAndFechaSalidaGreaterThanEqual(
        String ciudad, Date fechaEntrada, Date fechaSalida);

	Optional<Alojamiento> findById(Long id);
}
