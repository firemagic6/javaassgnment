package java_assessment.model;
import java.util.List;

public interface Evaluation             // business rules for any entities that require Eval. method here
{
    double getAverage();                // method signature

    List<Course> getApprovedCourses();  // method signature

}