import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String dnaSequence;
        System.out.println("Enter a DNA sequence below!");

        while (true) {
            dnaSequence = scanner.next().toUpperCase();

            boolean isValid = true;

            for (int i = 0; i < dnaSequence.length(); i++) {
                char c = dnaSequence.charAt(i);
                if (c != 'A' && c != 'T' && c != 'G' && c != 'C') {
                    System.out.println("The given sequence is invalid! Enter again!");
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                break;
            }
        }

        String complementarySequence = complementarySequence(dnaSequence);
        System.out.println("Complementary Sequence: " + complementarySequence);

        char mostFrequentBase = mostFrequentBase(dnaSequence);
        System.out.println("Most Frequent Base: " + mostFrequentBase);

        System.out.println("Enter a sequence to insert:");
        String sequenceToInsert = scanner.next().toUpperCase();

        System.out.println("Enter the position to insert:");
        int position = scanner.nextInt();

        String modifiedSequence = insert(dnaSequence, sequenceToInsert, position);
        System.out.println("Modified DNA Sequence: " + modifiedSequence);

        System.out.println("Enter the pattern to remove:");
        String patternToRemove = scanner.next().toUpperCase();

        String dnaAfterRemoval = remove(dnaSequence, patternToRemove);
        System.out.println("DNA sequence after removal: " + dnaAfterRemoval);

        
        System.out.println("Enter the compressed DNA sequence:");
        String compressedDna = scanner.next().toUpperCase();

        String decompressedDna = decompress(compressedDna);
        System.out.println("Decompressed DNA sequence: " + decompressedDna);

        scanner.close();
    }

    public static String complementarySequence(String dnaSequence) {
        StringBuilder fnOutput = new StringBuilder();

        for (int i = 0; i < dnaSequence.length(); i++) {
            char c = dnaSequence.charAt(i);
            switch (c) {
                case 'A':
                    fnOutput.append('T');
                    break;
                case 'T':
                    fnOutput.append('A');
                    break;
                case 'G':
                    fnOutput.append('C');
                    break;
                case 'C':
                    fnOutput.append('G');
                    break;
            }
        }

        return fnOutput.toString();
    }

    public static char mostFrequentBase(String dnaSequence) {
        char[] bases = {'A', 'T', 'G', 'C'};

        char frequentBase = 'A';
        int max = -1;

        for (char base : bases) {
            int cnt = 0;
            for (int j = 0; j < dnaSequence.length(); j++) {
                if (base == dnaSequence.charAt(j)) {
                    cnt++;
                }
            }
            if (cnt > max) {
                max = cnt;
                frequentBase = base;
            }
        }

        return frequentBase;
    }

    public static String insert(String initialDnaSequence, String sequenceToInsert, int position) {
        if (position < 0 || position > initialDnaSequence.length()) {
            throw new IllegalArgumentException("Position out of bounds");
        }

        StringBuilder modifiedSequence = new StringBuilder(initialDnaSequence);
        modifiedSequence.insert(position, sequenceToInsert);

        return modifiedSequence.toString();
    }

    public static String remove(String initialDnaSequence, String patternToRemove) {
        int index = initialDnaSequence.indexOf(patternToRemove);
        if (index == -1) {
            return initialDnaSequence;
        }
        return initialDnaSequence.substring(0, index) + initialDnaSequence.substring(index + patternToRemove.length());
    }

    public static String decompress(String compressedDnaSequence) {
        StringBuilder result = new StringBuilder();
        int length = compressedDnaSequence.length();

        for (int i = 0; i < length; i++) {
            char c = compressedDnaSequence.charAt(i);

            if (Character.isLetter(c)) {
                result.append(c);
            } else if (Character.isDigit(c)) {
                int repeatCount = c - '0';
                while (i + 1 < length && Character.isDigit(compressedDnaSequence.charAt(i + 1))) {
                    i++;
                    repeatCount = repeatCount * 10 + (compressedDnaSequence.charAt(i) - '0');
                }

                if (i + 1 < length && compressedDnaSequence.charAt(i + 1) == '(') {
                    int start = i + 2;
                    int end = start;

                    int openBrackets = 1;
                    while (end < length && openBrackets > 0) {
                        end++;
                        if (compressedDnaSequence.charAt(end) == '(') openBrackets++;
                        if (compressedDnaSequence.charAt(end) == ')') openBrackets--;
                    }

                    String pattern = compressedDnaSequence.substring(start, end);
                    result.append(pattern.repeat(repeatCount));
                    i = end;
                } else if (i + 1 < length && Character.isLetter(compressedDnaSequence.charAt(i + 1))) {
                    result.append(String.valueOf(compressedDnaSequence.charAt(i + 1)).repeat(repeatCount));
                    i++;
                }
            }
        }

        return result.toString();
    }
}
