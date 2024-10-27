package co.viajesglobal.MicroservicePromociones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.viajesglobal.MicroservicePromociones.Entity.Promocion;

public interface PromocionRepository extends JpaRepository<Promocion, Integer> {
}
