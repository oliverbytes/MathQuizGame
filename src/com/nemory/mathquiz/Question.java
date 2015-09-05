package com.nemory.mathquiz;

import java.util.ArrayList;

public class Question {

	private String text;
	private String answer;
	private String choice_a;
	private String choice_b;
	private String choice_c;
	private String file;
	
	public static ArrayList<Question> questions = new ArrayList<Question>();

	/** ------------ SETTERS AND GETTERS ------------ **/


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getChoiceA() {
		return choice_a;
	}

	public void setChoiceA(String choice_a) {
		this.choice_a = choice_a;
	}

	public String getChoiceB() {
		return choice_b;
	}

	public void setChoiceB(String choice_b) {
		this.choice_b = choice_b;
	}

	public String getChoiceC() {
		return choice_c;
	}

	public void setChoiceC(String choice_c) {
		this.choice_c = choice_c;
	}
}
