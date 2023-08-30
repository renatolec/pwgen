import java.util.*;

/**
 * Helper class
 */
public class PasswordGenerator {

    private static final List<Character> lowercase;
    private static final List<Character> uppercase;
    private static final List<Character> numbers;
    private static final List<Character> symbols;
    private static final Random random;

    static {
        random = new Random();
        lowercase = new ArrayList<>(26);
        uppercase = new ArrayList<>(26);
        numbers = new ArrayList<>(10);
        symbols = new ArrayList<>(32);
        for(int i = 33; i <= 126; i++){
            if(i >= 'a' && i <= 'z')
                lowercase.add((char) i);
            else if(i >= 'A' && i <= 'Z')
                uppercase.add((char) i);
            else if(i >= '0' && i <= '9')
                numbers.add((char) i);
            else
                symbols.add((char) i);
        }
    }

    public static String generate(int size, boolean upper, boolean number, boolean symbol){
        StringBuilder password = new StringBuilder();
        List<Character> characters = new ArrayList<>(lowercase);
        if(upper) characters.addAll(uppercase);
        if(number) characters.addAll(numbers);
        if(symbol) characters.addAll(symbols);
        for(int i = 0; i < size; i++)
            password.append(characters.get(random.nextInt(characters.size())));
        return password.toString();
    }
}
