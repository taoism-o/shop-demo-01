package xin.kevincheng.my.shop.web.admin.utils;

import cn.hutool.Hutool;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author kc
 * @title
 * @description The class breadCrumbUtils is for
 * @date Create in 0:48 2019/12/5
 */
@Component
public class BreadCrumbUtils {

    /**
     * @Author k5068
     * @Date 2019/12/5 1:32
     * @Description This is description of method get bread crumb links
     * @Param [request]
     * @Return java.util.ArrayList<java.lang.String>
     * @Since
     */
    public static ArrayList<String> getBreadCrumbLinks(HttpServletRequest request) {
        ArrayList<String> breadCrumbLinksList = new ArrayList<String>();
        String servletPath = request.getServletPath();
        String[] breadCrumbLinksSplit = servletPath.split("/");
        StringBuilder linkSb = new StringBuilder();

        for (String split : breadCrumbLinksSplit) {
            if (StrUtil.equals("main", split) && Arrays.binarySearch(breadCrumbLinksSplit, split) == breadCrumbLinksSplit.length - 1){
                breadCrumbLinksList.clear();
                breadCrumbLinksList.add("/main/");
                break;
            }

            if (StrUtil.endWith(linkSb.toString(), "/")) {
                linkSb.append(split).append("/");
            }

            // if blank means root link
            if (StrUtil.isBlank(split)) {
                linkSb.append("/main/");
            }


            breadCrumbLinksList.add(linkSb.toString());
        }


        return breadCrumbLinksList;
    }
}
