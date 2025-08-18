package dev.miguel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CuentaAhorrosTest {

    private CuentaAhorros cuentaActiva;
    private CuentaAhorros cuentaInactiva;

    @BeforeEach
    void setUp() {
        cuentaActiva = new CuentaAhorros(20000, 12);
        cuentaInactiva = new CuentaAhorros(5000, 12);
    }

    @Test
    void testConstructor_CuentaActiva() {
        assertTrue(cuentaActiva.isCuentaActiva(), "La cuenta debería estar activa");
    }

    @Test
    void testConstructor_CuentaInactiva() {
        assertFalse(cuentaInactiva.isCuentaActiva(), "La cuenta debería estar inactiva");
    }

    @Test
    void testConsignar_CuentaActiva() {
        cuentaActiva.consignar(5000);
        assertEquals(25000, cuentaActiva.saldo, 0.001, "El saldo debería ser 25000");
        assertEquals(1, cuentaActiva.numeroConsignaciones, "El número de consignaciones debería ser 1");
    }

    @Test
    void testConsignar_CuentaInactiva() {
        cuentaInactiva.consignar(5000);
        assertEquals(5000, cuentaInactiva.saldo, 0.001, "El saldo no debería cambiar");
        assertEquals(0, cuentaInactiva.numeroConsignaciones, "El número de consignaciones no debería cambiar");
    }

    @Test
    void testRetirar_CuentaActiva() {
        cuentaActiva.retirar(5000);
        assertEquals(15000, cuentaActiva.saldo, 0.001, "El saldo debería ser 15000");
        assertEquals(1, cuentaActiva.numeroRetiros, "El número de retiros debería ser 1");
    }

    @Test
    void testRetirar_SaldoInsuficiente() {
        cuentaActiva.retirar(30000);
        assertEquals(20000, cuentaActiva.saldo, 0.001, "El saldo no debería cambiar");
        assertEquals(0, cuentaActiva.numeroRetiros, "El número de retiros no debería cambiar");
    }

    @Test
    void testRetirar_CuentaInactiva() {
        cuentaInactiva.retirar(2000);
        assertEquals(5000, cuentaInactiva.saldo, 0.001, "El saldo no debería cambiar");
        assertEquals(0, cuentaInactiva.numeroRetiros, "El número de retiros no debería cambiar");
    }

    @Test
    void testExtractoMensual_SinComisionAdicional() {
        cuentaActiva.extractoMensual();
        float interesEsperado = 20000 * (12f / 12 / 100);
        assertEquals(20000 - 0 + interesEsperado, cuentaActiva.saldo, 0.001, "El saldo debería actualizarse con el interés");
        assertEquals(0, cuentaActiva.comisionMensual, 0.001, "La comisión debería ser 0");
    }

    @Test
    void testExtractoMensual_ConComisionAdicional() {
        cuentaActiva.retirar(1000);
        cuentaActiva.retirar(1000);
        cuentaActiva.retirar(1000);
        cuentaActiva.retirar(1000);
        cuentaActiva.retirar(1000);
        cuentaActiva.extractoMensual();
        assertEquals(1000, cuentaActiva.comisionMensual, 0.001, "La comisión debería ser 1000 por 1 retiro adicional");
    }
}