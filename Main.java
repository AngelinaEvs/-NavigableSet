import java.util.*;

public class Main {
    public static void main(String[] args) {
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.compareTo(o2) == 0) {
                    return 0;
                }
                if (o1.compareTo(o2) > 0) {
                    return 1;
                }
                if (o1.compareTo(o2) < 0) {
                    return -1;
                }
                return 1;
            }
        };
        NaviSet<Integer> ns = new NaviSet<>(c);
        ns.add(3);
        ns.add(4);
        ns.add(5);
        ns.add(3);
        ns.add(1);
        ns.add(0);
        ns.add(22);
        ns.add(23);
        ns.add(10);
        ns.add(2);
        ns.add(2);
        System.out.println(ns.toString());
        System.out.println("\n");
        System.out.println("lower: " + ns.lower(10));
        System.out.println("floor: " + ns.floor(100));
        System.out.println("ceiling: " + ns.ceiling(23));
        System.out.println("higher: " + ns.higher(3));
        System.out.println("poolFirst: " + ns.pollFirst() + " -> " + ns.toString());
        System.out.println("poolLast: " + ns.pollLast() + " -> " + ns.toString());
        ns.add(11);
        Iterator<Integer> it = ns.descendingIterator();
        System.out.print("descendingIterator: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        System.out.println("subSet: " + ns.subSet(10, false, 23, true));
        System.out.println("headSet: " + ns.headSet(24, true));
        System.out.println("tailSet: " + ns.tailSet(11, true));
        System.out.println("first: " + ns.first());
        System.out.println("last: " + ns.last());

        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(3);
        al.add(3);
        al.add(4);
        al.add(1);
        al.add(5);
        al.add(13);
        //al.add(null);
        al.add(50);
        Collection<Integer> cl = al;
        ns.addAll(cl);
        System.out.println("addAll: " + ns.toString());
        System.out.println("descendingSet: " + ns.descendingSet());
        System.out.println("poolFirst: " + ns.pollFirst() + "->" + ns.toString());
        System.out.println("descendingSet: " + ns.descendingSet());

        System.out.println("\n");
        SortedSet<Integer> sortedSet = ns;
        System.out.println("SortedSet.tailSet: " + sortedSet.tailSet(11));
        System.out.println("SortedSet.subSet: " + sortedSet.subSet(-1, 20));
        System.out.println("SortedSet.headSet: " + sortedSet.headSet(8));
        System.out.println("\n");

        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(1);
        al1.add(3);
        al1.add(3);
        al1.add(4);
        al1.add(1);
        al1.add(5);
        al1.add(0);
        al1.add(-1);
        Collection<Integer> cl1 = al1;
        NaviSet<Integer> nv = new NaviSet<>(cl1, c);
        System.out.println("{col, c}: " + nv.toString());
        System.out.println("\n");

        Comparator<String> c1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.compareTo(o2) == 0) {
                    return 0;
                }
                if (o1.compareTo(o2) > 0) {
                    return 1;
                }
                if (o1.compareTo(o2) < 0) {
                    return -1;
                }
                return 1;
            }
        };

        System.out.print("(1): ");
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(3);
        ar.add(2);
        ar.add(7);
        ar.add(0);
        NaviSet<Integer> navi = new NaviSet<>(ar);
        System.out.println(navi.toString());
        System.out.println("(1).descendingSet: " + navi.descendingSet());

        System.out.print("(2): ");
        ArrayList<Integer> ar2 = new ArrayList<>();
        ar2.add(3);
        ar2.add(2);
        ar2.add(7);
        ar2.add(0);
        ar2.add(11);
        NaviSet<Integer> navi1 = new NaviSet<>(ar2);
        System.out.println(navi1.toString());
        System.out.println("(1).equals((2)): " + navi.equals(navi1));

        System.out.println();
        System.out.println("SS test:");
        ArrayList<Integer> ar1 = new ArrayList<>();
        ar1.add(3);
        ar1.add(2);
        ar1.add(7);
        ar1.add(0);
        TreeSet<Integer> s = new TreeSet<>(ar1);
        NaviSet<Integer> nav = new NaviSet<>(s);
        System.out.println(nav.toString());
    }
}
