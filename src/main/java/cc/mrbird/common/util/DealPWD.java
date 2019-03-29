package cc.mrbird.common.util;

/**
 * TODO: Change this title
 *
 * @author: fengwang
 * @date: 2019-03-28 11:06
 * @version: 1.0
 * @since: JDK 1.8
 */
public class DealPWD {
    private static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
    private static byte[] codes = new byte[256];

    public DealPWD() {
    }

    public static String decrypt(String strpasswd) {
        String ls_decrypt = "";
        String ls_seed = "ZXT10LSZTESOFTRESMASTERBUSINESSOPERATIONSUPPORTSYSTEMRESMASTER30";

        for (int i = 0; i < strpasswd.length(); ++i) {
            int j = strpasswd.charAt(i) - ls_seed.charAt(i) + 95;
            if (j >= 95) {
                j -= 95;
            }

            ls_decrypt = ls_decrypt + String.valueOf((char) (j + 32));
        }

        return ls_decrypt;
    }

    public static String encrypt(String strpasswd) {
        String ls_decrypt = "";
        String ls_seed = "ZXT10LSZTESOFTRESMASTERBUSINESSOPERATIONSUPPORTSYSTEMRESMASTER30";

        for (int i = 0; i < strpasswd.length(); ++i) {
            int j = strpasswd.charAt(i) + ls_seed.charAt(i) - 64;
            if (j >= 95) {
                j -= 95;
            }

            ls_decrypt = ls_decrypt + String.valueOf((char) (j + 32));
        }

        return ls_decrypt;
    }

    public static String encodeBase64(String oldpass) {
        char[] data = oldpass.toCharArray();
        char[] out = new char[(data.length + 2) / 3 * 4];
        int i = 0;

        for (int index = 0; i < data.length; index += 4) {
            boolean quad = false;
            boolean trip = false;
            int val = 255 & data[i];
            val <<= 8;
            if (i + 1 < data.length) {
                val |= 255 & data[i + 1];
                trip = true;
            }

            val <<= 8;
            if (i + 2 < data.length) {
                val |= 255 & data[i + 2];
                quad = true;
            }

            out[index + 3] = alphabet[quad ? val & 63 : 64];
            val >>= 6;
            out[index + 2] = alphabet[trip ? val & 63 : 64];
            val >>= 6;
            out[index + 1] = alphabet[val & 63];
            val >>= 6;
            out[index + 0] = alphabet[val & 63];
            i += 3;
        }

        String strout = new String(out);
        return strout;
    }

    public static String decodeBase64(String oldpass) {
        char[] data = oldpass.toCharArray();
        int tempLen = data.length;

        int len;
        for (len = 0; len < data.length; ++len) {
            if (data[len] > 255 || codes[data[len]] < 0) {
                --tempLen;
            }
        }

        len = tempLen / 4 * 3;
        if (tempLen % 4 == 3) {
            len += 2;
        }

        if (tempLen % 4 == 2) {
            ++len;
        }

        byte[] out = new byte[len];
        int shift = 0;
        int accum = 0;
        int index = 0;

        for (int ix = 0; ix < data.length; ++ix) {
            int value = data[ix] > 255 ? -1 : codes[data[ix]];
            if (value >= 0) {
                accum <<= 6;
                shift += 6;
                accum |= value;
                if (shift >= 8) {
                    shift -= 8;
                    out[index++] = (byte) (accum >> shift & 255);
                }
            }
        }

        if (index != out.length) {
            throw new Error("Miscalculated data length (wrote " + index + " instead of " + out.length + ")");
        } else {
            String strout = new String(out);
            return strout;
        }
    }

    public static boolean testPasswd(String inpasswd) {
        int haveLS = 0;
        int haveN = 0;
        int haveP = 0;
        int haveUS = 0;

        for (int ij = 0; ij < inpasswd.length(); ++ij) {
            char c = inpasswd.charAt(ij);
            if (c >= 'a' && c <= 'z') {
                haveLS = 1;
            }

            if (c >= 'A' && c <= 'Z') {
                haveUS = 1;
            }

            if (c >= '0' && c <= '9') {
                haveN = 1;
            }

            if (c >= '!' && c <= '/' || c >= ':' && c <= '@' || c >= '[' && c <= '`' || c >= '{' && c <= '~') {
                haveP = 1;
            }
        }

        if (haveLS + haveN + haveP + haveUS > 2) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean testPasswd2(String inpasswd) {
        int haveS = 0;
        int haveN = 0;

        for (int ij = 0; ij < inpasswd.length(); ++ij) {
            char c = inpasswd.charAt(ij);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                haveS = 1;
            }

            if (c >= '0' && c <= '9') {
                haveN = 1;
            }
        }

        if (haveS + haveN == 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] argv) {
        new DealPWD();
        System.out.println(testPasswd("tA1#"));
    }

    static {
        int i;
        for (i = 0; i < 256; ++i) {
            codes[i] = -1;
        }

        for (i = 65; i <= 90; ++i) {
            codes[i] = (byte) (i - 65);
        }

        for (i = 97; i <= 122; ++i) {
            codes[i] = (byte) (26 + i - 97);
        }

        for (i = 48; i <= 57; ++i) {
            codes[i] = (byte) (52 + i - 48);
        }

        codes[43] = 62;
        codes[47] = 63;
    }
}
