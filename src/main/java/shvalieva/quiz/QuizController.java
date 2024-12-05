package shvalieva.quiz;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


@Controller
public class QuizController {
    Map<String, String[]> questions = new HashMap<>();

    @GetMapping("/quizzing")
    public String showQuizzing(Model model) {
        if (questions.isEmpty()) {
            questions.put("Можно ли взрослым ёжикам давать молоко?",
                    new String[]{"Да", "Нет"});
            questions.put("Сколько будет 2+2*2?",
                    new String[]{"6", "8"});
            questions.put("Солнце - это...",
                    new String[]{"Планета", "Звезда"});
        }

        model.addAttribute("questions", questions);
        return "quizzing";
    }


    @PostMapping("/result")
    public String getResults(@RequestParam Map<String, String> answers, Model model) {
        model.addAttribute("message", "Спасибо что прошли опрос!");
        model.addAttribute("rightAnswer1",
                "Можно ли взрослым ёжикам давать молоко? Правильный ответ: нет");
        model.addAttribute("rightAnswer2",
                "Сколько будет 2+2*2? Правильный ответ: 6");
        model.addAttribute("rightAnswer3",
                "Солнце - это... Правильный ответ: звезда");
        return "result";
    }
}
