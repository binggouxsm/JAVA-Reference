package chainOfResponsibility.filterChain;

public class FilterTwo extends AbstractFilter {
    @Override
    protected void doFilterRequestInternal(Request request, Response response) {
        request.content.append("Filter Two proceeded request\n");
    }

    @Override
    protected void doFilterResponseInternal(Request request, Response response) {
        response.content.append("Filter Two proceeded response\n");
    }
}
