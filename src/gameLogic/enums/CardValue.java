package gameLogic.enums;

public enum CardValue {
    DOIS(2),
    TRES(3),
    QUATRO(4),
    CINCO(5),
    SEIS(6),
    SETE(7),
    OITO(8),
    NOVE(9),
    DEZ(10),
    J(10),
    Q(10),
    K(10),
    A(11); // Could be 11 or 1

    public final int value;

    CardValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
