package co.viajesglobal.MicroserviceCarritoCompras.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.viajesglobal.MicroserviceCarritoCompras.Entity.Carrito;
import co.viajesglobal.MicroserviceCarritoCompras.Entity.EstadoCarrito;
import java.util.List;

public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    @Query("SELECT c FROM Carrito c WHERE c.idUsuario = :idUsuario AND c.estado = :estado")
    List<Carrito> findByIdUsuarioAndEstado(@Param("idUsuario") Long idUsuario, @Param("estado") EstadoCarrito estado);

    List<Carrito> findAllByIdUsuarioAndEstado(Long idUsuario, EstadoCarrito estado);
}
