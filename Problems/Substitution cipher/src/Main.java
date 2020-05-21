import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        Map<Character, Character> encode = new LinkedHashMap<>();
        Map<Character, Character> decode = new LinkedHashMap<>();
        String cipher = sc.nextLine();
        String code = sc.nextLine();
        char[] toCipher = cipher.toCharArray();
        char[] toCode = code.toCharArray();
        String needEncode = sc.nextLine();
        String needDecode = sc.nextLine();
        for (int i = 0; i < toCipher.length; i++) {
            encode.put(toCipher[i], toCode[i]);
            decode.put(toCode[i], toCipher[i]);
        }
        char[] toNeedEncode = needEncode.toCharArray();
        char[] toNeedDecode = needDecode.toCharArray();
        for (int i = 0; i < toNeedEncode.length; i++) {
            toNeedEncode[i] = encode.get(toNeedEncode[i]);
        }
        for (int i = 0; i < toNeedDecode.length; i++) {
            toNeedDecode[i] = decode.get(toNeedDecode[i]);
        }
        String str1 = new String(toNeedEncode);
        String str2 = new String(toNeedDecode);
        System.out.println(str1);
        System.out.println(str2);
    }
}