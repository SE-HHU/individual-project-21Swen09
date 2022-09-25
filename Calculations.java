import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Calculations {
    public static void main(String[] args) {
        Random in = new Random();
        Scanner put = new Scanner(System.in);
        HashMap<String, Integer> alg = new HashMap<>();
        System.out.print("请输入题目个数：");
        int n = put.nextInt();
        String[] sign = {"+", "-"};
        for (int i = 1; i <= n; ++i) {
            int num1 = in.nextInt(100) + 1;
            int num2 = in.nextInt(100) + 1;
            int sn = in.nextInt(2) + 1;
            if (sn == 1) {
                String s = sign[in.nextInt(2)];
                if (alg.containsKey(num1 + s + num2 + "=")) {
                    ++n;
                    break;
                }
                switch (s) {
                    case "+":
                        alg.put(num1 + s + num2 + "=", num1 + num2);
                        break;
                    case "-":
                        if (num1 >= num2) alg.put(num1 + s + num2 + "=", num1 - num2);
                        else ++n;
                        break;
                }
            } else {
                int num3 = in.nextInt(100) + 1;
                String s1 = sign[in.nextInt(2)];
                String s2 = sign[in.nextInt(2)];
                if (alg.containsKey(num1 + s1 + num2 + s2 + num3 + "=")) {
                    ++n;
                    break;
                }
                switch (s1 + s2) {
                    case "++":
                        alg.put(num1 + s1 + num2 + s2 + num3 + "=", num1 + num2 + num3);
                        break;
                    case "+-":
                        if (num1 + num2 >= num3) alg.put(num1 + s1 + num2 + s2 + num3 + "=", num1 + num2 - num3);
                        else ++n;
                        break;
                    case "-+":
                        if (num1 >= num2) alg.put(num1 + s1 + num2 + s2 + num3 + "=", num1 - num2 + num3);
                        else ++n;
                        break;
                    case "--":
                        if (num1 >= num2 && num1 - num2 >= num3) alg.put(num1 + s1 + num2 + s2 + num3 + "=", num1 - num2 - num3);
                        else ++n;
                        break;
                }
            }
        }
        try{
            File f1 = new File("C:\\Users\\Administrator\\IdeaProjects\\untitled\\src\\Exercises.txt");
            File f2 = new File("C:\\Users\\Administrator\\IdeaProjects\\untitled\\src\\Answers.txt");
            f1.createNewFile();
            f2.createNewFile();
            BufferedWriter Exe = new BufferedWriter(new FileWriter(f1));
            BufferedWriter Ans = new BufferedWriter(new FileWriter(f2));
            Set<String> keys = alg.keySet();
            Collection<Integer> values = alg.values();
            int i = 1;
            for(String key: keys){
                Exe.write(i+". "+key);
                Exe.newLine();
                ++i;
            }
            int j = 1;
            for(Integer value: values){
                Ans.write(j+". "+value);
                Ans.newLine();
                ++j;
            }
            Exe.close();
            Ans.close();
            System.out.println(alg);
        }
        catch(IOException e){
            System.out.println("IO异常");
        }
    }
}
