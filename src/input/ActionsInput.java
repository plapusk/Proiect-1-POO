package input;

public class ActionsInput {
    private String type;
    private String page;
    private String movie;
    private String feature;
    private CredentialsInput credentials;
    private String startsWith;
    private String tokens;
    private FiltersInput filters;

    private double rate;

    public final double getRate() {
        return rate;
    }

    public final void setRate(final double rate) {
        this.rate = rate;
    }

    public final String getCount() {
        return count;
    }

    public final void setCount(final String count) {
        this.count = count;
    }

    private String count;

    public final String getType() {
        return type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    public final String getPage() {
        return page;
    }

    public final void setPage(final String page) {
        this.page = page;
    }

    public final String getMovie() {
        return movie;
    }

    public final void setMovie(final String movie) {
        this.movie = movie;
    }

    public final String getFeature() {
        return feature;
    }

    public final void setFeature(final String feature) {
        this.feature = feature;
    }

    public final CredentialsInput getCredentials() {
        return credentials;
    }

    public final void setCredentials(final CredentialsInput credentials) {
        this.credentials = credentials;
    }

    public final String getStartsWith() {
        return startsWith;
    }

    public final void setStartsWith(final String startsWith) {
        this.startsWith = startsWith;
    }

    public final String getTokens() {
        return tokens;
    }

    public final void setTokens(final String tokens) {
        this.tokens = tokens;
    }

    public final FiltersInput getFilters() {
        return filters;
    }

    public final void setFilters(final FiltersInput filters) {
        this.filters = filters;
    }
}
