package com.nscorp;

/**
 * Created by raphael on 30/03/17.
 */
public class StreamImpl implements Stream {
    private char sequence[];
    private int currentIndex;

    private StreamImpl() { }

    private StreamImpl(char[] seq) {
        this.sequence = seq;
        this.currentIndex = 0;
    }

    public static Stream newStream(final String charSequeence){
        return new StreamImpl(charSequeence.toCharArray());
    }

    @Override
    public char getNext() {
        char next = sequence[currentIndex];
        currentIndex++;
        return next;
    }

    @Override
    public boolean hasNext() {
        return currentIndex <= sequence.length - 1;
    }
}
