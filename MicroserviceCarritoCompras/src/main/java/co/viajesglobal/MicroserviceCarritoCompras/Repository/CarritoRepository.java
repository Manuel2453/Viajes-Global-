package co.viajesglobal.MicroserviceCarritoCompras.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.viajesglobal.MicroserviceCarritoCompras.Entity.Carrito;
import co.viajesglobal.MicroserviceCarritoCompras.Entity.EstadoCarrito;
import java.util.List;

/**
 * Interfaz que extiende `JpaRepository` para acceder a las operaciones básicas de la base de datos
 * relacionadas con la entidad `Carrito`.
 * 
 * Proporciona métodos para consultar los carritos de compras de un usuario en función de su estado.
 * Las consultas pueden obtener carritos filtrados por el `idUsuario` y su `estado` (Activo, Pagado, Cancelado).
 */
public interface CarritoRepository extends JpaRepository<Carrito, Long> {

    /**
     * Busca los carritos de un usuario específico que estén en un estado determinado.
     * 
     * @param idUsuario El ID del usuario para el cual se buscan los carritos.
     * @param estado El estado del carrito (por ejemplo, Activo, Pagado, Cancelado).
     * @return Una lista de carritos que coinciden con el `idUsuario` y el `estado` especificados.
     */
    @Query("SELECT c FROM Carrito c WHERE c.idUsuario = :idUsuario AND c.estado = :estado")
    List<Carrito> findByIdUsuarioAndEstado(@Param("idUsuario") Long idUsuario, @Param("estado") EstadoCarrito estado);

    /**
     * Busca todos los carritos de un usuario en un estado específico sin utilizar una consulta personalizada.
     * 
     * @param idUsuario El ID del usuario para el cual se buscan los carritos.
     * @param estado El estado del carrito (por ejemplo, Activo, Pagado, Cancelado).
     * @return Una lista de carritos que coinciden con el `idUsuario` y el `estado` especificados.
     */
    List<Carrito> findAllByIdUsuarioAndEstado(Long idUsuario, EstadoCarrito estado);
}
