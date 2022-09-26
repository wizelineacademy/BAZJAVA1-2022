package com.wizeline.Exceptions;

//HERENCIA
public class ExcepcionNoBody extends ExcepcionGenerica{
    private static final String mensaje = "Fallo al obtener el request del body";

    public ExcepcionNoBody() {
        super(mensaje);
    }

    //SOBRECARGA DE CONSTRUCTOR
    public ExcepcionNoBody(String mensajeError) {
        super("mensaje1: ".concat(mensaje).concat(", mensaje2: ").concat(mensajeError));
    }
}
