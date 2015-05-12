package com.oliver;

public class Tree {

    Object data;
    Tree parent;
    Tree[] children;

    public Tree(Object data) {

        this.data = data;
        parent = null;
        children = null;
    }

    //  -> Tree[]
    // Return an array of children.
    // Strategy: Domain Knowledge
    public Tree[] getChildren() {

        return children;
    }

    // Tree[] -> void
    // Set the children of the tree entry.
    // Strategy: Domain Knowledge
    public void setChildren(Tree[] children) {

        this.children = children;
    }

    //  -> Object
    // Return the tree entry's data.
    // Strategy: Domain Knowledge
    public Object getData() {

        return data;
    }

    // Object -> void
    // Set the data of the tree entry.
    // Strategy: Domain Knowledge
    public void setData(Object data) {

        this.data = data;
    }

    //  -> Tree
    // Return the entry's parent.
    // Strategy: Domain Knowledge
    public Tree getParent() {

        return parent;
    }

    // Tree -> void
    // Set the parent of the tree entry.
    // Strategy: Domain Knowledge
    public void setParent(Tree parent) {

        this.parent = parent;
    }
}
