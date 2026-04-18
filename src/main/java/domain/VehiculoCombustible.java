package domain;

import java.time.LocalDate;

public class VehiculoCombustible extends Vehiculo {
    private double kilometrosPorLitro;
    private double litrosExtra;

    // Fíjate en el segundo parámetro: ahora es de tipo Marca
    public VehiculoCombustible(String patente, Marca marca, String modelo, int anio, double capacidadCarga,
                               Sucursal sucursal, double kilometrosPorLitro, double litrosExtra) {
        // Le pasamos el objeto 'marca' completo a la clase padre
        super(VehiculoTipo.COMBUSTIBLE, patente, marca, modelo, anio, capacidadCarga, sucursal);
        this.kilometrosPorLitro = kilometrosPorLitro;
        this.litrosExtra = litrosExtra;
    }
    
    public double getKilometrosPorLitro() {
        return kilometrosPorLitro;
    }

    public double getLitrosExtra() {
        return litrosExtra;
    }

    @Override
    public double calcularConsumo(double kilometros) {
        
        double litrosBase = kilometros / this.kilometrosPorLitro;
        double litrosPorAntiguedad = 0;
        if ((LocalDate.now().getYear() - this.anio) >= 5) {
            litrosPorAntiguedad = ((kilometros / 15)) * this.litrosExtra; 
        }
        
        double total = litrosBase + litrosPorAntiguedad;

        return total;
    }
}