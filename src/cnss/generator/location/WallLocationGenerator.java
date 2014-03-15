//*************************************************//
//          INTHER LOGISTICS ENGINEERING           //
//*************************************************//
package cnss.generator.location;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @CNSS-PTW This class is used in generate put to wall location ID
 * @since Feb 17, 2014
 * @author zyu
 */
public class WallLocationGenerator implements Runnable
{

  private final String directory;

  public WallLocationGenerator(String directory) throws Exception
  {
    this.directory = directory;
  }

  private void generateAll(String directory)
  {
    for (int i = 1; i <= 126; i++) // Adjust i to generate how many walls data
    {
      String wall = "W" + String.format("%03d", i);
      StringBuilder sb = new StringBuilder();
      sb.append("ZD_").append(wall);
      sb.append("\r\n");
      for (int j = 1; j <= 4; j++)
      {
        for (int k = 1; k <= 7; k++)
        {
          sb.append(wall).append("-").append(j).append("-").append(k);
          sb.append("\r\n");
        }
      }
      for (int j = 1; j <= 4; j++)
      {
        for (int k = 1; k <= 7; k++)
        {
          sb.append(wall).append("-").append(j).append("-").append(k).append("-B");
          sb.append("\r\n");
        }
      }
      System.out.println("Created " + i + " wall location txt file, Please check folder: " + directory);

      String filePath = directory + '/' + wall + ".txt";

      try
      {
        byte[] buff = new byte[]
        {
        };
        FileOutputStream output = new FileOutputStream(filePath);
        buff = sb.toString().getBytes();
        output.write(buff);
      }
      catch (FileNotFoundException e)
      {
      }
      catch (IOException e)
      {
      }

    }
  }

  /**
   * Local disk folder for write interface file parameter is needed for main
   * method.
   *
   * @throws Exception
   */
  public static void main(String[] args) throws Exception
  {

    String directory = "D:\\temp\\wall";

    WallLocationGenerator app = new WallLocationGenerator(directory);
    app.run();
  }

  @Override
  public void run()
  {
    generateAll(directory);
    System.out.println("Data created!");
  }

}
