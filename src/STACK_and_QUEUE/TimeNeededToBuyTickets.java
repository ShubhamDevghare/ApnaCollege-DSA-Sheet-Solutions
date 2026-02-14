package STACK_and_QUEUE;

/*
========== queue =========
 */
/*
There are n people in a line queuing to buy tickets, where the 0th person is at the front of the line and
the (n - 1)th person is at the back of the line.

You are given a 0-indexed integer array tickets of length n where the number of tickets that
the ith person would like to buy is tickets[i].

Each person takes exactly 1 second to buy a ticket. A person can only buy 1 ticket at a time and has to go back
to the end of the line (which happens instantaneously) in order to buy more tickets.
If a person does not have any tickets left to buy, the person will leave the line.

Return the time taken for the person initially at position k (0-indexed) to finish buying tickets.
 */
public class TimeNeededToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int t = tickets[k];

// per 1k vykti kiti vel ghenar ticket ghy sathi  i.e how many times each person gets to buy a ticket
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                time += Math.min(tickets[i], t);
            } else {
                time += Math.min(tickets[i], t - 1);
            }
        }
        return time;
    }
}
/*
Example
-------
tickets = [2, 3, 2]
k = 2   (person we care about)
-----------------------------------------------
Initial queue (index → tickets left):
[ 0:2 , 1:3 , 2:2 ]

⏱️ Time = 1
0 buys → tickets left = 1
Queue becomes:
[ 1:3 , 2:2 , 0:1 ]

⏱️ Time = 2
1 buys → tickets left = 2
Queue:
[ 2:2 , 0:1 , 1:2 ]

⏱️ Time = 3
2 (k) buys → tickets left = 1
Queue:
[ 0:1 , 1:2 , 2:1 ]

⏱️ Time = 4
0 buys → tickets left = 0 (leaves)
Queue:
[ 1:2 , 2:1 ]

⏱️ Time = 5
1 buys → tickets left = 1
Queue:
[ 2:1 , 1:1 ]

⏱️ Time = 6
2 (k) buys → tickets left = 0 ✅ DONE
STOP


✅ Answer = 6 seconds

Now… why that loop works 🤯

Let:
t = tickets[k] = 2

We count how many times each person gets to buy a ticket before k finishes.
 */

/*
Mental Picture to Remember 🧠
=============================
Everyone buys once per round
Person k needs t rounds
People:

Before / at k → can buy in all t rounds
After k → can only buy in first t - 1 rounds
 */