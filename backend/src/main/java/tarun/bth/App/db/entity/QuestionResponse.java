package tarun.bth.App.db.entity;

import java.util.List;

public class QuestionResponse {

    private Question question;

    private List<Choice> choiceList;

    public QuestionResponse(){}

    public QuestionResponse(Question question, List<Choice> choiceList){

        this.question = question;
        this.choiceList = choiceList;
    }


    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Choice> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<Choice> choiceList) {
        this.choiceList = choiceList;
    }
}
