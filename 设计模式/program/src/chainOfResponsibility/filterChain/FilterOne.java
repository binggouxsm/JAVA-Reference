package chainOfResponsibility.filterChain;

public class FilterOne extends AbstractFilter {
    protected void doFilterRequestInternal(Request request, Response response) {
        request.content.append("Filter One proceeded request\n");
    }

    protected void doFilterResponseInternal(Request request, Response response) {
    }
}
