package chainOfResponsibility.filterChain;

public class Main {
    public static void main(String[] args) {

        Request req = new Request();
        Response res = new Response();

        DefaultFilterChain chain = new DefaultFilterChain();
        chain.addFilter(new FilterOne());
        chain.addFilter(new FilterTwo());
        chain.addFilter(new FilterThreeResErr());

        try {
            chain.doFilter(req,res);
        }catch (Exception e){
        }

        System.out.println(req.content.toString());
        System.out.println("===========================");
        System.out.println(res.content.toString());
        System.out.println("===========================");
    }
}
