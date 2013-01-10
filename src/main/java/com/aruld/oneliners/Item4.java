package com.aruld.oneliners;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Read in a File
 */
public class Item4 {

  public static void main(String[] args) throws Exception {
    try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
      String fileText = reader.lines().reduce("", String::concat);
    }

    try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
      List<String> fileLines = reader.lines().collect(Collectors.toCollection(() -> new LinkedList<String>()));
    }
  }
}
