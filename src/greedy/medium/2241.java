package greedy.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/design-an-atm-machine/description/
// 2241. Design an ATM Machines
class ATM {

    Map<Integer, Integer> notes;
    private static final int[] noteTypes = { 20, 50, 100, 200, 500 };

    public ATM() {
        this.notes = new HashMap<>();
    }

    public void deposit(int[] banknotesCount) {
        Map<Integer, Integer> notesCnt = getMapRepOfDeposit(banknotesCount);
        for (Map.Entry<Integer, Integer> cnt : notesCnt.entrySet()) {
            int note = cnt.getKey();
            int count = cnt.getValue();
            notes.put(note, notes.getOrDefault(note, 0) + count);
        }
    }

    public int[] withdraw(int amount) {
        return withdrawAmount(amount);
    }

    Map<Integer, Integer> getMapRepOfDeposit(int[] deposit) {
        Map<Integer, Integer> notesCnt = new HashMap<>();
        for (int i = 0; i < deposit.length; i++) {
            notesCnt.put(noteTypes[i], deposit[i]);
        }
        return notesCnt;
    }

    private int[] withdrawAmount(int amount) {
        int[] money = new int[noteTypes.length];
        int remainingAmount = amount;
        Map<Integer, Integer> tempNotes = new HashMap<>(notes); // to check availability without modifying actual notes

        for (int i = noteTypes.length - 1; i >= 0; i--) {
            int note = noteTypes[i];
            int availableNotes = tempNotes.getOrDefault(note, 0);
            int requiredNotes = remainingAmount / note;

            if (requiredNotes > 0) {
                int usedNotes = Math.min(requiredNotes, availableNotes);
                money[i] = usedNotes;
                remainingAmount -= usedNotes * note;
                tempNotes.put(note, availableNotes - usedNotes);
            }
        }

        if (remainingAmount == 0) {
            for (int i = 0; i < noteTypes.length; i++) {
                if (money[i] > 0) {
                    notes.put(noteTypes[i], notes.get(noteTypes[i]) - money[i]);
                }
            }
            return money;
        }

        return new int[] { -1 };
    }
}
