package DataStructure.List;

import DataStructure.Matrix.Matrix;

public class List {
    private Node node;

    public List() {
        this.node = null;
    }

    public List(Node node) {
        this();
        this.node = node;
    }

    public void insertOnList(Matrix matrix, int row) {
        Node head = null;
        Node tail = null;

        for(int i = 0; i < matrix.cols; i++) {
            if(matrix.getMatrix()[row][i].equals("1")) {
                Node newNode = new Node(i);

                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.setNext(newNode);
                    tail = newNode;
                }
            }
        }

        this.node = head;
    }

    public void showList() {
        Node node = this.node;

        while (node != null) {
            System.out.printf("%d  ", node.getInfo());
            node = node.getNext();
        }
        System.out.println();
    }
}
