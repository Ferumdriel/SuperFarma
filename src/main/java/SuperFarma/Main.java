package SuperFarma;

import java.util.Scanner;

/**
 * Created by 20305 on 13.08.2017.
 */
public class Main {

    static Animal rabbit = new Animal();
    static Animal sheep = new Animal();
    static Animal pig = new Animal();
    static Animal cow = new Animal();
    static Animal horse = new Animal();
    static Animal smallDog = new Animal();
    static Animal bigDog = new Animal();

    public static void main(String[] args) {

        System.out.println(rabbit.isTradePossible(6));
        System.out.println("Witaj w tej cudownej grze kolego. Celem gry jest zdobycie conajmniej 1 królika, 1 owcy, 1 świni, 1 krowy oraz 1 konia.");
        System.out.println("Przeszkodzić Ci w tym mogą grasujące w okolicy wilki i lisy.");
        System.out.println("Przeciwko lisowi obronić Cię może mały pies, przeciwko wilkowi duży pies.");
        System.out.println("Aktualny stan Twojej hodowli: króliki: "+ rabbit.count+ ", owce: "+ sheep.count+", świnie: "+pig.count+", krowy: "+cow.count+", konie: "+horse.count);
        System.out.println("By rzucić kostkami wćisnij 1");

        while(rabbit.count * sheep.count * pig.count * cow.count * horse.count<1) {

            Scanner input = new Scanner(System.in);
            String playerChoice = input.nextLine();

            if (playerChoice.equals("1")) {
                RedDice.rollADice();
                RollReward.RedReward();
                foxAttack();
                YellowDice.rollADice();
                RollReward.YellowReward();
                reward();
                wolfAttack();
                RollReward.Reset();
            }
            else if (playerChoice.equals("2")) {
                if (rabbit.isTradePossible(6)) {
                    rabbit.subtractCount(6);
                    sheep.addCount(1);
                }
                else
                    slamACheater();
            }
            else if (playerChoice.equals("3")) {
                if (sheep.isTradePossible(1)) {
                    sheep.subtractCount(1);
                    rabbit.addCount(6);
                }
                else
                    slamACheater();
            }
            else if (playerChoice.equals("4")) {
                if (sheep.isTradePossible(2)) {
                    sheep.subtractCount(2);
                    pig.addCount(1);
                }
                else
                    slamACheater();
            }
            else if (playerChoice.equals("5")) {
                if (pig.isTradePossible(1)){
                    pig.subtractCount(1);
                    sheep.addCount(2);
                }
                else
                    slamACheater();
            }
            else if (playerChoice.equals("6")) {
                if (pig.isTradePossible(3)){
                    pig.subtractCount(3);
                    cow.addCount(1);
                }
                else
                    slamACheater();
            }
            else if (playerChoice.equals("7")) {
                if (cow.isTradePossible(1)){
                    cow.subtractCount(1);
                    pig.addCount(3);
                }
                else
                    slamACheater();
            }
            else if (playerChoice.equals("8")) {
                if (cow.isTradePossible(2)){
                    cow.subtractCount(2);
                    horse.addCount(1);
                }
                else
                    slamACheater();
            }
            else if (playerChoice.equals("9")) {
                if (horse.isTradePossible(1)){
                    horse.subtractCount(1);
                    cow.addCount(2);
                }
                else
                    slamACheater();
            }
            else if (playerChoice.equals("10")) {
                if (sheep.isTradePossible(1)){
                    sheep.subtractCount(1);
                    smallDog.addCount(1);
                }
                else
                    slamACheater();
            }
            else if (playerChoice.equals("11")) {
                if (cow.isTradePossible(1)){
                    cow.subtractCount(1);
                    smallDog.addCount(1);
                }
                else
                    slamACheater();
            }
            else
                slamACheater();

            System.out.println("Aktualny stan Twojej hodowli: króliki: " + rabbit.count + ", owce: " + sheep.count + ", świnie: " + pig.count + ", krowy: " + cow.count + ", konie: " + horse.count+" (dodatkowo: małe psy: "+ smallDog.count+", duże psy: "+ bigDog.count+")");
            System.out.println("Wciśnij 1 by rzucić kostkami");
            if (rabbit.isTradePossible(6)) System.out.println("Wciśnij 2 by wymienić 6 królików na 1 owcę");
            if (sheep.isTradePossible(1)) System.out.println("Wciśnij 3 by wymienić 1 owcę na 6 królików");
            if (sheep.isTradePossible(2)) System.out.println("Wciśnij 4 by wymienić 2 owce na 1 świnię");
            if (pig.isTradePossible(1)) System.out.println("Wciśnij 5 by wymienić 1 świnię na 2 owce");
            if (pig.isTradePossible(3)) System.out.println("Wciśnij 6 by wymienić 3 świnie na 1 krowę");
            if (cow.isTradePossible(1)) System.out.println("Wciśnij 7 by wymienić 1 krowę na 3 świnie");
            if (cow.isTradePossible(2)) System.out.println("Wciśnij 8 by wymienić 2 krowy na 1 konia");
            if (horse.isTradePossible(1)) System.out.println("Wciśnij 9 by wymienić 1 konia na 2 krowy");
            if (sheep.isTradePossible(1)) System.out.println("Wciśnij 10 by wymienić 1 owcę na 1 małego psa");
            if (cow.isTradePossible(1)) System.out.println("Wciśnij 11 by wymienić 1 krowę na 1 dużego psa");

        }
    }

    public static void slamACheater(){
        System.out.println("Hola, hola, nie oszukuj, kolego.");
    }

    public static void wolfAttack(){
        if(YellowDice.result.equals("wilk")){
            if(bigDog.count<1){
                System.out.println("Zły wilk zakradł się do zagrody i zjadł wszystkie Twoje zwierzęta, tzn króliki: " + rabbit.count + ", owce: " + sheep.count + ", świnie: " + pig.count + ", krowy: " + cow.count);
                rabbit.count = 0;
                sheep.count = 0;
                pig.count = 0;
                cow.count = 0;
            }
            else {
                bigDog.count -= 1;
                System.out.println("Dzięki bohaterskiej postawie dużego psa, udało się obronić Twoje zwierzęta, co jednak przypłacił życiem");
            }
        }
    }

    public static void foxAttack(){
        if(RedDice.result.equals("lis")){
            if(smallDog.count<1){
                System.out.println("Sprytny lis zakradł się do zagrody i zjadł Twoje króliki w ilości: "+ rabbit.count+", innymi słowy - wszystkie");
                rabbit.count = 0;
            }
            else {
                smallDog.count -= 1;
                System.out.println("Dzięki bohaterskiej postawie małego psa, udało się obronić Twoje króliki, co jednak przypłacił życiem");
            }
        }
    }


    public static void reward() {

        rabbit.count = RollReward.AnimalReward(RollReward.bonusRabbit, RollReward.rewardRabbit, rabbit.count);
        sheep.count = RollReward.AnimalReward(RollReward.bonusSheep, RollReward.rewardSheep, sheep.count);
        pig.count = RollReward.AnimalReward(RollReward.bonusPig, RollReward.rewardPig, pig.count);
        cow.count = RollReward.AnimalReward(RollReward.bonusCow, RollReward.rewardCow, cow.count);
        horse.count = RollReward.AnimalReward(RollReward.bonusHorse, RollReward.rewardHorse, horse.count);

    }
}
