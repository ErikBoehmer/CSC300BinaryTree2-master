package com.example.csc300binarytree;

import java.io.Serializable;

public class NumberofTress implements Serializable
{
    private int payload;
    private NumberofTress leftSide;
    private NumberofTress rightSide;

    public NumberofTress(int payload)
    {
        this.payload = payload;
        this.leftSide = null;
        this.rightSide = null;
    }

    public void add(int payloadToAdd)
    {
        if(payloadToAdd <= this.payload)
        {
            if(this.leftSide == null)
            {
                this.leftSide = new NumberofTress(payloadToAdd);
            }
            else
            {
                this.leftSide.add(payloadToAdd);
            }
        }
        else
        {
            if(this.rightSide == null)
            {
                this.rightSide = new NumberofTress(payloadToAdd);
            }
            else
            {
                this.rightSide.add(payloadToAdd);
            }
        }
    }

    public String visitInOrder()
    {
        String tree = "";
        if(this.leftSide != null)
        {
            tree += this.leftSide.visitInOrder(); // blocking call
        }
        tree += this.payload + ", ";
        if(this.rightSide != null)
        {
            tree += this.rightSide.visitInOrder(); // blocking call
        }
        return tree;
    }

    public String visitPreOrder()
    {
        String tree = "";
        tree += this.payload + ", ";
        if(this.leftSide != null)
        {
            tree += this.leftSide.visitPreOrder();
        }
        if(this.rightSide != null)
        {
            tree += this.rightSide.visitPreOrder();
        }
        return tree;
    }

    public String visitPostOrder()
    {
        String tree = "";
        if(this.leftSide != null)
        {
            tree += this.leftSide.visitPostOrder();
        }
        if(this.rightSide != null)
        {
            tree += this.rightSide.visitPostOrder();
        }
        tree += this.payload + ", ";
        return tree;
    }

    public int getPayload()
    {
        return payload;
    }

    public NumberofTress getLeft()
    {
        return leftSide;
    }

    public NumberofTress getRight()
    {
        return rightSide;
    }
}