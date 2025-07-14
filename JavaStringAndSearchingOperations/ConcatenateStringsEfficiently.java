public class ConcatenateStringsEfficiently {

    public static String concatenateStrings(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"Hello", " ", "World", "!"};
        System.out.println("Concatenated String: " + concatenateStrings(words));

        String[] phrases = {"Java", " is", " awesome", "."};
        System.out.println("Concatenated String: " + concatenateStrings(phrases));
    }
}