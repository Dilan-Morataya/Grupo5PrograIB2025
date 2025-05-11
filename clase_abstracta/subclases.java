package clase_abstracta;

public class subclases {
    public abstract class Animal {
        protected int idAnimal;
        protected String nombre;
        protected int edad;
        protected String tipoComida;
    
        public Animal(int idAnimal, String nombre, int edad, String tipoComida) {
            this.idAnimal = idAnimal;
            this.nombre = nombre;
            this.edad = edad;
            this.tipoComida = tipoComida;
        }
    
        public int getIdAnimal() {
            return idAnimal;
        }
    
        public abstract void comer();
    
        public void mostrarInfo() {
            System.out.println("ID: " + idAnimal);
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Tipo de comida: " + tipoComida);
        }
    }
    public class Mamifero extends Animal {
        public Mamifero(int idAnimal, String nombre, int edad, String tipoComida) {
            super(idAnimal, nombre, edad, tipoComida);
        }
    
        @Override
        public void comer() {
            System.out.println(nombre + " (Mamífero) está comiendo " + tipoComida);
        }
    }
    public class Ave extends Animal {
        public Ave(int idAnimal, String nombre, int edad, String tipoComida) {
            super(idAnimal, nombre, edad, tipoComida);
        }
    
        @Override
        public void comer() {
            System.out.println(nombre + " (Ave) está comiendo " + tipoComida);
        }
    }
    public class Reptil extends Animal {
        public Reptil(int idAnimal, String nombre, int edad, String tipoComida) {
            super(idAnimal, nombre, edad, tipoComida);
        }
    
        @Override
        public void comer() {
            System.out.println(nombre + " (Reptil) está comiendo " + tipoComida);
        }
    }
}
