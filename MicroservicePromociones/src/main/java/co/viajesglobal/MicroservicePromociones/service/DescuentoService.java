package co.viajesglobal.MicroservicePromociones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.viajesglobal.MicroservicePromociones.Entity.Descuento;
import co.viajesglobal.MicroservicePromociones.Repository.DescuentoRepository;

/**
 * Servicio para gestionar las operaciones relacionadas con los descuentos.
 * 
 * Esta clase proporciona métodos para interactuar con los descuentos, como la obtención
 * de todos los descuentos disponibles y la validación de cupones. Utiliza el repositorio
 * `DescuentoRepository` para realizar las operaciones de acceso a datos relacionadas con
 * la entidad `Descuento`.
 * 
 * El servicio está marcado con la anotación `@Service`, lo que indica que es un componente
 * de servicio en la capa de lógica de negocio de la aplicación.
 * 
 * @see DescuentoRepository
 * @see Descuento
 */
@Service
public class DescuentoService {

    private final DescuentoRepository descuentoRepository;

    /**
     * Constructor que inyecta el repositorio de descuentos.
     * 
     * @param descuentoRepository el repositorio de descuentos a utilizar
     */
    public DescuentoService(DescuentoRepository descuentoRepository) {
        this.descuentoRepository = descuentoRepository;
    }

    /**
     * Obtiene todos los descuentos disponibles en la base de datos.
     * 
     * @return una lista con todos los descuentos
     */
    public List<Descuento> obtenerTodosLosDescuentos() {
        return descuentoRepository.findAll();
    }

    /**
     * Valida un cupón de descuento. Busca un descuento por su código de cupón.
     * 
     * @param cupon el código del cupón de descuento a validar
     * @return un objeto `Optional` que contiene el descuento si existe, o vacío si no se
     *         encuentra el cupón
     */
    public Optional<Descuento> validarCupon(String cupon) {
        return descuentoRepository.findByCupon(cupon);
    }
}
