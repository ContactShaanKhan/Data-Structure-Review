// Standard Enum 
enum Week {
    MONDAY, // Monday = final int 0
    TUESDAY, // Tuesday = final int 1
    WEDNESDAY, // Wednesday = final int 2
    THURSDAY // = 3
}

// Custom Enum
enum greetings {
    HELLO("hello"), HI("hi"), HOWDY("howdy");

    private String greetings;

    private greetings(String greetings) {
        this.greetings = greetings;
    }

    public String getGreeting() {
        return greetings;
    }
}

// We made this wrapper because compareTo for enums only works for default enum
// values (int). Since we defined our enums as strings, we must make a
// wrapper to have a valid compareTo for greetings
class greetings_wrapper implements Comparable<greetings_wrapper> {
    public greetings g;

    greetings_wrapper(greetings g) {
        this.g = g;
    }

    @Override
    public int compareTo(greetings_wrapper gw) {
        greetings a = this.g;
        greetings b = gw.g;

        String a_string = a.getGreeting();
        String b_string = b.getGreeting();

        return a_string.compareTo(b_string);
    }
}

public class Enum {
    public static void main(String... args) {
        Week day = Week.THURSDAY;
        Week day_1 = Week.TUESDAY;

        System.out.println(day);

        System.out.println(day.compareTo(day_1));

        greetings greet = greetings.HELLO;
        greetings greet_1 = greetings.HI;
        greetings greet_2 = greetings.HOWDY;

        System.out.println(greet);

        System.out.println(greet_2.compareTo(greet));

        greetings_wrapper a = new greetings_wrapper(greetings.HI);
        greetings_wrapper b = new greetings_wrapper(greetings.HELLO);

        System.out.println(("HELLO".compareTo("HI")));
        System.out.println(b.compareTo(a));

    }
}
