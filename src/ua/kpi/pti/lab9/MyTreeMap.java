package ua.kpi.pti.lab9;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyTreeMap implements MyMap {

    private SimpleEntry root;
    private int size;
    private final Comparator comparator;

    private static final boolean BLACK = true;
    private static final boolean RED = false;

    public MyTreeMap() {
        this(null);
    }

    public MyTreeMap(Comparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return getEntry(key) != null;
    }

    @Override
    public Object get(Object key) {
        SimpleEntry entry = getEntry(key);
        return entry == null ? null : entry.getValue();
    }

    @Override
    public boolean containsValue(Object value) {
        return containsValue(value, root);
    }

    @Override
    public Iterator entryIterator() {
        Set<SimpleEntry> simpleEntrySet = new HashSet<>();
        AddEntryToSet(simpleEntrySet, root);
        return simpleEntrySet.iterator();
    }

    @Override
    public Object put(Object key, Object value) {
        SimpleEntry tmp = root;
        if (tmp == null) {
            compare(key, key);

            root = new SimpleEntry(key, value, null);
            size = 1;
            return null;
        }
        int comp;
        SimpleEntry parent;
        Comparator comparator = this.comparator;
        if (comparator != null) {
            do {
                parent = tmp;
                comp = comparator.compare(key, tmp.key);
                if (comp < 0)
                    tmp = tmp.left;
                else if (comp > 0)
                    tmp = tmp.right;
                else
                    return tmp.setValue(value);
            } while (tmp != null);
        } else {
            Comparable keyComparable = (Comparable) key;
            do {
                parent = tmp;
                comp = keyComparable.compareTo(tmp.key);
                if (comp < 0)
                    tmp = tmp.left;
                else if (comp > 0)
                    tmp = tmp.right;
                else
                    return tmp.setValue(value);
            } while (tmp != null);
        }
        SimpleEntry entry = new SimpleEntry(key, value, parent);
        if (comp < 0)
            parent.left = entry;
        else
            parent.right = entry;
        size++;
        return null;
    }

    @Override
    public Object remove(Object key) {
        SimpleEntry p = getEntry(key);
        if (p == null)
            return null;

        Object oldValue = p.value;
        deleteEntry(p);
        return oldValue;
    }

    private int compare(Object k1, Object k2) {
        return comparator == null ? ((Comparable) k1).compareTo(k2) : comparator.compare(k1, k2);
    }

    private SimpleEntry getEntry(Object key) {
        if (comparator != null)
            return getEntryUsingComparator(key);
        if (key == null)
            throw new NullPointerException();
        Comparable k = (Comparable) key;
        SimpleEntry p = root;
        while (p != null) {
            int cmp = k.compareTo(p.key);
            if (cmp < 0)
                p = p.left;
            else if (cmp > 0)
                p = p.right;
            else
                return p;
        }
        return null;
    }

    private SimpleEntry getEntryUsingComparator(Object key) {
        Object k = key;
        Comparator comp = comparator;
        if (comp != null) {
            SimpleEntry p = root;
            while (p != null) {
                int cmp = comp.compare(k, p.key);
                if (cmp < 0)
                    p = p.left;
                else if (cmp > 0)
                    p = p.right;
                else
                    return p;
            }
        }
        return null;
    }

    private boolean containsValue(Object value, SimpleEntry entry) {
        if (entry.getValue().equals(value)) return true;
        boolean result = false;

        if (entry.getRight() != null) result = containsValue(value, entry.getRight());

        if (!result && entry.getLeft() != null) result = containsValue(value, entry.getLeft());

        return result;
    }

    private void AddEntryToSet(Set<SimpleEntry> simpleEntrySet, SimpleEntry element) {
        if (element == null) return;
        simpleEntrySet.add(element);

        AddEntryToSet(simpleEntrySet, element.getLeft());
        AddEntryToSet(simpleEntrySet, element.getRight());
    }

    class SimpleEntry implements MyMap.Entry {
        private Object key;
        private Object value;
        private SimpleEntry left;
        private SimpleEntry right;
        private SimpleEntry parent;
        private boolean color = BLACK;

        public SimpleEntry getParent() {
            return parent;
        }

        public void setParent(SimpleEntry parent) {
            this.parent = parent;
        }

        public SimpleEntry getRight() {
            return right;
        }

        public void setRight(SimpleEntry right) {
            this.right = right;
        }

        public SimpleEntry getLeft() {
            return left;
        }

        public void setLeft(SimpleEntry left) {
            this.left = left;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public Object setValue(Object newValue) {
            Object oldValue = value;
            value = newValue;
            return oldValue;
        }

        public SimpleEntry(Object key, Object value, SimpleEntry parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
            color = BLACK;
        }
    }

    //---TreeMap manipulation methods

    private void deleteEntry(SimpleEntry p) {
        size--;

        if (p.left != null && p.right != null) {
            SimpleEntry s = successor(p);
            p.key = s.key;
            p.value = s.value;
            p = s;
        }

        SimpleEntry replacement = (p.left != null ? p.left : p.right);
        if (replacement != null) {
            replacement.parent = p.parent;
            if (p.parent == null)
                root = replacement;
            else if (p == p.parent.left)
                p.parent.left = replacement;
            else
                p.parent.right = replacement;
            p.left = p.right = p.parent = null;
            if (p.color == BLACK)
                fixAfterDeletion(replacement);
        } else if (p.parent == null) {
            root = null;
        } else {
            if (p.color == BLACK)
                fixAfterDeletion(p);
            if (p.parent != null) {
                if (p == p.parent.left)
                    p.parent.left = null;
                else if (p == p.parent.right)
                    p.parent.right = null;
                p.parent = null;
            }
        }
    }

    static SimpleEntry successor(SimpleEntry t) {
        if (t == null)
            return null;
        else if (t.right != null) {
            SimpleEntry p = t.right;
            while (p.left != null)
                p = p.left;
            return p;
        } else {
            SimpleEntry p = t.parent;
            SimpleEntry ch = t;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }

    private void fixAfterDeletion(SimpleEntry x) {
        while (x != root && colorOf(x) == BLACK) {
            if (x == leftOf(parentOf(x))) {
                SimpleEntry sib = rightOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateLeft(parentOf(x));
                    sib = rightOf(parentOf(x));
                }

                if (colorOf(leftOf(sib)) == BLACK &&
                        colorOf(rightOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(rightOf(sib)) == BLACK) {
                        setColor(leftOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateRight(sib);
                        sib = rightOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(sib), BLACK);
                    rotateLeft(parentOf(x));
                    x = root;
                }
            } else { // symmetric
                SimpleEntry sib = leftOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateRight(parentOf(x));
                    sib = leftOf(parentOf(x));
                }

                if (colorOf(rightOf(sib)) == BLACK && colorOf(leftOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(leftOf(sib)) == BLACK) {
                        setColor(rightOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateLeft(sib);
                        sib = leftOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(leftOf(sib), BLACK);
                    rotateRight(parentOf(x));
                    x = root;
                }
            }
        }

        setColor(x, BLACK);
    }

    private static boolean colorOf(SimpleEntry p) {
        return (p == null ? BLACK : p.color);
    }

    private static SimpleEntry parentOf(SimpleEntry p) {
        return (p == null ? null : p.parent);
    }

    private static void setColor(SimpleEntry p, boolean c) {
        if (p != null)
            p.color = c;
    }

    private static SimpleEntry leftOf(SimpleEntry p) {
        return (p == null) ? null : p.left;
    }

    private static SimpleEntry rightOf(SimpleEntry p) {
        return (p == null) ? null : p.right;
    }

    private void rotateLeft(SimpleEntry p) {
        if (p != null) {
            SimpleEntry r = p.right;
            p.right = r.left;
            if (r.left != null)
                r.left.parent = p;
            r.parent = p.parent;
            if (p.parent == null)
                root = r;
            else if (p.parent.left == p)
                p.parent.left = r;
            else
                p.parent.right = r;
            r.left = p;
            p.parent = r;
        }
    }

    private void rotateRight(SimpleEntry p) {
        if (p != null) {
            SimpleEntry l = p.left;
            p.left = l.right;
            if (l.right != null) l.right.parent = p;
            l.parent = p.parent;
            if (p.parent == null)
                root = l;
            else if (p.parent.right == p)
                p.parent.right = l;
            else p.parent.left = l;
            l.right = p;
            p.parent = l;
        }
    }


}
