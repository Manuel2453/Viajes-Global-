package co.viajesglobal.MicroservicePagos.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.viajesglobal.MicroservicePagos.Entitys.PagoEntity;
import co.viajesglobal.MicroservicePagos.Entitys.TarjetaEntity;

/**
 * Interface del repositorio para la entidad TarjetaEntity.
 * Este repositorio se encarga de la interacción con la base de datos para realizar operaciones CRUD (crear, leer, actualizar, eliminar) sobre los registros de tarjetas.
 * Extiende JpaRepository, lo que proporciona métodos básicos para la persistencia de datos sin necesidad de implementación explícita.
 */
public interface TarjetaRepository extends JpaRepository<TarjetaEntity, String> {

    /**
     * Consulta personalizada que obtiene los números de tarjeta asociados a un cliente específico.
     * 
     * @param idCliente El identificador del cliente cuyas tarjetas se desean listar.
     * @return Una lista de números de tarjeta asociados al cliente.
     */
    @Query(value = "SELECT Numero_Tarjeta FROM datos_tarjeta WHERE Id_Cliente = :idCliente", nativeQuery = true)
    List<String> listarporCliente(@Param("idCliente") int idCliente);
}
