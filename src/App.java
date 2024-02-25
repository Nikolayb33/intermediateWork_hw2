import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

    // львы для розыгрыша
    Toy lion1 = new Lion(1, "Lion1", 0.2);
    Toy lion2 = new Lion(2, "Lion2", 0.2);
    Toy lion3 = new Lion(3, "Lion3", 0.2);
    Toy lion4 = new Lion(4, "Lion4", 0.2);
    Toy lion5 = new Lion(5, "Lion5", 0.2);
    
    //слоны для розыгрыша
    Toy elephant1 = new Elephant(6, "Elephant1", 0.2);
    Toy elephant2 = new Elephant(7, "Elephant2", 0.2);
    Toy elephant3 = new Elephant(8, "Elephant3", 0.2);
    Toy elephant4 = new Elephant(9, "Elephant4", 0.2);
    Toy elephant5 = new Elephant(10, "Elephant5", 0.2);

    //мячи для розыгрыша
    Toy ball1 = new Ball(11, "Ball1", 0.6);
    Toy ball2 = new Ball(12, "Ball2", 0.6);
    Toy ball3 = new Ball(13, "Ball3", 0.6);
    Toy ball4 = new Ball(14, "Ball4", 0.6);
    Toy ball5 = new Ball(15, "Ball5", 0.6);


    //создаем стек для розыгрыша
    List<Toy> realese_list_Ball = new ArrayList<>();
    List<Toy> realese_list_Elephant = new ArrayList<>();
    List<Toy> realese_list_Lion = new ArrayList<>();
    // кладем игрушки в стек
    realese_list_Lion.add(lion1);
    realese_list_Lion.add(lion2);
    realese_list_Lion.add(lion3);
    realese_list_Lion.add(lion4);
    realese_list_Lion.add(lion5);

    realese_list_Elephant.add(elephant1);
    realese_list_Elephant.add(elephant2);
    realese_list_Elephant.add(elephant3);
    realese_list_Elephant.add(elephant4);
    realese_list_Elephant.add(elephant5);

    realese_list_Ball.add(ball1);
    realese_list_Ball.add(ball2);
    realese_list_Ball.add(ball3);
    realese_list_Ball.add(ball4);
    realese_list_Ball.add(ball5);

    // выводим игрушки из стека
    int a = 1;
    List<Toy> resultList = new ArrayList<>();
    while (a <= 10){
        /*
         * в зависимости от числа случайным образом выбирается один из подарков
         */
        double rand = Math.random();
        // System.out.println(rand);
        System.out.println("___________________________");
        System.out.println(a + " розыгрыш!");;
        if (rand <= 0.2 & rand > 0) {
            if (realese_list_Lion.isEmpty() == true){
                
                Collections.shuffle(realese_list_Elephant);
                Toy elephant_rand = realese_list_Elephant.removeFirst();
                System.out.println("<id: " + elephant_rand.getId() + "> <имя: " + elephant_rand.getName() + ">");
                resultList.add(elephant_rand);
                a += 1;
                System.out.println("___________________________\n");
                continue;
            }
            
            Collections.shuffle(realese_list_Lion);
            Toy lion_rand = realese_list_Lion.removeFirst();
            System.out.println("<id: " + lion_rand.getId() + "> <имя: " + lion_rand.getName() + ">");
            resultList.add(lion_rand);
            a += 1;
            System.out.println("___________________________\n");
        }
        if (rand > 0.2 & rand <= 0.4) {
            if (realese_list_Elephant.isEmpty() == true){
                
                Collections.shuffle(realese_list_Lion);
                Toy lion_rand = realese_list_Lion.removeFirst();
                System.out.println("<id: " + lion_rand.getId() + "> <имя: " + lion_rand.getName() + ">");
                resultList.add(lion_rand);
                System.out.println("___________________________/n");
                a += 1;
                continue;
                
            }
            
            Collections.shuffle(realese_list_Elephant);
            Toy elephant_rand = realese_list_Elephant.removeFirst();
            System.out.println("<id: " + elephant_rand.getId() + "> <имя: " + elephant_rand.getName() + ">");
            resultList.add(elephant_rand);
            System.out.println("___________________________\n");
            a += 1;
        }
        if(rand > 0.4){
            // если не остается мячиков, то выбрасывается слон или лев с вероятностью 50 %
            if (realese_list_Ball.isEmpty() == true){
                double rand1 = Math.random();
                if(rand1 >= 0.5){
                    Collections.shuffle(realese_list_Elephant);
                    Toy elephant_rand = realese_list_Elephant.removeFirst();
                    System.out.println("<id: " + elephant_rand.getId() + "> <имя: " + elephant_rand.getName() + ">");
                    resultList.add(elephant_rand);
                    a += 1;
                    System.out.println("___________________________\n");
                    continue;
                }
                if(rand1 < 0.5 & rand > 0){
                    Collections.shuffle(realese_list_Lion);
                    Toy lion_rand = realese_list_Lion.removeFirst();
                    System.out.println("<id: " + lion_rand.getId() + "> <имя: " + lion_rand.getName() + ">");
                    resultList.add(lion_rand);
                    a += 1;
                    System.out.println("___________________________\n");
                    continue;
                }
                
            }
            
            Collections.shuffle(realese_list_Ball);
            Toy ball_rand = realese_list_Ball.removeFirst();
            System.out.println("<id: " + ball_rand.getId() + "> <имя: " + ball_rand.getName() + ">");
            resultList.add(ball_rand);
            a += 1;
            System.out.println("___________________________\n");
            
        }
        
    }

    // запись розыгрыша в файл
    try (FileWriter writer =  new FileWriter("resultFile.csv")){
        for(Toy s : resultList){
            writer.write(s.getName() + ", ");
        }
        
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }   

    }
}
