package chainOfResponsibility.filterChain;

public class FilterThreeResErr extends AbstractFilter {
    @Override
    protected void doFilterRequestInternal(Request request, Response response) {
        request.content.append("Filter Three proceeded request\n");
    }

    @Override
    protected void doFilterResponseInternal(Request request, Response response) {
        response.content.append("Filter Three proceeded response error rollback\n");
        int a = 1/0;
    }
}
