package com.company.Magic8BallAPI.model;

import javax.validation.constraints.NotEmpty;

public class Answer {
    @NotEmpty( message="You must supply a question for the magic-8-ball.")
    private String question;
    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
