package com.example;

import java.util.BitSet;

public class Cache {
  private BitSet _bitset;

  public Cache(int size) {
    this._bitset = new BitSet(size);
  }

  public Cache(String fromFile) {
    super();
  }

  public void save(String toFile) {

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
    return this;
  }
}
