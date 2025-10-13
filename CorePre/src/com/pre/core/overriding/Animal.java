package com.pre.core.overriding;

class Animal {
    Animal getAnimal() { 
        System.out.println("Animal version"); 
        return new Animal(); 
    }
}

class Dog extends Animal {
    @Override
    Dog getAnimal() {   // <-- covariant return: Dog is a subtype of Animal
        System.out.println("Dog version");
        return new Dog();
    }

//    @Override
//    String getAnimal() {   // <-- INVALID: String is not a subtype of Animal
//        System.out.println("Dog version");
//        return "Non Covariant type";
//    }
}
