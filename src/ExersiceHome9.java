import java.util.Random;
import java.util.Scanner;

public class ExersiceHome9 {
    public static final int ARRAY_SIZE = 4;
    public static int[] secretCode(){
        Random random = new Random();
        int [] array = new int[ARRAY_SIZE];
        int temp=0;
        for (int i=0;i< array.length;i++){
            temp=random.nextInt(6) + 1;
            if(i==0){
                array[i]=temp;
            }
            else {
                boolean check=false;
                for (int j=0;j< i+1;j++){
                if (array[j] == temp) {
                    check=false;
                    i--;
                    break;
                } else {
                    check = true;
                }
                }if (check==true) {
                    array[i] = temp;
                }
            }
        }return array;
    }
    public static int [] UserGuess(){
        Scanner scanner=new Scanner(System.in);
        int [] array = new int[ARRAY_SIZE];
        System.out.println("enter your guess");
        int userGuess = scanner.nextInt();
            if (userGuess / 1000 >= 7 ) {
                System.out.print("wrong number");
            } else {
                for (int i = array.length-1; i >= 0; i=i-1) {
                        array[i] = userGuess % 10;
                        userGuess = userGuess / 10;

                }
        }
        return array;

    }
    public static boolean checkPropriety(int [] guess) {
        boolean check = false;
        for (int i=0;i<guess.length;i++){
            if(guess[i]<=6){
                check=true;
            }
            else {
                check=false;
                break;
            }
        }
        return check;
    }
    public static int checkRepetitions(int [] guess){
        int counter= 0;
        for (int i=0;i<guess.length;i++){
            for (int j=i+1;j<guess.length;j++){
                if (guess[i]==guess[j]){
                    counter++;
                }
            }
        }
        return counter;
    }
    public static int isAccurate(int [] secretCode,int[] guess){
        int accurate=0;
        int halfAccurate=0;
            for (int i = 0; i < ARRAY_SIZE; i++) {
                if (secretCode[i] == guess[i]) {
                    accurate++;
                } else
                {
                    for (int j=0; j<ARRAY_SIZE;j++)
                    {
                        if (secretCode[j] == guess[i]) {
                            halfAccurate++;
                        }
                    }

                }
            }


        System.out.println("num of accurate is " + accurate + " num of half is " + halfAccurate);
        return accurate;
    }
    public static int opportunities(int userInput){
        Random random = new Random();
        int amountOfOpportunities=0;
            switch (userInput) {
                case 1:
                    amountOfOpportunities = 20;
                    break;
                case 2:
                    amountOfOpportunities = 15;
                    break;
                case 3:
                    amountOfOpportunities = 10;
                    break;
                case 4:
                    amountOfOpportunities = random.nextInt(20) + 5;
                    break;

            }
        return amountOfOpportunities;
    }
    public static void route(int amountOfOpportunities , int [] secretCode){
        int i=amountOfOpportunities;
        boolean check=false;
        int accurate=0;
        int [] guess =new int[ARRAY_SIZE];
        while (i>0){
            guess=UserGuess();
            check=checkPropriety(guess);
            if (check) {
                int checkRepetition= checkRepetitions(guess);
                if (checkRepetition >= 1) {
                    i -= 2;
                    System.out.println("you put to equals number you will be fine in 2 opportunities");
                } else {
                    accurate = isAccurate(secretCode, guess);
                    if (accurate == 4) {
                        System.out.println("you won!!!");
                        break;
                    } else {
                        i--;

                    }
                }
            }
        }
        if (i==0 && accurate!=4 ){
            System.out.println("you loos!");
            for (int k=0;k<secretCode.length;k++) {
                System.out.print(secretCode[k] + ",");

            }
        }
    }
    public static void mission(){
        System.out.println("\nwelcome to our game!!\nyou need to guess a secret code\nthis secret code is in size of only 4 digits\nthe number is only between 1-6");
        System.out.println("you have 4 route \n1.easy route : have 20 opportiunities\n2.medium route : have 15 opportiunities\n3.hard route : have 10 opportiunities\n4.suprise route : have random opportiunities between 5-25");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] secretCode =new int[ARRAY_SIZE];
        secretCode=secretCode();
        for (int k=0;k<secretCode.length;k++) {
            System.out.print(secretCode[k] + ",");
        }
        mission();
        System.out.println("which route you want");
        int userInput=scanner.nextInt();
        if (userInput>=1 && userInput<=4) {
            int amountOfOpportunities = opportunities(userInput);
            route(amountOfOpportunities, secretCode);
        }
        else {
            System.out.print("there isn't route like this");
        }
    }

}


/*for (int i=0;i<array.length;i++){
        System.out.print(array[i] + ",");
        }
        guess=UserGuess();
        System.out.println(checkPropriety(array));
        isAccurate(array,guess);*/

