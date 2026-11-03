// Класс Прямая на плоскости: Ax + By + C = 0
class Line {
    private final Rational a;
    private final Rational b;
    private final Rational c;

    public Line(Rational a, Rational b, Rational c) {
        if (a.isZero() && b.isZero()) {
            throw new IllegalArgumentException("Коэффициенты A и B не могут быть одновременно равны нулю.");
        }
        // Нормализация для корректного сравнения (чтобы 2x+2y+2=0 и x+y+1=0 были эквивалентны)
        Rational factor = !a.isZero() ? a : b;
        this.a = a.divide(factor);
        this.b = b.divide(factor);
        this.c = c.divide(factor);
    }

    // 1. Точки пересечения с осями координат
    public String getAxisIntersections() {
        StringBuilder sb = new StringBuilder();

        // С осью OX (y = 0) -> Ax + C = 0 -> x = -C/A
        if (!a.isZero()) {
            Rational x = c.multiply(new Rational(-1)).divide(a);
            sb.append("Пересечение с OX: (").append(x).append(", 0); ");
        } else {
            sb.append("Параллельна OX (нет пересечения); ");
        }

        // С осью OY (x = 0) -> By + C = 0 -> y = -C/B
        if (!b.isZero()) {
            Rational y = c.multiply(new Rational(-1)).divide(b);
            sb.append("Пересечение с OY: (0, ").append(y).append(")");
        } else {
            sb.append("Параллельна OY (нет пересечения)");
        }

        return sb.toString();
    }

    // 2. Координаты пересечения двух прямых (Крамер)
    public String intersect(Line o) {
        // Детерминант матрицы: D = A1*B2 - A2*B1
        Rational d = this.a.multiply(o.b).subtract(o.a.multiply(this.b));

        if (d.isZero()) {
            // Если A1/A2 == B1/B2 == C1/C2 — прямые совпадают, иначе — параллельны
            if (this.b.equals(o.b) && this.c.equals(o.c)) {
                return "Прямые совпадают (бесконечно много точек пересечения)";
            }
            return "Прямые параллельны (нет точек пересечения)";
        }

        // Dx = -C1*B2 - (-C2*B1) = B1*C2 - B2*C1
        Rational dx = this.b.multiply(o.c).subtract(o.b.multiply(this.c));
        // Dy = A1*(-C2) - A2*(-C1) = A2*C1 - A1*C2
        Rational dy = o.a.multiply(this.c).subtract(this.a.multiply(o.c));

        Rational x = dx.divide(d);
        Rational y = dy.divide(d);

        return "(" + x + ", " + y + ")";
    }

    // Вспомогательный метод для группировки по угловому коэффициенту
    // У параллельных прямых отношение A/B одинаково (или B=0 у обеих)
    public String getSlopeKey() {
        if (b.isZero()) return "vertical";
        return a.divide(b).toString();
    }

    @Override
    public String toString() {
        return String.format("(%sx) + (%sy) + (%s) = 0", a, b, c);
    }
}
