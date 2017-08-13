package SuperFarma;

public class YellowDice extends DiceRoll {

    public static void rollADice() {

        score= dice.nextInt(12);
        result = "";

        if (score <= 5)
            result = "królik";
        else if (score == 6 || score == 7)
            result = "owca";
        else if (score == 8 || score == 9)
            result = "świnia";
        else if (score == 10)
            result = "krowa";
        else if (score == 11)
            result = "wilk";
        System.out.println("Kostka żółta: " + result);

    }
}

