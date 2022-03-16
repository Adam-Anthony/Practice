import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;
class DPSCheck{
    public static void main(String[] args){
        String sample = "1d6 + 1d4 + 1d8 + 3 + 2";
        System.out.println("What is your damage roll?");
        System.out.println("(Example formating: "+ sample +")");
        Scanner scan = new Scanner(sample);
        int bonusDamage = 0;
        int signage = 1;
        int[] dice = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        Pattern p = Pattern.compile("(\\d*)d(\\d+)");
        while(scan.hasNext()){
            if (scan.hasNextInt()){
                bonusDamage += (signage*scan.nextInt());
            }
            else{
                String temp = scan.next();
                boolean sign = false;
                switch(temp){
                    case "+": signage=1; sign=true; break;
                    case "-": signage=-1;sign=true; break;
                }
                if (!sign){
                    Scanner reg = new Scanner(temp);
                    reg.findInLine(p);
                    MatchResult result = reg.match();
                    int amount = Integer.parseInt(result.group(1));
                    int value = Integer.parseInt(result.group(2));
                    dice[value-1] = amount;
                }
            }
        }
        System.out.println("Min Damage: " + (minDam(dice) + bonusDamage));
        System.out.println("Avg Damage: " + (avgDam(dice) + bonusDamage));
        System.out.println("Max Damage: " + (maxDam(dice) + bonusDamage));
        System.out.println("Random Damage (100 rolls): " + (ranDam(dice, 100)+ bonusDamage));
    }

    public static int minDam(int[] diceVal){
        int result = 0;
        for (int i=0; i<diceVal.length; i++){
            result += diceVal[i];
        }
        return result;
    }
    public static int avgDam(int[] diceVal){
        int result = 0;
        for (int i=0; i<diceVal.length; i++){
            if (diceVal[i]>0){
                if (i%2 == 1){
                    result += (diceVal[i])/2;
                }
                result += ((i+1) * diceVal[i])/2;
            }
        }
        return result;
    }
    public static int maxDam(int[] diceVal){
        int result = 0;
        for (int i=0; i<diceVal.length; i++){
            result += (diceVal[i]*(i+1));
        }
        return result;
    }

    public static int ranDam(int[] diceVal, int rolls){
        if (rolls <= 0){
            return 0;
        }
        Random ran = new Random();
        int total = 0;
        for (int j=0; j<rolls;j++){
            for (int i=0;i<diceVal.length;i++){
                int rollDown = diceVal[i];
                while (rollDown>0){
                    total += ran.nextInt(i+1)+1;
                    rollDown--;
                }
            }
        }
        int result = total/rolls;
        return result;
    }
}