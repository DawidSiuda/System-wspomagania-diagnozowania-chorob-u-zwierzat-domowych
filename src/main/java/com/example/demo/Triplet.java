//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package com.example.demo;

import java.io.Serializable;
import javafx.beans.NamedArg;

public class Triplet<K, V, J> implements Serializable {
    private K value1;
    private V value2;
    private J value3;

    public K getValue1() {
        return this.value1;
    }

    public V getValue2() {
        return this.value2;
    }

    public J getValue3() {
        return this.value3;
    }

    public Triplet(@NamedArg("value1") K var1, @NamedArg("value2") V var2, @NamedArg("value3") J var3) {
        this.value1 = var1;
        this.value2 = var2;
        this.value3 = var3;
    }

    public String toString() {
        return this.value1 + "," + this.value2 + "," + this.value3;
    }

    public int hashCode() {
        byte var1 = 7;
        int var2 = 31 * var1 + (this.value1 != null ? this.value1.hashCode() : 0);
        var2 = 31 * var2 + (this.value2 != null ? this.value2.hashCode() : 0);
        var2 = 31 * var2 + (this.value3 != null ? this.value3.hashCode() : 0);
        return var2;
    }

    public boolean equals(Object var1) {
        if (this == var1) {
            return true;
        } else if (!(var1 instanceof Triplet)) {
            return false;
        } else {
            Triplet var2 = (Triplet)var1;
            if (this.value1 != null) {
                if (!this.value1.equals(var2.value1)) {
                    return false;
                }
            } else if (var2.value1 != null) {
                return false;
            }

            if (this.value2 != null) {
                if (!this.value2.equals(var2.value2)) {
                    return false;
                }
            } else if (var2.value2 != null) {
                return false;
            }

            if (this.value3 != null) {
                if (!this.value3.equals(var2.value3)) {
                    return false;
                }
            } else if (var2.value3 != null) {
                return false;
            }

            return true;
        }
    }
}
