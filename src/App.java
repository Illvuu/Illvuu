import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner a = new Scanner(System.in);
        String input, output;
        input = a.nextLine();
        output = a.nextLine();
        int il = input.length(), ol = output.length();
        char skb = '-', ska = '-', qk = '-';
        if (il == ol) {
            for (int i = 0; i < il; i++) {
                if (input.charAt(i) != output.charAt(i)) {
                    skb = input.charAt(i);
                    ska = output.charAt(i);
                    qk = '-';
                    System.out.println(skb + " " + ska);
                    System.out.println(qk);
                    break;
                }
            }

        }

        if (il != ol) {
            int b = 0;
            for (int i = 0; i < il; i++) {
                char x = input.charAt(i + b);
                if (x == qk) {
                   
                    // keep checking until the next one is not qk anymore
                    for (int r = i + 1; r < il; r++) {
                        if (input.charAt(r) == qk) {
                            b++;
                        } 
                    }
                    
                    continue;
                }
                if (x == skb) {
                    continue;
                }

                if (i < ol) {
                    char y = output.charAt(i);
                    if (x == y) {
                        continue;
                    } else {
                        if (qk == '-') {
                            for (int r = i + 1; r < il; r++) {
                                if (input.charAt(r) == x) {
                                    continue;
                                } else if (input.charAt(r) == y) {
                                    qk = x;
                                    b = r - i;
                                    break;
                                }
                            }

                            if (qk == '-') {
                                skb = x;
                                ska = y;
                            }
                        } else {
                            skb = x;
                            ska = y;
                        }

                        if (skb != '-' && ska != '-' && qk != '-') {
                            System.out.println(skb + " " + ska);
                            System.out.println(qk);
                            break;
                        }
                    }

                } else {
                    qk = x;
                    System.out.println(skb + " " + ska);
                    System.out.println(qk);
                    break;
                }

            }

       }
        a.close();
    }
}
