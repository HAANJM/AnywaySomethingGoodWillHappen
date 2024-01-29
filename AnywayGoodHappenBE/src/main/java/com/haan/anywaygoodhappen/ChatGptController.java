package com.haan.anywaygoodhappen;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/ASGWH")
@RestController
public class ChatGptController {

    private final ChatGptService chatGptService;

    @PostMapping("/question")
    public ResponseEntity sendQuestion(@RequestBody String req) {

                JSONObject content = new JSONObject(req);
                String con = content.getString("content");

                ChatGptResponse chatGptResponse = null;
                try {
                    chatGptResponse = chatGptService.askQuestion(con);
                    System.out.println(chatGptResponse.getChoices().get(0).getMessage().content);
                } catch (Exception e) {
                    System.out.println(e);
                }

                //return 부분은 자유롭게 수정하시면됩니다. ex)return chatGptResponse;
                return new ResponseEntity(HttpStatus.OK);
            }
}
