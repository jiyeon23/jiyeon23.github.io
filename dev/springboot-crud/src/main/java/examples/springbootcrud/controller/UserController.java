package examples.springbootcrud.controller;

import examples.springbootcrud.dto.User;
import examples.springbootcrud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


//signup 페이지로
@Controller
@RequiredArgsConstructor // final 붙은 것 생성자
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String signupForm(User user) {
        return "add-user"; // view의 이름만 리턴, view resolver가 add-user.html 찾음
    }

    @GetMapping("/index")
    public String indexForm(Model model) {
        model.addAttribute("users",userService.getUsers());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String updateForm(@PathVariable("id") long id, Model model){
        User user = userService.getUser(id).get();
        model.addAttribute("user",user);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "update-user";
        }
        userService.updateUser(user);
        return "redirect:/index";
    }

   @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model){

        // 값 가져오지 못할 경우
        if(result.hasErrors()){
            return "add-user"; // view 이름
        }

        userService.addUser(user);

        // 값 저장 후 index 페이지로

       // 포워딩 vs redirect
        return "redirect:index"; // 주소 이름
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "redirect:/index";
        }
        userService.deleteUser(user);

        return "redirect:/index";
    }
}