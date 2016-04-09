package Lab05_FractalArt;

import Class05_Multimedia.StdDraw;
import java.util.Scanner;
import java.awt.Color;

public class Sierpinski {

    public static void sierpinski(int n, double x0, double y0, double x1,
                            double y1, double x2, double y2) {

        // define array xm, ym to store x and y values of midpoints
        double [] xm = new double[3];
        double [] ym = new double[3];

        // assign midpoints’ values to xm and ym
        xm[0]= (x0+x1)/2;
        xm[1]= (x1+x2)/2;
        xm[2]= (x2+x0)/2;
        ym[0]= (y0+y1)/2;
        ym[1]= (y1+y2)/2;
        ym[2]= (y2+y0)/2;

        if (n == 0) {
            triangle(xm, ym);
            return;
        } else {

            StdDraw.filledPolygon(xm, ym);
            sierpinski(n-1,xm[0],ym[0],xm[1],ym[1],x1,y1);
            sierpinski(n-1,xm[1],ym[1],xm[2],ym[2],x2,y2);
            sierpinski(n-1,xm[2],ym[2],xm[0],ym[0],x0,y0);

        }
    }

    public static void triangle(double[] xm, double[] ym) {

        xm = new double[3];
        ym = new double[3];

        // fill arrays initially to draw black solid TRIANGLE xm, ym = 0.0, 0.0, 0.5, t, 1.0, 0.0
        StdDraw.filledPolygon(xm, ym);

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of recursions: ");
        int N = scan.nextInt();
        double t = Math.sqrt(3.0) / 2.0;

        sierpinski(N, 0.0, 0.0, 0.5, t, 1.0, 0.0);
    }
}