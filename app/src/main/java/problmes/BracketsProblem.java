package problmes;

import datastructures.stack.Stack;

public class BracketsProblem {
  String leftBrackets;
  Stack<Character> stack;
  String vaildBracketPairs;
  boolean isVaild;

  public BracketsProblem() {
    this.leftBrackets = "[{(";
    this.vaildBracketPairs = "[] {} ()";
    this.isVaild = true;
    this.stack = new Stack<Character>();

  }

  public boolean solve(String input) {

    for (int i = 0; i < input.length(); i++) {
      if (this.leftBrackets.indexOf(input.charAt(i)) != -1) {
        this.stack.push(input.charAt(i));
      } else {
        char leftBracket = this.stack.pop();
        this.isVaild = checkIfBracketsIsVaild(leftBracket, input.charAt(i));
        if (isVaild == false) {
          break;
        }
      }
    }

    if (this.stack.size() != 0) {
      this.isVaild = false;
    }

    return this.isVaild;
  }

  public boolean checkIfBracketsIsVaild(Character leftBracket, Character rightBracket) {
    StringBuilder stringBuilder = new StringBuilder();
    String brackets = stringBuilder.append(leftBracket).append(rightBracket).toString();
    return this.vaildBracketPairs.contains(brackets);
  }

}
