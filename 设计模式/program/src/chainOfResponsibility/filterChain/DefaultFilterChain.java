package chainOfResponsibility.filterChain;

import java.util.ArrayList;
import java.util.List;

public class DefaultFilterChain implements FilterChain {

    private List<Filter> filters;

    private int pos;

    public DefaultFilterChain(){
        filters = new ArrayList<>();
        pos = 0;
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void doFilter(Request request, Response response) {
        if (pos < filters.size()){
            Filter filter = filters.get(pos);
            pos++;
            filter.doFilter(request,response,this);
        }
    }
}
