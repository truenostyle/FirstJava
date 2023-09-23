package step.learning.basics;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class BasicsDemo {
    public void run()  {
//        String currentDirectory = System.getProperty("user.dir");
//
//
//        File directory = new File(currentDirectory);
//
//
//        File[] filesAndDirs = directory.listFiles();
//
//
//        if (filesAndDirs != null) {
//            for (File file : filesAndDirs) {
//                String name = file.getName();
//                String type = file.isDirectory() ? "d" : "-";
//                String size = String.valueOf(file.length());
//                String lastModified = String.valueOf(file.lastModified());
//
//                System.out.printf("%s %s %s %s%n", type, lastModified, size, name);
//            }
//        }



        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть максимальну кількість рядків у файлі: ");
        int maxLines = scanner.nextInt();


        String fileName = "random_strings.txt";
        generateRandomStringsFile(fileName, maxLines);


        String longestLine = findLongestLine(fileName);


        System.out.println("Найдовший рядок:");
        System.out.println(longestLine);
    }
    private static void generateRandomStringsFile(String fileName, int maxLines) throws IOException {
        Random random = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < maxLines; i++) {
                String randomLine = generateRandomString(random.nextInt(200) + 1); // Випадкова довжина рядка
                writer.write(randomLine);
                writer.newLine();
            }
        }
    }


    private static String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char randomChar = characters.charAt(random.nextInt(characters.length()));
            sb.append(randomChar);
        }
        return sb.toString();
    }

    private static String findLongestLine(String fileName) throws IOException {
        String longestLine = "";
        int lineNumber = 0;
        try (Scanner scanner = new Scanner(new java.io.File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNumber++;
                if (line.length() > longestLine.length()) {
                    longestLine = line;
                }
            }
        }
        return "Найдовший рядок номер " + lineNumber + " з довжиною " + longestLine.length() + " символів:\n" + longestLine;
    }
}
