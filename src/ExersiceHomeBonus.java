import java.util.Scanner;

public class ExersiceHomeBonus {
    public static boolean property(String str) {
        boolean check = false;
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '(') {
                i++;
                check = true;
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    i++;
                    check = true;
                    if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '^' || str.charAt(i) == '*') {
                        i++;
                        check = true;
                        if (str.charAt(i) > '0' && str.charAt(i) < '9') {
                            i++;
                            check = true;
                            if (str.charAt(i) == ')') {
                                if (i + 1 < str.length()) {
                                    if (str.charAt(i + 1) != '(') {
                                        i++;
                                        check = true;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                check = false;
                                break;
                            }
                        } else {
                            check = false;
                            break;
                        }
                    } else {
                        check = false;
                        break;
                    }
                } else {
                    check = false;
                    break;
                }
            } else if (str.charAt(i) > '0' && str.charAt(i) < '9') {
                i++;
                check = true;
                if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '^' || str.charAt(i) == '*') {
                    i++;
                    check = true;
                    if (str.charAt(i) > '0' && str.charAt(i) < '9') {
                        i++;
                        check = true;
                    } else if (str.charAt(i) == '(') {
                        check = true;
                    }
                } else {
                    if (str.charAt(i) == ')' || str.charAt(i) == '(') {
                        check = false;
                        break;
                    }
                }
            } else if (str.charAt(i - 1) == ')') {
                check = true;
                if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '^' || str.charAt(i) == '*') {
                    i++;
                    check = true;
                    if (str.charAt(i) == '(') {
                        check = true;
                    } else if (str.charAt(i) > '0' && str.charAt(i) < '9') {
                        check = true;

                    }
                } else {
                    check = false;
                    break;
                }
            } else {
                check = false;
                break;
            }
        }
        return check;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your question");
        String str=scanner.next();
        boolean check=property(str);
        while (!check){
            System.out.println(check);
            System.out.println("enter again");
            str=scanner.next();
            check=property(str);
        }



    }
}
