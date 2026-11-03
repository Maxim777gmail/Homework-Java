import java.util.Objects;

// Класс Рациональная Дробь (дроби вида p/q)
class Rational {
    private final long num; // числитель
    private final long den; // знаменатель

    public Rational(long num, long den) {
        if (den == 0) throw new ArithmeticException("Знаменатель не может быть равен нулю.");
        long gcd = gcd(Math.abs(num), Math.abs(den));
        long sign = (num * den < 0) ? -1 : 1;
        this.num = sign * Math.abs(num) / gcd;
        this.den = Math.abs(den) / gcd;
    }

    public Rational(long num) {
        this(num, 1);
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public Rational add(Rational o) {
        return new Rational(this.num * o.den + o.num * this.den, this.den * o.den);
    }

    public Rational subtract(Rational o) {
        return new Rational(this.num * o.den - o.num * this.den, this.den * o.den);
    }

    public Rational multiply(Rational o) {
        return new Rational(this.num * o.num, this.den * o.den);
    }

    public Rational divide(Rational o) {
        return new Rational(this.num * o.den, this.den * o.num);
    }

    public boolean isZero() {
        return this.num == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rational)) return false;
        Rational rational = (Rational) o;
        return num == rational.num && den == rational.den;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, den);
    }

    @Override
    public String toString() {
        return den == 1 ? String.valueOf(num) : num + "/" + den;
    }
}
