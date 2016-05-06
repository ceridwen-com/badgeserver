/*  * Copyright 2016 Matthew J. Dovey (www.ceridwen.com). * * Licensed under the Apache License, Version 2.0 (the "License"); * you may not use this file except in compliance with the License. * You may obtain a copy of the License at * *      http://www.apache.org/licenses/LICENSE-2.0 * * Unless required by applicable law or agreed to in writing, software * distributed under the License is distributed on an "AS IS" BASIS, * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. * See the License for the specific language governing permissions and * limitations under the License. */
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
