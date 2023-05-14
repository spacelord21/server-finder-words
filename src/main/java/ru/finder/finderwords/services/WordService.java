package ru.finder.finderwords.services;

import org.springframework.stereotype.Service;

import ru.finder.finderwords.entities.Word;
import ru.finder.finderwords.repository.GameMode;
import ru.finder.finderwords.repository.WordsRepository;

@Service
public class WordService {
  private final WordsRepository wordsRepository;

  public WordService(WordsRepository wordsRepository) {
    this.wordsRepository = wordsRepository;
  }

  public Word getWord(int wordLength) {
    switch (wordLength) {
      case 4: {
        return Word.builder().word(wordsRepository.getWordByMode(GameMode.FOUR_LETTERS)).build();
      }
      case 5: {
        return Word.builder().word(wordsRepository.getWordByMode(GameMode.FIVE_LETTERS)).build();
      }
      case 6: {
        return Word.builder().word(wordsRepository.getWordByMode(GameMode.SIX_LETTERS)).build();
      }
      default: {
        return Word.builder().word(wordsRepository.getWordByMode(GameMode.FIVE_LETTERS)).build();
      }
    }
  }

}
