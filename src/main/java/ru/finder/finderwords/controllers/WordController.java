package ru.finder.finderwords.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.finder.finderwords.services.WordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/words")
public class WordController {
  private final WordService wordService;

  public WordController(WordService wordService) {
    this.wordService = wordService;
  }

  @GetMapping("/random-word={letters}")
  public String getMethodName(@PathVariable(name = "letters") int wordLength) {
    return wordService.getWord(wordLength);
  }

}
