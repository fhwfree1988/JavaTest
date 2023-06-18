package Sample.Collections.Map.HashMap;


import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashMapEntrySetExample {

    //https://www.journaldev.com/11560/java-hashmap
    /*
    This entrySet is backed by HashMap, so any changes in map reflects in entry set and vice versa
     */
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", null);
        map.put(null, "100");

        Set<Entry<String,String>> entrySet = map.entrySet();
        Iterator<Entry<String, String>> iterator = entrySet.iterator();
        Entry<String, String> next = null;

        System.out.println("map before processing = "+map);
        System.out.println("entrySet before processing = "+entrySet);
        while(iterator.hasNext()){
            next = iterator.next();
            System.out.println("Processing on: "+next.getValue());
            if(next.getKey() == null) iterator.remove();
        }

        System.out.println("map after processing = "+map);
        System.out.println("entrySet after processing = "+entrySet);

        Entry<String, String> simpleEntry = new AbstractMap.SimpleEntry<String, String>("1","1");
        entrySet.remove(simpleEntry);
        System.out.println("map after removing Entry = "+map);
        System.out.println("entrySet after removing Entry = "+entrySet);

        //---------------------------------
        List<String> fruits = Arrays.asList("apple","mango");
        System.out.println(fruits.stream().map(fruit -> fruit.split("")).flatMap(Arrays::stream).collect(Collectors.toSet()));

        List<String> lst = StringToList();


        BCodeDto bCodeDto = new BCodeDto();
       /* bCodeDto.setSerialCode("012345678901");
        bCodeDto.setStatusCode("1");
        bCodeDto.setMoeinCode("01");
        bCodeDto.setBudgetIncomeCode("150101");
        bCodeDto.setProvinceCode("82");
        bCodeDto.setOrganizationCode("0115");
        bCodeDto.setIdCharacteristicCode("2");
        bCodeDto.setCost("000999910000000");*/

        bCodeDto.setSerialCode("111111111111");
        bCodeDto.setStatusCode("2");
        bCodeDto.setMoeinCode("01");
        bCodeDto.setBudgetIncomeCode("150101");
        bCodeDto.setProvinceCode("74");
        bCodeDto.setOrganizationCode("0115");
        bCodeDto.setIdCharacteristicCode("2");
        bCodeDto.setCost("000000000245551");

        /*bCodeDto.setSerialCode("111111111112");
        bCodeDto.setStatusCode("2");
        bCodeDto.setMoeinCode("01");
        bCodeDto.setBudgetIncomeCode("150101");
        bCodeDto.setProvinceCode("74");
        bCodeDto.setOrganizationCode("0115");
        bCodeDto.setIdCharacteristicCode("2");
        bCodeDto.setCost("000000000362543");*/

        /*bCodeDto.setSerialCode("111111111115");
        bCodeDto.setStatusCode("2");
        bCodeDto.setMoeinCode("01");
        bCodeDto.setBudgetIncomeCode("150101");
        bCodeDto.setProvinceCode("74");
        bCodeDto.setOrganizationCode("0115");
        bCodeDto.setIdCharacteristicCode("2");
        bCodeDto.setCost("000000000101001");*/

       /* bCodeDto.setSerialCode("111111111118");
        bCodeDto.setStatusCode("2");
        bCodeDto.setMoeinCode("01");
        bCodeDto.setBudgetIncomeCode("150101");
        bCodeDto.setProvinceCode("74");
        bCodeDto.setOrganizationCode("0115");
        bCodeDto.setIdCharacteristicCode("2");
        bCodeDto.setCost("000000000060103");*/

        String bCode = generateCodeString(bCodeDto);
        bCode.toString();
    }

    private static List<String> StringToList(){
        List<String> serialCode = new ArrayList<>(13);
        String val = "012345678910";
        serialCode = Stream.of(val.split("")).collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder(12);
        stringBuilder.append("12345678910");
        return serialCode;
    }


    /*----------------BehdadCode------------------------*/
    public static String generateCodeString(BCodeDto bCodeDto){
        List<String> CodeArray = generateCodeArray(bCodeDto);
        String code = String.join("", CodeArray);
        String X = Verhoeff.generateVerhoeff(code);

        List<String> CodeArrayReversed = generateCodeArrayReversed(bCodeDto);
        String codeReversed = String.join("", CodeArrayReversed);
        String Y = Verhoeff.generateVerhoeff(codeReversed);

        CodeArray.add(1,X);
        CodeArray.add(2,Y);
        String behCode = String.join("", CodeArray);
        return behCode;
    }
    public static List<String> generateCodeArray(BCodeDto bCodeDto){
        List<String> CodeArray = GenerateCode(bCodeDto);
        CodeArray.addAll(Stream.of(bCodeDto.getCost().split("")).collect(Collectors.toList()));
        return CodeArray;
    }

    private static List<String> generateCodeArrayReversed(BCodeDto bCodeDto){
        List<String> CodeArrayReversed = GenerateCode(bCodeDto);
        Collections.reverse(CodeArrayReversed);

        List<String> costReversed = Stream.of(bCodeDto.getCost().split("")).collect(Collectors.toList());
        Collections.reverse(costReversed);
        CodeArrayReversed.addAll(costReversed);
        return CodeArrayReversed;
    }

    private static List<String> GenerateCode(BCodeDto bCodeDto){
        List<String> behdadCodeArray = new ArrayList<>(50);

        behdadCodeArray.addAll(Stream.of(bCodeDto.getIdCharacteristicCode().split("")).collect(Collectors.toList()));
        behdadCodeArray.addAll(Stream.of(bCodeDto.getOrganizationCode().split("")).collect(Collectors.toList()));
        behdadCodeArray.addAll(Stream.of(bCodeDto.getProvinceCode().split("")).collect(Collectors.toList()));
        behdadCodeArray.addAll(Stream.of(bCodeDto.getBudgetIncomeCode().split("")).collect(Collectors.toList()));
        behdadCodeArray.addAll(Stream.of(bCodeDto.getMoeinCode().split("")).collect(Collectors.toList()));
        behdadCodeArray.addAll(Stream.of(bCodeDto.getStatusCode().split("")).collect(Collectors.toList()));
        behdadCodeArray.addAll(Stream.of(bCodeDto.getSerialCode().split("")).collect(Collectors.toList()));

        return behdadCodeArray;
    }

   /* private static String generateSerialCode(BCodeDto bCodeDto){
        List<String> serialCode = new ArrayList<>(13);
        String val = "12345678910";
        return val;
    }*/
}
