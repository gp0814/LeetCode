class Class {
    double pass;
    double total;
    public Class(double pass, double total) {
        this.pass = pass;
        this.total = total;
    }
}

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Class> pq = new PriorityQueue<>((a, b) -> 
            Double.compare((b.pass + 1) / (b.total + 1) - (b.pass / b.total),
                           (a.pass + 1) / (a.total + 1) - (a.pass / a.total))
        );

        for (int i = 0; i < classes.length; i++) {
            pq.add(new Class(classes[i][0], classes[i][1]));
        }

        while (extraStudents > 0) {
            Class newCC = pq.poll();
            newCC.pass += 1;
            newCC.total += 1;
            extraStudents--;
            pq.add(newCC);
        }

        double avg = 0;
        while (!pq.isEmpty()) {
            Class newCC = pq.poll();
            avg += (newCC.pass / newCC.total);
        }

        return avg / classes.length;
    }
}