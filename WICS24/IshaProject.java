public class IshaProject {
    
}

/*
//Text Based Adventure Game

import java.util.*;

class Main {
  public static void main(String[] args) {
    System.out.println("");
    System.out.println("Welcome back to high school! To win, you need to pass high school, graduate college, and then get a job");
    HighSchool();
    College();
    LFJob();
                      
  }

  public static void HighSchool(){
    Scanner console = new Scanner(System.in);
    Random rand = new Random();
    String[] npcs = {"The administration", "Pre-calc Test", "Your one accomplishment", "Mr. GG", "Band practice", "Undercooked Orange Chicken", "Wi-Fi", "Yuki falling off his chair"};
    
    //HSD Npc variables
    int maxEnemyHealth = 200;
    int enemyAttackDamage = 20;
    boolean Depression = false;

    //HSD Player variables
    int health = 400;
    int attackDamage = 30;
    int money = 20;
    boolean winGame = false;
    int food = 3;

    boolean running = true;
    
    while(running){
      int trueAttackDamage = 30;
      attackDamage = trueAttackDamage;
      System.out.println("You need to graduate school! Get the graduation cap to graduate!");
      System.out.println("You have " + money + " dollars!");
      System.out.println("You have " + food + " items to eat!");
      System.out.println("----------------------------");
      System.out.println();

      System.out.println("\nWhat will you do?");
      System.out.println("\n\t1. Go into classroom");
      System.out.println("\n\t2. Go to store");
      System.out.println("\n\t3. Go into bathroom");
      System.out.println("\n\t4. Graduate");
      System.out.println();

      if (health < 0){
        System.out.println();
        System.out.println("Congratuations! You have succumed to the horrors of high school!");
        return;
      }

      String inp = console.nextLine();

      //If you entered the dungeon
      if (inp.equals("1")){
        int enemyHealth = rand.nextInt(maxEnemyHealth);
        String thing = npcs[rand.nextInt(npcs.length)];
        System.out.println("\tA " + thing + " has appeared!\n");
        
        while(enemyHealth > 0){
          System.out.println("\nYour HP: " + health);
          System.out.println(thing + "'s HP: " + enemyHealth);
          System.out.println("\nWhat will you do?");
          System.out.println("\n\t1. Cry");
          System.out.println("\n\t2. Suffer");
          System.out.println("\n\t3. Study");
          System.out.println("\n\t4. Eat and Sleep");
          System.out.println("\n\t5. Spam thunderbolt");
        
          String input = console.nextLine();
          System.out.println();
          if (input.equals("1")){
            System.out.println("You have used your crying attack!");
            System.out.println("The " + thing + " is crying too!\nYou have inflicted depression onto " + thing);
            int damageTaken = rand.nextInt(enemyAttackDamage);
            System.out.println("You have taken " + damageTaken + " damage!");
            health -= damageTaken;
            Depression = true;
          } else if (input.equals("2")) {
            System.out.println("You have used your suffering attack!");
            int damageDealt = rand.nextInt(attackDamage);
            System.out.println("You have dealt " + damageDealt + " damage!");
            int damageTaken = rand.nextInt(enemyAttackDamage);
            System.out.println("You have taken " + damageTaken + " damage!");
  
            enemyHealth -= damageDealt;
            health -= damageTaken;
            
          } else if (input.equals("3")) {
            System.out.println("You are studying! You feel energized, like you are now stronger!");
            attackDamage += 5;
            System.out.println("Your attack damage has increased to: " + attackDamage);
            int damageTaken = rand.nextInt(enemyAttackDamage);
            System.out.println("You have taken " + damageTaken + " damage!");
            health -= damageTaken;
            
          } else if (input.equals("4")) {
            if (food > 0){
            System.out.println("You have healed yourself!\nYou are now fat and lazy but not tired or hungry!");
              int damageTaken = rand.nextInt(enemyAttackDamage);
              System.out.println("You have gained " + 50 + " health!");
              food -= 1;
              health += 50;
            } else {
              System.out.println("Sorry! You have no food");
            }
            int damageTaken = rand.nextInt(enemyAttackDamage);
            System.out.println("You have taken " + damageTaken + " damage!");
            
            health -= damageTaken;
            
          } else if (input.equals("5")) {
            System.out.println("You have used your spamming thunderbolt attack!");
            int damageDealt = rand.nextInt(attackDamage);
            int damageTaken = rand.nextInt(enemyAttackDamage);
  
            enemyHealth -= 2 * damageDealt;
            health -= damageTaken;
            System.out.println("You have dealt " + damageDealt + " damage!");
            System.out.println("You have taken " + damageTaken + " damage!");
            
          }
  
          if (Depression == true){
            System.out.println();
            System.out.println(thing + " has hurt itself in depression!");
            enemyHealth -= 10;
          }
        }
        System.out.println();
        System.out.println("You have defeated " + thing + "!");
        int tempMoney = Math.abs(rand.nextInt(10));
        System.out.println("You have gained " + tempMoney + " dollars!");
        System.out.println();
        money += tempMoney;
        Depression = false;
        attackDamage = trueAttackDamage;
      }

      if (inp.equals("2")){
        boolean inStore = true;
        while (inStore == true){
          System.out.println("Welcome to the shop!");
          System.out.println("You have " + money + " dollars!");
          System.out.println("What would you like to buy?:");
          System.out.println("\n\t1. I want to leave");
          System.out.println("\n\t2. Graduation Cap- $50");
          System.out.println("\n\t3. Pop Tarts- $5");
          String input = console.nextLine();
          if (input.equals("3")) {
            if (money >= 5){
              System.out.println("You have bought Pop Tarts!");
              money -= 5;
              System.out.println("You now have " + money + " dollars!");
            } else {
              System.out.println("Sorry! You are too poor nerd");
            }
          }
          if (input.equals("2")) {
            if (money >= 50){
              System.out.println("You have bought a Graduation Cap!");
              winGame = true;
              money -= 50;
              System.out.println("You now have " + money + " dollars!");
            } else {
              System.out.println("Sorry! You are too poor nerd");
            }
          }
          if (input.equals("1")) {
            System.out.println("Goodbye!");
            System.out.println();
            break;
          }
          
        }
      }
      if (inp.equals("4")){
        if (winGame){
          System.out.println("YOU GRADUATED HIGH SCHOOL! TOO BAD YOU NEED TO GO TO COLLEGE");
          break;
        } else {
          System.out.println("Sorry! You still need a graduation cap");
        }
      }
      if (inp.equals("3")){
        System.out.println("A very suspcicious man in the bathroom is offering you this weird candy. Do you eat the candy?");
        System.out.println();
        System.out.println("\n\t1. No. I'm too cool for drugs");
        System.out.println("\n\t2. GIVE IT TO ME!");
        String input = console.nextLine();
        if (input.equals("1")) {
          System.out.println("I can't believe you didn't take that free candy.");
        }
        if (input.equals("2")) {
          System.out.println("You feel very weird. Also, all your money is gone.");
          money = 1;
          health /= 3;
          trueAttackDamage = 60;
        }
      }
  }
}


public static void College(){
  //COLLEGE DUNGEON CODE
  
    Scanner console = new Scanner(System.in);
    Random rand = new Random();
    String[] npcs = {"The sorority next door", "Quantam Mechanics Test", "Your one accomplishment", "Mr. GGG",     "Marching band practice in the sun", "Broken McDonald's ice cream machine", "Wi-Fi", "Yuki falling off his chair",
    "Your mom"};

    //College Npc variables
    int maxEnemyHealth = 250; //More Health
    int enemyAttackDamage = 30; //More ATK DMG
    boolean CollegeDepression = false;

    //College Player variables
    int health = 300; //Less Health
    int attackDamage = 25; //Less ATK DMG
    int money = 1; //College Debt
    boolean winGame = false;

    boolean running = true;
    
    while(running){
      System.out.println("You need to graduate College! Pay off your tuition to win!");
      System.out.println("You have " + money + " dollars!");
      System.out.println("----------------------------");
      System.out.println();

      System.out.println("\nWhat will you do?");
      System.out.println("\n\t1. Do the job you've been skipping");
      System.out.println("\n\t2. Go to store");
      System.out.println("\n\t3. Graduate");
      System.out.println();

      String inp = console.nextLine();

      //If you entered the dungeon
      if (inp.equals("1")){
        int enemyHealth = rand.nextInt(maxEnemyHealth);
        String thing = npcs[rand.nextInt(npcs.length)];
        System.out.println("\tA " + thing + " has appeared!\n");
        
        while(enemyHealth > 0){
          System.out.println("\nYour HP: " + health);
          System.out.println(thing + "'s HP: " + enemyHealth);
          System.out.println("\nWhat will you do?");
          System.out.println("\n\t1. Cry");
          System.out.println("\n\t2. Suffer");
          System.out.println("\n\t3. Study");
          System.out.println("\n\t4. Eat and Sleep");
          System.out.println("\n\t5. Actually do work");
        
          String input = console.nextLine();
          System.out.println();
          if (input.equals("1")){
            System.out.println("You have used your crying attack!");
            System.out.println("The " + thing + " is crying too!\nYou have inflicted depression onto " + thing);
            int damageTaken = rand.nextInt(enemyAttackDamage);
            System.out.println("You have taken " + damageTaken + " damage!");
            health -= damageTaken;
            CollegeDepression = true;
          } else if (input.equals("2")) {
            System.out.println("You have used your suffering attack!");
            int damageDealt = rand.nextInt(attackDamage);
            System.out.println("You have dealt " + damageDealt + " damage!");
            int damageTaken = rand.nextInt(enemyAttackDamage);
            System.out.println("You have taken " + damageTaken + " damage!");
  
            enemyHealth -= damageDealt;
            health -= damageTaken;
            
          } else if (input.equals("3")) {
            System.out.println("You are studying! You feel energized, like you are now stronger!");
            attackDamage += 5;
            System.out.println("Your attack damage has increased to: " + attackDamage);
            int damageTaken = rand.nextInt(enemyAttackDamage);
            System.out.println("You have taken " + damageTaken + " damage!");
            health -= damageTaken;
            
          } else if (input.equals("4")) {
            System.out.println("You have healed yourself!\nYou are now fat and lazy (like you already weren't) but now you're sad because you need money!");
            int damageDealt = rand.nextInt(attackDamage);
            System.out.println("You have dealt " + damageDealt + " damage!");
            int damageTaken = rand.nextInt(enemyAttackDamage);
            System.out.println("You have taken -" + damageTaken + " damage!");
  
            enemyHealth -= damageDealt;
            health += damageTaken;
            
          } else if (input.equals("5")) {
            System.out.println("Wow you actually did work! Be proud of yourself!");
            int damageDealt = rand.nextInt(attackDamage);
            int damageTaken = rand.nextInt(enemyAttackDamage);
  
            enemyHealth -= 2 * damageDealt;
            health -= damageTaken;
            System.out.println("You have dealt " + damageDealt + " damage!");
            System.out.println("You have taken " + damageTaken + " damage!");
            
          }
  
          if (CollegeDepression == true){
            System.out.println();
            System.out.println(thing + " has hurt itself in depression!");
            enemyHealth -= 10;
          }
        }
        System.out.println("You have defeated " + thing + "!");
        int tempMoney = Math.abs(rand.nextInt(15));
        System.out.println("You have gained " + tempMoney + " dollars!");
        money += tempMoney;
        CollegeDepression = false;
      }

      if (inp.equals("2")){
        boolean inStore = true;
        while (inStore == true){
          System.out.println("Welcome to the shop!");
          System.out.println("You have " + money + " dollars!");
          System.out.println("What would you like to buy?:");
          System.out.println("\n\t1. I want to leave");
          System.out.println("\n\t2. Pay off tuition- $100");
          System.out.println("\n\t3. Very School Appropriate Things That You Didn't Waste Money On Before- $30");
          String input = console.nextLine();
          if (input.equals("3")) {
            if (money >= 5){
              System.out.println("You have bought Very School Appropriate Things!");
              money -= 5;
              System.out.println("You now have " + money + " dollars!");
            } else {
              System.out.println("Sorry! You are too poor nerd");
            }
          }
          if (input.equals("2")) {
            if (money >= 100){
              System.out.println("You have paid off your tuition!");
              winGame = true;
              money -= 100;
              System.out.println("You now have " + money + "dollars!");
            } else {
              System.out.println("Sorry! You are too poor nerd");
            }
          }
          if (input.equals("1")) {
            System.out.println("Goodbye!");
            break;
          }
          
        }
      }
      if (inp.equals("3")){
        if (winGame){
          System.out.println("You GRADUATED COLLEGE! TOO BAD YOU NEED TO GET A JOB NOW!");
          break;
        } else {
          System.out.println("Sorry! You still need to pay off your tuition");


        }
      }
    }
  }

//Trying To Find A Job Code 


//Added a job application function for this dungeon
//Basically replaced int money with int "words" on the job application 
//If you have enough words on your job application then you get a job, if you don't then RIP 
//I left 70% of the money function in the code just so the code doesn't break (it might still break tbh)
//I also changed health & damage variable but it might be unbalanced so QA will be needed later 
//I didn't change any NPCs yet 
//Also added a new retirement dungeon in case we need extra content to satisfy Mr.W

public static void LFJob() {

    Scanner console = new Scanner(System.in);
    Random rand = new Random();
    String[] npcs = {"Your parents breathing down your neck", "Job Surveys", "Your one accomplishment", "Mr. GGG", "Band practice", "Cup Ramen but its empty since you're broke", "Wi-Fi", "Yuki falling off his chair"}; 

    //Work Npc variables
    int maxEnemyHealth = 350; //More Health
    int enemyAttackDamage = 35; //More ATK DMG
    boolean WorkDepression = false;

    //Work Player variables
    int health = 200; //EVEN less Health
    int attackDamage = 25; //Less ATK DMG 
    int JAwords = 1; //Job application words
    int money = 5; //I left the money variables incase what I do breaks the code :)
    boolean winGame = false;

    boolean running = true;
    
    while(running) {
      System.out.println("You need to get a job to survive the real world! AND ITS A RECESSION SO GOOD LUCK LOL");
      System.out.println("You have " + JAwords + " words on your job application!");
      System.out.println("You have " + money + " money!");  
      System.out.println("----------------------------");
      System.out.println();

      System.out.println("\nWhat will you do?");
      System.out.println("\n\t1. Fill out job applications");
      System.out.println("\n\t2. Go to the recruiting office");
      System.out.println("\n\t3. Get a job");
      System.out.println();

      String inp = console.nextLine();

      //If you entered the dungeon
      if (inp.equals("1")){
        int enemyHealth = rand.nextInt(maxEnemyHealth);
        String thing = npcs[rand.nextInt(npcs.length)];
        System.out.println("\tA " + thing + " has appeared!\n");
        
        while(enemyHealth > 0){
          System.out.println("\nYour HP: " + health);
          System.out.println(thing + "'s HP: " + enemyHealth);
          System.out.println("\nWhat will you do?");
          System.out.println("\n\t1. Cry");
          System.out.println("\n\t2. Suffer");
          System.out.println("\n\t3. Die");
          System.out.println("\n\t4. Eat and Sleep");
          System.out.println("\n\t5. Fill out your job application");
        
          String input = console.nextLine();
          System.out.println();
          if (input.equals("1")){
            System.out.println("You have used your crying attack!");
            System.out.println("The " + thing + " is crying too!\nYou have inflicted depression onto " + thing);
            int damageTaken = rand.nextInt(enemyAttackDamage);
            System.out.println("You have taken " + damageTaken + " damage!");
            health -= damageTaken;
            WorkDepression = true;
          } else if (input.equals("2")) {
            System.out.println("You have used your suffering attack!");
            int damageDealt = rand.nextInt(attackDamage);
            System.out.println("You have dealt " + damageDealt + " damage!");
            int damageTaken = rand.nextInt(enemyAttackDamage);
            System.out.println("You have taken " + damageTaken + " damage!");
  
            enemyHealth -= damageDealt;
            health -= damageTaken;
            
          } else if (input.equals("3")) {
            System.out.println("Because you want to die, you have not died (you've tried to off yourself a good amount of times) (Are you OK??). Try therapy!");
            int damageDealt = rand.nextInt(attackDamage);
            System.out.println("You have dealt " + damageDealt + " damage!");
            int damageTaken = rand.nextInt(enemyAttackDamage);
            System.out.println("You have taken " + damageTaken + " damage!");
  
            enemyHealth -= damageDealt;
            health += damageTaken;
            
          } else if (input.equals("4")) {
            System.out.println("You have healed yourself!\nYou are now fat and lazy (like you already weren't) but now you're sad because you remember that you need to get a job!");
            int damageDealt = rand.nextInt(attackDamage);
            System.out.println("You have dealt " + damageDealt + " damage!");
            int damageTaken = rand.nextInt(enemyAttackDamage);
            System.out.println("You have taken -" + damageTaken + " damage!");
  
            enemyHealth -= damageDealt;
            health += damageTaken;
            
          } else if (input.equals("5")) {
            System.out.println("Wow you actually filled out your job application! Be proud of yourself!");
            int damageDealt = rand.nextInt(attackDamage);
            int damageTaken = rand.nextInt(enemyAttackDamage);
  
            enemyHealth -= 2 * damageDealt;
            health -= damageTaken;
            System.out.println("You have dealt " + damageDealt + " damage!");
            System.out.println("You have taken " + damageTaken + " damage!");
            
          }
  
          if (WorkDepression == true){
            System.out.println();
            System.out.println(thing + " has hurt itself in depression!");
            enemyHealth -= 10;
          }
        }
        System.out.println("You have defeated " + thing + "!");
        int tempMoney = Math.abs(rand.nextInt(5));
        int tempWords = Math.abs(rand.nextInt(JAwords));
        System.out.println("You have gained " + tempWords + " filled out words on applications!");
        System.out.println("You have gained " + tempMoney + " money!");
        JAwords += tempWords;
        money += tempMoney; 
        WorkDepression = false;
      }

      if (inp.equals("2")){
        boolean inStore = true;
        while (inStore == true){
          System.out.println("Welcome to the recruiting office!");
          System.out.println("You have " + money + "money! ");
          System.out.println("You have " + JAwords + " words on your job application!");
          System.out.println("What would you like to do?:");
          System.out.println("\n\t1. I want to leave");
          System.out.println("\n\t2. Get a job - 300 words on job");
          System.out.println("\n\t3. Very School Appropriate Things That You Didn't Waste Money On Before- $30");
          String input = console.nextLine();
          if (input.equals("3")) {
            if (money >= 5){
              System.out.println("You have bought Very School Appropriate Things!");
              money -= 5;
              System.out.println("You now have " + money + " dollars!");
            } else {
              System.out.println("Sorry! You are still too poor nerd! Even after so many decades!");
            }
          }
          if (input.equals("2")) {
              if (JAwords >= 300){
              System.out.println("You're getting a job!");
              winGame = true;
              JAwords -= 300;
              System.out.println("You now have " + JAwords + "words on your job application! You're done job hunting!");
            } else {
              System.out.println("Sorry! You got rejected since you didn't fill out the whole application!");
            }
          }
          if (input.equals("1")) {
            System.out.println("Goodbye!");
            break;
          }
          
        }
      }
      if (inp.equals("3")){
        if (winGame){
          System.out.println("CONGRATS! You'll finally have a stable income and not live on ramen the rest of your life! (The game lied as naturally as it breathed) ");
          break;
        } else {
          System.out.println("Sorry! You'll now be working for fast food chains on minimum wage for the rest of your life! (BAD ENDING LIKE WOW HOW DID YOU MESS UP THIS BAD)");
        }
      }
    }
  console.close();
  }
}

  
//Work (About To Retire) Dungeon Code  - EXTRA IN CASE


    Scanner console = new Scanner(System.in);
    Random rand = new Random();
    String[] npcs = {"Your boss", "Paperwork", "Your one accomplishment", "Mr. GGG", "Therapy sessions (which don't work)", "Your 99 cent cup Ramen", "Wi-Fi", "Yuki falling off his chair (yes still, he's kind of stuck in that eternally)"}; 
    //Work Npc variables
    int maxEnemyHealth = 400; //More Health
    int enemyAttackDamage = 50; //More ATK DMG
    boolean WorkDepression = false;

    //Work Player variables
    int health = 150; //EVEN less Health B/C you've been killed by the workforce
    int attackDamage = 20; //Less ATK DMG B/C you're like 60 something 
    int money = 0; //No money saved for retirement cause you're dumb
    boolean winGame = false;

    boolean running = true;
    
    while(running) {
      System.out.println("You need to get enough retirement money to survive! Get enough money to win!");
      System.out.println("You have " + money + " dollars!");
      System.out.println("----------------------------");
      System.out.println();

      System.out.println("\nWhat will you do?");
      System.out.println("\n\t1. Do the job you've been taking days off on");
      System.out.println("\n\t2. Go to bank");
      System.out.println("\n\t3. Retire");
      System.out.println();

      String inp = console.nextLine();

      //If you entered the dungeon
      if (inp.equals("1")){
        int enemyHealth = rand.nextInt(maxEnemyHealth);
        String thing = npcs[rand.nextInt(npcs.length)];
        System.out.println("\tA " + thing + " has appeared!\n");
        
        while(enemyHealth > 0){
          System.out.println("\nYour HP: " + health);
          System.out.println(thing + "'s HP: " + enemyHealth);
          System.out.println("\nWhat will you do?");
          System.out.println("\n\t1. Cry");
          System.out.println("\n\t2. Suffer");
          System.out.println("\n\t3. Die");
          System.out.println("\n\t4. Eat and Sleep");
          System.out.println("\n\t5. Actually go to work");
        
          String input = console.nextLine();
          System.out.println();
          if (input.equals("1")){
            System.out.println("You have used your crying attack!");
            System.out.println("The " + thing + " is crying too!\nYou have inflicted depression onto " + thing);
            int damageTaken = rand.nextInt(enemyAttackDamage);
            System.out.println("You have taken " + damageTaken + " damage!");
            health -= damageTaken;
            Depression = true;
          } else if (input.equals("2")) {
            System.out.println("You have used your suffering attack!");
            int damageDealt = rand.nextInt(attackDamage);
            System.out.println("You have dealt " + damageDealt + " damage!");
            int damageTaken = rand.nextInt(enemyAttackDamage);
            System.out.println("You have taken " + damageTaken + " damage!");
  
            enemyHealth -= damageDealt;
            health -= damageTaken;
            
          } else if (input.equals("3")) {
            System.out.println("Because you want to die, you have not died (you've tried to off yourself a good amount of times now) (Are you OK??). You get even more depressed!");
            int damageDealt = rand.nextInt(attackDamage);
            System.out.println("You have dealt " + damageDealt + " damage!");
            int damageTaken = rand.nextInt(enemyAttackDamage);
            System.out.println("You have taken " + damageTaken + " damage!");
  
            enemyHealth -= damageDealt;
            health += damageTaken;
            
          } else if (input.equals("4")) {
            System.out.println("You have healed yourself!\nYou are now fat and lazy (like you already weren't) but now you're sad because you remember that you need money to retire!");
            int damageDealt = rand.nextInt(attackDamage);
            System.out.println("You have dealt " + damageDealt + " damage!");
            int damageTaken = rand.nextInt(enemyAttackDamage);
            System.out.println("You have taken -" + damageTaken + " damage!");
  
            enemyHealth -= damageDealt;
            health += damageTaken;
            
          } else if (input.equals("5")) {
            System.out.println("Wow you actually did work! Be proud of yourself! Too bad the little pride you feel is going to evaporate!");
            int damageDealt = rand.nextInt(attackDamage);
            int damageTaken = rand.nextInt(enemyAttackDamage);
  
            enemyHealth -= 2 * damageDealt;
            health -= damageTaken;
            System.out.println("You have dealt " + damageDealt + " damage!");
            System.out.println("You have taken " + damageTaken + " damage!");
            
          }
  
          if (Depression == true){
            System.out.println();
            System.out.println(thing + " has hurt itself in depression!");
            enemyHealth -= 10;
          }
        }
        System.out.println("You have defeated " + thing + "!");
        int tempMoney = Math.abs(rand.nextInt(money));
        System.out.println("You have gained " + tempMoney + " dollars!");
        money += tempMoney;
        Depression = false;
      }

      if (inp.equals("2")){
        boolean inStore = true;
        while (inStore == true){
          System.out.println("Welcome to the bank!");
          System.out.println("You have " + money + " dollars!");
          System.out.println("What would you like to buy?:");
          System.out.println("\n\t1. I want to leave");
          System.out.println("\n\t2. Retire - $250");
          System.out.println("\n\t3. Very School Appropriate Things That You Didn't Waste Money On Before - $50");
          String input = console.nextLine();
          if (input.equals("3")) {
            if (money >= 5){
              System.out.println("You have bought Very School Appropriate Things!");
              money -= 5;
              System.out.println("You now have " + money + " dollars!");
            } else {
              System.out.println("Sorry! You are still too poor nerd! Even after so many decades!");
            }
          }
          if (input.equals("2")) {
            if (money >= 250){
              System.out.println("You're going to finally retire! And then be stuffed into a retirement home until you die!");
              winGame = true;
              money -= 250;
              System.out.println("You now have " + money + "dollars!");
            } else {
              System.out.println(Sorry! You are still too poor nerd! Even after so many decades!");
            }
          }
          if (input.equals("1")) {
            System.out.println("Goodbye!");
            break;
          }
          
        }
      }
      if (inp.equals("3")){
        if (winGame){
          System.out.println("CONGRATS! You're now a dreg to society and stuffed into a retirement home! ");
          break;
        } else {
          System.out.println("Sorry! You can't retire yet! The workforce still has to squeeze you as dry as possible!");

*/


