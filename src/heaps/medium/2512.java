package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/reward-top-k-students/description/
// 2512. Reward Top K Students
class Solution {
    class Student implements Comparable<Student> {
        int id;
        int score;

        Student(int id, int score) {
            this.id = id;
            this.score = score;
        }

        @Override
        public int compareTo(Student other) {
            if (this.score != other.score) {
                return other.score - this.score; // Higher score first
            }
            return this.id - other.id; // Lower ID first if scores are equal
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Student)) {
                return false;
            }
            Student other = (Student) obj;
            return this.id == other.id && this.score == other.score;
        }

    }

    public List<Integer> topStudents(String[] positiveFeedback, String[] negativeFeedBack, String[] report,
            int[] studentId, int k) {
        Set<String> positive = new HashSet<>(Arrays.asList(positiveFeedback));
        Set<String> negative = new HashSet<>(Arrays.asList(negativeFeedBack));

        PriorityQueue<Student> pq = new PriorityQueue<>();

        for (int i = 0; i < report.length; i++) {
            String[] words = report[i].split(" ");
            int score = 0;
            for (String word : words) {
                if (positive.contains(word)) {
                    score += 3;
                } else if (negative.contains(word)) {
                    score -= 1;
                }
            }
            pq.offer(new Student(studentId[i], score));
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            result.add(pq.poll().id);
        }

        return result;
    }
}