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

    public List insertOnList(Matrix matrix, int row) {
        Node node = new Node();
        for(int i = 0; i < matrix.cols; i++) {
            if(matrix.getMatrix()[row][i].equals("1")) {
                System.out.println(i);
                if(node == null)
                    node = new Node(i);
                else {
                    Node nodeAux = node;

                    while(nodeAux.getNext() != null) {
                        nodeAux = nodeAux.getNext();
                    }

                    nodeAux.setNext(new Node(i));
                }
            }
        }

        return new List(node);
    }

    public void showList() {
        Node node = this.node;
        while(node != null) {
            System.out.printf(node.getInfo() + "\t");
        }

        System.out.println();
    }
}
