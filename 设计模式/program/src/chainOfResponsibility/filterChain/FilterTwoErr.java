package chainOfResponsibility.filterChain;

public class FilterTwoErr extends AbstractFilter {
    @Override
    protected void doFilterRequestInternal(Request request, Response response) {
        request.content.append("Filter Two proceeded request error, rollback\n");
        int a = 1/0;
    }

    @Override
    protected void doFilterResponseInternal(Request request, Response response) {
        response.content.append("Filter Two proceeded response\n");
    }
}
