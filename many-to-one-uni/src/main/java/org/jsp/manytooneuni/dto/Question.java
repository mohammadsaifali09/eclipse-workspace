package org.jsp.manytooneuni.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String question, questionedBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionBy() {
		return questionedBy;
	}

	public void setQuestionBy(String questionBy) {
		this.questionedBy = questionBy;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", questionBy=" + questionedBy + "]";
	}

}
