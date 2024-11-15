package co.viajesglobal.MicroservicePagos.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.viajesglobal.MicroservicePagos.Entitys.PagoEntity;
import co.viajesglobal.MicroservicePagos.Entitys.TarjetaEntity;

public interface TarjetaRepository extends JpaRepository<TarjetaEntity, String>{
	@Query(value = "SELECT Numero_Tarjeta FROM datos_tarjeta WHERE Id_Cliente = :idCliente", nativeQuery = true)
	List<String> listarporCliente(@Param("idCliente")int idCliente);
}
