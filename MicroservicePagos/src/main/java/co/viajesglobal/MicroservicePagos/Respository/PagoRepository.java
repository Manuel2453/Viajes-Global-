package co.viajesglobal.MicroservicePagos.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.viajesglobal.MicroservicePagos.DTO.PagoDTO;
import co.viajesglobal.MicroservicePagos.Entitys.PagoEntity;

@Repository
public interface PagoRepository extends JpaRepository<PagoEntity, String>{
	
	@Query(value = "SELECT * FROM pago WHERE Id_Cliente = :idCliente", nativeQuery = true)
	List<PagoEntity> listarporCliente(@Param("idCliente")int idCliente);
}
