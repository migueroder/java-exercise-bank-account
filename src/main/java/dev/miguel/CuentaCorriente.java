package dev.miguel;

public class CuentaCorriente extends Cuenta {
    private float sobregiro = 0;

    public CuentaCorriente(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
    }

    @Override
    public void retirar(float cantidad) {
        if (cantidad > saldo) {
            sobregiro += (cantidad - saldo);
            saldo = 0;
        } else {
            super.retirar(cantidad);
        }
    }

    @Override
    public void consignar(float cantidad) {
        super.consignar(cantidad);
        if (sobregiro > 0) {
            if (cantidad >= sobregiro) {
                saldo -= sobregiro;
                sobregiro = 0;
            } else {
                sobregiro -= cantidad;
                saldo = 0;
            }
        }
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    @Override
    public String imprimir() {
        return "Saldo de la cuenta: " + saldo +
               "\nComisión mensual: " + comisionMensual +
               "\nNúmero de transacciones: " + (numeroConsignaciones + numeroRetiros) +
               "\nSobregiro: " + sobregiro;
    }
}