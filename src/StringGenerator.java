class StringGenerator {

    String generateString(int len) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder builder = new StringBuilder();
        while (len-- != 0) {
            int i = (int)(Math.random()* alphabet.length());
            builder.append(alphabet.charAt(i));
        }
        return builder.toString();
    }
}
