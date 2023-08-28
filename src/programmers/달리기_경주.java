package programmers;

import java.util.HashMap;

public class 달리기_경주 {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        String[] result = solution(players, callings);
        for(String name : result) {
            System.out.print(name + " -> ");
        }
    }

    public static String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerMap = new HashMap<>();

        int rank = 0;
        for(String player : players) {
            playerMap.put(player, rank++);
        }

        for(String call : callings) {
            int calledPlayerRank = playerMap.get(call);
            playerMap.replace(call, calledPlayerRank-1);

            String changeTarget = players[calledPlayerRank-1];
            playerMap.replace(changeTarget, calledPlayerRank);

            String temp = players[calledPlayerRank];
            players[calledPlayerRank] = players[calledPlayerRank-1];
            players[calledPlayerRank-1] = temp;
        }

        return players;
    }
}
