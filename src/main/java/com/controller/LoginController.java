package com.controller;

import com.entity.Account;
import com.mapper.AccountMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {
    @Resource
	AccountMapper accountMapper;
    @RequestMapping("/loginController/list.do")
    public ModelAndView queryStudent(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, ModelMap model){
    	String aa=(String)model.get("name");
    	System.out.println("---"+aa);
        mv.setViewName("list");
        return mv;
    }

    @RequestMapping("/loginController/login.do")
    public void login(String pass, String user, RedirectAttributes attr, ModelAndView mv, Model model, HttpServletResponse response) throws IOException {
    	System.out.println("=======");
        Account account = this.accountMapper.select(user,pass);
		model.addAttribute("param", "需要传递的参数");
        if(account!=null){
			attr.addFlashAttribute("name","YES");
			response.getWriter().print(2);
        } else {
			attr.addFlashAttribute("name","BNO");
			response.getWriter().print(1);
        }
    }
    @RequestMapping("/")
    public ModelAndView login0(ModelAndView mv){
            mv.setViewName("login");
        return mv;
    }
}
