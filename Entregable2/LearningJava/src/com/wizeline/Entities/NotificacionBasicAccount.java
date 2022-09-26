package com.wizeline.Entities;

import com.wizeline.LearningJava;

import java.util.logging.Logger;

public class NotificacionBasicAccount implements Notificacion {
    private static final Logger LOGGER = Logger.getLogger(LearningJava.class.getName());

    @Override
    public void notificaCreacion() {
        LOGGER.info("Se ha creado cuenta Basica");
    }
}
