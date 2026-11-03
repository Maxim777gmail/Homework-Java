// Мармелад
class JellyCandy extends Confectionery {
    private final boolean hasGellingAgent;

    public JellyCandy(String name, double weight, double sugarContent, boolean hasGellingAgent) {
        super(name, weight, sugarContent);
        this.hasGellingAgent = hasGellingAgent;
    }
}
