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
public enum Estado_ {

    UNDEFINED, ACTIVO, INACTIVO;

    public String toString() {
        switch (this) {
            case UNDEFINED:
                return "";
            case ACTIVO:
                return "ACTIVO";
            case INACTIVO:
                return "INACTIVO";
        }
        return this.name();
    }

    public static Estado_ getUNDEFINED() {
        return UNDEFINED;
    }

    public static Estado_ getACTIVO() {
        return ACTIVO;
    }

    public static Estado_ getINACTIVO() {
        return INACTIVO;
    }

}
