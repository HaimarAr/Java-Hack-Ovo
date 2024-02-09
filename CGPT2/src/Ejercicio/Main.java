package Ejercicio;

public class Main {
	
    public static void main(String[] args) {
        try {
            EmpleadoAsalariado empleado1 = new EmpleadoAsalariado("Juan", 30, 5000);
            EmpleadoPorHoras empleado2 = new EmpleadoPorHoras("Maria", 25, 20, 40);

            System.out.println("Salario de " + empleado1.getNombre() + ": $" + empleado1.calcularSalario());
            System.out.println("Vacaciones remuneradas de " + empleado1.getNombre() + ": $" + empleado1.calcularVacacionesRemuneradas());

            System.out.println("Salario de " + empleado2.getNombre() + ": $" + empleado2.calcularSalario());

            // Intentar crear un empleado con salario negativo lanzará la excepción
            EmpleadoPorHoras empleado3 = new EmpleadoPorHoras("Carlos", 28, -10, 30);
        } catch (SalarioInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
