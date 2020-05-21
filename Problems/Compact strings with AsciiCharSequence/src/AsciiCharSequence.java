public class AsciiCharSequence /* extends/implements */implements java.lang.CharSequence {
    byte[] array;

    AsciiCharSequence(byte[] array) {
        this.array = array;
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public char charAt(int index) {
        return (char)array[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(java.util.Arrays.copyOfRange(array, start, end));
    }

    @Override
    public String toString() {
        return new String(this.array);
    }

}