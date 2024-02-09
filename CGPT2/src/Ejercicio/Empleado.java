package Ejercicio;

abstract class Empleado {
    private String nombre;
    private int edad;
    private double salario;

    Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    abstract double calcularSalario();
    
    String getNombre() {
        return nombre;
    }
    
    double getSalario() {
        return salario;
    }
}