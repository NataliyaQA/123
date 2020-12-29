package calculator.java;

public class Session {
    private float first;
    private float second;
    private char action;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getFirst() {
        return first;
    }

    public void setFirst(float first) {
        this.first = first;
    }

    public float getSecond() {
        return second;
    }

    public void setSecond(float second) {
        this.second = second;
    }

    public char getAction() {
        return action;
    }

    public void setAction(char action) {
        this.action = action;
    }
}
