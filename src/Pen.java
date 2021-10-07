public class Pen extends WritingImplement {
    @Override
    public void write(String text) {
        System.out.println("This message is written out in ink: " + text);
        this.addCharactersWritten(text.length());
    }
}
