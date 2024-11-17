package co.viajesglobal.MicroservicePagos.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.viajesglobal.MicroservicePagos.DTO.PagoDTO;
import co.viajesglobal.MicroservicePagos.Entitys.PagoEntity;

/**
 * Interfaz de repositorio que permite realizar operaciones de acceso a datos sobre la entidad Pago.
 * Extiende JpaRepository para proporcionar acceso a las operaciones CRUD básicas, 
 * y permite realizar consultas personalizadas mediante el uso de anotaciones y JPQL o SQL nativo.
 */
@Repository
public interface PagoRepository extends JpaRepository<PagoEntity, String> {

    /**
     * Método que obtiene una lista de pagos asociados a un cliente específico a partir de su identificador.
     * Utiliza una consulta SQL nativa para recuperar los registros de pagos correspondientes.
     * 
     * @param idCliente El identificador del cliente para el cual se desean obtener los pagos.
     * @return Una lista de entidades PagoEntity correspondientes a los pagos realizados por el cliente.
     */
    @Query(value = "SELECT * FROM pago WHERE Id_Cliente = :idCliente", nativeQuery = true)
    List<PagoEntity> listarporCliente(@Param("idCliente") int idCliente);
}
