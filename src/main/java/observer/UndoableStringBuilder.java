package observer;

import java.util.ArrayList;
import java.util.List;

public class UndoableStringBuilder {
    private List<String> previousValues = new ArrayList();
    private StringBuilder sb = new StringBuilder();

    public UndoableStringBuilder() {
    }


    /**
     * Appends the specified string to this character sequence.
     * @param str - a string.
     * @return - a reference to this object.
     */
    public UndoableStringBuilder append(String str) {
        if (str == null) {
            return this;
        } else {
            String temp = this.sb.toString();

            try {
                this.sb.append(str);
                this.previousValues.add(temp);
            } catch (Exception var4) {
                System.out.println(var4);
            }

            return this;
        }
    }

    /**
     * Removes the characters in a substring of this sequence.
     * @param start - The beginning index, inclusive.
     * @param end - The ending index, exclusive.
     * @return - This object.
     */
    public UndoableStringBuilder delete(int start, int end) {
        String temp = this.sb.toString();

        try {
            this.sb.delete(start, end);
            this.previousValues.add(temp);
        } catch (Exception var5) {
            System.out.println(var5);
        }

        return this;
    }

    /**
     * Inserts the string into this character sequence.
     * @param offset
     * @param str - a string.
     * @return - a reference to this object.
     */
    public UndoableStringBuilder insert(int offset, String str) {
        if (str == null) {
            return this;
        } else {
            String temp = this.sb.toString();

            try {
                this.sb.insert(offset, str);
                this.previousValues.add(temp);
            } catch (Exception var5) {
                System.out.println(var5);
            }

            return this;
        }
    }

    /**
     * Replaces the characters in a substring of this sequence with characters in the specified String
     * @param start - The beginning index, inclusive.
     * @param end - The ending index, exclusive.
     * @param str -String that will replace previous contents.
     * @return - This object.
     */
    public UndoableStringBuilder replace(int start, int end, String str) {
        if (str == null) {
            return this;
        } else {
            String temp = this.sb.toString();

            try {
                this.sb.replace(start, end, str);
                this.previousValues.add(temp);
            } catch (Exception var6) {
                System.out.println(var6);
            }

            return this;
        }
    }

    /**
     * Causes this character sequence to be replaced by the reverse of the sequence.
     */
    public UndoableStringBuilder reverse() {
        String temp = this.sb.toString();

        try {
            this.sb.reverse();
            this.previousValues.add(temp);
        } catch (Exception var3) {
            System.out.println(var3);
        }

        return this;
    }

    /**
     * Returns a string representing the data in this sequence.
     * @return -a string representation of this sequence of characters.
     */
    public String toString() {
        return this.sb.toString();
    }


    /**
     * Undo the edit. Performs like Control Z in a PC.
     * @return - This object.
     */
    public UndoableStringBuilder undo() {
        int opSize = this.previousValues.size();
        if (opSize > 0) {
            this.sb = new StringBuilder((String)this.previousValues.remove(opSize - 1));
        }

        return this;
    }
}
