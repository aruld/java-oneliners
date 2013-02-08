package com.aruld.oneliners;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.CloseableStream;

import static java.util.stream.Collectors.toCollection;

/**
 * Read in a File
 */
public class Item4 {

  public static void main(String[] args) throws Exception {
    try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
      String fileText = reader.lines().reduce("", String::concat);
    }

    try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
      List<String> fileLines = reader.lines().collect(toCollection(LinkedList<String>::new));
    }

    try (CloseableStream<String> lines = Files.lines(new File("data.txt").toPath(), Charset.defaultCharset())) {
      List<String> fileLines = lines.collect(toCollection(LinkedList<String>::new));
    }

  }
}
