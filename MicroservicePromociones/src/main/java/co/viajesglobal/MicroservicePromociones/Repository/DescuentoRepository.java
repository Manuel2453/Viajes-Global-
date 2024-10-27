package co.viajesglobal.MicroservicePromociones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.viajesglobal.MicroservicePromociones.Entity.Descuento;

import java.util.Optional;

public interface DescuentoRepository extends JpaRepository<Descuento, Integer> {
    Optional<Descuento> findByCupon(String cupon);
}
