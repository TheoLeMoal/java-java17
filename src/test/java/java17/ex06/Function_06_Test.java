package java17.ex06;


import java.util.function.Supplier;

import org.junit.Test;

import java17.data.Person;

/**
 * Exercice 06 - java.util.function.Supplier
 */
public class Function_06_Test {

    // tag::formatAge[]
    // Compléter la méthode
    // La méthode retourne une chaîne de caractères de la forme [age=<AGE>] (exemple : [age=12])
    String formatAge(Supplier<Person> supplier) {
        // Récupérer la personne à partir du Supplier
        Person person = supplier.get();

        // Retourner la chaîne de caractères formatée
        return "[age=" + person.getAge() + "]";
    }
    // end::formatAge[]

    @Test
    public void test_supplier_formatAge() throws Exception {
        // Créer un Supplier qui fournit une personne avec un âge de 35
        Supplier<Person> personSupplier = () -> new Person("John", "Doe", 35, "password");

        // Invoquer la méthode formatAge avec le Supplier
        String result = formatAge(personSupplier);

        // Vérifier que le résultat est conforme à la chaîne attendue
        assert result.equals("[age=35]");
    }
}