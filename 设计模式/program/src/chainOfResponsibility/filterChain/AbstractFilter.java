package chainOfResponsibility.filterChain;

public abstract class AbstractFilter implements Filter{
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        doFilterRequestInternal(request,response);
        chain.doFilter(request,response);
        doFilterResponseInternal(request,response);
    }
    // 处理请求的业务逻辑
    protected abstract void doFilterRequestInternal(Request request, Response response);
    // 处理响应的业务逻辑
    protected abstract void doFilterResponseInternal(Request request, Response response);
}
