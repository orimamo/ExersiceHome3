public class ExersiceHome7_2 {
        public static void QuadraticEquation(String str) {
            boolean check = checkPropriety(str);
            if (check = true) {
                double ans1 = 0, ans2 = 0;
                String temp = "";
                int a = 0;
                int b = 0;
                int c = 0;
                int i = 0;
                if (str.charAt(0) == '-') {
                    i = 1;
                }
                while (i < str.length()) {
                    if (i == 1) {
                        temp = temp + str.charAt(i - 1) + str.charAt(i);
                        a = Integer.parseInt(temp);
                        temp = "";
                        i = i + 4;
                    } else {
                        temp = temp + str.charAt(i);
                        a = Integer.parseInt(temp);
                        temp = "";
                        i = i + 4;
                    }
                    if (str.charAt(i) == '-') {
                        temp = temp + str.charAt(i) + str.charAt(i + 1);
                        b = Integer.parseInt(temp);
                        temp = "";
                        i = i + 3;
                    } else {
                        if (str.charAt(i) == '+') {
                            temp = temp + str.charAt(i + 1);
                            b = Integer.parseInt(temp);
                            temp = "";
                            i = i + 3;
                        }
                    }
                    if (str.charAt(i) == '-') {
                        temp = temp + str.charAt(i) + str.charAt(i + 1);
                        c = Integer.parseInt(temp);
                        temp = "";
                        break;
                    } else {
                        if (str.charAt(i) == '+') {
                            temp = temp + str.charAt(i + 1);
                            c = Integer.parseInt(temp);
                            temp = "";
                            break;
                        }
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
            String str = "-1x^2-2x+1=0";
            QuadraticEquation(str);
        }
    }
