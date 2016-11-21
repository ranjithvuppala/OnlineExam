package tarun.bth.App.db.entity;


public class UserExamScore {

    private Integer id;
    private Integer  userId;
    private Integer examId;
    private Integer score;


    public UserExamScore() {
    }

    public UserExamScore(Integer id,Integer userId, Integer examId, Integer score) {
        this.id = id;
        this.userId = userId;
        this.examId = examId;
        this.score = score;
    }

    public UserExamScore(Integer userId, Integer examId) {
        this.userId = userId;
        this.examId = examId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
