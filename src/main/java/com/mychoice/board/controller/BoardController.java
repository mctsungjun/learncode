package com.mychoice.board.controller;


import com.mychoice.board.model.Board;
import com.mychoice.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.StringBufferInputStream;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;
    @GetMapping("/list")
    public String list(Model model){

        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards",boards);
        return "board/list";
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("board",new Board());
        return "board/form";
    }
    @PostMapping("/form")
    public String greetingSubmit(@ModelAttribute Board board){
        boardRepository.save(board);
        return "redirect:/board/list";
    }

}
