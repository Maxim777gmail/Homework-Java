//Класс Листинг (код не бьется на предложения по правилам обычного текста)
class Listing extends TextBlock {
    private final String code;

    public Listing(String code) {
        this.code = code;
    }

    @Override
    public String getValue() {
        return "[Листинг кода]:\n" + code;
    }
}
