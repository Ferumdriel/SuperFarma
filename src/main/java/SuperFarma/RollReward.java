package SuperFarma;

public class RollReward {
    static int bonusRabbit = 0;
    static int bonusSheep = 0;
    static int bonusPig = 0;
    static int bonusCow = 0;
    static int bonusHorse = 0;
    static int rewardRabbit = 0;
    static int rewardSheep = 0;
    static int rewardPig = 0;
    static int rewardCow = 0;
    static int rewardHorse = 0;

    public static void RedReward(){
        if(RedDice.result.equals("królik")){
            bonusRabbit +=1;
        }
        else if(RedDice.result.equals("owca")){
            bonusSheep +=1;
        }
        else if(RedDice.result.equals("świnia")){
            bonusPig +=1;
        }
        else if(RedDice.result.equals("koń")){
            bonusHorse +=1;
        }
    }
    public static void YellowReward(){
        if(YellowDice.result.equals("królik")){
            bonusRabbit +=1;
        }
        else if(YellowDice.result.equals("owca")){
            bonusSheep +=1;
        }
        else if(YellowDice.result.equals("świnia")){
            bonusPig +=1;
        }
        else if(YellowDice.result.equals("krowa")){
            bonusCow +=1;
        }
    }

    public static int AnimalReward(int bonus, int reward, int count){
        if(bonus>0)
            reward = (bonus + count) / 2;

        else
            reward = 0;
        count+=reward;
        return count;
    }
    public static void Reset(){
        bonusRabbit = 0;
        bonusSheep = 0;
        bonusPig = 0;
        bonusCow = 0;
        bonusHorse = 0;
        rewardRabbit = 0;
        rewardSheep = 0;
        rewardPig = 0;
        rewardCow = 0;
        rewardHorse = 0;
    }
}
