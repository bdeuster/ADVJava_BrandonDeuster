package us.mattgreen;

import java.util.Scanner;

public class Main {
    private static String line = "";
    private static String lineScore = "";
    private final static FileInput cardAccts = new FileInput("movie_cards.csv");
    private final static FileInput cardPurchases = new FileInput("movie_purchases.csv");
    private final static FileInput cardRating = new FileInput("movie_rating.csv");
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        String line;
        String[] fields;
        boolean first = true;
        int[] nums = new int[4];
        System.out.format("%8s  %-18s %6s %6s %6s\n","Account","Name", "Movies", "Points", "Score");
        while ((line = cardAccts.fileReadLine()) != null) {
            fields = line.split(",");
            findPurchases(first,fields[0], nums);
            findScores(first, fields[0], nums);
            first= false;
            System.out.format("00%6s  %-18s  %2d   %4d %6s\n",fields[0],fields[1], nums[0], nums[1], nums[2]);
        }
    }

    public static void findPurchases(boolean first, String acct, int[] nums) {
        nums[0] = 0;
        nums[1] = 0;

        //String line ="";
        String[] fields;
        boolean done = false;

        if(first)
        {
            line = cardPurchases.fileReadLine();
        }
        while (((line != null) && !(done))) {
            fields = line.split(",");
            if (fields[0].compareTo(acct) > 0) {
                done = true;
            }
            else if (fields[0].equals(acct)) {
                nums[0]++;
                nums[1] += Integer.parseInt(fields[2]);
                line = cardPurchases.fileReadLine();
            }


        }
    }
    public static void findScores(boolean first, String acct, int[] nums) {
        nums[2] = 0;
        nums[3] = 0;
        int total = 0;
        //String line ="";
        String[] fields;
        boolean done = false;

        if(first)
        {
            lineScore = cardRating.fileReadLine();
        }
        while (((lineScore != null) && !(done))) {
            fields = lineScore.split(",");
            if (fields[0].compareTo(acct) > 0) {
                done = true;
            }
            else if (fields[0].equals(acct)) {
               nums[3] += Integer.parseInt(fields[1]);
               total++;
               nums[2] = nums[3]/total;
               lineScore = cardRating.fileReadLine();
            }
        }



    }

}