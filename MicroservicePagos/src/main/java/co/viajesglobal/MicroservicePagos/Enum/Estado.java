package co.viajesglobal.MicroservicePagos.Enum;

/**
 * Esta enumeración representa los posibles estados de un pago dentro del sistema de pagos.
 * Los estados reflejan el progreso y la situación actual del pago.
 */
public enum Estado {

    /**
     * El pago se ha completado con éxito.
     */
    Completado,

    /**
     * El pago está pendiente, aún no se ha procesado completamente.
     */
    Pendiente,

    /**
     * El pago ha fallado, ya sea por un error en el procesamiento o por un motivo externo.
     */
    Fallido
}
