package sort.baekjoon.S10814;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /**
     * https://www.acmicpc.net/problem/10814
     */
    public static class PersonInfo {
        private final int age;
        private final String name;

        public PersonInfo(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int age() {
            return age;
        }

        public String name() {
            return name;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int persons = Integer.parseInt(br.readLine());

        List<PersonInfo> personInfos = new ArrayList<>();
        for (int i = 0; i < persons; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            personInfos.add(new PersonInfo(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        /*
         * personInfos.sort((o1, o2) -> Integer.compare(o1.age(), o2.age()));
         * Comparator의 comparing 메서드는 “o1를 o2 앞에 둘지(음수), 뒤에 둘지(양수)”를 결정
         * return 값 < 0 → o1이 앞
         * return 값 == 0 → 동일
         * return 값 > 0 → o1이 뒤
         */
        personInfos.sort(Comparator.comparingInt(PersonInfo::age));

        for (PersonInfo personInfo : personInfos) {
            bw.write(personInfo.age() + " " + personInfo.name() + "\n");
        }

        br.close();

        // 최종 출력
        bw.flush();
        bw.close();
    }
}
