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
    J(11),
    Q(11),
    K(11),
    A(0); // Could be 11 or 1

    public final int value;

    CardValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
