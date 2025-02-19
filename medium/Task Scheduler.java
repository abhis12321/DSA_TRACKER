class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        for(char c : tasks) {
            freq[c - 'A']++;
        }
        
        // PriorityQueue<Integer> maxheap = new PriorityQueue<>((a , b) -> b - a);
        // for(int m : freq) {
        //     if(m > 0) {
        //         maxheap.offer(m);
        //     }
        // }
        // int cycles = 0;
        // List<Integer> temp;
        // while(!maxheap.isEmpty()) {
        //     temp = new ArrayList<>();
        //     for(int i = 1; i <= n+1 && !maxheap.isEmpty(); i++) {
        //         temp.add(maxheap.poll());
        //     }

        //     for(int m : temp) {
        //         if(--m > 0) {
        //             maxheap.offer(m);
        //         }
        //     }

        //     cycles += maxheap.isEmpty() ? temp.size() : n + 1;
        // }

        // return cycles;
        Arrays.sort(freq);
        int maxIdleSlots = --freq[25] * n;
        // System.out.println(maxIdleSlots);

        for(int i = 24; i >= 0 && freq[i] > 0; i--) {
            maxIdleSlots -= Math.min(freq[i], freq[25]);
        }

        // System.out.println(maxIdleSlots);
        return Math.max(maxIdleSlots , 0) + tasks.length;
    }  
}