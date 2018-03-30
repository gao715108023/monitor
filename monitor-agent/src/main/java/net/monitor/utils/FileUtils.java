package net.monitor.utils;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA. User: zyj Date: 13-5-15 Time: 下午2:13 To change
 * this template use File | Settings | File Templates.
 */
public class FileUtils {

  private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);

  public static List<String> readFile(String fileName) {
    List<String> msgList = new ArrayList<>();
    File file = new File(fileName);
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(file));
      String tempString;
      while ((tempString = reader.readLine()) != null) {
        msgList.add(tempString);
      }
    } catch (IOException e) {
      LOGGER.error(String.format("read file error. file_name = %s", fileName), e);
    } finally {
      try {
        if (reader != null) {
          reader.close();
        }
      } catch (IOException e) {
        LOGGER.error(String.format("close BufferedReader error. file_name = %s", fileName), e);
      }

    }
    return msgList;
  }

  public static void writeShellFile(String filePath, String info) {
    OutputStreamWriter osw = null;
    BufferedWriter bw = null;
    try {
      osw = new OutputStreamWriter(new FileOutputStream(filePath, false));
      bw = new BufferedWriter(osw);
      try {
        bw.write("#!/bin/sh");
        bw.newLine();
        bw.write(info);
        bw.newLine();
        bw.flush();
      } catch (IOException e) {
        LOGGER.error(
            String.format("write shell file error. file_path = %s, info = %s", filePath, info), e);
      }
    } catch (FileNotFoundException e) {
      LOGGER
          .error(String.format("write shell file error. file_path = %s, info = %s", filePath, info),
              e);
    } finally {
      try {
        if (bw != null) {
          bw.close();
        }
      } catch (IOException e) {
        LOGGER.error(
            String.format("close BufferedWriter error. file_path = %s, info = %s", filePath, info),
            e);
      }
      try {
        if (osw != null) {
          osw.close();
        }
      } catch (IOException e) {
        LOGGER.error(String
                .format("close OutputStreamWriter error. file_path = %s, info = %s", filePath, info),
            e);
      }
    }
  }
}
