import java.util.*;
public class DrawDiagram {
    public static void main(String[] args) {

        int height, length;
        Scanner kbd = new Scanner(System.in);
        System.out.println("Enter a length: ");
        length = kbd.nextInt();
        height = length;
        for (int i = 0; i < height; i++)
        {
            for(int k = 0; k < height-i; k++)
            {
                System.out.print(" ");
            }
            for(int j = 0; j < length; j++)
            {
                System.out.print("* ");
            }
                System.out.println();
        }

        for(int i = 0; i < length;i++)
        {
            for(int j = 0; j <= i;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }


    }
}

