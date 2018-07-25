/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> list;
    int i = 0;
    LinkedList<NestedInteger> q;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = nestedList;
        i = 0;
        q = new LinkedList<>();
        while(i < list.size()) q.add(list.get(i++));
    }

    @Override
    public Integer next() {
        return q.poll().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(q.size() != 0 && !q.peek().isInteger()) {
            List<NestedInteger> tmp = q.poll().getList();
            for(int j = 0; j < tmp.size(); j++) {
                q.add(j,tmp.get(j));
            }
        }
        if(q.size() == 0) return false;
        return true;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
