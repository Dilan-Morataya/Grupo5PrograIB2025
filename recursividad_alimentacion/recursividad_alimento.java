public double calcularAlimento(int dias) {
    if (dias <= 0) return 0;
    return cantidadComidaDiaria + calcularAlimento(dias - 1);
}
@Override
public void alimentar() {
    System.out.println(nombre + " ha sido alimentado...");
}
