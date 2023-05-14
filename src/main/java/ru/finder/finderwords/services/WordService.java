package ru.finder.finderwords.services;

import org.springframework.stereotype.Service;

import ru.finder.finderwords.repository.GameMode;
import ru.finder.finderwords.repository.WordsRepository;

@Service
public class WordService {
  private final WordsRepository wordsRepository;

  public WordService(WordsRepository wordsRepository) {
    this.wordsRepository = wordsRepository;
  }

  public String getWord(int wordLength) {
    switch (wordLength) {
      case 4: {
        return wordsRepository.getWordByMode(GameMode.FOUR_LETTERS);
      }
      case 5: {
        return wordsRepository.getWordByMode(GameMode.FIVE_LETTERS);
      }
      case 6: {
        return wordsRepository.getWordByMode(GameMode.SIX_LETTERS);
      }
      default: {
        return wordsRepository.getWordByMode(GameMode.FIVE_LETTERS);
      }
    }
  }

}
