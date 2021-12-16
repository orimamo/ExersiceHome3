import java.util.Scanner;

public class ExersiceHome3 {
    public static int[] Factorization(int number) {
        int j = 0;
            int[] factors = new int[number];
            if (number == 1) {
                factors[0] = number;
                return factors;
            } else
            {
                if (number > 1) {
                    for (int i = 2; i <= number; i++) {
                        while (number % i == 0) {
                            factors[j] = i;
                            number = number / i;
                            j++;
                            if (number == 1) {
                                break;
                            }
                        }

                    }
                }
            }

            int[] factors2 = new int[j];
            for (int k = 0; k < factors2.length; k++) {
                factors2[k] = factors[k];
            }
        return factors2;

    }

    public static void main(String[] args) {
        Scanner s1=new Scanner(System.in);
        System.out.println("enter your number");
        int number = s1.nextInt();
        int[] factors = Factorization(number);
        for (int i=0;i<factors.length;i++){
            System.out.print(factors[i] + ",");
        }

    }

}
