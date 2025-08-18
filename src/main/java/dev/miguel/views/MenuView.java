package dev.miguel.views;

import dev.miguel.controllers.ControladorBanco;
import java.util.Scanner;

public class MenuView {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControladorBanco controlador = new ControladorBanco();
        int opcion;
        System.out.println("=== BIENVENIDO AL SISTEMA BANCARIO ===");

        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Crear una Cuenta de Ahorros");
            System.out.println("2. Crear una Cuenta Corriente");
            System.out.println("3. Realizar una consignación");
            System.out.println("4. Realizar un retiro");
            System.out.println("5. Ver extracto mensual");
            System.out.println("6. Imprimir información de la cuenta");
            System.out.println("7. Salir");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el saldo inicial para la cuenta de ahorros: ");
                    float saldoAhorros = scanner.nextFloat();
                    System.out.print("Ingrese la tasa anual (ej. 12): ");
                    float tasaAhorros = scanner.nextFloat();
                    System.out.println(controlador.crearCuentaAhorros(saldoAhorros, tasaAhorros));
                    break;
                case 2:
                    System.out.print("Ingrese el saldo inicial para la cuenta corriente: ");
                    float saldoCorriente = scanner.nextFloat();
                    System.out.print("Ingrese la tasa anual (ej. 12): ");
                    float tasaCorriente = scanner.nextFloat();
                    System.out.println(controlador.crearCuentaCorriente(saldoCorriente, tasaCorriente));
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a consignar: ");
                    float cantidadConsignar = scanner.nextFloat();
                    System.out.println(controlador.consignar(cantidadConsignar));
                    break;
                case 4:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    float cantidadRetirar = scanner.nextFloat();
                    System.out.println(controlador.retirar(cantidadRetirar));
                    break;
                case 5:
                    System.out.println(controlador.extractoMensual());
                    break;
                case 6:
                    System.out.println("\n--- Información de la Cuenta ---");
                    System.out.println(controlador.imprimirInformacion());
                    break;
                case 7:
                    System.out.println("Saliendo del programa. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}
