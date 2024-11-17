package co.viajesglobal.MicroservicePromociones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.viajesglobal.MicroservicePromociones.Entity.Promocion;

/**
 * Repositorio de la entidad `Promocion`.
 * 
 * Esta interfaz extiende `JpaRepository` de Spring Data JPA, lo que proporciona métodos 
 * CRUD (Crear, Leer, Actualizar, Eliminar) listos para usar sin necesidad de implementación 
 * explícita. Permite interactuar con la tabla `promociones` en la base de datos, 
 * facilitando la manipulación de las entidades `Promocion`.
 * 
 * `PromocionRepository` actúa como una capa de abstracción entre la aplicación y 
 * la base de datos, lo que facilita las operaciones de acceso a datos.
 * 
 * Los métodos básicos de la interfaz `JpaRepository` incluyen:
 * - `save()`: para guardar o actualizar una entidad.
 * - `findById()`: para encontrar una entidad por su identificador.
 * - `findAll()`: para obtener todas las entidades de la tabla.
 * - `deleteById()`: para eliminar una entidad por su identificador.
 * 
 * No es necesario definir ninguna implementación específica para estos métodos ya que
 * `JpaRepository` los proporciona automáticamente.
 * 
 * @see JpaRepository
 * @see Promocion
 */
public interface PromocionRepository extends JpaRepository<Promocion, Integer> {
    // No es necesario agregar métodos aquí si se usan los proporcionados por JpaRepository.
    // Si se requieren consultas personalizadas, pueden añadirse métodos de consulta aquí.
}
