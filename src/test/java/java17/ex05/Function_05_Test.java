package java17.ex05;

import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import java17.data.Data;
import java17.data.Person;

/**
 * Exercice 5 - java.util.function.Consumer
 */
public class Function_05_Test {

    //tag::functions[]
    // Compléter la fonction
    // Modifier le mot de passe en "secret"
    Consumer<Person> changePasswordToSecret = person -> person.setPassword("secret");

    // Compléter la fonction
    // Vérifier que l'âge > 4 avec une assertion JUnit
    Consumer<Person> verifyAge = person -> {
        assert person.getAge() > 4;
    };

    // Compléter la fonction
    // Vérifier que le mot de passe est "secret" avec une assertion JUnit
    Consumer<Person> verifyPassword = person -> {
        assert "secret".equals(person.getPassword());
    };
    //end::functions[]


    @Test
    public void test_consumer() throws Exception {
        List<Person> personList = Data.buildPersonList();

        // Invoquer la méthode personList.forEach pour modifier les mots de passe en "secret"
        personList.forEach(changePasswordToSecret);

        // Remplacer la boucle for par l'invocation de la méthode forEach
        // Utiliser la méthode andThen pour chaîner les vérifications verifyAge et verifyPassword
        personList.forEach(verifyAge.andThen(verifyPassword));
    }
}
