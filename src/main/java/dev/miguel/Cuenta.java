package dev.miguel;

public class Cuenta {
    protected float saldo;
    protected int numeroConsignaciones = 0;
    protected int numeroRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;

    public Cuenta(float saldoInicial, float tasaAnual) {
        this.saldo = saldoInicial;
        this.tasaAnual = tasaAnual;
    }

    public void consignar(float cantidad) {
        saldo += cantidad;
        numeroConsignaciones++;
    }

    public void retirar(float cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            numeroRetiros++;
        }
    }

    public void calcularInteresMensual() {
        float interesMensual = saldo * (tasaAnual / 12 / 100);
        saldo += interesMensual;
    }

    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
    }

    public String imprimir() {
        return "Saldo: " + saldo +
               "\nNúmero de consignaciones: " + numeroConsignaciones +
               "\nNúmero de retiros: " + numeroRetiros +
               "\nComisión mensual: " + comisionMensual;
    }
}