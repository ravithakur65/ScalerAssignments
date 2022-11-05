package com.learn.scaler.advance.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Problem Description

Given two arrays of strings A of size N and B of size M.

Return a binary string C where C[i] = '1' if B[i] can be found in dictionary A using exactly one modification in B[i], Else C[i] = '0'.

NOTE: modification is defined as converting a character into another character.



Problem Constraints

1 <= N <= 30000

1 <= M <= 2500

1 <= length of any string either in A or B <= 20

strings contains only lowercase alphabets



Input Format

First argument is the string arrray A.

Second argument is the string array B.



Output Format

Return a binary string C where C[i] = '1' if B[i] can be found in dictionary A using one modification in B[i], Else C[i] = '0'.



Example Input

Input 1:

 A = [data, circle, cricket]
 B = [date, circel, crikket, data, circl]
Input 2:

 A = [hello, world]
 B = [hella, pello, pella]


Example Output

Output 1:

 "10100"
Output 2:

 "110"


Example Explanation

Explanation 1:

 1. date = dat*(can be found in A)
 2. circel =(cannot be found in A using exactly one modification)
 3. crikket = cri*ket(can be found in A)
 4. data = (cannot be found in A using exactly one modification)
 5. circl = (cannot be found in A using exactly one modification)
Explanation 2:

 Only pella cannot be found in A using only one modification.
 */
public class ModifiedSearchUsingTries {
    public String solve(ArrayList<String> A, ArrayList<String> B) {
        ModifiedSearch modifiedSearch = new ModifiedSearch();
        return modifiedSearch.modifiedSearch(A,B);
    }
}
	class TriesNode {
	    boolean isLast;
	    Map<Character,TriesNode> child;
	    public TriesNode(){
	        this.child = new HashMap<>();
	    }
	    public TriesNode(boolean isLast){
	        this.child = new HashMap<>();
	        this.isLast = isLast;
	    }
	    public TriesNode(boolean isLast,int count){
	        this.child = new HashMap<>();
	        this.isLast = isLast;
	    }
	}
	class Utility {
	    public static void insert(TriesNode root,String input){
	        TriesNode curr = root;
	        for(int i = 0 ; i < input.length(); ++i){
	            if(!curr.child.containsKey(input.charAt(i))){
	                curr.child.put(input.charAt(i),new TriesNode());
	            }
	            curr = curr.child.get(input.charAt(i));
	        }
	        curr.isLast = true;
	    }
	}
	class ModifiedSearch {
	   public boolean DFS(TriesNode root,String input,boolean isModified,int index){
	        //Base Case
	        if(root == null) return false;
	        /**
	         * In case of exact match with trie we will return false
	         * */
	        if(!isModified && root.isLast){
	            return false;
	        }
	        if(root.isLast) return true;
	        if(index >= input.length()) return false;
	        if(isModified && !root.child.containsKey(input.charAt(index))){
	            return false;
	        }
	        for(Character c : root.child.keySet()){
	            if(c == input.charAt(index)){
	                if(DFS(root.child.get(c),input,isModified,index+1)){
	                    return true;
	                }
	            }
	            else if(!isModified){
	                if(DFS(root.child.get(c),input,true,index+1)){
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
	    public String modifiedSearch(ArrayList<String> input1, ArrayList<String> input2){
	        //Modification can be done on a single char
	        StringBuilder output = new StringBuilder();
	        TriesNode root = new TriesNode(); //Dummy node
	        input1.forEach((a)->Utility.insert(root,a));
	        input2.forEach((a)->{
	            output.append(DFS(root,a,false,0)?1:0);
	        });
	        return output.toString();
	    }
	}


