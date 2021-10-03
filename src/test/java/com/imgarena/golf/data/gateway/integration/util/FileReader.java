package com.imgarena.golf.data.gateway.integration.util;

import java.io.*;

/**
 * Utility class to read files from the resources folder.
 */
public class FileReader {
  public static String read(String filename) throws IOException {
    InputStream inputStream = FileReader.class.getResourceAsStream(File.separator + filename);
    return readFromInputStream(inputStream);
  }

  private static String readFromInputStream(InputStream inputStream) throws IOException {
    StringBuilder resultStringBuilder = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = br.readLine()) != null) {
        resultStringBuilder.append(line).append("\n");
      }
    }
    return resultStringBuilder.toString();
  }
}
