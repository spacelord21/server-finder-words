package ru.finder.finderwords.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class WordsRepository {
  @Value("classpath:templates/four-letters.txt")
  private File fourLetters;
  @Value("classpath:templates/five-letters.txt")
  private File fiveLetters;
  @Value("classpath:templates/six-letters.txt")
  private File sixLetters;
  private final int SIZE_FOUR_LETTERS = 1607;
  private final int SIZE_FIVE_LETTERS = 3483;
  private final int SIZE_SIX_LETTERS = 4836;

  public String getWordByMode(GameMode mode) {
    switch (mode) {
      case FOUR_LETTERS: {
        return getRandomWord(fourLetters, SIZE_FOUR_LETTERS);
      }
      case FIVE_LETTERS: {
        return getRandomWord(fiveLetters, SIZE_FIVE_LETTERS);
      }
      case SIX_LETTERS: {
        return getRandomWord(sixLetters, SIZE_SIX_LETTERS);
      }
      default: {
        return "ошибка";
      }
    }
  }

  private String getRandomWord(File file, int upperBound) {
    Random random = new Random();
    int randomNumber = random.nextInt(upperBound);
    String word = "ошибка";
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
      int i = 0;
      while ((word = bufferedReader.readLine()) != null) {
        if (i == randomNumber) {
          return word;
        }
        i++;
      }
      bufferedReader.close();
      return word;
    } catch (IOException exception) {
      System.out.println(exception.getMessage());
      return "ошибка";
    }
  }
}
