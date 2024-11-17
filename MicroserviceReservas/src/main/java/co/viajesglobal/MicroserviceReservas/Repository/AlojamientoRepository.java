package co.viajesglobal.MicroserviceReservas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.viajesglobal.MicroserviceReservas.Entity.Alojamiento;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio para gestionar la persistencia de la entidad {@link Alojamiento}.
 * Proporciona métodos para realizar operaciones de base de datos personalizadas
 * además de las proporcionadas por {@link JpaRepository}.
 */
@Repository
public interface AlojamientoRepository extends JpaRepository<Alojamiento, Integer> {

    /**
     * Busca alojamientos en una ciudad específica que estén disponibles
     * dentro de un rango de fechas dado.
     *
     * @param ciudad       la ciudad donde se busca el alojamiento.
     * @param fechaEntrada la fecha de entrada, que debe ser igual o posterior a la fecha especificada.
     * @param fechaSalida  la fecha de salida, que debe ser igual o anterior a la fecha especificada.
     * @return una lista de alojamientos disponibles que cumplen con los criterios.
     */
    List<Alojamiento> findByCiudadAndFechaEntradaLessThanEqualAndFechaSalidaGreaterThanEqual(
            String ciudad, Date fechaEntrada, Date fechaSalida);

    /**
     * Busca un alojamiento por su identificador único.
     *
     * @param id el identificador del alojamiento.
     * @return un {@link Optional} que contiene el alojamiento si se encuentra, o vacío si no existe.
     */
    Optional<Alojamiento> findById(Long id);
}
