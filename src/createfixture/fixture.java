package createfixture;

import java.util.*;

public class fixture {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("TAKIM SAYISI GİRİNİZ:");
        int takımsayısı= input.nextInt();;

        List<String> takımlarılistele = new ArrayList<>();

        for (int i = 0; i < takımsayısı; i++) {
            System.out.println("Takım ismi Giriniz:");
            String takımismi = input.next();
            takımlarılistele.add(takımismi);
        }

        if (takımsayısı % 2 != 0) {
            takımlarılistele.add("BAY");
            takımsayısı += 1;
        }

        Iterator<String> itr = takımlarılistele.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }


        for (int i = 0; i < takımsayısı; i++) {
            int index = (int) (Math.random() * takımlarılistele.size());
            takımlarılistele.add(takımlarılistele.get(index));
            takımlarılistele.remove(takımlarılistele.get(index));
        }

        int totalround = takımsayısı - 1;
        int numMatchperround = takımsayısı / 2;

        LinkedHashMap<String, ArrayList<ArrayList<String>>> rounds = new LinkedHashMap<>();

        for (int i = 0; i < totalround; i++) {
            String round = String.valueOf(i + 1);
            rounds.put(round, new ArrayList<ArrayList<String>>());
        }

        for (int i = 0; i < totalround; i++) {
            ArrayList<String> home = new ArrayList<>();
            ArrayList<String> away = new ArrayList<>();
            for (int j = 0; j < numMatchperround; j++) {
                home.add(takımlarılistele.get(j));
                away.add(takımlarılistele.get((takımsayısı - 1) - j));  //(takımsayısı-1)-j index of away team
            }

            String round = String.valueOf(i + 1);
            rounds.get(round).add(home);
            rounds.get(round).add(away);

            List<String> newTeams = new ArrayList<>();

            newTeams.add(takımlarılistele.get(0));
            newTeams.add(takımlarılistele.get(takımsayısı - 1));

            for (int k = 1; k < takımlarılistele.size()-1; k++) {
                newTeams.add(takımlarılistele.get(k));
            }

            takımlarılistele = newTeams;
        }
        System.out.println();

        for (int i = 0; i < 2 * totalround; i++) {
            System.out.println(i + 1 + ".Round");
            for (int j = 0; j < numMatchperround; j++) {
                if (i < totalround) {
                    System.out.println(rounds.get(String.valueOf(i + 1)).get(0).get(j) + " vs " + rounds.get(String.valueOf(i + 1)).get(1).get(j));
                } else {
                    System.out.println(rounds.get(String.valueOf(i + 1 - totalround)).get(1).get(j) + " vs " + rounds.get(String.valueOf(i + 1 - totalround)).get(0).get(j));
                }
            }
            System.out.println();
        }

       /* int []arr1={1,2,3,4};
        int []arr2={10,20,30,40};

        arr1=arr2;

        arr2[0]=100;
        System.out.println(arr1[0]);*/
    }
}