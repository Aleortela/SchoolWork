public class Main {
    public static void main(String[] args) {
        WritingImplement wi = new WritingImplement();
        wi.write("hello");
        wi.write("goodbye");
        System.out.println(wi);
        Pen p = new Pen();
        p.write("sketch books");
        System.out.println(p);
        System.out.println("Are they the same: " + wi.equals(p));
    }
}
