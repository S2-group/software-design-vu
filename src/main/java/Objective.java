import java.util.*;

public class Objective {
    private TimeLimit goal;
    private boolean result;
    private String winStatement;
    private String loseStatement;

    public Objective(TimeLimit goal, boolean result, String winStatement, String loseStatement) {
        this.goal = goal;
        this.result = result;
        this.winStatement = winStatement;
        this.loseStatement = loseStatement;
    }

    public String getWinStatement() {
        return this.winStatement;
    }

    public String getLoseStatement() {
        return this.loseStatement;
    }
}
