import java.io.*;
import java.util.*;

public class Main {

    public static class People{
        int age;
        String name;

        public People(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<People> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new People(age, name));
        }

        list.sort(Comparator.comparingInt(p -> p.age));

        for (People people : list) {
            bw.write(people.age + " " + people.name + "\n");
        }
        bw.flush();
        bw.close();
    }
}