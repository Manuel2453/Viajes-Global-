package co.viajesglobal.MicroservicePromociones.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.viajesglobal.MicroservicePromociones.Entity.Promocion;
import co.viajesglobal.MicroservicePromociones.Repository.PromocionRepository;

/**
 * Servicio para manejar la lógica de negocio relacionada con las promociones.
 * 
 * Esta clase contiene la lógica que interactúa con el repositorio de `Promocion` para realizar
 * operaciones sobre las promociones. Está anotada con `@Service`, lo que indica que es un 
 * componente de servicio en el contexto de Spring y permite la inyección automática de dependencias.
 * 
 * El servicio se encarga de abstraer la lógica relacionada con las promociones de la capa de 
 * controlador, garantizando que el código se mantenga limpio y desacoplado.
 * 
 * @see PromocionRepository
 * @see Promocion
 */
@Service
public class PromocionService {

    /**
     * Repositorio de promociones utilizado para acceder a la base de datos.
     * Este repositorio se inyecta a través del constructor.
     */
    private final PromocionRepository promocionRepository;

    /**
     * Constructor de la clase `PromocionService`.
     * 
     * @param promocionRepository El repositorio que maneja las operaciones CRUD para las promociones.
     */
    public PromocionService(PromocionRepository promocionRepository) {
        this.promocionRepository = promocionRepository;
    }

    /**
     * Recupera todas las promociones disponibles.
     * 
     * Este método utiliza el repositorio de promociones para obtener todas las promociones 
     * desde la base de datos.
     * 
     * @return Una lista de todas las promociones.
     */
    public List<Promocion> listarPromociones() {
        return promocionRepository.findAll();
    }
}
