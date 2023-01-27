/*
 Задание 1.

Дана строка sql-запроса "select * from students where ".
Сформируйте часть WHERE этого запроса, используя StringBuilder.
Данные приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.
Входная строка:

{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Выходная строка:

select * from students where name = "Ivanov" and country = "Russia" and city = "Moscow"
 */
public class Task_1 {

    public static void main(String[] args) {

    System.out.print("\033\143");
    String request = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
    System.out.println(request);
    String newR = request.replace('"', ' ').replace('{', ' ').replace('}', ' ');
    String[] array = newR.split(",");
    StringBuilder sb = new StringBuilder();
    sb.append("select * from students where ");
    
    for (String item:array){
        String[] array2 = item.split(":");
        array2[0] = array2[0].trim();
        array2[1] = array2[1].trim();
        //System.out.println(array2[0]+":"+array2[1]);
        if (!array2[1].equals("null")) {
            sb.append(array2[0]).append(" = ").append('"').append(array2[1]).append('"').append(" ");
            sb.append("and ");
            }
    }
    sb.delete(sb.length()-4, sb.length());
    System.out.println(sb);

    }
}