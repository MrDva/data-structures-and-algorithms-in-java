package edu.czb.datastructures.util;

import edu.czb.datastructures.trees.BinarySearchTree;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author: 陈泽彬
 * @date: 2022/1/6 16:05
 * @description:
 */
public class DrawDemo extends JFrame {
    private static final float STROKE_WIDTH=10.1f;
    private static final int WIDTH=1800;
    private static final int HEIGHT=800;
    private ArrayList<Point2> list=new ArrayList<Point2>();

    private BinarySearchTree tree;
    private int count =1;

    private int deltaY=60;
    private int deltaX=WIDTH/4;

    private Graphics g;

    public Graphics getG(){
        return g;
    }

    public DrawDemo(BinarySearchTree tree){
        this();
        this.tree=tree;
        paintTree(this.tree,g);
    }

    public DrawDemo(){
        Container p=getContentPane();
        setBounds(100,100,WIDTH,HEIGHT);
        setVisible(true);
        p.setBackground(new Color(0xFFFFFF));
        setLayout(null);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
        g=this.getGraphics();
    }

    public void paintTree(BinarySearchTree tree,Graphics g){
        //g.setColor(Color.red);
        TreeNode root = tree.getRoot();
        if(root==null){
            return;
        }
        paintTree(root,WIDTH/2,50,deltaX,deltaY,g);
    }
    public void paintTree(TreeNode treeNode,int x,int y,int deltaX,int deltaY,Graphics g){
        g.fillOval(x-2,y-2,2,2);
        g.drawString(count+++" "+treeNode.getElement(),x-2,y+2);
        list.add(new Point2(x,y,x,y));
        if(treeNode.getLeft()!=null){
            g.drawLine(x,y,x-deltaX,y+deltaY);
            list.add(new Point2(x,y,x-deltaX,y+deltaY));
            paintTree(treeNode.getLeft(),x-deltaX,y+deltaY,deltaX/2,deltaY,g);
        }
        if(treeNode.getRight()!=null){
            g.drawLine(x,y,x+deltaX,y+deltaY);
            list.add(new Point2(x,y,x+deltaX,y+deltaY));
            paintTree(treeNode.getRight(),x+deltaX,y+deltaY,deltaX/2,deltaY,g);
        }
        /*for (int i = 0; i < list.size(); i++) {
            Point2 l=list.get(i);
            g.drawLine(l.x,l.y,l.x1,l.y1);
        }*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                repaint1();
            }
        }).start();
    }


    public void repaint1() {
        //super.repaint();
        for (int i = 0; i < list.size(); i++) {
            g.drawLine(list.get(i).x,list.get(i).y,list.get(i).x1,list.get(i).y1);
        }
    }

    class Point2{
        int x;
        int y;
        int x1;
        int y1;
        public Point2(int x,int y,int x1,int y1){
            this.x=x;
            this.y=y;
            this.x1=x1;
            this.y1=y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX1() {
            return x1;
        }

        public void setX1(int x1) {
            this.x1 = x1;
        }

        public int getY1() {
            return y1;
        }

        public void setY1(int y1) {
            this.y1 = y1;
        }
    }

}

