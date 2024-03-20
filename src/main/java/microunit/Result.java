package microunit;

public class Result {
    private int numberOfSuccess;
    private int numberOfFailures;
    private int numberOfErrors;

    public void onError() {
        numberOfErrors++;
    }

    public void onFailure() {
        numberOfFailures++;
    }

    public void onSuccess() {
        numberOfSuccess++;
    }

    @Override
    public String toString() {
        return "Result{" +
                "numberOfSuccess=" + numberOfSuccess +
                ", numberOfFailures=" + numberOfFailures +
                ", numberOfErrors=" + numberOfErrors +
                '}';
    }
}
