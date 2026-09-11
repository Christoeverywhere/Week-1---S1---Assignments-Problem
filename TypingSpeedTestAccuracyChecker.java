```java
public class TypingSpeedTestAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {

        int matched = 0;
        int firstMismatch = -1;

        int totalCharacters = Math.min(
            original.length(),
            typed.length()
        );

        for (int i = 0; i < totalCharacters; i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy =
            (matched * 100.0) / original.length();

        if (original.length() == typed.length()
                && firstMismatch == -1) {

            System.out.printf(
                "Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                matched,
                original.length(),
                accuracy
            );

        } else {

            if (firstMismatch == -1) {
                firstMismatch = totalCharacters;
            }

            char originalChar =
                firstMismatch < original.length()
                ? original.charAt(firstMismatch)
                : '-';

            char typedChar =
                firstMismatch < typed.length()
                ? typed.charAt(firstMismatch)
                : '-';

            System.out.printf(
                "Matched: %d/%d | Accuracy: %.2f%% | "
                + "First Mismatch at position %d ('%c' vs '%c')%n",
                matched,
                original.length(),
                accuracy,
                firstMismatch + 1,
                originalChar,
                typedChar
            );
        }
    }

    public static void main(String[] args) {

        checkTypingAccuracy(
            "hello world",
            "hello worlt"
        );

        checkTypingAccuracy(
            "coding",
            "coding"
        );
    }
}
```
