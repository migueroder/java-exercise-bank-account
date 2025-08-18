package dev.miguel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CuentaCorrienteTest {

    private CuentaCorriente cuenta;

    @BeforeEach
    void setUp() {
        cuenta = new CuentaCorriente(10000, 12);
    }

    @Test
    void testRetirar_SaldoSuficiente() {
        cuenta.retirar(5000);
        assertEquals(5000, cuenta.saldo, 0.001, "El saldo debería ser 5000");
        assertEquals(1, cuenta.numeroRetiros, "El número de retiros debería ser 1");
        assertEquals(0, cuenta.getSobregiro(), 0.001, "No debería haber sobregiro");
    }

    @Test
    void testConsignar_SinSobregiro() {
        cuenta.consignar(5000);
        assertEquals(15000, cuenta.saldo, 0.001, "El saldo debería ser 15000");
        assertEquals(1, cuenta.numeroConsignaciones, "El número de consignaciones debería ser 1");
        assertEquals(0, cuenta.getSobregiro(), 0.001, "No debería haber sobregiro");
    }

    @Test
    void testConsignar_ReducirSobregiro() {
        cuenta.retirar(15000);
        cuenta.consignar(3000);
        assertEquals(0, cuenta.saldo, 0.001, "El saldo debe ser 0");
        assertEquals(2000, cuenta.getSobregiro(), 0.001, "El sobregiro debe ser 2000");
    }

    @Test
    void testConsignar_EliminarSobregiro() {
        cuenta.retirar(15000);
        cuenta.consignar(8000);
        assertEquals(3000, cuenta.saldo, 0.001, "El saldo debe ser 3000");
        assertEquals(0, cuenta.getSobregiro(), 0.001, "El sobregiro debe ser 0");
    }

    @Test
    void testExtractoMensual() {
        cuenta.consignar(1000);
        cuenta.extractoMensual();
        float interesEsperado = 11000 * (12f / 12 / 100);
        assertEquals(11000 + interesEsperado, cuenta.saldo, 0.001, "El saldo debe actualizarse con el interés");
    }
}