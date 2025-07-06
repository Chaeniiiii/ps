import java.util.*;

class Solution {
    
    private static class Task {
        
        String name;
        int st;
        int lt;

        private Task(String name, int st, int lt) {
            this.name = name;
            this.st = st;
            this.lt = lt;
        }
        
    }
    
    public String[] solution(String[][] plans) {
        
        PriorityQueue<Task> tasks = new PriorityQueue<>((a, b) -> a.st - b.st);
        
        for (String[] plan : plans) {
            tasks.add(new Task(plan[0], convertToMinute(plan[1]), Integer.parseInt(plan[2])));
        }

        Deque<Task> paused = new ArrayDeque<>();
        ArrayList<String> finished = new ArrayList<>();

        Task now = tasks.poll();
        int time = now.st;

        while (!tasks.isEmpty()) {
            Task next = tasks.peek();
            int availableTime = next.st - time;

            if (now.lt > availableTime) {
                now.lt -= availableTime;
                paused.push(now);
                time = next.st;
            } else {
                time += now.lt;
                finished.add(now.name);
                if (!paused.isEmpty()) {
                    now = paused.pop();
                } else {
                    now = tasks.poll();
                    time = now.st;
                }
                continue;
            }
            now = tasks.poll();
        }

        finished.add(now.name);
        while (!paused.isEmpty()) {
            finished.add(paused.pop().name);
        }

        return finished.toArray(new String[0]);
    }

    private int convertToMinute(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

}
