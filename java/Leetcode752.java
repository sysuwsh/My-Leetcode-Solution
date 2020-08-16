import javax.sound.midi.Soundbank;
import java.util.*;

public class Leetcode752 {
    public static void main(String[] args) {
        Solution752 s = new Solution752();
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(s.openLock(deadends, target));
    }
}

// 采用双向BFS的方式，就是从start起始点和target目标点同时做BFS扩散，当相遇的时时候就说明找到路径了
// 这样的好处是可以节省一点时间，有可能不需要遍历整个图就能找到最短路径
class Solution752 {
    public int openLock(String[] deadens, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadens));
        Set<String> visited = new HashSet<>();
        int step = 0;
        // 如果这里采用队列的话，会超时，因为在后面判断q2中是否含有q1里面的元素时候花费时间过长，采用Set可以在O(1)时间复杂度内判断是否含有
//        Queue<String> q1 = new LinkedList<>();
//        Queue<String> q2 = new LinkedList<>();
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 这里判断q1和q2的大小，然后从小的集合开始扩散，在一定程度上可以节省一点时间
            if (q1.size() > q2.size()) {
                Set<String> t = q1;
                q1 = q2;
                q2 = t;
            }
            Set<String> tmp = new HashSet<>();
            for (String cur : q1) {
                if (deads.contains(cur))
                    continue;
                if (q2.contains(cur))
                    return step;
                visited.add(cur);
                for (int i = 0; i < 4; ++i) {
                    String up = plusOne(cur, i);
                    if (!visited.contains(up)) {
                        tmp.add(up);
                    }
                    String down = minusOne(cur, i);
                    if (!visited.contains(down)) {
                        tmp.add(down);
                    }
                }
            }
            ++step;
            q1 = q2;
            q2 = tmp;
        }
        return -1;
    }

    public String plusOne(String s, int index) {
        StringBuilder tmp = new StringBuilder(s);
        if (tmp.charAt(index) == '9')
            tmp.setCharAt(index, '0');
        else
            tmp.setCharAt(index, (char)(tmp.charAt(index) + 1));
        return tmp.toString();
//        char[] tmp = s.toCharArray();
//        if (tmp[index] == '9')
//            tmp[index] = '0';
//        else
//            tmp[index] += 1;
//        return new String(tmp);
    }

    public String minusOne(String s, int index) {
        StringBuilder tmp = new StringBuilder(s);
        if (tmp.charAt(index) == '0')
            tmp.setCharAt(index, '9');
        else
            tmp.setCharAt(index, (char)(tmp.charAt(index) - 1));
        return tmp.toString();
//        char[] tmp = s.toCharArray();
//        if (tmp[index] == '0')
//            tmp[index] = '9';
//        else
//            tmp[index] -= 1;
//        return new String(tmp);
    }
}


// 核心思想，将四位密码看作是10000个状态，这些状态分别是从"0000"--"9999"
// 那么对于这些状态，就可以构成一个图，例如对于"0000"来说，它所连接的其他节点一共有八个，分别是：
// "0001" "0010" "0100" "1000" "0009" "0090" "0900" "9000"
// 寻找到target这个状态，就是采用BFS求从"0000"到target的最短路径
// 当然，中间需要避免deadens里面的东西，以及如果一个状态已经访问过了，就忽略掉
class Solution752_1 {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }
        Queue<String> q = new LinkedList<>();
        int step = 0;
        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                String cur = q.poll();
                if (deads.contains(cur))
                    continue;
                if (cur.equals(target))
                    return step;
                for (int j = 0; j < 4; ++j) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            ++step;
        }

        return -1;
    }

    public String plusOne(String s, int index) {
        StringBuilder tmp = new StringBuilder(s);
        if (tmp.charAt(index) == '9')
            tmp.setCharAt(index, '0');
        else
            tmp.setCharAt(index, (char)(tmp.charAt(index) + 1));
        return tmp.toString();
//        char[] tmp = s.toCharArray();
//        if (tmp[index] == '9')
//            tmp[index] = '0';
//        else
//            tmp[index] += 1;
//        return new String(tmp);
    }

    public String minusOne(String s, int index) {
        StringBuilder tmp = new StringBuilder(s);
        if (tmp.charAt(index) == '0')
            tmp.setCharAt(index, '9');
        else
            tmp.setCharAt(index, (char)(tmp.charAt(index) - 1));
        return tmp.toString();
//        char[] tmp = s.toCharArray();
//        if (tmp[index] == '0')
//            tmp[index] = '9';
//        else
//            tmp[index] -= 1;
//        return new String(tmp);
    }
}