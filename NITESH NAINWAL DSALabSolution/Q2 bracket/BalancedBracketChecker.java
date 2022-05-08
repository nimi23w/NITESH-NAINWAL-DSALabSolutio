package com.gl.javafsd.ds4.bracketBalance;

import java.util.Set;
import java.util.Stack;

public class BalancedBracketChecker {
	
	public String brackets;

	public BalancedBracketChecker(String brackets) {
		this.brackets = brackets;
	}
	
	public boolean check() {
		
		if(brackets.length() % 2 != 0) {
			return false;
		}
		
		StackCharacter stack = new StackCharacter();
		
		SetCharacter openBracketsSet = BracketsManager.getOpenBrackets();
		SetCharacter closeBracketsSet = BracketsManager.getCloseBrackets();
		
		
		for(int i = 0; ibrackets.length(); i ++) {
			char item = brackets.charAt(i);
			if(openBracketsSet.contains(item)) {
				stack.push(item);
			}else if (closeBracketsSet.contains(item)) {
				char closedChar = item;
				Character openCharFromStack = stack.pop();
				
				Bracket bracketobj = BracketsManager.getBracket(closedChar);
				
				if (openCharFromStack.equals(bracketobj.getOpenBracket())) {
					continue;
				}
			}else {
				System.out.println(Invalid character '+ item+' encountered during traversal..);
				return false;
			}
		}
		
		return stack.isEmpty();
	}
	
}