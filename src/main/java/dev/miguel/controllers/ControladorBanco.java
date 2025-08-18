package dev.miguel.controllers;

import dev.miguel.Cuenta;
import dev.miguel.CuentaAhorros;
import dev.miguel.CuentaCorriente;

public class ControladorBanco {

    private Cuenta cuenta;

    public String crearCuentaAhorros(float saldoInicial, float tasaAnual) {
        this.cuenta = new CuentaAhorros(saldoInicial, tasaAnual);
        return "Cuenta de Ahorros creada exitosamente.";
    }

    public String crearCuentaCorriente(float saldoInicial, float tasaAnual) {
        this.cuenta = new CuentaCorriente(saldoInicial, tasaAnual);
        return "Cuenta Corriente creada exitosamente.";
    }

    public String consignar(float cantidad) {
        if (cuenta == null) {
            return "Por favor, cree una cuenta primero.";
        }
        cuenta.consignar(cantidad);
        return "Consignación exitosa.";
    }

    public String retirar(float cantidad) {
        if (cuenta == null) {
            return "Por favor, cree una cuenta primero.";
        }
        cuenta.retirar(cantidad);
        return "Retiro exitoso.";
    }

    public String extractoMensual() {
        if (cuenta == null) {
            return "Por favor, cree una cuenta primero.";
        }
        cuenta.extractoMensual();
        return "Extracto mensual generado.";
    }

    public String imprimirInformacion() {
        if (cuenta == null) {
            return "Por favor, cree una cuenta primero.";
        }
        return cuenta.imprimir();
    }
}
