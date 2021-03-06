package com.example.facebookdemo.controller;

import com.example.facebookdemo.entity.User;
import com.example.facebookdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
/*
     @GetMapping("/")
   public String viewHomePage(Model model){
        model.addAttribute("ListUsers",userService.getAllUser());
           return "user";
        }
*/



    @GetMapping("/userLoggedIn/{id}")
    public String userLoggedIn(@PathVariable("id") long id,Model model){
    User user=userService.getUserById(id);
    model.addAttribute("user",user);
    return "loggedin";
}

    @PostMapping("/logginUser")
    public String loggingUser(@RequestParam("userName") String userName,
                              @RequestParam("password") String password){
        User user=userService.getNameByUserName(userName);
        long id=user.getId();
        if(user!=null && userName.equals(user.getUserName()) &&
                password.equals(user.getPassword())){
         return "redirect:/userLoggedIn/"+id;
        }
        return "redirect:/failed";
    }
  /*
  @GetMapping("/showFormUser")
    public String showFormUser(@ModelAttribute("user") User user, Model model){
        model.addAttribute("users",userService.getAllUser());
        return "user";
    }
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/showFormUser";
    }
     */
    @GetMapping("/")
    public String welcome(@ModelAttribute("user") User user, Model model){
        model.addAttribute("users", userService.getAllUser() );
        return "user";
    }
    @GetMapping("/success")
    public String success(@ModelAttribute("user") User user, Model model){
        model.addAttribute("msg","Du har sparat");
        return "user";
    }

    @GetMapping("/failed")
    public String failed(@ModelAttribute("user") User user,Model model){
        model.addAttribute("msg","Skriv l??senord r??tt!!!");
        return "user";
    }
/*
    @PostMapping("/saveUserParam")
    public String saveUserParam( @RequestParam("userName") String userName,
                                 @RequestParam("email") String email,
                                @RequestParam("passwordOne") String passwordOne,
                                 @RequestParam("passwordTwo") String passwordtwo
                                ){
        if(passwordOne.equals(passwordtwo)){
            User user=new User();
            user.setUserName(userName);
            user.setEmail(email);
            user.setPassword(passwordOne);
            userService.saveUser(user);
            return "redirect:/success";
        }
            return "redirect:/failed";
    }
*/


     @PostMapping("/saveUser")
    public String saveUserParam(@RequestParam("password") String passwordOne,
                                 @RequestParam("passwordTwo") String passwordTwo, User user
    ){
        if(passwordOne.equals(passwordTwo)){
            user.setImage("https://via.placeholder.com/150");

            userService.saveUser(user);
            return "redirect:/success";
        }
        return "redirect:/failed";
    }
@GetMapping("/admin")
    public ModelAndView adminDashboard(){
    ModelAndView mv= new ModelAndView();
    mv.setViewName("AdminDash");
    List<User> users=userService.getAllUser();
    mv.addObject("users",users);
    return mv;

}

    @PostMapping("/save-user")
    public String saveAndUpdateUser(@ModelAttribute("user") User user){
         System.out.print(user);
         userService.updateUser(user);
return "redirect:/admin";
    }
    @GetMapping(value = "/edit/{id}")
    public ModelAndView editUserInfo(@PathVariable(name = "id") long id){
         ModelAndView mav=new ModelAndView();
         mav.setViewName("edit");
         User userObject= userService.getUserById(id);
         mav.addObject("user",userObject);
         return mav;
    }
    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") long id){
         userService.removeUser(id);
        return "user";
    }
    }
