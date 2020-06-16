package common;

public class StringWrap {

    public static String wordCapitalize(String name) {
        boolean first = true;
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            int asci = (int) c;
            if (first) {
                bf.append((c + "").toUpperCase());
                first = false;
            } else {
                if (asci > 64 && asci < 91) {
                    bf.append(" " + c);
                } else {
                    bf.append(c + "");
                }
            }
        }
        return bf.toString();
    }

    public static String getterByWord(String name) {
        boolean first = true;
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            int asci = (int) c;
            if (first) {
                bf.append("get");
                bf.append((c + "").toUpperCase());
                first = false;
            } else {
                bf.append(c + "");
            }
        }
        return bf.toString();
    }

    public static String setterByWord(String name) {
        boolean first = true;
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            int asci = (int) c;
            if (first) {
                bf.append("set");
                bf.append((c + "").toUpperCase());
                first = false;
            } else {
                bf.append(c + "");
            }
        }
        return bf.toString();
    }
}
