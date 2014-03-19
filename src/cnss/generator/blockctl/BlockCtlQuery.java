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
    String walls[] =
    {
      "037", "038", "039"
    };
    StringBuilder sb = new StringBuilder();
    sb.append("update inther_lc.ctl_controller set hostname =")
            .append("'10.0.0.8'")
            .append(" where ");
    int i = 1;
    for (String wall : walls)
    {
      sb.append("id not like ").append("'%").append(wall).append("%'");
      if (i != walls.length)
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
