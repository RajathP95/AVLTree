package com.baeldung.avltree;

import org.junit.Assert;
import org.junit.Test;

public class AVLTreeTest {

    @Test
    public void givenEmptyTree_whenHeightCalled_shouldReturnMinus1() {
        AVLTree tree = new AVLTree();
        Assert.assertEquals(-1, tree.height());
    }

    @Test
    public void givenEmptyTree_whenInsertCalled_heightShouldBeZero() {
        AVLTree tree = new AVLTree();
        tree.insert(1);
        Assert.assertEquals(0, tree.height());
    }

    @Test
    public void givenEmptyTree_whenInsertCalled_treeShouldBeAvl() {
        AVLTree tree = new AVLTree();
        tree.insert(1);
        Assert.assertTrue(isAVL(tree));
    }

    @Test
    public void givenSampleTree_whenInsertCalled_treeShouldBeAvl() {
        AVLTree tree = getSampleAVLTree();
        int newKey = 11;
        tree.insert(newKey);
        Assert.assertTrue(isAVL(tree));
    }

    @Test
    public void givenSampleTree_whenFindExistingKeyCalled_shouldReturnMatchedNode() {
        AVLTree tree = getSampleAVLTree();
        int existingKey = 2;
        AVLTree.Node result = tree.find(existingKey);
        Assert.assertEquals(result.key, existingKey);
    }

    @Test
    public void givenSampleTree_whenFindNotExistingKeyCalled_shouldReturnNull() {
        AVLTree tree = getSampleAVLTree();
        int notExistingKey = 11;
        AVLTree.Node result = tree.find(notExistingKey);
        Assert.assertNull(result);
    }

    @Test
    public void givenEmptyTree_whenDeleteCalled_treeShouldBeAvl() {
        AVLTree tree = new AVLTree();
        tree.delete(1);
        Assert.assertTrue(isAVL(tree));
    }

    @Test
    public void givenSampleTree_whenDeleteCalled_treeShouldBeAvl() {
        AVLTree tree = getSampleAVLTree();
        tree.delete(1);
        Assert.assertTrue(isAVL(tree, tree.getRoot()));
    }
    
    @Test
    public void givenSampleTree_whenInsertLeftCalled_treeShouldBeAvl() {
    	AVLTree tree = new AVLTree();
        int newKey = 5;
        tree.insert(newKey);
        int left = 4;
        tree.insert(left);
        int right = 1;
        tree.insert(right);
        int leftNew = 7;
        tree.insert(leftNew);
        int leftRightNew = 9;
        tree.insert(leftRightNew);
        Assert.assertTrue(isAVL(tree));
    }
    
    @Test
    public void givenSampleTree_whenDeleteLeftCalled_treeShouldBeAvl() {
    	AVLTree tree = new AVLTree();
    	int newKey = 11;
        tree.insert(newKey);
        int left = 5;
        tree.insert(left);
        int right = 15;
        tree.insert(right);
        int leftNew = 3;
        tree.insert(leftNew);
        int leftRightNew = 4;
        tree.insert(leftRightNew);
        int rightleftNew = 13;
        tree.insert(rightleftNew);
        int rigthRightNew = 16;
        tree.insert(rigthRightNew);
        int delLeft = 5;
        tree.delete(delLeft);
        int delRight = 15;
        tree.delete(delRight);
        Assert.assertTrue(isAVL(tree));
    }
    
    @Test(expected = RuntimeException.class)
    public void exceptionWhenSame() {
    		AVLTree tree = new AVLTree();
	    	int newKey = 11;
	        tree.insert(newKey);
	        int sameKey = 11;
	        tree.insert(sameKey);
    }

    private boolean isAVL(AVLTree tree) {
       return isAVL(tree, tree.getRoot());
    }

    private boolean isAVL(AVLTree tree, AVLTree.Node node) {
        if ( node == null )
            return true;
        int balance = tree.getBalance(node);
        return (balance <= 1 && balance >= -1) && isAVL(tree, node.left) && isAVL(tree, node.right);
    }

    private AVLTree getSampleAVLTree() {
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < 10; i++)
            avlTree.insert(i);
        return avlTree;
    }
}
