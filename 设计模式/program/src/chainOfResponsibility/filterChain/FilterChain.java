package chainOfResponsibility.filterChain;

public interface FilterChain {
    public void addFilter(Filter filter);

    public void doFilter(Request request, Response response);
}
