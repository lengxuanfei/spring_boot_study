//package com.dff.filter;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * @Description: LoginFilter
// * @Author: daifeifei
// * @CreateDate: 2018/4/11 1:49
// */
//public class LoginFilter extends ZuulFilter {
//    @Override
//    public int filterOrder() {
//        return 0;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public String filterType() {
//        return "pre";
//    }
//
//    @Override
//    public Object run() {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//
//        System.out.println(
//                String.format("%s LoginFilter request to %s",
//                        request.getMethod(),
//                        request.getRequestURI().toString()));
//
//        String p = request.getParameter("p");
//        if("123456".equals(p)) {
//            ctx.setSendZuulResponse(true);
//            ctx.setResponseStatusCode(200);
//            ctx.set("success", true);
//        } else {
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            ctx.setResponseBody("{\"ret_info\": \"p is not correct!");
//            ctx.set("success", false);
//        }
//        return null;
//    }
//}
