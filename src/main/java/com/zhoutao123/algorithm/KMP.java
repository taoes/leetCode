package com.zhoutao123.algorithm;

public class KMP {

  public static void main(String[] args) {
    String source = "ABCDEFEAFDGABHXYZABD";
    byte[] bytes = source.getBytes();
    byte[] tag = new byte[source.length()];
    String target = "AB";
    for (int i = 0; i < target.length(); i++) {
      char c = target.charAt(i);
      for (int i1 = 0; i1 < bytes.length; i1++) {
        if (c == bytes[i1]) {
          tag[i1] = 1;
        } else {
          tag[i1] = 0;
        }
      }
    }
  }
}
