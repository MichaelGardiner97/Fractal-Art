package Lab05_FractalArt;

import Class05_Multimedia.StdDraw;

import java.awt.*;
import java.util.Scanner;

public class FractalArt {

    // plot a square, centered on (x, y) of the given side length
    public static void drawCircle(double x, double y, double size) {
        StdDraw.setPenColor(Color.getHSBColor((float) Math.random(), 1f, 1f));
        StdDraw.filledCircle(x, y, size/2.5);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.circle(x, y, size/4.5);
    }

    // plot an order n recursive squares pattern
    // centered on (x, y) of the given side length
    public static void draw(int n, double x, double y, double size) {
        if (n == 0) return;

        drawCircle(x, y, size/5);

        // recursively draw 4 smaller trees of order n-1
        draw(n-1, x - size/4, y - size/4, size/2);    // lower left
        draw(n-1, x - size/4, y + size/4, size/2);    // upper left
        draw(n-1, x + size/4, y - size/4, size/2*2);    // lower right
        draw(n-1, x + size/4, y + size/4, size/2);    // upper right
    }

    // Sets
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the number of recursions: ");
        int N = in.nextInt();
        double x = 0.5, y = 0.5;   // center of square
        double size = 1;         // side length of square
        draw(N, x, y, size);
    }

}