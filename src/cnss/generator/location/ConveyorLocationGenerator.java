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
public class ConveyorLocationGenerator implements Runnable
{

  private final String directory;

  public ConveyorLocationGenerator(String directory) throws Exception
  {
    this.directory = directory;
  }

  // Generate 126*28 orders for 126 walls, each order has different wall location
  private void generateAll(String directory)
  {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= 70; i++) // Adjust i to generate how many walls data
    {
      String conveyor = "C" + String.format("%03d", i);
      sb.append(conveyor);
      sb.append("\r\n");
      System.out.println("Created " + i + " conveyor location txt file, Please check folder: " + directory);
    }
    String filePath = directory + '/' + "C.txt";

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

  /**
   * Local disk folder for write interface file parameter is needed for main
   * method.
   *
   * @throws Exception
   */
  public static void main(String[] args) throws Exception
  {

    String directory = "D:\\temp\\conveyor";

    ConveyorLocationGenerator app = new ConveyorLocationGenerator(directory);
    app.run();
  }

  @Override
  public void run()
  {
    generateAll(directory);
    System.out.println("Data created!");
  }

}
