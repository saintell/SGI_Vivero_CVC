/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Santiago
 */
public enum Cargo_ {

    UNDEFINED, GERENTE, ENCARGADO;

    public String toString() {
        switch (this) {
            case UNDEFINED:
                return "";
            case GERENTE:
                return "Gerente";
            case ENCARGADO:
                return "Encargado";
        }
        return this.name();
    }

    public static Cargo_ getUNDEFINED() {
        return UNDEFINED;
    }

    public static Cargo_ getGERENTE() {
        return GERENTE;
    }

    public static Cargo_ getENCARGADO() {
        return ENCARGADO;
    }

}
