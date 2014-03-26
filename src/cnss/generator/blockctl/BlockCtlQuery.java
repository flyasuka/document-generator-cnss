//*************************************************//
//          INTHER LOGISTICS ENGINEERING           //
//*************************************************//
package cnss.generator.blockctl;

/**
 *
 * @since Mar 19, 2014
 * @author zyu
 */
public class BlockCtlQuery
{

  /**
   *
   * @param args
   */
  public static void main(String[] args)
  {
    String[] controllers = new String[32];
    for (int i = 0; i < 15; i++)
    {
      controllers[i] = "PTL1." + String.valueOf(i + 21) + "_W";
    }
    for (int i = 0; i < 15; i++)
    {
      controllers[i + 15] = "PTL2B." + String.valueOf(i + 21) + "_C";
    }
    for (int i = 0; i < 2; i++)
    {
      controllers[i + 30] = "PTL2A." + String.valueOf(i + 3);
    }

    StringBuilder sb = new StringBuilder();
    sb.append("update inther_lc.ctl_controller set hostname =")
            .append("'10.0.0.8'")
            .append(" where ");
    int i = 1;
    for (String controller : controllers)
    {
      sb.append("id not like ").append("'").append(controller).append("%'");
      if (i != controllers.length)
      {
        sb.append(" and ");
      }
      else
      {
        sb.append(";");
      }
      i++;
    }

    System.out.println(sb);
  }

}
