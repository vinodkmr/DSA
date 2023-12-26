package com.core.java.test;

import org.apache.commons.codec.binary.Hex;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericPackager;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CoreJava {

    public static void main(String[] args) throws ParseException, ISOException, ExecutionException, InterruptedException, TimeoutException, IOException {
//        ORCheck();
//        ORUltaCheck();
//        functionalTest();
//        bitOperatorCheck();
       /* int[] ints = twoSum(new int[]{3,2,4}, 6);
        System.out.println("out "+ints[0]+""+ints[1]);*/
        //dateFormatter();
        //charTest();
        //StrIndexTest();
       //formatDateTest();
//        renameFile();
//        System.out.println(makeGM TDate(new Date(), "yDDD"));
//        decodeCavv();
//        fxTest();
//        sporgTest();
//        subStrtest();
//        httpClientAsyncTest();
//        Thread.currentThread().sleep(100000);
//        comparatorTest();
//        streamTest();
        stringTest();
    }

    private static void stringTest() {
        String str = "Sou of Dia";
        String[] s = str.split(" ");
        System.out.printf(Arrays.toString(s));
        for (String st : s){
            System.out.println(st);
        }

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(10);
        int i = atomicInteger.incrementAndGet();
        System.out.println(i);
        System.out.println(atomicInteger.get());
        atomicInteger.compareAndSet(11,12);
        System.out.println(atomicInteger.get());
    }

    private static void streamTest() {
        /*Employee e1 = new Employee(Profile.DEV, 100);
        Employee e2 = new Employee(Profile.CEO, 100);*/
       // List<Employee> employeeList = Arrays.asList(e1, e2);
   /*     Employee.collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getSalary));
        System.out.println(Employee.collect);
        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        System.out.println(stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
        int[] intArr = {10,20,30,-1,-2};
        OptionalInt max = Arrays.stream(intArr).max();*/
//        System.out.println(max.orElse(-1));

    }

 /*   private static void comparatorTest() {
        List<Employee> list = Arrays.asList(new Employee(Profile.HR, 100),
                new Employee(Profile.HR, 1100),
                new Employee(Profile.DEV, 200));
        list.sort((o1, o2) -> {
            int diff = o1.getProfile().value - o2.getProfile().value;
            if (diff != 0) return diff;
            return o2.getSalary() - o1.getSalary();
        });
        System.out.println(list);
    }*/

    private static void httpClientAsyncTest() throws IOException, ExecutionException, InterruptedException, TimeoutException {

        URL url = new URL("https://google.com");
        System.out.println(url.getHost()+url.getPort());
        HttpURLConnection huc = (HttpURLConnection) url.openConnection();

        int responseCode = huc.getResponseCode();
        System.out.println(responseCode);


        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(2))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8095/settlementservice/api/v1/jobs/settlement/visa"))
                .build();


        CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> res = response.get(10, TimeUnit.MINUTES);
        System.out.println(res.body());
        System.out.println("success async");
    }

    private static void subStrtest() {
        System.out.println("PayU Pay=Test MerchantTest 1234567dfgfdgfdgfg".substring(0,38).length());
    }

    private static void sporgTest() {
        File file = new File("D:\\accosa\\accosa_pg\\files\\amex\\gsmf_response\\16479914\\incoming\\AXISBKWIBMOTST.SPORG#P64NJ93060113L");
        String name = file.getName();
        System.out.println(name);
        System.out.println(name.split("\\.")[1].contains("SPORG"));
    }


    private static void fxTest() {
        final DecimalFormat DF = new DecimalFormat("#.00");
        double expFactor = Math.pow(10,3); // getting exponent value with base of 10 for amount conversion and calculations
            double destExpFactor = Math.pow(10,2); //Exponent 2 for inr conversion
            double ttRate = 269.17195578;
         double markupExRate = Double.parseDouble(String.valueOf(0)) / 100;
         double newMarkupRate = (100 + markupExRate) / 100;

            long finalGrossAmt = (long) (((Double.parseDouble(String.valueOf(107614123 / expFactor))) * ttRate
                    * newMarkupRate) * destExpFactor);
        long finalGrossAmtWithDec = ((long) ((Double.parseDouble(DF.format(107614123 / expFactor)) * ttRate
                * newMarkupRate) * destExpFactor));
        System.out.println("final Gross Amt "+finalGrossAmt);
        System.out.println(finalGrossAmtWithDec);
        }


    private static void decodeCavv() throws ISOException {
        //00 00 01 05 67 12 34 87 63 79 46 53 86 63 47 00 00 00 00 00
        String aevv = "AAABBWcSNIdjeUZThmNHAAAAAAA=";
        System.out.println(ISOUtil.hexString(aevv.getBytes()));
        System.out.println(decodeCavv(aevv));
    }

    public static String decodeCavv(String cavv) throws ISOException {
        GenericPackager genericPackager = new GenericPackager("jar:amex.xml");
        ISOMsg iso = new ISOMsg();
        iso.setPackager(genericPackager);
        byte[] jk = java.util.Base64.getDecoder().decode(cavv);
        String x1 = ISOUtil.hexString(jk);
        System.out.println(x1);
        String eci = "05";
        String xidv = "/wAAAAEAwDLsGmUAmbHTglMAAAA=";
        iso.set(61,"AX" + "ASK" + eci + "AEVV" + cavv +"XID" + xidv );
        System.out.println(ISOUtil.hexString(iso.pack()));
        iso.dump(System.out,"");
        String x = new String(jk);
        System.out.println("str "+x);
        System.out.println("hex str from bytes "+ x1 +" hex str from str "+ISOUtil.hexString(x.getBytes()));

        return Hex.encodeHexString(jk, false);
    }
    public static String makeGMTDate(java.util.Date date, String format) {
        if (format == null)
            format = "yyMMdd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+00:50"));
        String txTime;
        try {
            txTime = sdf.format(date);
        } catch (Exception e) {
           e.printStackTrace();
            txTime = "";
        }
        System.out.println(txTime.substring(4,6));
       /* String julianDate = Utility.makeLocalDate(bean.getTransmissionDateTime(), "yDDD");

        String rrn = julianDate.substring(1) + txnDate + map.get("DE11");*/
        return txTime;
    }


    private static void renameFile() {
        java.io.File file = new java.io.File("D:\\New Text Document.txt");
        file.renameTo(new File("test"));
    }

    private static void formatDateTest() throws ParseException {
        String fileNameToBeProcessed = "Mapping_Blazecard_new_format_2023_08_12.csv";
        String strDate = fileNameToBeProcessed.substring(fileNameToBeProcessed.indexOf("20"),
                fileNameToBeProcessed.indexOf("20") + 11);
        System.out.println(strDate);
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
        System.out.println(date);
    }

    private static void StrIndexTest() {
        System.out.println("flow".startsWith("flower"));
    }

    private static void charTest() {
        char c = 'a';
        System.out.println(c);
    }

    private static void dateFormatter() {
        System.out.println(DateTimeFormatter.ofPattern("yyMMddhhmmss").format(LocalDateTime.now()));
    }

    private static void bitOperatorCheck() {
        System.out.println(10/2);
        System.out.println(10 >> 1);
    }

    private static void functionalTest() {
        test(e -> e % 2 == 0, 2);
    }

    private static void test(Predicate<Integer> predicate, int a) {
        boolean test = predicate.test(a);
        System.out.println(test);
    }

    private static void ORCheck() {
        boolean isRecursionTxn = true;
        int amount = 100;
        final int VISA_SIRECUR_AMTFORVALIDATION = 15000;

        if (isRecursionTxn && amount <= VISA_SIRECUR_AMTFORVALIDATION) {
            System.out.println("Not doing anythin");
        } else {
            System.out.println("appending message hash");
        }
    }

    private static void ORUltaCheck() {
        boolean isRecursionTxn = true;
        int amount = 100;
        final int VISA_SIRECUR_AMTFORVALIDATION = 15000;

        if (!isRecursionTxn || amount > VISA_SIRECUR_AMTFORVALIDATION) {
            System.out.println("Appending message hash in ulta");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] out = null;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    out = new int[]{i, j};
                }
            }
        }
        for (int i = 0; i<out.length; i++){
            System.out.println(out[i]);
        }
        return nums;
    }

  /*  public void inheritanceTest(){
        ArrayList<A> list = new ArrayList<>();
        list.add(new B());
        list.add(new C());
        for (A a : list){
            a.X();
            a.Y();
        }
    }*/
}

interface  A{ void X();}
class  B implements  A{
    public void X() {}
}

class  C extends  B{
    public void Y(){};
}

class Employee{
    @Override
    public String toString() {
        return "Employee{" +
                "year=" + year +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }

    public static Map<Integer, List<Employee>> collect;
    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    private Profile profile;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private int year;
    private int salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Employee(int salary, int id, int year) {
        this.salary = salary;
        this.id = id;
        this.year = year;
    }

}

enum Profile{
    HR(1),
    CEO(10),
    DEV(2);

    public int value;
    Profile(int value) {
        this.value = value;
    }

}

