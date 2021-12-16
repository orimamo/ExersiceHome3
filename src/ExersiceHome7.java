public class ExersiceHome7 {
    public static void QuadraticEquation(String str) {
        boolean check = checkPropriety(str);
        if (check = true) {
            double ans1 = 0, ans2 = 0;
            String temp = "";
            int a = 0;
            int b = 0;
            int c = 0;
            if (str.charAt(0) == '-') {
                temp = temp + str.charAt(0) + str.charAt(1);
                a = Integer.parseInt(temp);
                temp = "";
                if (str.charAt(5) == '-') {
                    temp = temp + str.charAt(5) + str.charAt(6);
                    b = Integer.parseInt(temp);
                    temp = "";
                } else {
                    if (str.charAt(5) == '+') {
                        temp = temp + str.charAt(6);
                        b = Integer.parseInt(temp);
                        temp = "";
                    }
                }
                if (str.charAt(8) == '-') {
                    temp = temp + str.charAt(8) + str.charAt(9);
                    c = Integer.parseInt(temp);
                    temp = "";
                } else {
                    if (str.charAt(8) == '+') {
                        temp = temp + str.charAt(9);
                        c = Integer.parseInt(temp);
                        temp = "";
                    }
                }


            } else {
                temp = temp + str.charAt(0);
                a = Integer.parseInt(temp);
                temp = "";
                if (str.charAt(4) == '-') {
                    temp = temp + str.charAt(4) + str.charAt(5);
                    b = Integer.parseInt(temp);
                    temp = "";
                } else {
                    if (str.charAt(4) == '+') {
                        temp = temp + str.charAt(5);
                        b = Integer.parseInt(temp);
                        temp = "";
                    }
                }
                if (str.charAt(7) == '-') {
                    temp = temp + str.charAt(7) + str.charAt(8);
                    c = Integer.parseInt(temp);
                    temp = "";
                } else {
                    if (str.charAt(7) == '+') {
                        temp = temp + str.charAt(8);
                        c = Integer.parseInt(temp);
                        temp = "";
                    }
                }
                double determinant = b * b - 4 * a * c;
                if (determinant > 0) {
                    ans1 = (-b + Math.sqrt(determinant)) / (2 * a);
                    ans2 = (-b - Math.sqrt(determinant)) / (2 * a);
                    System.out.println(ans1 + "," + ans2);

                } else if (determinant == 0) {
                    ans1 = ans2 = -b / (2 * a);
                    System.out.println(ans1);


                } else {
                    System.out.println("The equation has no real roots.");

                }

            }
        } else {
            System.out.println("this is wrong!!!");
        }
    }
    public static boolean checkPropriety(String str) {
        boolean check = false;
        int i = 0;
        if (str.charAt(0) == 'x') {
            check = false;
        }
        while (i < str.length()) {
            if (str.charAt(i) == '-') {
                check = true;
                i++;
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                i++;
                check = true;
                if (str.charAt(i) == 'x' && str.charAt(i + 1) == '^' && str.charAt(i + 2) == '2') {
                    i = i + 3;
                    check = true;
                    if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                        i++;
                        check = true;
                        if ((str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                            i++;
                            check = true;
                            if (str.charAt(i) == 'x') {
                                i++;
                                if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                                    i++;
                                    check = true;
                                    if ((str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                                        i++;
                                        check = true;
                                        if (str.charAt(i) == '=' && str.charAt(i + 1) == '0') {
                                            check = true;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                check = false;
                break;
            }
        }
        return check;
    }

    public static void main(String[] args) {
        String str = "1x^2-6x+9=0";
        QuadraticEquation(str);
    }

}
