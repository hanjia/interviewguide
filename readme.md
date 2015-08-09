#Interview Guide

##Overview

	1. 数组类

主要思路：1) 对于数组查找问题，如果数组有序则首先应该想到做二分搜索，时间复杂度为`O(logn)`。如果数组无序，则考虑排序，MergeSort或QuickSort都可以在`O(nlogn)`内完成排序，接着可以考虑二分搜索; 2) 对于两个有序数组的问题（如合并，给定和的数对等），应该考虑利用数组有序特性，设置2个指针分别从两个数组的头部开始遍历

	2. 字符串类
		
主要思路：1) 字符可以用ASCII码表示，并且用数组的Index来表示;

	3. 链表类
	4. 栈和队列类
	5. 树类

##Problems & Solutions

### 1. 数组类

#### Problem 1: 数组求和
给定一个含有n个元素的整型数组a，求a中所有元素的和。要求使用递归实现。

解法：

    public static int sum(int[] a, int n) {
        return n == 0 ? 0 : sum(a, n - 1) + a[n - 1];
    }

#### Problem 2: 求数组中出现次数超过一半的元素
给定一个n个整型元素的数组a，其中有一个元素出现次数超过n / 2，求这个元素。

解法1：排序，然后找中间的元素。如果该元素出现超过次数超过一半则一定位于排序后的数组中间。

解法2：设置一个当前值和当前值出现次数的计数器，初始化为第一个元素，计数器值为1.然后从第二个元素开始遍历数组。如果第i个元素值等于当前值则计数器加1，不等则计数器减1，如果计数器值小于1则更新当前值并重置计数器值为1.遍历完成后的当前值即为出现超过一半的元素。

    public static int find(int[] a) {
        int current = a[0];
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == current) {
                count++;
            } else {
                count--;
                if (count < 0) {
                    current = a[i];
                    count = 1;
                }
            }

        }
        return current;
    }

#### Problem 3: 求数组中元素的最短距离
给定一个含有n个元素的整型数组，找出数组中的两个元素x和y使得abs(x - y)值最小

解法：对数组排序，然后遍历一遍求前后两元素差值即可求出。

    public static int findMinAbs(int[] a, int n) {
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (Math.abs(a[i] - a[i - 1]) < min) {
                min = Math.abs(a[i] - a[i - 1]);
            }
        }
        return min;
    }

#### Problem 4: 求两个有序数组的共同元素
给定两个含有n个元素的有序（非降序）整型数组a和b，求出其共同元素，比如
a = 0, 1, 2, 3, 4
b = 1, 3, 5, 7, 9
输出 1, 3

解法1：利用数组有序的性质，设置两个指针i，j分别指向数组a，b的头部。
判断a[i], b[j]的大小，如果相等则输出共同元素并且共同向后移动。如果a[i]大则指针j向后移动，如果b[j]大则指针i向后移动。

    public static void findCommon(int[] a, int[] b) {
        for (int i = 0, j = 0; i < a.length && j < b.length; ) {
            if (a[i] == b[j]) {
                System.out.println("Found common: " + a[i]);
                i++;
                j++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                i++;
            }
        }
    }

解法2：可以对数组a中每一个元素在数组b中做二分搜索（binary search），这样的话只需要数组b有序即可。

#### Problem 5: 求三个数组的共同元素
给定三个含有n个元素的整型数组a,b和c，求他们最小的共同元素

解法1： 如果三个数组都有序，则可以设置3个指针，根据3个指针所指的值比较来移动指针。

解法2：
如果三个数组都无序，可以对数组a，b排序，然后遍历数组c，对于c中的每一个元素在数组a，b中做二分搜索。

#### Problem 6: 找出数组中唯一的重复元素
给定含有1001个元素的数组，其中存放了1-1000之内的整数，只有一个整数是重复的，请找出这个数

解法：求出整个数组的和，再减去1-1000的和

#### Problem 7: 找出出现奇数次的元素
给定一个含有n个元素的整型数组a，其中只有一个元素出现奇数次，找出这个元素。

解法：对于任意一个数k，有`k ^ k = 0`，`k ^ 0 = k`，所以将数组a中所有元素进行异或，则个数为偶数的元素异或后都变成了0，只留下了个数为奇数的那个元素。

    public static int find(int[] a) {
        int k = 0;
        for (int i : a) {
            k^= i;
        }
        return k;
    }

#### Problem 8: 求两数组中满足给定和的数对
给定两个有序整型数组a和b，各有n个元素，求两个数组中满足给定和的数对，即对a中元素i和b中元素j，满足i + j = s(s已知)

解法：利用数组有序特性，设置2个指针i，j分别指向数组a，b的头部。然后从两端向中间遍历，直到交叉。

    public static void findInTwoArray(int[] a, int[] b, int s) {
        for (int i = 0, j = b.length - 1; i < a.length && j > 0; ) {
            if (a[i] + b[j] == s) {
                System.out.println("Found fixed sum with " + a[i] + " " + b[j]);
                i++;
                j--;
            } else if (a[i] + b[j] > s) {
                j--;
            } else {
                i++;
            }
        }
    }

#### Problem 9: 求数组中是否存在3元素之和满足给定数
给定一无序整型数组a，求数组a中是否有任意3个元素之和等于给定数s

解法：对数组排序，然后设置3个指针i，j，k。i指向头部，j指向i+1个元素，k指向尾部。遍历数组，求a[i],a[j],a[k]之和，如果等于s则输出，反之根据比较值决定i向后移动或k向前移动，直到i，k交叉。

    public static void findThreeTupleSumEqFixedNum(int[] a, int s) {
        Arrays.sort(a);
        for (int i = 0; i < a.length - 2; i++) {
            int j = i + 1;
            int k = a.length - 1;
            while (j < k) {
                if (a[i] + a[j] + a[k] == s) {
                    System.out.println("Found fixed sum with " + a[i] + " " + a[j] + " " + a[k]);
                    return;
                } else if (a[i] + a[j] + a[k] > s) {
                    k--;
                } else {
                    j++;
                }
            }
        }
    }
    
#### Problem 10: 最大子段和
给定一个整型数组a，求出最大连续子段之和，如果和为负数，则按0计算，比如`1， 2， -5， 6， 8`则输出`14`

    public static void find(int[] a) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum < 0) {
                sum = 0;
            }
            max = sum > max ? sum : max;
        }
        return max;
    }

#### Problem 11: 最大子段积
给定一个整型数组a，求出最大连续子段的乘积，比如`1， 2， -8， 12， 7`则输出`84`

解法：和最大子段和类似，注意正负符号。

    public static int findMaxMultiply(int[] a) {
        int max = 1;
        int min = 1;
        int result = 1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                max *= a[i];
                min = Math.min(min * a[i], 1);
            } else if (a[i] == 0) {
                max = 1;
                min = 1;
            } else {
                int temp = max;
                max = Math.max(min * a[i], 1);
                min = temp * a[i];
            }
            result = Math.max(result, max);
        }

        return result;
    }

#### Problem 12: 数组循环移位
将一个含有n个元素的数组向右循环移动k位，要求时间复杂度是O(n)，且只能使用两个额外的变量。要求时间复杂度不超过`O(n)`，空间复杂度不超过`O(1)`

例如：数组`1,2,3,4,5` 循环2位后为`4,5,1,2,3`

解法：将数组分为两部分`1,2,3 | 4,5`，首先逆序第一部分得到`3,2,1 | 4,5`，然后逆序第二部分得到`3,2,1 | 5,4`，最后逆序整个数组可得结果`4,5,1,2,3`。需要注意的是k可能大于n，所以实际需要移动的是`k%n`位。

    public static void reverse(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start++] = a[end];
            a[end--] = temp;
        }
    }

    public static void rotate(int[] a, int k) {
        int n = a.length;
        k %= n;
        reverse(a, 0, n - k - 1);
        reverse(a, n - k, n - 1);
        reverse(a, 0, n - 1);
    }
    
#### Problem 13: 合并两个数组
给定含有n个元素的有序（非降序）整型数组a和含有m个元素的有序（非降序）整型数组b。合并两个数组中的元素到整型数组c，要求去除重复元素并保持c有序（非降序）。例子如下
a = 1, 2, 4, 8
b = 1, 3, 5, 8
c = 1, 2, 3, 4, 5, 8

解法：利用数组有序特性，设置指针i，j分别指向数组a，b头部。比较是a[i], b[j]

+ a[i] > b[j] 则c[k] = b[j] 向后移动j
+ a[i] == b[k] 则 c[k] = a[i] 向后移动i，j
+ a[i] < b[j] 则c[k] = a[i] 向后移动i

最后将数组a或数组b中剩余的元素填入数组c即可

    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while(i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                c[k++] = b[j++];
            } else if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = a[i++];
                j++;
            }
        }
        // if array a and array b are not the same length
        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }
        return Arrays.copyOfRange(c, 0, k);
    }

#### Problem 14: 重排问题1 - 将0移到数组前段
给定含有n个元素的整型数组a，其中包括0元素和非0元素，对数组进行排序，要求：
1. 排序后所有0元素在前，所有非零元素在后，且非零元素排序前后相对位置不变
2. 不能使用额外存储空间
例子如下
输入 0, 3, 0, 2, 1, 0, 0
输出 0, 0, 0, 0, 3, 2, 1

解法：从后向前遍历整个数组，遇到某个位置i上的元素是非0元素时，如果a[k]为0，则将a[i]赋值给a[k]，a[k]赋值为0。实际上i是非0元素的下标，而k是0元素的下标

    public static int[] zeroFirst(int[] a) {
        for (int i = a.length - 1, k = a.length - 1; i >= 0; i--) {
            if (a[i] != 0) {
                if (a[k] == 0) {
                    a[k] = a[i];
                    a[i] = 0;
                }
                k--;
            }
        }
        return a;
    }

#### Problem 15: 重排问题2 - 奇偶数分开
给定含有n个元素的整型数组a，将奇数都归到数组的左边，偶数归到数组的右边，不考虑元素的相对顺序。要求时间复杂度为`O(n)`

解法：类似于QuickSort的partition，设置left，right两个指针分别指向数组的头尾向中间移动。

    public static boolean isOdd(int a) {
        return (a & 1) == 1;
    }

    public static int[] oddLeftEvenRight(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            while (left < right && isOdd(a[left])) {
                left++;
            }
            while (left < right && !isOdd(a[right])) {
                right--;
            }
            if (left != right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }
        return a;
    }
    
#### Problem 16: 找出绝对值最小的元素
给定一个有序整数序列（非递减序），可能包含负数，找出其中绝对值最小的元素，比如给定序列`-5, -3, -1, 2, 8` 则返回1。

解法：有序数组查找首先考虑二分搜索:
如果给定数组中均为负数，则绝对值最小的是最后一个元素;
如果给定数组中均为正数，则绝对值最小的是第一个元素;
如果既有正数又有负数，则绝对值最小的元素一定在正负数连接处。


    public static int findMinAbsElement(int[] a) {
    	int n = a.length;
        if (n == 1) {
            return a[0];
        }
        if (isSameSign(a[0], a[n - 1])) {
            return a[0] > 0 ? a[0] : a[n - 1];
        }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (left + 1 == right) {
                return Math.min(Math.abs(a[left]), Math.abs(a[right]));
            }
            int m = left + ((right - left) >> 1);
            if (isSameSign(a[left], a[m])) {
                left = m;
                continue;
            }
            if (isSameSign(a[m], a[right])) {
                right = m;
                continue;
            }
        }
        return -1;
    }

    public static boolean isSameSign(int a, int b) {
        return a > 0 && b > 0 || a < 0 && b < 0;
    }



#### Problem 17: 找出数组中第k小的元素 ***
给定一无序整型数组a，在不排序的情况下，查找第k小的元素

解法：查找元素优先考虑二分搜索，因为数组无序，所以需要对二分搜索作出修改。参考QuickSort的partition过程。首选在数组中任选一个元素做参考值，将比参考值小的元素都移动到参考值的左边，比参考值大的元素都移动到右边。判断左边数组的长度若大于k，则第k小的值一定在左边，只需要在左边部分重复在这一过程。若左边数组长度小于k，则在右边数组重复这一过程，只不过查找的是k减去左边数组的长度。

    static Random random = new Random();

    public static int findKSmallestElement(int[] a, int k) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int pivotIndex = left + random.nextInt(right - left + 1);
            int idx = partition(a, left, right, pivotIndex);
            int length = idx - left +1;
            if (k < length) {
                right = idx - 1;
            } else if (k > length) {
                left = idx + 1;
                k = k - length;
            } else {
                return a[idx];
            }
        }
        return Integer.MIN_VALUE;
    }

    private static int partition(int[] a, int left, int right, int pivotIndex) {
        int pivotValue = a[pivotIndex];
        swap(a, pivotIndex, right);
        int storedIndex = left;
        for (int i = left; i < right; i++) {
            if (a[i] < pivotValue) {
                swap(a, i, storedIndex);
                storedIndex++;
            }
        }
        swap(a, storedIndex, right);
        return storedIndex;
    }

    private static void swap(int[] a, int src, int target) {
        int temp = a[src];
        a[src] = a[target];
        a[target] = temp;
    }


#### Problem 18: 找出两个有序数组的中位数 ***
给定两个有序整型数组A，B，查找两个数组合并后的中位数，要求时间复杂度不超过`O(log(n+m))`

解法1：可以将两个数组拼凑成一个数组然后使用与上一题相同的方法解，即查找第K个元素

解法2：假设两个数组中位数为合并后第k小的元素，比较A[k/2 - 1] 与 B[k/2 - 1]

如果A[k/2 - 1] < B[k/2 - 1]则意味着A[0]到A[k/2 - 1]全部小于中位数，所以可以忽略
如果A[k/2 - 1] > B[k/2 - 1]则意味着B[0]到B[k/2 - 1]全部小于中位数，所以可以忽略
如果A[k/2 - 1] = B[k/2 - 1]则意味着已经找到中位数

前两种情况则需要采用递归

	public double findMedianSortedArrays(int A[], int B[]) {
	        int m = A.length;
	        int n = B.length;
	        int total = A.length + B.length;  
	        if (total%2 != 0)
	            return (double)findKth(A, 0, m-1, B, 0, n-1, total/2 + 1);
	        else {
	            return (double)(findKth(A, 0, m-1, B, 0, n-1, total/2) + findKth(A, 0, m-1, B, 0, n-1, total/2 + 1))/2;
	        }
		}
	    
	public int findKth(int a[], int astart, int aend, int b[], int bstart, int bend, int k)  {  
			int m = aend - astart + 1;
			int n = bend - bstart + 1;
		    
			if(m>n)
				return findKth(b,bstart,bend,a,astart,aend,k);
			if(m==0)
				return b[k-1];
			if(k==1)
				return Math.min(a[astart],b[bstart]);
	   
			int partA = Math.min(k/2,m);
			int partB = k - partA;
			
			if(a[astart+partA-1] < b[bstart+partB-1])
				return findKth(a,astart+partA,aend,b,bstart,bend,k-partA);
			else if(a[astart+partA-1] > b[bstart+partB-1])
				return findKth(a,astart,aend,b,bstart+partB,bend,k-partB);
			else
				return a[astart+partA-1];
	}



### 2. 字符串类

#### 字符串反转
给定一个含有n个元素的字符数组a，将其原地逆序。

解法：设置2个指针分别指向头尾，交换两指针所指向的字符，逐渐向中间靠拢直到指针交叉。

    public static char[] reverseString(char[] a) {
        int left = 0;
        int right = a.length -1;
        while (left < right) {
            char temp = a[left];
            a[left++] = a[right];
            a[right--] = temp;
        }
        return a;
    }

#### 字符串反转2 - 反转单词出现顺序
给定一个字符串，反转其中单词出现的顺序，单词本身不反转。
例如字符串s1 = "This is a sentence" 反转后得到"sentence a is This"

解法：先反转整个字符串，再单独反转每一个单词即可。

    public static char[] reverseString(char[] a, int left, int right) {
        while (left < right) {
            char temp = a[left];
            a[left++] = a[right];
            a[right--] = temp;
        }
        return a;
    }

    public static char[] reverseSentence(char[] s) {
        reverseString(s, 0, s.length - 1);

        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverseString(s, left, right - 1);
                left = i + 1;
                right = left;
            } else {
                right++;
            }
        }
        reverseString(s, left, right - 1);
        return s;
    }

#### 判断字符串中字符是否唯一
给定一含有n元素的字符串（假定都是ASCII字符），判断该字符串中的各个字符是否唯一。要求时间复杂度为`O(n)`

解法：新建一布尔数组，遍历字符串中每个字符，判断其在布尔数组中是否重复出现。

    public static boolean isCharAllUnique(String s) {
        boolean[] map = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)]) {
                return false;
            } else {
                map[s.charAt(i)] = true;
            }
        }
        return true;
    }
    
#### 判断两字符串是否旋转关系
给定两个字符串s1，s2.判断s2是否由s1旋转得来。例如s1 = "waterbottle", s2 = "terbottlewa"，则判断为true。若s1 = "dog", s2 = "god" 则返回false

解法：将s2 加上（concat）其本身得到新字符串s3，如果s1是s3的子串（substring）则判断为true

### 3. 链表类

单链表数据结构为

    public class Node {
        int value;
        Node next;
        public Node(int value) {
           this.value = value;
        }
    ｝

#### 反转单链表
给定一单链表 1->2->3->4，要求在`O(n)`时间复杂度内反转得到新的单链表 4->3->2->1

    public static Node reverse(Node head) {
        Node pre = null;
        Node next = null;
        Node current = head;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

#### 判断单链表是否存在环

解法：设置2个指针p1，p2均指向链表头部，p1每次向后移动一格，p2每次向后移动2格。如果p2 == p1则说明链表中存在环。

    public static boolean isCircular(Node head) {
        Node p1 = head;
        Node p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            if (p1 == p2) {
                return true;
            }

        }
        return false;
    }
    
#### 查找链表中离尾部距离为n的元素

解法：设置2个指针p1，p2均指向头部。将p2向后移动n-1步，则p1和p2的距离为n。移动p2到尾部，则p1就是那个要找的元素。

#### 链表数值求和
给定2个单链表，链表中每个元素的值均是一个整型。链表表达的数字是反向存储的，即第一位数字存储在链表的头部。实现一个函数将两个链表所表达的数字相加并且以同样的链表格式返回。

例如 (3->1->5), (5->9->2) 输出为 8->0->8

解法：

    public static Node addList(Node n1, Node n2, int carry) {
        if (n1 == null && n2 == null) {
            return null;
        }
        Node result = new Node(carry);
        int value = carry;
        if (n1 != null) {
            value += n1.value;
        }
        if (n2 != null) {
            value += n2.value;
        }
        result.value = value % 10;
        Node more = addList(n1 == null ? null : n1.next, n2 == null ? null : n2.next, value >= 10 ? 1 : 0);
        result.next = more;
        return result;
    }

### 4. 栈和队列类
用链表做存储，栈的数据结构实现如下

    public class HStack {
        Node head;
        int size;
    
        public void push(int value) {
            Node node = new Node(value);
            if (head == null) {
                head = node;
            } else {
                node.next = head;
                head = node;
            }
            size++;
        }
    
        public int size() {
            return this.size;
        }
    
        public int pop() {
            int value = head.value;
            head = head.next;
            size--;
            return value;
        }
    
        public boolean isEmpty() {
            return head == null;
        }
    
        public int peek() {
            return head.value;
        }
    }
    
#### 递归颠倒栈內元素
给定一含有多个元素的栈，用递归颠倒栈內元素。例如栈内元素为`{1,2,3,4,5}` 1在栈顶，颠倒后成为`｛5，4，3，2，1｝` 5在栈顶。

    public static void reverseStack(HStack stack) {
        if (!stack.isEmpty()) {
            int data = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, data);
        }
    }

    public static void insertAtBottom(HStack stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
        } else{
            int data = stack.pop();
            insertAtBottom(stack, value);
            stack.push(data);
        }
    }

#### 实现min函数的栈
定义栈的数据结构，要求添加一个min函数，能够得到栈的最小元素。要求函数min、push以及pop的时间复杂度都是O(1)。

解法：在栈內另存一个栈来保存最小值。

    public class HStackWithMin extends HStack{
        HStack minStack;
    
        @Override
        public void push(int value) {
            if (value < min()) {
                minStack.push(value);
            }
            super.push(value);
        }
    
        @Override
        public int pop() {
            int value = super.pop();
            if (value == min()) {
                minStack.pop();
            }
            return value;
        }
    
        public int min() {
            if (minStack.isEmpty()) {
                return Integer.MAX_VALUE;
            }
            return minStack.peek();
        }
    }
    
#### 用两个栈来实现队列

解法：栈和队列的区别在于访问策略，栈是FILO，队列是FIFO。假设有栈s1，s2，在读取元素的时候，第一次将s1所有元素出栈并压入s2，之后只要判断s2不为空则直接从s2 pop出第一个元素，当s2为空时重复s1出栈并压入s2的过程即可实现队列。
    public class MyQueue {
        HStack s1;
        HStack s2;
    
        public void add(int value) {
            s1.push(value);
        }
    
        public int size() {
            return s1.size() + s2.size();
        }
    
        public int remove(){
            if (!s2.isEmpty()) {
                return s2.pop();
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }
    
#### 栈的排序
编写程序将一给定栈的元素以升序排列，栈类上只有4个方法可用，`pop`,`push`,`peek`,`isEmpty`

例如给定栈s1 = {4, 3, 1, 5, 2} 2为栈顶，排序后得到 s2 = {1, 2, 3, 4, 5} 5为栈顶

    public static HStack sort(HStack stack) {
        HStack r = new HStack();
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            while (!r.isEmpty() && r.peek() > tmp) {
                stack.push(r.pop());
            }
            r.push(tmp);
        }
        return r;
    }
    
### 5. 树类

二叉查找树 Binary search tree 的定义

+ 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值
+  若它的右子树不空，则右子树上所有结点的值均大于它的根结点的
+  左、右子树也分别为二叉排序树

#### 二叉查找树插入子节点

    public boolean addNode(int value) {
        BinarySearchTreeNode current = this;
        BinarySearchTreeNode parent = this;
        while (current != null) {
            parent = current;
            if (value == parent.value) {
                return false; // duplicate value;
            } else if (value < parent.value) {
                current = parent.left;
            } else {
                current = parent.right;
            }
        }
        if (parent == null) {
            parent = new BinarySearchTreeNode(value);
        }else if (value < parent.value) {
            parent.left = new BinarySearchTreeNode(value);
        }else{
            parent.right = new BinarySearchTreeNode(value);
        }
        return true;
    }    

#### 如何判断树是否平衡二叉树

平衡二叉树Balanced binary tree 的定义是它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1。

    public static int getMaxDepth(BinarySearchTreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
    }

    public static int getMinDepth(BinarySearchTreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.min(getMinDepth(root.left), getMinDepth(root.right));
    }

    public static boolean isBalanced(BinarySearchTreeNode root) {
        return (getMaxDepth(root) - getMinDepth(root)) <= 1;
    }
    
#### 判断两颗二叉树是否相等

解法：递归判断很简单

    public static boolean isTreeEquals(BinarySearchTreeNode t1, BinarySearchTreeNode t2) {
        if (t1 == t2) {
            return true;
        }
        return (t1.value == t2.value) && isTreeEquals(t1.left, t2.left) && isTreeEquals(t1.right, t2.right);
    }
    
#### 二叉树的遍历

二叉树的遍历分前序 preorder，中序 inorder，后序 postorder，这三种统称深度优先遍历 Depth-first traversal，还有一种是广度优先遍历 Breadth-first traversal

##### 前序遍历的非递归实现

要点在于用栈来保存左右节点

    public static void preOrderNoRecursive(BinarySearchTreeNode root) {
        Stack<BinarySearchTreeNode> s = new Stack();
        BinarySearchTreeNode node = null;
        s.push(root);
        while (!s.isEmpty()) {
            node = s.pop();
            visit(node);
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
        }
    }

##### 广度优先遍历的非递归实现

要点在于用队列来保存左右节点

    public static void breadthFirstTraversal(BinarySearchTreeNode root) {
        ArrayDeque<BinarySearchTreeNode> queue = new ArrayDeque<BinarySearchTreeNode>();
        BinarySearchTreeNode node = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            node = queue.remove();
            visit(node);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
    
#### 找出二叉查找树Binary search tree上任意两个节点的最近共同父节点。

解法：因为是二叉查找树，所以很简单。最近共同父节点的值n和任意两个节点n1，n2之间一定满足关系`n1<n<n2`

非递归实现

    public static int findCommonAncestor(BinarySearchTreeNode root, BinarySearchTreeNode t1, BinarySearchTreeNode t2) {
        int left = t1.value;
        int right = t2.value;
        BinarySearchTreeNode parent = null;

        if (left > right) {
            int temp = left;
            left = right;
            right = temp;
        }

        while (true) {
            if (root.value < left) {
                parent = root;
                root = root.right;
            } else if (root.value > right) {
                parent = root;
                root = root.left;
            } else if (root.value == left || root.value == right) {
                return parent.value;
            } else {
                return root.value;
            }
        }
    }

递归实现

    public static int findCommonAncestorRecursive(BinarySearchTreeNode root, BinarySearchTreeNode n1, BinarySearchTreeNode n2) {
        if (n1.value < root.value && n2.value > root.value) {
            return root.value;
        }
        if (n1.value < root.value && n2.value < root.value) {
            return findCommonAncestorRecursive(root.left, n1, n2);
        } else if (n1.value > root.value && n2.value > root.value) {
            return findCommonAncestorRecursive(root.right, n1, n2);
        }
        return -1;
    }