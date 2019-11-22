package httpPostRequest.tools;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils extends Date {
    private static final long serialVersionUID = 2155545266875552658L;

    /**
     * 语言表示
     */
    public static final String LANGUAGE_CHINESE = "Chinese";

    /**
     * 语言表示
     */
    public static final String LANGUAGE_JAPANESE = "Japanese";

    /** 中文星期字符 */
    private static final String[] CHINESE_WEEKS = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

    /** 日文星期字符 */
    private static final String[] JAPANESE_WEEKS = { "日曜日", "月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日" };

    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FMT_YMDHMSS = "yyyyMMddHHmmss";

    static int dateBetwwen(Calendar bcal, Calendar scal) {
        long time1 = bcal.getTimeInMillis();
        long time2 = scal.getTimeInMillis();

        long between_days = (time1 - time2) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));

    }

    public static long getYYYYMMDD(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
        String str = sdf.format(date);
        return sdf.parse(str).getTime();

    }

    public static Date getWeekMonday() {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 功能：转换为Calendar。
     *
     * @return Calendar
     */
    public Calendar toCalendar() {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        return c;
    }

    /**
     * 功能：判断日期是否和当前date对象在同一天。
     *
     * @param date 比较的日期
     * @return boolean 如果在返回true，否则返回false。
     */
    public boolean isSameDay(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("日期不能为null");
        }
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date);
        return this.isSameDay(cal2);
    }

    /**
     * 功能：判断日期是否和当前date对象在同一天。
     *
     * @param cal 比较的日期
     * @return boolean 如果在返回true，否则返回false。
     */
    public boolean isSameDay(Calendar cal) {
        if (cal == null) {
            throw new IllegalArgumentException("日期不能为null");
        }
        // 当前date对象的时间
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(this);
        return (cal1.get(Calendar.ERA) == cal.get(Calendar.ERA) && cal1.get(Calendar.YEAR) == cal.get(Calendar.YEAR)
                && cal1.get(Calendar.DAY_OF_YEAR) == cal.get(Calendar.DAY_OF_YEAR));
    }

    /**
     * 功能：将当前日期的秒数进行重新设置。
     *
     * @param second 秒数
     * @return 设置后的日期
     */
    public Date setSecondNew(int second) {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.SECOND, second);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 功能：将当前日期的分钟进行重新设置。
     *
     * @param minute 分钟数
     * @return 设置后的日期
     */
    public Date setMinuteNew(int minute) {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.MINUTE, minute);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 功能：将当前日期的小时进行重新设置。
     *
     * @param hours 小时数 (24小时制)
     * @return 设置后的日期
     */
    public Date setHourNew(int hour) {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.HOUR_OF_DAY, hour);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 功能：将当前日期的天进行重新设置。
     *
     * @param days 某一天
     * @return 设置后的日期
     */
    public Date setDayNew(int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.DATE, day);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 功能：将当前日期的月进行重新设置。
     *
     * @param months 某一月
     * @return 设置后的日期
     */
    public Date setMonthNew(int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.MONTH, month - 1);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 功能：将当前日期的年进行重新设置。
     *
     * @param years 某一年
     * @return 设置后的日期
     */
    public Date setYearNew(int year) {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.YEAR, year);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 功能：得到当月有多少天。
     *
     * @return int
     */
    public int daysNumOfMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this);
        return cal.getActualMaximum(Calendar.DATE);
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss字符串转换成日期(net.maxt.util.Date)<br/>
     *
     * @param dateStr 时间字符串
     * @param         当前时间字符串的格式。
     * @return net.maxt.util.Date 日期 ,转换异常时返回null。
     */
    public static Date parseDate(String dateStr, SimpleDateFormat dataFormat) {
        try {
            Date d = dataFormat.parse(dateStr);
            return new Date(d.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss字符串转换成日期(net.maxt.util.Date)<br/>
     *
     * @param dateStr yyyy-MM-dd HH:mm:ss字符串
     * @return net.maxt.util.Date 日期 ,转换异常时返回null。
     */
    public static Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d = sdf.parse(dateStr);
            return new Date(d.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 功能：当前时间增加毫秒数。
     *
     * @param milliseconds 正值时时间延后，负值时时间提前。
     * @return Date
     */
    public Date addMilliseconds(int milliseconds) {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.MILLISECOND, c.get(Calendar.MILLISECOND) + milliseconds);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 功能：当前时间增加秒数。
     *
     * @param seconds 正值时时间延后，负值时时间提前。
     * @return Date
     */
    public Date addSeconds(int seconds) {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.SECOND, c.get(Calendar.SECOND) + seconds);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 功能：当前时间增加分钟数。
     *
     * @param minutes 正值时时间延后，负值时时间提前。
     * @return Date
     */
    public Date addMinutes(int minutes) {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.MINUTE, c.get(Calendar.MINUTE) + minutes);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 功能：当前时间增加小时数。
     *
     * @param hours 正值时时间延后，负值时时间提前。
     * @return Date
     */
    public Date addHours(int hours) {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.HOUR, c.get(Calendar.HOUR) + hours);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 功能：当前时间增加天数。
     *
     * @param days 正值时时间延后，负值时时间提前。
     * @return Date
     */
    public Date addDays(int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.DATE, c.get(Calendar.DATE) + days);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 功能：当前时间增加月数。
     *
     * @author 沙琪玛 QQ：862990787 May 29, 2013 11:26:27 AM
     * @param months 正值时时间延后，负值时时间提前。
     * @return Date
     */
    public Date addMonths(int months) {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.MONTH, c.get(Calendar.MONTH) + months);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 功能：当前时间增加年数。注意遇到2月29日情况，系统会自动延后或者减少一天。
     *
     * @param years 正值时时间延后，负值时时间提前。
     * @return Date
     */
    public Date addYears(int years) {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.YEAR, c.get(Calendar.YEAR) + years);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 得到秒。格式：56<br/>
     *
     * @return int
     */
    public int secondInt() {
        return Integer.parseInt(toString("ss"));
    }

    /**
     * 得到分钟。格式：56<br/>
     *
     * @return int
     */
    public int minuteInt() {
        return Integer.parseInt(toString("mm"));
    }

    /**
     * 得到小时。格式：23<br/>
     *
     * @return int
     */
    public int hourInt() {
        return Integer.parseInt(toString("HH"));
    }

    /**
     * 得到日。格式：26<br/>
     * 注意：这里1日返回1,2日返回2。
     *
     * @return int
     */
    public int dayInt() {
        return Integer.parseInt(toString("dd"));
    }

    /**
     * 得到月。格式：5<br/>
     * 注意：这里1月返回1,2月返回2。
     *
     * @return int
     */
    public int monthInt() {
        return Integer.parseInt(toString("MM"));
    }

    /**
     * 得到年。格式：2013
     *
     * @return int
     */
    public int yearInt() {
        return Integer.parseInt(toString("yyyy"));
    }

    /**
     * 得到短时间。格式：12:01
     *
     * @return String
     */
    public String shortTime() {
        return toString("HH:mm");
    }

    /**
     * 得到长时间。格式：12:01:01
     *
     * @return String
     */
    public String longTime() {
        return toString("HH:mm:ss");
    }

    /**
     * 得到今天的第一秒的时间。
     *
     * @return Date
     */
    public Date dayStart() {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 得到当前所在自然月的第一天的开始,格式为长日期格式。例如：2012-03-01 00:00:00。
     *
     * @return Date
     * @throws ParseException
     */
    public Date monthStart() throws ParseException {
        Calendar c = Calendar.getInstance();
        String startStr = toString("yyyy-MM-") + c.getActualMinimum(Calendar.DATE) + " 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(startStr);
    }

    public Date monthEnd() throws ParseException {
        Calendar c = Calendar.getInstance();
        String startStr = toString("yyyy-MM-") + c.getActualMaximum(Calendar.DATE) + " 23:59:59";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(startStr);
    }

    public Date monthStart(String yyyymm) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Calendar c = Calendar.getInstance();
        this.setTime(sdf.parse(yyyymm).getTime());
        c.setTime(sdf.parse(yyyymm));
        String startStr = toString("yyyy-MM-") + c.getActualMinimum(Calendar.DATE) + " 00:00:00";
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(startStr);
    }

    public Date monthEnd(String yyyymm) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Calendar c = Calendar.getInstance();
        this.setTime(sdf.parse(yyyymm).getTime());
        c.setTime(sdf.parse(yyyymm));
        String startStr = toString("yyyy-MM-") + c.getActualMaximum(Calendar.DATE) + " 23:59:59";
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(startStr);
    }

    /**
     * 得到今天的最后一秒的时间。
     *
     * @return Date
     */
    public Date dayEnd() {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 根据日期得到星期几,得到数字。<br/>
     * 7, 1, 2, 3, 4, 5, 6
     *
     * @return Integer 如：6
     */
    public int dayOfWeekInt() {
        Integer dayNames[] = { 7, 1, 2, 3, 4, 5, 6 };
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek < 0)
            dayOfWeek = 0;
        return dayNames[dayOfWeek];
    }

    /**
     * 将日期转换成长日期字符串 例如：2009-09-09 01:01:01
     *
     * @return String
     */
    public String toLongDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return (null == this) ? null : df.format(this);
    }

    /**
     * 将日期按照一定的格式进行格式化为字符串。<br/>
     * 例如想将时间格式化为2012-03-05 12:56 ,则只需要传入formate为yyyy-MM-dd HH:mm即可。
     *
     * @param formate 格式化格式，如：yyyy-MM-dd HH:mm
     * @return String 格式后的日期字符串。如果当前对象为null，则直接返回null。
     */
    public String toString(String formate) {
        DateFormat df = new SimpleDateFormat(formate);
        return (null == this) ? null : df.format(this);
    }

    /**
     * 得到某个时间的时间戳yyyyMMddHHmmss。
     *
     * @param date 时间
     * @return String 如果当前对象为null，则直接返回null。
     */
    public String toTimeStamp() {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return (null == this) ? null : df.format(this);
    }

    /**
     * 将日期转换成短日期字符串,例如：2009-09-09。
     *
     * @return String ,如果当前对象为null，返回null。
     */
    public String toShortDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return (null == this) ? null : df.format(this);
    }

    /**
     * 功能：用java.util.Date进行构造。
     *
     * @author
     * @param java.util.Date date
     */
    public DateUtils(Date date) {
        super(date.getTime());
    }

    /**
     * 功能：用毫秒进行构造。
     *
     * @author
     * @param timeInMillis
     */
    public DateUtils(long timeInMillis) {
        super(timeInMillis);
    }

    /**
     * 功能：默认构造函数。
     *
     * @author
     */
    public DateUtils() {
        super();
    }

    /**
     * 求出指定的时间那天是中文星期几，默认返回中文
     *
     * @param date 指定的时间
     * @return 星期X
     */
    public static String getWeekString(Date date, String language) {

        String result = "";

        // 根据语言判断返回的结果
        if (LANGUAGE_CHINESE.equals(language)) {
            result = DateUtils.CHINESE_WEEKS[getWeek(date) - 1];
        }
        if (LANGUAGE_JAPANESE.equals(language)) {
            result = DateUtils.JAPANESE_WEEKS[getWeek(date) - 1];
        } else { // 默认返回中文
            result = DateUtils.CHINESE_WEEKS[getWeek(date) - 1];
        }
        return result;
    }

    /**
     * @Title getCurrentTimestamp
     * @Description 获取系统当前时间戳
     * @param
     * @return long
     */
    public static long getCurrentTimestamp() {
        long timeStamp = new Date().getTime();
        return timeStamp;
    }

    /**
     * 得到指定时间的时间日期格式
     *
     * @param date   指定的时间
     * @param format 时间日期格式
     * @return
     */
    public static String getFormatDateTime(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    public static Date getStringToDate(String format, String timeStr) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(timeStr);
    }

    /**
     * 判断指定时间是否是周末
     *
     * @param date 指定的时间
     * @return true:是周末,false:非周末
     */
    public static boolean isWeeks(Date date) {
        boolean isWeek = false;
        isWeek = (getWeek(date) - 1 == 0 || getWeek(date) - 1 == 6);
        return isWeek;
    }

    /**
     * 求出指定时间那天是星期几
     *
     * @param date 指定的时间
     * @return 1-7
     */
    public static int getWeek(Date date) {
        int week = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        week = cal.get(Calendar.DAY_OF_WEEK);
        return week;
    }

    /**
     * 判断是否是润年
     *
     * @param date 指定的年
     * @return true:是润年,false:不是润年
     */
    public static boolean isLeapYear(int year) {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.isLeapYear(year);
    }

    /**
     * 得到某年某月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(int year, int month) {
        Calendar cl = Calendar.getInstance();
        cl.set(Calendar.YEAR, year);
        cl.set(Calendar.MONTH, month - 1);
        cl.set(Calendar.DAY_OF_MONTH, 1);
        return cl.getTime();
    }

    /**
     * 根据当前传入日期指定当前日期几年后的日期
     *
     * @param date
     * @param year
     * @return
     */
    public static String getSpecifiedYearAfter(Date date, int year) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int currentyear = c.get(Calendar.YEAR);
        c.set(Calendar.YEAR, currentyear + year);
        String yearAfter = getFormatDateTime(c.getTime(), "yyyy-MM-dd");
        return yearAfter;
    }

    /**
     * 根据当前传入日期指定当前日期几年后的日期
     *
     * @param date
     * @param year
     * @return
     */
    public static int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 根据当前传入日期指定当前日期几月后的日期
     *
     * @param date
     * @param year
     * @return
     */
    public static String getSpecifiedMonthAfter(Date date, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int currentyear = c.get(Calendar.MONTH);
        c.set(Calendar.MONTH, currentyear + month);
        String monthAfter = getFormatDateTime(c.getTime(), "yyyy-MM-dd");
        return monthAfter;
    }

    /**
     * 根据当前传入日期指定当前日期几天后的日期
     *
     * @param date
     * @param day
     * @return
     */
    public static String getSpecifiedDayAfter(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int currentday = c.get(Calendar.DATE);
        c.set(Calendar.DATE, currentday + day);
        String monthAfter = getFormatDateTime(c.getTime(), "yyyy-MM-dd");
        return monthAfter;
    }

    /**
     * 根据传入月份获取指定英语月份
     *
     * @param month
     * @return
     */
    public static String getMonth(String month) {
        Map<String, String> dateMap = new HashMap<String, String>();
        dateMap.put("01", "Jan");// 一月
        dateMap.put("02", "Feb");// 二月
        dateMap.put("03", "Mar");// 三月
        dateMap.put("04", "Apr");// 四月
        dateMap.put("05", "May");// 五月
        dateMap.put("06", "Jun");// 六月
        dateMap.put("07", "Jul");// 七月
        dateMap.put("08", "Aug");// 八月
        dateMap.put("09", "Sep");// 九月
        dateMap.put("10", "Oct");// 十月
        dateMap.put("11", "Nov");// 十一月
        dateMap.put("12", "Dec");// 十二月
        return dateMap.get(month);
    }

    /**
     * 对指定日期指定类型加减
     *
     * @param date 指定日期
     * @param type 2-月份 3-星期 5-每日 10-小时 12-分钟 13-秒
     * @param num
     * @return
     */
    public static Date addOrMinusYear(Date date, int type, int num) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(type, num);
        return cal.getTime();
    }

    public static String getTimeStamp() {
        int time = (int) (System.currentTimeMillis() / 1000);
        return String.valueOf(time);
    }

    public static Date getBeforeDaysX(Date date, Integer d) {
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); // 得到日历
        calendar.setTime(date);// 把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -d); // 设置为前x天
        dBefore = calendar.getTime(); // 得到前2天的时间
        return dBefore;
    }

    public static Date getHoursBefore(Date date, Integer h) {
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); // 得到日历
        calendar.setTime(date);// 把当前时间赋给日历
        calendar.add(Calendar.HOUR, -h); // 设置为前h小时
        dBefore = calendar.getTime();
        return dBefore;
    }

    /**
     * 日期转指定格式字符串
     * @param date
     * @param format
     * @return
     * zhangll
     */

    public static String date2Str(Date date, String format) {
        if (date == null) {
            return null;
        }
        //if (StringUtils.isEmpty(format)) {
        //    return null;
        //}
        String sRet = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            sRet = formatter.format(date).toString();
        } catch (Exception ex) {
            sRet = null;
        }
        return sRet;
    }

    // Date直接转String 暂时供Date 转 Timestamp 转
    public static String date2String(Date date) {
        return date2Str(date, FORMAT);
    }

    /**
     * 当期日
     *
     * @return
     */
    public static int getCurrentDay() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DATE);
    }

    public static Date getCurrentYM(int gap, int day) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 0);
        cal.add(Calendar.MONTH, gap);

        cal.set(Calendar.DATE, day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    public static Date getLastYMD() {
        Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
        ca.setTime(new Date()); // 设置时间为当前时间
        ca.add(Calendar.MONTH, -1);
        return ca.getTime();
    }

    // 指定时间往后推一个月
    public static Date getAfterYMD(Date date) {
        Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
        ca.setTime(date); // 设置时间为当前时间
        ca.add(Calendar.MONTH, 1);
        return ca.getTime();
    }

    // 在两个时间之间生成一个随机时间
    public static Date randomDate(Date beginDate, Date endDate) {
        try {

            if (beginDate.getTime() >= endDate.getTime()) {
                return null;
            }
            long date = random(beginDate.getTime(), endDate.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 在两个时间之间生成一个随机时间
    private static long random(long begin, long end) {
        long rtnn = begin + (long) (Math.random() * (end - begin));
        if (rtnn == begin || rtnn == end) {
            return random(begin, end);
        }
        return rtnn;
    }

    /**
     * 格式化日期
     * @param d
     * @param ptn
     * @return
     * zhangll
     */
    public static String formatDate(Date d, String ptn) {
        SimpleDateFormat sf = new SimpleDateFormat(ptn);
        return sf.format(d);
    }

    /**
     * 格式化日期
     * @param str
     * @param ptn
     * @return
     * @throws ParseException
     * zhangll
     */
    public static Date parse(String str, String ptn) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat(ptn);
        return sf.parse(str);
    }

    /**
     * 获取年龄
     * @param dateOfBirth
     * @return
     * zhangll
     */
    public static int getAge(Date dateOfBirth) {
        int age = 0;
        Calendar born = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        if (dateOfBirth != null) {
            now.setTime(new Date());
            born.setTime(dateOfBirth);
            age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);
            if (now.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR)) {
                age -= 1;
            }
        }
        return age;
    }

    public static Date getYear(int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, month);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 指定日期的（24小时制）最晚时间，精确到时分秒。
     * @param date
     * @return
     * zhangll
     */
    public static Date dayEnd(Long date) {
        if (null == date) {
            return null;
        }
        Date date_1 = new Date(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date_1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return new Date(calendar.getTimeInMillis());
    }

    /**
     * 指定日期的（24小时制）最早时间，精确到时分秒。
     * @param date
     * @return
     * zhangll
     */
    public static Date dayStart(Long date) {
        if (null == date) {
            return null;
        }
        Date date_1 = new Date(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date_1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return new Date(calendar.getTimeInMillis());
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            System.out.println(getAge(sdf.parse("2020-02-21 09:20:00")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

