package flashcards;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main implements Serializable {
    public static Map<String, String> cards = new LinkedHashMap<>();
    public static Map<String, Integer> hardCard = new LinkedHashMap<>();
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<String> logArray = new ArrayList<>();
    public static String menu = "Input the action (add, remove, import, export, ask, exit, " +
                                "log, hardest card, reset stats):";


    public static void main(String[] args) throws IOException {

        String pathToExport = null;
        String pathToImport;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-import")) {
                pathToImport = args[i + 1];
                importFile(pathToImport);
            } else if (args[i].equals("-export")) {
                pathToExport = args[i + 1];
            }
        }
        System.out.println(menu);
        logArray.add(menu);
        String action = sc.nextLine();
        logArray.add(action);

        while (!action.equals("exit")) {
            switch (action) {
                case "add":
                    add();
                    break;
                case "remove":
                    cardRemove();
                    break;
                case "import":
                    cardImport();
                    break;
                case "export":
                    cardExport();
                    break;
                case "ask":
                    questions();
                    break;
                case "log":
                    saveLog(logArray);
                    break;
                case "hardest card":
                    hardestCard();
                    break;
                case "reset stats":
                    resetStats();
                    break;
                default:
                    System.out.println(menu);
                    logArray.add(menu);
            }
            action = sc.nextLine();
            logArray.add(action);
        }
        exit(pathToExport);
    }

    private static void saveLog(ArrayList<String> logArray) {
        System.out.println("File name:");
        logArray.add("File name:");
        String path = sc.nextLine();
        logArray.add(path);
        File file = new File(path);

        try (FileWriter writer = new FileWriter(file, false)) {
            for (String s : logArray) {
                writer.write(s + "\n");
            }
            System.out.println("The log has been saved.");
            logArray.add("The log has been saved.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            logArray.add(e.getMessage());
        }
        System.out.println(menu);
        logArray.add(menu);
    }

    private static void hardestCard() {
        int maxErrors = 0;
        int countCards = 0;

        for (String key : hardCard.keySet()) {
            if (hardCard.get(key) > maxErrors) {
                maxErrors = hardCard.get(key);
            }
        }
        for (String key : hardCard.keySet()) {
            if (hardCard.get(key) == maxErrors && maxErrors > 0) {
                countCards++;
            }
        }
        if (countCards == 1) {
            String str = null;
            for (String s : hardCard.keySet()) {
                if (Integer.valueOf(maxErrors).equals(hardCard.get(s))) {
                    str = s;
                }
            }
            System.out.println("The hardest card is \"" + str +
                    "\". You have " + maxErrors + " errors answering it.");
            logArray.add("The hardest card is \"" + str + "\". You have " + maxErrors + " errors answering it.");
        } else if (countCards > 1) {
            System.out.print("The hardest cards are \"");
            StringBuilder resString = new StringBuilder("The hardest cards are \"");
            for (String key : hardCard.keySet()){
                if (countCards > 1) {
                    System.out.print(key + "\", \"");
                    resString.append(key).append("\", \"");
                } else {
                    System.out.print(key);
                    resString.append(key);
                }
                countCards--;
            }
            System.out.println("\". You have " + maxErrors + " errors answering them.");
            resString.append("\". You have ").append(maxErrors).append(" errors answering them.");
            String finalString = resString.toString();
            logArray.add(finalString);
        } else {
            System.out.println("There are no cards with errors.");
            logArray.add("There are no cards with errors.");
        }
        System.out.println(menu);
        logArray.add(menu);
    }

    private static void resetStats() {
        try {
            for (String s : hardCard.keySet()) {
                hardCard.replace(s, 0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Card statistics has been reset.");
        logArray.add("Card statistics has been reset.");
        System.out.println(menu);
        logArray.add(menu);
    }

    private static void cardRemove() {
        System.out.println("The card:");
        logArray.add("The card");
        String cardToRemove = sc.nextLine();
        logArray.add(cardToRemove);

        if (cards.containsKey(cardToRemove)) {
            cards.remove(cardToRemove);
            hardCard.remove(cardToRemove);
            System.out.println("The card has been removed.");
            logArray.add("The card has been removed.");
        } else {
            System.out.println("Can't remove \"" + cardToRemove + "\": there is no such card.");
            logArray.add("Can't remove \"" + cardToRemove + "\": there is no such card.");
        }
        System.out.println(menu);
        logArray.add(menu);
    }

    private static void questions() {
        System.out.println("How many times to ask?");
        logArray.add("How many times to ask?");
        int numOfQuestions = Integer.parseInt(sc.nextLine());
        logArray.add(Integer.toString(numOfQuestions));
        String answer;
        int j = 0;

        while (j < numOfQuestions) {
            for (String key : cards.keySet()) {
                System.out.println("Print the definition of \"" + key + "\":");
                logArray.add("Print the definition of \"" + key + "\":");
                answer = sc.nextLine();
                logArray.add(answer);
                if (cards.get(key).equals(answer)) {
                    System.out.println("Correct answer");
                    logArray.add("Correct answer");
                } else {
                    hardCard.replace(key, (hardCard.get(key) + 1));
                    if (cards.containsValue(answer)) {
                        String goodAnswer = null;
                        for (var entry : cards.entrySet()) {
                            if (entry.getValue().equals(answer)) {
                                goodAnswer = entry.getKey();
                            }
                        }
                        System.out.println("Wrong answer. The correct one is \"" + cards.get(key)
                                + "\", you've just written the definition of \"" + goodAnswer + "\".");
                        logArray.add("Wrong answer. The correct one is \"" + cards.get(key)
                                + "\", you've just written the definition of \"" + goodAnswer + "\".");
                    } else {
                        System.out.println("Wrong answer. The correct one is \"" + cards.get(key) + "\".");
                        logArray.add("Wrong answer. The correct one is \"" + cards.get(key) + "\".");
                    }
                }
                j++;
                if (j == numOfQuestions) { break; }
            }
        }
        System.out.println(menu);
        logArray.add(menu);
    }

    private static void cardExport() throws IOException {
        System.out.println("File name:");
        logArray.add("File name:");
        String path = sc.nextLine();
        logArray.add(path);
        exportFile(path);
        System.out.println(menu);
        logArray.add(menu);
    }

    private static void exportFile(String path) throws IOException {
        SavedFile savedFile = new SavedFile(cards, hardCard);
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(savedFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logArray.add(e.getMessage());
        }
        int i = 0;
        for (var entry : cards.entrySet()) {
            i++;
        }
        System.out.println(i + " cards have been saved.");
        logArray.add(i + " cards have been saved.");
    }

    private static void cardImport() {
        System.out.println("File name:");
        logArray.add("File name:");
        String fileToLoad = sc.nextLine();
        logArray.add(fileToLoad);
        importFile(fileToLoad);
        System.out.println(menu);
        logArray.add(menu);
    }

    private static void importFile(String fileToLoad) {
        int i = 0;

        try (FileInputStream fileInputStream = new FileInputStream(fileToLoad)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            SavedFile savedFile = (SavedFile) objectInputStream.readObject();
            for (var entry : savedFile.getCards().keySet()) {
                if (!cards.containsKey(entry)) {
                    cards.put(entry, savedFile.cards.get(entry));
                } else if (cards.containsKey(entry) && !cards.get(entry).equals(savedFile.cards.get(entry))) {
                    cards.replace(entry, savedFile.cards.get(entry));
                }
                i++;
            }

            for (var entry : savedFile.getHardCard().keySet()) {
                if (!hardCard.containsKey(entry)) {
                    hardCard.put(entry, savedFile.hardCard.get(entry));
                } else {
                    hardCard.replace(entry, savedFile.hardCard.get(entry));
                }
            }
            System.out.println(i + " cards have been loaded.");
            logArray.add(i + " cards have been loaded.");
        } catch (Exception e) {
            System.out.println("File not found");
            logArray.add("File not found");
        }
    }

    private static void add() {
        System.out.println("The card:");
        logArray.add("The card");
        String card = sc.nextLine();
        logArray.add(card);
        String definition;

        if (cards.containsKey(card)) {
            System.out.println("The card \"" + card + "\" already exists.");
            logArray.add("The card \\\"\" + card + \"\\\" already exists.");
        } else {
            System.out.println("The definition of the card:");
            logArray.add("The definition of the card:");
            definition = sc.nextLine();
            logArray.add(definition);
            if (cards.containsValue(definition)) {
                System.out.println("The definition \"" + definition + "\" already exists.");
                logArray.add("The definition \"" + definition + "\" already exists.");
            } else {
                cards.put(card, definition);
                hardCard.put(card, 0);
                System.out.println("The pair (\"" + card + "\":\"" + definition + "\") has been added.");
                logArray.add("The pair (\"" + card + "\":\"" + definition + "\") has been added.");
            }
        }
        System.out.println(menu);
        logArray.add(menu);
    }

    public static void exit(String param) throws IOException {
        System.out.println("Bye bye!");
        logArray.add("Bye bye!");
        if (param != null) {
            exportFile(param);
        }
        System.exit(0);
    }
}

class SavedFile implements Serializable {
    private static final long serialVersionUID = 1L;
    Map<String, String> cards;
    Map<String, Integer> hardCard;
    SavedFile(Map<String, String> car, Map<String, Integer> hardCar) {
        this.cards = car;
        this.hardCard = hardCar;
    }

    public Map<String, String> getCards() {
        return cards;
    }

    public Map<String, Integer> getHardCard() {
        return hardCard;
    }
}
