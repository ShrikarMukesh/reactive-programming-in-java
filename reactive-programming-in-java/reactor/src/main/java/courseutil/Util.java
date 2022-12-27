package courseutil;

import com.github.javafaker.Faker;

import java.util.function.Consumer;

public class Util {

    private static final Faker FAKER = Faker.instance();

    public static Consumer<? super Integer> onNext(){
        return object -> System.out.println("Received : "+ object);
    }

    public static Consumer<Throwable> onError(){
        return e -> System.out.println("ERROR : "+ e.getMessage());
    }

    public static Runnable onComplete(){
        return () -> System.out.println("Completed");
    }

    public static Faker faker(){
        return FAKER;
    }
}
