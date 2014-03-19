/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cnss.generator.picklightupdate;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author zyu
 */
public class PicklightUpdateQueryGenerator
{

  /**
   * This program used in generate location update query for all address files
   * in a directory.
   *
   * @args[0] CNSS address files directory
   * {D:\intherlc\tools\ptltool_27_feb_2014\location-ID}
   * @args[1]{output file}
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException
  {
    InputStreamReader inputReader;
    BufferedReader bufferReader;

    Path dir = Paths.get(args[0]);

    try (FileOutputStream out = new FileOutputStream(args[1]))
    {
      for (Path file : Files.newDirectoryStream(dir))
      {
        try
        {
          InputStream inputStream = new FileInputStream(file.toFile());
          inputReader = new InputStreamReader(inputStream);
          bufferReader = new BufferedReader(inputReader);

          String line;
          String location;
          String address;

          out.write(("\r\n----Update picklight address query of " + file + "----\r\n").getBytes());
          while ((line = bufferReader.readLine()) != null)
          {
            StringBuilder sb = new StringBuilder();
            int space = line.indexOf(" ");
            location = line.substring(0, space);
            address = line.substring(space + 1, line.length());
            Long address_dec = Long.valueOf(address, 16);
            sb.append("UPDATE INTHER_LC.PTL_PICKLIGHT set ADDRESS = ").append(address_dec).append(" WHERE ID = '").append(location).append("';");
            sb.append("\r\n");
            out.write(sb.toString().getBytes());
          }
        }
        catch (StringIndexOutOfBoundsException | NumberFormatException ex)
        {
          out.write(("\r\n----No address in  " + file + "----\r\n").getBytes());
        }
      }
    }
  }
}
