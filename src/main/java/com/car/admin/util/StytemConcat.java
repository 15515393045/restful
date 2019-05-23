package com.car.admin.util;

public final class StytemConcat {

    public static final int STATUS_ERROR = 0;

    public static final int STATUS_SUCCESS = 1;

    public static final long EXECUTE_TIME_ERROR = -1;

    public static final String FILE_PATH = "ShopImg/";

    public static final String IMA_CODE = "imgCode";

    public static final String SALT_UUID = "aisdhiahsidhasas";

    public static final int LOGIN_FLAG = 3;

    public static final int LOGIN_STATUS = 1;

    public static final String THROUGH_URL = "login.jhtml,enrollUser.jhtml,api/product/list.jhtml";

    public static final String OREDR_COLUMN =  "order[0][column]";

    public static final String OREDR_DIR =  "order[0][dir]";

    /*cos相关*/
    public static final String COS_ACCESSKEY = "AKIDA8qJYasyKlzzkGwaNuEKA4jIcgU47ZU9";
    public static final String COS_SECRETKEY = "qTqyrVu4zpQlrjNmvob9Tu88sMbkUzJQ";
    public static final String COS_BUCKET = "fh-1808-1258898786";
    public static final String COS_REGION = "ap-beijing";
    public static final String COS_URL = "http://fh-1808-1258898786.cos.ap-beijing.myqcloud.com/";

/*    //使用Map做映射   方法一
    public static final Map ORDER_MAP = new HashMap();

    //静态块,它和静态变量一样,在加载的时候就会执行,静态块只能调用静态的。
        static{
        ORDER_MAP.put("errorLoginTime","errorLoginTime");
        ORDER_MAP.put("birthday","birthday");
        ORDER_MAP.put("loginCount","loginCount");
            }*/

    //方法二 使用Gson,将Json字符串转换为指定的Java对象
    public static final String OREDR_GSON = "{errorLoginTime:errorLoginTime,birthday:birthday,loginCount:loginCount}";

}