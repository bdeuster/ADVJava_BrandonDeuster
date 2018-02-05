package com.company;
import java.util.Scanner;
import java.util.ArrayList;

public class TestScores {
    public static Scanner scan = new Scanner(System.in);

    public int TestScores() throws Exception {
        ArrayList<Integer> score = new ArrayList<>();
        String input;
        boolean run = true;
        int ans = 0, average = 0, count = 0;

        do {
            System.out.println("Do you want to enter (T)est score or (E)xit? ");
            input = scan.nextLine();

            if ((input != null) && (input.toUpperCase().equals("T"))) {
                System.out.println("Input your test score: (0-100)");
                ans = scan.nextInt();

                try {

                    if (ans < 0 || ans > 100) {
                        throw new Exception();
                    } else {
                        score.add(ans);
                    }

                } catch (IllegalArgumentException exc) {
                    System.out.println(exc.getMessage());
                }


            }
            if ((input != null) && (input.toUpperCase().equals("E"))) {
                run = false;

                for( int x=0; x < score.size(); x++)
                {
                    count+= score.get(x);
                }
                average = (count / score.size());
                return (average);

            }



        }
        while (run);
        System.out.println(average);
        return (average);
    }


}