package dev.miguel;

public class CuentaAhorros extends Cuenta {
    private boolean cuentaActiva;

    public CuentaAhorros(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
        this.cuentaActiva = (saldoInicial >= 10000);
    }

    @Override
    public void consignar(float cantidad) {
        if (cuentaActiva) {
            super.consignar(cantidad);
        }
    }

    @Override
    public void retirar(float cantidad) {
        if (cuentaActiva) {
            super.retirar(cantidad);
        }
    }

    @Override
    public void extractoMensual() {
        if (numeroRetiros > 4) {
            comisionMensual += (numeroRetiros - 4) * 1000;
        }
        super.extractoMensual();
        cuentaActiva = (saldo >= 10000);
    }

    @Override
    public String imprimir() {
        return "Saldo de la cuenta: " + saldo +
               "\nComisión mensual: " + comisionMensual +
               "\nNúmero de transacciones: " + (numeroConsignaciones + numeroRetiros);
    }
}