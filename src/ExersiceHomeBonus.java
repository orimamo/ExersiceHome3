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
        String str = "3(5-9)";
        System.out.println(property(str));
    }
}
