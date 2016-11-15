
package tarun.bth.App.process;

        import tarun.bth.App.db.entity.Exam;

        import javax.ws.rs.NotFoundException;
        import java.util.List;

public interface ExamProcess {
    List<Exam> getExams();
    Exam create(Exam exam);
    Exam update(Integer exam_id, Exam exam) throws NotFoundException;
    Exam find(Integer exam_id) throws NotFoundException;
    void delete(Integer exam_id);
}
