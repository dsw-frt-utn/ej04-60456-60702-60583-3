package domain;

public class VehiculoElectrico extends Vehiculo {
    private double kwhBase;

    // Nuevamente, cambiamos String por Marca en el constructor
    public VehiculoElectrico(String patente, Marca marca, String modelo, int anio, double capacidadCarga,
                             Sucursal sucursal, double kwhBase) {
        super(VehiculoTipo.ELECTRICO, patente, marca, modelo, anio, capacidadCarga, sucursal);
        this.kwhBase = kwhBase;
    }

    @Override
    public double calcularConsumo(double kilometros) {
        double total = (kilometros/100)*kwhBase;

        if (capacidadCarga >= 1200) {
            total = 1.15 * total;
        }

        return total;
    }
}