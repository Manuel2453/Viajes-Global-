package co.viajesglobal.MicroserviceCarritoCompras.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.viajesglobal.MicroserviceCarritoCompras.Entity.Item_Carrito;

public interface Item_CarritoRepository extends JpaRepository<Item_Carrito, Long> {

    List<Item_Carrito> findAllByCarrito_IdCarrito(Long idCarrito);

}
