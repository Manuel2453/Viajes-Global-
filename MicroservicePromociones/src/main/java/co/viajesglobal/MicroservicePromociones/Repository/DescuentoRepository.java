package co.viajesglobal.MicroservicePromociones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.viajesglobal.MicroservicePromociones.Entity.Descuento;
import java.util.Optional;

/**
 * Repositorio de la entidad `Descuento`.
 * Esta interfaz extiende `JpaRepository`, lo que permite realizar operaciones CRUD (crear, leer, actualizar, eliminar)
 * sobre la tabla `descuentos` en la base de datos. Además, proporciona una capa de abstracción para interactuar con la
 * entidad `Descuento` sin necesidad de escribir consultas SQL.
 */
public interface DescuentoRepository extends JpaRepository<Descuento, Integer> {

    /**
     * Método para buscar un descuento por su código de cupón.
     * 
     * @param cupon El código del cupón que se desea buscar.
     * @return Un objeto `Optional<Descuento>` que contiene el descuento encontrado si existe, o un valor vacío si no se encuentra.
     */
    Optional<Descuento> findByCupon(String cupon);
}
