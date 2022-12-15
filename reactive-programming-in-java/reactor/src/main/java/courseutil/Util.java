package courseutil;

import java.util.function.Consumer;

public class Util {
    public static Consumer<? super Integer> onNext(){
        return object -> System.out.println("Received : "+ object);
    }

    public static Consumer<Throwable> onError(){
        return e -> System.out.println("ERROR : "+ e.getMessage());
    }

    public static Runnable onComplete(){
        return () -> System.out.println("Completed");
    }
}
