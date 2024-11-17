package co.viajesglobal.MicroserviceCarritoCompras.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.viajesglobal.MicroserviceCarritoCompras.Entity.Item_Carrito;

/**
 * Interfaz que extiende `JpaRepository` para acceder a las operaciones básicas de la base de datos
 * relacionadas con la entidad `Item_Carrito`.
 * 
 * Proporciona métodos para consultar los artículos del carrito de compras en función del ID del carrito.
 */
public interface Item_CarritoRepository extends JpaRepository<Item_Carrito, Long> {

    /**
     * Busca todos los artículos de un carrito de compras específico utilizando su ID.
     * 
     * @param idCarrito El ID del carrito cuyo artículo(s) se desean consultar.
     * @return Una lista de artículos pertenecientes al carrito con el `idCarrito` especificado.
     */
    List<Item_Carrito> findAllByCarrito_IdCarrito(Long idCarrito);

}
