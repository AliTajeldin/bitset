package com.example;

public class Encoder {
  public static int maxNumId = 36*36*36*36*36;
  public static char[] numToCharMap = {
    '0','1','2','3','4','5','6','7','8','9',
    'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
    // 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
  };

  public static String numIdToStr(int id) {
    StringBuffer buf = new StringBuffer(10);
    assert(id >= 0 && id < (maxNumId-1));

    while(id>0) {
      buf.append(numToCharMap[id % 36]);
      id = id / 36;
    }

    buf.append("00000").setLength(5);
    return buf.reverse().toString();
  }

  public static int strIdToNum(String id) {
    int len = id.length();
    assert( len == 5 || len == 6);
    int res = 0;
    int start = (len == 6) ? 1 : 0;
    final int ordA = (int)'A', ordZ = (int)'Z';
    final int ord0 = (int)'0', ord9 = (int)'9';

    for (int i=start; i < id.length(); ++i) {
      int c = (int) id.charAt(i);
      int v = 0;
      if (c>=ordA && c<=ordZ) { v = c-ordA+10; } else
      if (c>=ord0 && c<=ord9) { v = c-ord0;    }
      res = res * 36 + v;
    }

    return res;
  }
}
