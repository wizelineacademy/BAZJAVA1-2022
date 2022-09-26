package com.wizeline.Entities;

public class NotificacionFactory {
    public Notificacion createAccount(String type) {
        if (type == null || type.isEmpty())
            return null;
        switch (type) {
            case "BASIC":
                return new NotificacionBasicAccount();
            case "ADVANCE":
                return new NotificacionNormalAccount();
            default:
                throw new IllegalArgumentException("Unknown channel " + type);
        }
    }
}
