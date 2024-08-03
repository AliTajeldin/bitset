package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.BitSet;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Cache {
  private BitSet _bitset;

  public Cache(int size) {
    this._bitset = new BitSet(size);
  }

  public Cache(String fromFile, int len) throws IOException {
    try (
        FileInputStream fs = new FileInputStream(fromFile);
        GZIPInputStream gs = new GZIPInputStream(fs);) {
          int r, i = 0;
          byte[] buf = new byte[len];
          while ((r = gs.read(buf, i, buf.length - i)) > 0) {
            i += r;
          }
          this._bitset = BitSet.valueOf(buf);
    }
  }

  public void save(String toFile) throws IOException {
    try (
        FileOutputStream fs = new FileOutputStream(toFile);
        GZIPOutputStream gs = new GZIPOutputStream(fs);) {
      gs.write(this._bitset.toByteArray());
    }
  }

  public boolean has(String id) {
    int idx = Encoder.strIdToNum(id);
    return this._bitset.get(idx);
  }

  public Cache set(String id) {
    int idx = Encoder.strIdToNum(id);
    this._bitset.set(idx);
    return this;
  }

  public Cache clear(String id) {
    int idx = Encoder.strIdToNum(id);
    this._bitset.clear(idx);
    return this;
  }
}
