public class WritingImplement {
    private int charactersWritten = 0;

    public void write(String text) {
        System.out.println("This message is written out: " + text);
        this.addCharactersWritten(text.length());
    }

    public void addCharactersWritten(int c) {
        this.charactersWritten += c;
    }

    public int getCharactersWritten() {
        return this.charactersWritten;
    }

    public String toString() {
        return "Characters written so far: " + this.charactersWritten;
    }

    public boolean equals(WritingImplement wi) {
        return this.getCharactersWritten() == wi.getCharactersWritten();
    }
}
