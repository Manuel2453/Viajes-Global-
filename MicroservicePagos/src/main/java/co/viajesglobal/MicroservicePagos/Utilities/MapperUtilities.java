package co.viajesglobal.MicroservicePagos.Utilities;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;


/**
 * Clase utilitaria para realizar el mapeo entre entidades y DTOs utilizando la biblioteca 
 * {@code ModelMapper}. Esta clase proporciona métodos estáticos para mapear listas y objetos 
 * individuales de un tipo a otro.

 * La clase utiliza {@code ModelMapper} para simplificar el proceso de conversión entre diferentes 
 * tipos de objetos, facilitando así la transferencia de datos entre capas de la aplicación.

 * El código se basa en el ejemplo de Baeldung: 
 * <a href="https://www.baeldung.com/java-modelmapper-lists">https://www.baeldung.com/java-modelmapper-lists</a>.

 * @see org.modelmapper.ModelMapper
 * @since 1.0
 */
public class MapperUtilities {
	
	private static final ModelMapper modelMapper = new ModelMapper();

	/**
     * Mapea una lista de objetos del tipo fuente a una lista de objetos del tipo destino.
     * 
     * @param <S> El tipo de los objetos en la lista fuente.
     * @param <T> El tipo de los objetos en la lista destino.
     * @param source La lista de objetos del tipo fuente a mapear.
     * @param targetClass La clase de los objetos destino a los que se desea mapear.
     * @return Una lista de objetos del tipo destino resultante del mapeo.
     */
    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source.stream()
                     .map(element -> modelMapper.map(element, targetClass))
                     .collect(Collectors.toList());
    }
    
    /**
     * Mapea un objeto del tipo fuente a un objeto del tipo destino.
     * 
     * @param <S> El tipo del objeto fuente.
     * @param <T> El tipo del objeto destino.
     * @param source El objeto del tipo fuente a mapear.
     * @param targetClass La clase del objeto destino al que se desea mapear.
     * @return El objeto del tipo destino resultante del mapeo.
     */
    public static <S, T> T mapearObjetos(S source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }
}
