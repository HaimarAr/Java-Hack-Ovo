package Ejercicio;

class EmpleadoAsalariado extends Empleado implements VacacionesRemuneradas {
    EmpleadoAsalariado(String nombre, int edad, double salarioMensual) {
        super(nombre, edad, salarioMensual);
    }

    @Override
    double calcularSalario() {
        return getSalario(); // Salario fijo para empleados asalariados
    }

    @Override
    public double calcularVacacionesRemuneradas() {
        // Lógica para calcular las vacaciones remuneradas basadas en el salario mensual
        return getSalario() * 0.1;
    }
}

