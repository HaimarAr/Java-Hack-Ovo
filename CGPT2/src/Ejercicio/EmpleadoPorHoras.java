package Ejercicio;

class EmpleadoPorHoras extends Empleado {
    private double tarifaPorHora;
    private int horasTrabajadas;

    EmpleadoPorHoras(String nombre, int edad, double tarifaPorHora, int horasTrabajadas) {
        super(nombre, edad, 0); // El salario se calculará en función de las horas trabajadas
        this.tarifaPorHora = tarifaPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    double calcularSalario() {
        return tarifaPorHora * horasTrabajadas; // Salario basado en horas trabajadas
    }
}