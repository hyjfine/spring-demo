package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "lily") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("say-hi")
    public @ResponseBody
    String sayHi() {
        return "hi";
    }


}
