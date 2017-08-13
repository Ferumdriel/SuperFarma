package SuperFarma;

public class RedDice extends DiceRoll {

    public static void rollADice() {

        score= dice.nextInt(12);
        result = "";

        if (score <= 5)
            result = "królik";
        else if (score > 5 && score <= 8)
            result = "owca";
        else if (score == 9)
            result = "świnia";
        else if (score == 10)
            result = "koń";
        else if (score == 11)
            result = "lis";
        System.out.println("Kostka czerwona: " + result);
        diceRollsCount++;
    }
}
