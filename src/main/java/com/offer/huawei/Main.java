package com.offer.huawei;

import java.util.*;

/**
 * Main class
 *
 * @author 格林
 * @date 2023-07-11
 */
class Node {
    private int no;
    private Integer value;
    private List<Node> child;
    private Node father;

    public Node(int no, int value, Node father) {
        this.no = no;
        this.value =  value;
        this.father = father;
        this.child = new ArrayList<>();
    }

    public Node(int no) {
        this.no = no;
        this.value =  null;
        this.father = null;
        this.child = new ArrayList<>();
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public List<Node> getChild() {
        return child;
    }

    public void setChild(List<Node> child) {
        this.child = child;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = Integer.valueOf(in.nextLine());
            Map<Integer, Node> map = new HashMap<>();
            Integer rootNo = null;
            for(int i = 0; i < n; i ++) {
                String readStr = null;
                try{
                    readStr = in.nextLine();
                }catch (NoSuchElementException  e) {

                }
                if(readStr == null) {
                    continue;
                }
                String[] split = readStr.split("\\s+");
                int nodeNo = Integer.valueOf(split[0]);
                Integer nodeFatherNo = split[1].length()  == 0 ? 0: Integer.valueOf(split[1]);
                Integer value = split[2].length() == 0 ? 0 : Integer.valueOf(split[2]) ;

                if(nodeFatherNo == null) {
                    Node faherNode = map.get(nodeNo);
                    if(faherNode == null) {
                        faherNode = new Node(nodeNo);
                        map.put(nodeNo, faherNode);
                    }
                    throw new RuntimeException(readStr +"," +split[0]+"," +split[1]+"," +split[2] );
                } else {
                    Node faherNode = map.get(nodeFatherNo);
                    if(faherNode == null) {
                        faherNode = new Node(nodeFatherNo);
                        map.put(nodeFatherNo, faherNode);
                    }
                    Node child = map.get(nodeNo);
                    if(child == null) {
                        child = new Node(nodeNo, value, faherNode);
                        map.put(nodeNo, child);
                    } else {
                        child.setValue(value);
                        child.setFather(faherNode);
                    }
                    faherNode.getChild().add(child);
                }

            }
            Node root = null;
            for(Node node : map.values()) {
                if(node.getFather() == null) {
                    root = node;
                    break;
                }
            }
            List<Node> child = root.getChild();
            int value = 0;
            for(int i = 0; i < child.size(); i ++) {
                value += getValue(child.get(i));
            }
            System.out.println(root.getNo() + " " +value);


        }
    }

    public static int getValue(Node root) {
        if(root == null) {
            return 0;
        }
        if(root.getChild().size() == 0) {
            Integer value = root.getValue();
            return value / 100 * 15;
        } else {
            Integer value = root.getValue() == null ? 0: root.getValue() ;
            List<Node> child = root.getChild();
            for(int i = 0; i < child.size(); i ++) {
                value += getValue(child.get(i));
            }
            return value / 100 * 15;
        }

    }

}
