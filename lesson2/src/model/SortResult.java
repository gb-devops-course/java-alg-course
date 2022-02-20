package model;

public class SortResult {

    private final long duration;
    private final long iterations;

    public SortResult(long duration, long iterations) {
        this.duration = duration;
        this.iterations = iterations;
    }

    public long getDuration() {
        return duration;
    }

    public long getIterations() {
        return iterations;
    }

    @Override
    public String toString() {
        return "duration=" + duration +
                ", iterations=" + iterations;
    }
}
