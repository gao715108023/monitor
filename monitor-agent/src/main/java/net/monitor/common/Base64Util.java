package net.monitor.common;

public class Base64Util {

  private static final char[] INT_TO_BASE_64 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
      'K', 'L',
      'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e',
      'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
      'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', '_'};

  private static final byte[] BASE_64_TO_INT = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
      -1, -1, -1,
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
      -1, -1, -1, -1, -1, -1, -1, 62, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1,
      -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
      23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
      40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

  public static String byteArrayToBase64(byte[] a) {
    int aLen = a.length;
    int numFullGroups = aLen / 3;
    int numBytesInPartialGroup = aLen - 3 * numFullGroups;
    int resultLen = 4 * ((aLen + 2) / 3);
    StringBuilder result = new StringBuilder(resultLen);

    int inCursor = 0;
    for (int i = 0; i < numFullGroups; i++) {
      int byte0 = a[(inCursor++)] & 0xFF;
      int byte1 = a[(inCursor++)] & 0xFF;
      int byte2 = a[(inCursor++)] & 0xFF;
      result.append(INT_TO_BASE_64[(byte0 >> 2)]);
      result.append(INT_TO_BASE_64[(byte0 << 4 & 0x3F | byte1 >> 4)]);
      result.append(INT_TO_BASE_64[(byte1 << 2 & 0x3F | byte2 >> 6)]);
      result.append(INT_TO_BASE_64[(byte2 & 0x3F)]);
    }

    if (numBytesInPartialGroup != 0) {
      int byte0 = a[(inCursor++)] & 0xFF;
      result.append(INT_TO_BASE_64[(byte0 >> 2)]);

      if (numBytesInPartialGroup == 1) {
        result.append(INT_TO_BASE_64[(byte0 << 4 & 0x3F)]);
        result.append("==");
      } else {
        int byte1 = a[(inCursor++)] & 0xFF;
        result.append(INT_TO_BASE_64[(byte0 << 4 & 0x3F | byte1 >> 4)]);
        result.append(INT_TO_BASE_64[(byte1 << 2 & 0x3F)]);
        result.append('=');
      }
    }

    return result.toString();
  }

  public static byte[] base64ToByteArray(String s) throws Exception {
    int sLen = s.length();
    int numGroups = sLen / 4;
    if (4 * numGroups != sLen) {
      throw new IllegalArgumentException("字串长度必须是4的倍数");
    }
    int missingBytesInLastGroup = 0;
    int numFullGroups = numGroups;
    if (sLen != 0) {
      if (s.charAt(sLen - 1) == '=') {
        missingBytesInLastGroup++;

        numFullGroups--;
      }

      if (s.charAt(sLen - 2) == '=') {
        missingBytesInLastGroup++;
      }
    }

    byte[] result = new byte[3 * numGroups - missingBytesInLastGroup];
    int inCursor = 0;
    int outCursor = 0;
    for (int i = 0; i < numFullGroups; i++) {
      int ch0 = base64toInt(s.charAt(inCursor++), BASE_64_TO_INT);
      int ch1 = base64toInt(s.charAt(inCursor++), BASE_64_TO_INT);
      int ch2 = base64toInt(s.charAt(inCursor++), BASE_64_TO_INT);
      int ch3 = base64toInt(s.charAt(inCursor++), BASE_64_TO_INT);
      result[(outCursor++)] = ((byte) (ch0 << 2 | ch1 >> 4));
      result[(outCursor++)] = ((byte) (ch1 << 4 | ch2 >> 2));
      result[(outCursor++)] = ((byte) (ch2 << 6 | ch3));
    }
    if (missingBytesInLastGroup != 0) {
      int ch0 = base64toInt(s.charAt(inCursor++), BASE_64_TO_INT);
      int ch1 = base64toInt(s.charAt(inCursor++), BASE_64_TO_INT);

      result[(outCursor++)] = ((byte) (ch0 << 2 | ch1 >> 4));

      if (missingBytesInLastGroup == 1) {
        int ch2 = base64toInt(s.charAt(inCursor++), BASE_64_TO_INT);
        result[(outCursor++)] = ((byte) (ch1 << 4 | ch2 >> 2));
      }
    }
    return result;
  }

  private static int base64toInt(char c, byte[] alphaToInt) throws Exception {
    int result = alphaToInt[c];
    if (result < 0) {
      throw new Exception("非法索引值");
    }
    return result;
  }
}