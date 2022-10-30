/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc272.week3.genericpair;

/**
 *
 * @author Reddogg
 */
public class Pair<F, S> {
    private F firstElem;
    private S secondElem;
    
    Pair () {
        firstElem = (F) "";
        secondElem = (S) "";
    }
    
    Pair (F first) {
        firstElem = first;
        secondElem = (S) "";
    }
    
    // Pair constructor with two arguments
    Pair (F first, S second)
    {
        firstElem = first;
        secondElem = second;
    }
    
    public F getFirstElement(){
        return firstElem;
    }
    
    public S getSecondElement(){
        return secondElem;
    }
    
    public void setFirstElement(F firstElem){
        this.firstElem = firstElem;
    }
    
    public void setSecondElement(S secondElem){
        this.secondElem = secondElem;
    }
}
