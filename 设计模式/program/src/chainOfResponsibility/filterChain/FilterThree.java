package chainOfResponsibility.filterChain;

public class FilterThree extends AbstractFilter {
    @Override
    protected void doFilterRequestInternal(Request request, Response response) {

    }

    @Override
    protected void doFilterResponseInternal(Request request, Response response) {
        response.content.append("Filter Three proceeded response\n");
    }
}
