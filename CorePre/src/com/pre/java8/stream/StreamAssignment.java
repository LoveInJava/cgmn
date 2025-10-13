package com.pre.java8.stream;

import com.pre.java8.stream.utils.Fruit;
import com.pre.java8.stream.utils.News;
import com.pre.java8.stream.utils.TestData;
import com.pre.java8.stream.utils.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamAssignment {

    public static void main(String[] args) {
        //assignmentOnFruits();
        //assignmentOnNews();
        //assignmentOnTransaction();
        assignmentOnAllTypes();

    }

    private static void assignmentOnAllTypes() {
        //1. Print all high calories Fruits(Calorie > 200) using partitioning.
        List<Fruit> allFruits = TestData.getAllFruits();
        Map<Boolean, List<Fruit>> collect = allFruits.stream().collect(Collectors.partitioningBy(fruit -> fruit.getCalories() > 200));
        System.out.println("Print all high calories Fruits(Calorie > 200) using partitioning. \n"+ collect.get(true));

        //2.Find out the newsId which has received maximum comments.
        List<News> allNews = TestData.getAllNews();
        Map.Entry<Integer, Long> integerLongEntry = allNews.stream()
                .collect(Collectors.groupingBy((News news) -> news.getNewsId(), Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue))
                .get();

        System.out.println("Find out the newsId which has received maximum comments. \n");
        System.out.println("News Id of max comment : "+integerLongEntry.getKey()+ " and Total Comment : "+ integerLongEntry.getValue());

        //3. Display commentByUser wise number of comments.
        Map<String, Long> collect1 = allNews.stream().collect(Collectors.groupingBy((News news) -> news.getCommentByUser(), Collectors.counting()));
        System.out.println("Display commentByUser wise number of comments. \n"+collect1);

        //4. Find out which user has posted maximum comments.
        Optional<Map.Entry<String, Long>> max = allNews.stream().collect(Collectors.groupingBy((News news) -> news.getCommentByUser(), Collectors.counting())).entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
        if(max.isPresent()){
            System.out.println("Find out which user has posted maximum comments. \n"+ max.get().getKey());
        }

    }

    private static void assignmentOnTransaction() {

        List<Transaction> allTransactions = TestData.getAllTransactions();

        //5. Find all transactions in the year 2011 and sort them by value (small to high).
        List<Transaction> filterd = allTransactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        System.out.println("Find all transactions in the year 2011 and sort them by value (small to high). \n"+filterd);

        //6. What are all the unique cities where the traders work

        List<String> uniqueCity = allTransactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct().collect(Collectors.toList());

        System.out.println("What are all the unique cities where the traders work : \n"+uniqueCity);


       //7. Find all traders from Pune and sort them by name.

        List<Transaction> puneTraders = allTransactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Pune"))
                .sorted(Comparator.comparing((Transaction transaction) -> transaction.getTrader().getName()).reversed())
                .collect(Collectors.toList());

        System.out.println("Find all traders from Pune and sort them by name. : \n"+puneTraders);

        //8. Return a string of all traders’ names sorted alphabetically.

        List<String> tradersNmae = allTransactions.stream().map(transaction -> transaction.getTrader().getName())
                .sorted().collect(Collectors.toList());

        System.out.println("Return a string of all traders’ names sorted alphabetically. :\n"+tradersNmae);


        //9. Are any traders based in Indore?

        Optional<Transaction> indore = allTransactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Indore"))
                .findAny();

        if (indore.isPresent()) {
            System.out.println("Indore based Traders "+ indore.get());
        }

        //10. Print all transactions values from the traders living in Delhi.
        List<Integer> delhi = allTransactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Pune"))
                .map(transaction -> transaction.getValue())
                .collect(Collectors.toList());

        System.out.println("Print all transactions values from the traders living in Delhi. \n"+ delhi);

        //11. What’s the highest value of all the transactions?
        Optional<Transaction> max = allTransactions.stream().max(Comparator.comparing((Transaction transaction) -> transaction.getValue()));

        System.out.println("What’s the highest value of all the transactions : \n"+max);


        //12. Find the transaction with the smallest value.
        Optional<Transaction> min = allTransactions.stream().min(Comparator.comparing((Transaction transaction) -> transaction.getValue()));
        System.out.println("What’s the lowest value of all the transactions : \n"+min);

        //13. Print first 15 prime numbers.

    }

    private static void assignmentOnNews() {

        List<News> allNews = TestData.getAllNews();

        //4 Find out how many times the word 'budget' arrived in user comments of all news.
        // Assume that ‘budget’ word has arrived maximum once in a given user comment.

        long budgetsCount = allNews.stream().filter(news -> news.getComment().contains("budget")).count();
        System.out.println("Find out how many times the word 'budget' arrived in user comments of all news. Assume that ‘budget’ word has arrived maximum once in a given user comment. \n"+budgetsCount);

    }

    private static void assignmentOnFruits() {
        //1. Display the fruit names of low calories fruits
        //i.e. calories < 100 sorted in descending order of calories.

        List<Fruit> allFruits = TestData.getAllFruits();

        List<String> filterFruits = allFruits.stream()
                .filter(fruit -> fruit.getCalories() < 100)
                .sorted(Comparator.comparing(Fruit::getCalories).reversed())
                .map(fruit -> fruit.getName()).collect(Collectors.toList());

        System.out.println("Display the fruit names of low calories fruits i.e. calories < 100 sorted in descending order of calories \n"+ filterFruits);


       //2.  Display colorwise list of fruits.

        Map<String, List<String>> collect = allFruits.stream().collect(Collectors.groupingBy(Fruit::getColor, Collectors.mapping(Fruit::getName, Collectors.toList())));

        System.out.println("Display colorwise list of fruits : "+collect);

        //3. Display only RED color fruits sorted as per their price in ascending order.

        List<Fruit> redFruits = allFruits.stream()
                .filter(fruit -> fruit.getColor().equals("Red"))
                .sorted(Comparator.comparing(Fruit::getPrice))
                .collect(Collectors.toList());

        System.out.println("Display only RED color fruits sorted as per their price in ascending order. \n : "+redFruits);


    }
}
