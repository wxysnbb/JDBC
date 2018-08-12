package cn.wd.web;

import cn.wd.entity.User;
import cn.wd.service.ServiceFactory;
import cn.wd.service.user.UserService;
import cn.wd.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * main页面需要ajax使用的servlet
 */
@WebServlet("/home")
public class HomeServlet extends  BaseServlet {

    private UserService userService;
    @Override
    public Class getServletClass() {
        return HomeServlet.class;
    }
    //当用户访问我们这个servlet的时候 先执行init
    @Override
    public void init() throws ServletException {
        userService=(UserService) ServiceFactory.getServiceImpl("userService");
    }
    /**
     *  分页的方法
     */
    public PageUtil findAllByPage(HttpServletRequest req, HttpServletResponse resp){
        //获取当前页面 pageIndex
        int pageIndex=Integer.parseInt(req.getParameter("pageIndex"));
        if (pageIndex==0){
            pageIndex=1;
        }
        //创建PageUtil对象
        PageUtil pageUtil=new PageUtil();
        //把获取的数据封装到PageUtil
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setTotalCount(userService.findrownum());
        //调用service代码 获取数据
        List<User> list = userService.findAllByPage(pageUtil);
        pageUtil.setList(list);
        System.out.println("pageUtil===>"+pageUtil);
        //返回PageUtil
        return  pageUtil;
    }
    public String deleteUser(HttpServletRequest req, HttpServletResponse resp){
        String id= req.getParameter("id");
        System.out.println(111111);
        int num= userService.deleteByCondition(id);
        if (num>0){
            return "main";
        }
        return "login";
    }
}
