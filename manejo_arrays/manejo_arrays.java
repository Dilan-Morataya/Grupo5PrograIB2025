public class GestorAnimales {
    Animal[] animales = new Animal[10];
    int contador = 0;

    public boolean agregarAnimal(Animal animal) {
        if (contador >= animales.length) {
            System.out.println("No se puede agregar más animales. Capacidad llena.");
            return false;
        }

        for (int i = 0; i < contador; i++) {
            if (animales[i].getIdAnimal() == animal.getIdAnimal()) {
                System.out.println("Error: ID repetido.");
                return false;
            }
        }

        animales[contador++] = animal;
        return true;
    }

    public void mostrarAnimales() {
        for (int i = 0; i < contador; i++) {
            animales[i].mostrarInfo();
        }
    }

    public boolean estaLleno() {
        return contador == animales.length;
    }

    public Animal[] getAnimales() {
        return animales;
    }

    public int getContador() {
        return contador;
    }
}
