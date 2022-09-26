package com.wizeline.Entities;

import com.wizeline.ENUMS.UserType;

public class User{
    private String user;
    private String pass;
    private UserType tipo;
    private boolean administrador;  //Tipo primitivo
    private int edad;   //Tipo primitivo

    private User(UserBuilder userBuilder){
        this.user = userBuilder.user;
        this.pass = userBuilder.pass;
        this.tipo = userBuilder.tipo;
        this.administrador = userBuilder.administrador;
        this.edad = userBuilder.edad;
    }

    public String getUser() {return user;}
    public String getPass() {return pass;}
    public UserType getTipo() {return tipo;}
    public boolean isAdministrador() {return administrador;}
    public int getEdad() {return edad;}

    public static final class UserBuilder{
        private String user;
        private String pass;
        private UserType tipo;
        private boolean administrador;
        private int edad;

        public UserBuilder() {
        }

        public UserBuilder user(String user) {
            this.user = user;
            return this;
        }
        public UserBuilder pass(String pass) {
            this.pass = pass;
            return this;
        }
        public UserBuilder tipo(UserType tipo) {
            this.tipo = tipo;
            return this;
        }
        public UserBuilder administrador(boolean administrador) {
            this.administrador = administrador;
            return this;
        }
        public UserBuilder edad(int edad) {
            this.edad = edad;
            return this;
        }
        public User build() {
            User user =  new User(this);
            return user;
        }
    }

}
