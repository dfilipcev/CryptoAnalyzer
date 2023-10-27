package constants;

public enum WorkWays {
    ENCRYPT(1),
    DECRYPT(2),
    BRUTE_FORCE (3);

    private final int number;

    WorkWays(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
