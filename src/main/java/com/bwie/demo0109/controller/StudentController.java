package com.bwie.demo0109.controller;

import com.bwie.demo0109.entity.Account;
import com.bwie.demo0109.entity.Student;
import com.bwie.demo0109.mapper.StudentMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentController {
    @Resource
    StudentMapper studentMapper;
    @RequestMapping("/list")
    public ModelAndView queryStudent(@RequestParam(value = "condition",required = false,defaultValue = "") String condition, HttpServletRequest request,
									 ModelAndView mv, ModelMap model){
    	//String fuckk=(String) RequestContextUtils.getInputFlashMap(request).get("name");
    	String aa=(String)model.get("name");
    	System.out.println("---"+aa);
        List<Student> students = this.studentMapper.queryStudent(condition);
        mv.addObject("list",students);
        mv.setViewName("list");
        return mv;
    }
    @RequestMapping("/login")
    public ModelAndView login(String pass, String user, RedirectAttributes attr, ModelAndView mv, Model model){
        Account account = this.studentMapper.select(user,pass);
		model.addAttribute("param", "需要传递的参数");
        if(account!=null){
			attr.addFlashAttribute("name","YES");
            mv.setViewName("redirect:/list");
        } else {
			attr.addFlashAttribute("name","BNO");
            mv.setViewName("login");
        }
        return mv;
    }
    @RequestMapping("/")
    public ModelAndView login0(ModelAndView mv){
            mv.setViewName("login");
        return mv;
    }
}
