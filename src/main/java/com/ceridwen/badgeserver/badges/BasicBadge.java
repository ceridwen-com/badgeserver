/* 
package com.ceridwen.badgeserver.badges;

import com.ceridwen.badgeserver.AbstractBadgeServlet;
import com.ceridwen.badgeserver.BadgeData;
import java.util.Arrays;
import java.util.Iterator;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Matthew
 */
@WebServlet(
	name = "badge",
	urlPatterns = "/badge/*"
)
public class BasicBadge extends AbstractBadgeServlet {

  @Override
  protected BadgeData getBadgeData(HttpServletRequest request) {
    BadgeData data;
    
    String parameters = StringUtils.strip(StringUtils.defaultString(request.getPathInfo()), "/");
       
    Iterator<String> components = Arrays.asList(parameters.split("-")).iterator();
    
    data = new BadgeData(request);
    
    if (components.hasNext()) {
      data.setCaption(components.next());
    }
    
    if (components.hasNext()) {
      data.setMessage(components.next());
    }
    if (components.hasNext()) {
      data.setMessageColour(components.next());
    }
    
    return data;
  }
  
}